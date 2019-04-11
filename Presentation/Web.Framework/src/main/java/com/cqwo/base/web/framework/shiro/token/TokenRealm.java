package com.cqwo.base.web.framework.shiro.token;

import com.cqwo.base.core.domain.authors.AuthUserInfo;
import com.cqwo.base.core.domain.authors.AuthorActionInfo;
import com.cqwo.base.core.domain.authors.AuthorRoleInfo;
import com.cqwo.base.core.enums.authors.LoginType;
import com.cqwo.base.core.exption.token.NoLoginException;
import com.cqwo.base.core.helper.StringHelper;
import com.cqwo.base.services.*;
import com.cqwo.base.web.framework.model.UserTokenPasswordToken;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.exception.UCenterException;
import com.cqwo.ucenter.client.exception.UCenterLoginSuccessException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cdyoue on 2016/10/21.
 */


public class TokenRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private Users users;


    @Autowired(required = false)
    private Logs logs;


    /**
     * loginFailLogs
     */
    @Autowired(required = false)
    private LoginFailLogs loginFailLogs;

    @Autowired(required = false)
    private UserRanks userRanks;

    @Autowired(required = false)
    private Authors authors;

    @Override
    public String getName() {
        return LoginType.TokenLogin.getName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("doGetAuthorizationInfo+" + principals.toString());

        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();

        AuthUserInfo authUserInfo = (AuthUserInfo) principals.getPrimaryPrincipal();


        if (authUserInfo == null) {
            return auth;
        }

        PartUserInfo userInfo = authUserInfo.getUserInfo();

        if (userInfo == null || StringHelper.isNullOrWhiteSpace(userInfo.getUid())) {
            return auth;
        }

        List<AuthorRoleInfo> authorRoleList = authors.getUserAuthorRoleList(userInfo.getUid());

        //赋予管理员角色
        for (AuthorRoleInfo roleInfo : authorRoleList) {
            auth.addRole(roleInfo.getCode());
        }

        List<AuthorActionInfo> authorActionList = authors.getUserAuthorActionList(userInfo.getUid());

        for (AuthorActionInfo actionInfo : authorActionList) {
            auth.addStringPermission(actionInfo.getAction());
        }
        return auth;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +" + authenticationToken.toString());


        if (!(authenticationToken instanceof UserTokenPasswordToken)) {
            throw new UnknownAccountException("类型不匹配");
        }

        UserTokenPasswordToken token = (UserTokenPasswordToken) authenticationToken;

        if (token == null) {
            throw new UnknownAccountException("token异常");
        }

        if (!(token.getLoginType().equals(LoginType.TokenLogin))) {
            throw new UnknownAccountException("登录类型异常");
        }


        PartUserInfo userInfo = null;
        String token2 = "";

        try {

            users.onLogin(token.getToken());

        } catch (UCenterLoginSuccessException ex) {

            userInfo = ex.getUserInfo();

            token2 = ex.getToken();

            if (token2.isEmpty()) {
                throw new UnknownAccountException("Token信息获取失败");
            }


            if (userInfo == null || userInfo.getUid().isEmpty()) {
                throw new UnknownAccountException("未找到用户信息");
            }


            loginFailLogs.deleteLoginFailLogByIP("127.0.0.1");


            Session session = SecurityUtils.getSubject().getSession();


            session.setAttribute("userinfo", userInfo);


            AuthUserInfo authUserInfo = new AuthUserInfo(LoginType.TokenLogin, token.getUsername(), userInfo.getUid(), userInfo);

            return new SimpleAuthenticationInfo(authUserInfo, token.getPassword(), getName());

        } catch (UCenterException ex) {
            ex.printStackTrace();
            throw new UnknownAccountException(ex.getMessage());
        } catch (NoLoginException ex) {
            ex.printStackTrace();
            throw new UnknownAccountException("未找到用户信息");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        throw new UnknownAccountException("登录失败");


    }
}

