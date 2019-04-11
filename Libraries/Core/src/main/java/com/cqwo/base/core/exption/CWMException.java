/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆英卡电子有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.exption;

/**
 * Created by cqnews on 2017/3/20.
 */
public class CWMException extends Exception{

    private static final long serialVersionUID = -8042053209328899711L;

    public CWMException() {
    }

    public CWMException(String message) {
        super(message);
    }

    public CWMException(String message, Throwable cause) {
        super(message, cause);
    }

    public CWMException(Throwable cause) {
        super(cause);
    }

    public CWMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
