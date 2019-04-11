/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.framework.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cqnews on 2017/12/15.
 */


public class FormCollection {


    @Autowired
    private HttpServletRequest request;


    public HttpServletRequest getRequest() {
        return request;
    }
}
