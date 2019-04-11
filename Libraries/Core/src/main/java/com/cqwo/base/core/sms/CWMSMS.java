/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cqnews on 2017/3/20.
 */
@Service(value = "CWMSMS")
public class CWMSMS {

    @Autowired(required = false)
    private ISMSStrategy ismsStrategy;


    public ISMSStrategy getIsmsStrategy() {
        return ismsStrategy;
    }

    public void setIsmsStrategy(ISMSStrategy ismsStrategy) {
        this.ismsStrategy = ismsStrategy;
    }
}

