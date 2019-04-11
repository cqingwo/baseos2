/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.strategy.rdbs.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Created by cqnews on 2017/12/1.
 */

public class RDBSService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 获取spring中当前的session
     *
     * @return
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    @Before(value = "SessionBefore")
    public void prepare() {
        System.out.println(" before ：所有的测试方法之前都先执行这个方法");
    }

    @After(value = "SessionAfter")
    public void destroy() {
        System.out.println(" destroy ：所有的测试方法之后都要执行这个方法");
    }


}

