/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.sms;

/**
 * Created by cqnews on 2017/4/16.
 */
public enum SMSType {


    /// <summary>
    /// 基础短信
    /// </summary>
    Base,

    /// <summary>
    /// 注册
    /// </summary>
    Regist,

    /// <summary>
    /// 找回密码
    /// </summary>
    FindPwd,

    /// <summary>
    /// 安全中心验证
    /// </summary>
    SCVerify,

    /// <summary>
    /// 更新通知
    /// </summary>
    SCUpdate,

    /// <summary>
    /// 欢迎短信
    /// </summary>
    Welcome, /// <summary>
    /// 用户登录
    /// </summary>
    Login;

    private Integer value = 0;

    public static SMSType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return Base;
            case 2:
                return Regist;
            case 3:
                return FindPwd;
            case 4:
                return SCVerify;
            case 5:
                return SCUpdate;
            case 6:
                return Welcome;
            case 7:
                return Login;
            default:
                return Base;
        }
    }

    public Integer value() {
        return this.value;
    }
}
