/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cqnews on 2017/4/16.
 */

@Service(value = "CWMEmail")
public class CWMEmail {

    /**
     * 邮件策略
     */
    @Autowired(required = false)
    private IEmailStrategy iEmailStrategy;

    public IEmailStrategy getiEmailStrategy() {
        return iEmailStrategy;
    }

    public void setiEmailStrategy(IEmailStrategy iEmailStrategy) {
        this.iEmailStrategy = iEmailStrategy;
    }


}
