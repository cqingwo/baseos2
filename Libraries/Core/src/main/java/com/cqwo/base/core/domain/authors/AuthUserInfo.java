/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.core.domain.authors;


import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.base.core.enums.authors.LoginType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cqnews
 */
@Data
public class AuthUserInfo implements Serializable {

    private static final long serialVersionUID = 3760155479508197901L;


    /**
     * 认证类型
     */
    private LoginType loginType = LoginType.AdminLogin;

    /**
     * 用户token
     */
    private String token = "";

    /**
     * 用户名
     */
    private String username = "";

    /**
     * uid
     */
    private String uid = "";

    /**
     * 用户
     */
    public PartUserInfo userInfo = new PartUserInfo();

    public AuthUserInfo(LoginType loginType, String username, String uid, PartUserInfo userInfo) {
        this.loginType = loginType;
        this.username = username;
        this.uid = uid;
        this.userInfo = userInfo;
    }

    public AuthUserInfo(LoginType loginType, String token, PartUserInfo userInfo) {
        this.loginType = loginType;
        this.token = token;
    }


    public AuthUserInfo(LoginType loginType, String username) {
        this.loginType = loginType;
        this.username = username;
    }

    public AuthUserInfo(LoginType loginType, String username, char[] password) {
        this.loginType = loginType;
        this.username = username;
    }
}
