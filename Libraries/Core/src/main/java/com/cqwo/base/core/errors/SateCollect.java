package com.cqwo.base.core.errors;


public class SateCollect {

    /**
     * 成功
     */
    public static final Integer SUCCESS = 0;

    /**
     * 无权限
     */
    public static final Integer AUTHOR_FAILED = 1000;


    /**
     * 用户未登录
     */
    public static final Integer AUTHOR_NOLOGIN = 1100;


    /**
     * 错误登录
     */
    public static final Integer AUTHOR_ERRLOGIN = 1200;


    /**
     * 错误的手机号码
     */
    public static final Integer AUTHOR_ERRMOBILE = 1300;


    /**
     * 错误的手机号码
     */
    public static final Integer AUTHOR_ERRWECHAT = 1300;


    /**
     * 校验证失败
     */
    public static final Integer VALIDATION_FAILED = 2000;


}
