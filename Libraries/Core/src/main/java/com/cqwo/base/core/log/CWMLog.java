/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cqnews on 2017/4/15.
 */
@Service(value = "CWMLog")
public class CWMLog {

    @Autowired(required = false)
    private ILogStrategy iLogStrategy;


    public ILogStrategy getiLogStrategy() {
        return iLogStrategy;
    }

    public void setiLogStrategy(ILogStrategy iLogStrategy) {
        this.iLogStrategy = iLogStrategy;
    }
}
