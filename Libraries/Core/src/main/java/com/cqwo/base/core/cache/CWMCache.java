/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cqnews on 2017/4/10.
 */
@Component(value = "CWMCache")
public class CWMCache {

    @Autowired
    private ICacheStrategy icachestrategy;//短信策略

    public ICacheStrategy getIcachestrategy() {
        return icachestrategy;
    }

    public void setIcachestrategy(ICacheStrategy icachestrategy) {
        this.icachestrategy = icachestrategy;
    }

}
