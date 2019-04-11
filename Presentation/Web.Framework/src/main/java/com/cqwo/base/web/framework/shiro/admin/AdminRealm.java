package com.cqwo.base.web.framework.shiro.admin;

import com.cqwo.base.core.config.AppConfig;
import com.cqwo.base.core.domain.authors.AuthUserInfo;
import com.cqwo.base.core.domain.authors.AuthorActionInfo;
import com.cqwo.base.core.domain.authors.AuthorRoleInfo;
import com.cqwo.base.core.enums.authors.AuthorGroups;
import com.cqwo.base.core.helper.StringHelper;
import com.cqwo.base.data.Users;
import com.cqwo.base.services.Authors;
import com.cqwo.base.services.LoginFailLogs;
import com.cqwo.base.services.Logs;
import com.cqwo.base.services.UserRanks;
import com.cqwo.base.web.framework.model.UserTokenPasswordToken;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.exception.UCenterException;
import com.cqwo.ucenter.client.exception.UCenterLoginSuccessException;
import com.cqwo.base.core.enums.authors.LoginType;
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

import java.util.Arrays;
import java.util.List;

/**
 * Created by cdyoue on 2016/10/21.
 */


public class AdminRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired(required = false)
    private Users users;


    @Autowired(required = false)
    private Logs logs;

    @Autowired(required = false)
    private LoginFailLogs loginFailLogs;

    @Autowired(required = false)
    private UserRanks userRanks;

    @Autowired(required = false)
    private Authors authors;

    @Autowired(required = false)
    private AppConfig appConfig;

    @Override
    public String getName() {
        return LoginType.AdminLogin.getName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        logger.info("doGetAuthorizationInfo+" + principals.toString());

        //System.out.println(principals.getPrimaryPrincipal());

        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();

        //region 获取用户信息
        AuthUserInfo authorUserInfo = (AuthUserInfo) principals.getPrimaryPrincipal();

        if (authorUserInfo == null) {
            return auth;
        }

        PartUserInfo userInfo = authorUserInfo.getUserInfo();

        if (userInfo == null || StringHelper.isNullOrWhiteSpace(userInfo.getUid())) {
            return auth;
        }

        //endregion

        //region 用户管理权限

        List<AuthorRoleInfo> authorRoleList = authors.getUserAuthorRoleList(userInfo.getUid());

        //赋予管理员角色
        for (AuthorRoleInfo roleInfo : authorRoleList) {
            auth.addRole(roleInfo.getCode());
        }

        List<AuthorActionInfo> authorActionList = authors.getUserAuthorActionList(userInfo.getUid());

        for (AuthorActionInfo actionInfo : authorActionList) {
            auth.addStringPermission(actionInfo.getAction());
        }

        //endregion 用户管理权限


        //region 判断用户是否是超级管理员
        if (Arrays.asList(appConfig.getAdmin()).contains(userInfo.getUserName())) {

            for (AuthorGroups groups : AuthorGroups.values()) {

                auth.addRole(groups.getCode());
            }


            List<AuthorActionInfo> allActionInfo = authors.getAllAuthorActionList();

            for (AuthorActionInfo actionInfo : allActionInfo) {
                auth.addStringPermission(actionInfo.getAction());
            }

        }

        //endregion

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

        if (!(token.getLoginType().equals(LoginType.AdminLogin))) {
            throw new UnknownAccountException("登录类型异常");
        }


        PartUserInfo userInfo = null;

        String token2 = "";
        //System.out.println("我应在江湖悠悠,饮一壶浊酒..." + getName());
        //System.out.println(authenticationToken.toString());


        String account = token.getUsername();

        String password = StringHelper.charToString(token.getPassword());

        if (StringHelper.isNullOrWhiteSpace(account) || StringHelper.isNullOrWhiteSpace(password)) {
            throw new UnknownAccountException("账号或密码不能为空");
        }

        try {
            users.onLogin(account, password);
        } catch (UCenterLoginSuccessException ex) {

            userInfo = ex.getUserInfo();

            if (userInfo == null || userInfo.getUid().isEmpty()) {
                throw new UnknownAccountException("未找到用户信息");
            }

            token2 = ex.getToken();

            if (token2.isEmpty()) {
                throw new UnknownAccountException("Token信息获取失败");
            }

            loginFailLogs.deleteLoginFailLogByIP("127.0.0.1");

            Session session = SecurityUtils.getSubject().getSession();


            session.setAttribute("userinfo", userInfo);
            //System.out.println("处理数据,...sawq");


            AuthUserInfo authUserInfo = new AuthUserInfo(LoginType.AdminLogin, token.getUsername(), userInfo.getUid(), userInfo);

            return new SimpleAuthenticationInfo(authUserInfo, token.getPassword(), getName());

        } catch (UCenterException ex) {

            throw new UnknownAccountException(ex.getMessage());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        throw new UnknownAccountException("未找到用户信息");
    }

}

