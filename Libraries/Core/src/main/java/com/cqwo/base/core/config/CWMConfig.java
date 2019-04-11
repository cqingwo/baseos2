/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cqnews on 2017/3/24.
 */


@Service(value = "CWMConfig")
public class CWMConfig {



    /**
     * 配置策略
     */

    @Autowired(required = false)
    private IConfigStrategy iconfigstrategy;//配置策略


    public CWMConfig() {

    }

    public IConfigStrategy getIconfigstrategy() {
        return iconfigstrategy;
    }

    public void setIconfigstrategy(IConfigStrategy iconfigstrategy) {
        this.iconfigstrategy = iconfigstrategy;
    }
}
