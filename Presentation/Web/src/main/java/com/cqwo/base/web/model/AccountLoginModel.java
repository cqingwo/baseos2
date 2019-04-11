/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.model;

import com.cqwo.base.core.helper.ValidateHelper;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author cqnews
 * @date 2017/12/23
 */
public class AccountLoginModel {

    /**
     * 账号名称
     */
    @NotNull(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "用户名长度必须在6-20之间")
    @Pattern(regexp = ValidateHelper.ACCOUNT_REGEX, message = "用户名账号不合法")
    private String account = "";

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @Length(min = 6, max = 30, message = "密码长度必须在6-20之间")
    private String password = "";

    /**
     * 验证码
     */
    @NotNull(message = "验证码不能为空")
    @Length(min = 4, max = 10, message = "验证码长度必须在5-10之间")
    private String verifyCode = "";

    /**
     * 返回地址
     */
    private String returnUrl = "/admin/index";


    public AccountLoginModel() {
    }

    public AccountLoginModel(String account, String password, String verifyCode) {
        this.account = account;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public AccountLoginModel(String account, String password, String verifyCode, String returnUrl) {
        this.account = account;
        this.password = password;
        this.verifyCode = verifyCode;
        this.returnUrl = returnUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    @Override
    public String toString() {
        return "AccountLoginModel{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                '}';
    }
}
