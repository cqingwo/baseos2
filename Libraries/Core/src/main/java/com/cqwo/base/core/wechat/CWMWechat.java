/*
 *
 *  *
 *  *  * Copyright (C) 2018.
 *  *  * 用于JAVA项目开发
 *  *  * 重庆青沃科技有限公司 版权所有
 *  *  * Copyright (C)  2018.  CqingWo Systems Incorporated. All rights reserved.
 *  *
 *
 */

package com.cqwo.base.core.wechat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CWMWechat")
public class CWMWechat {

    /**
     * 微信小程序策略
     */
    @Autowired(required = false)
    private IMiniAppStrategy iMiniAppStrategy;

    /**
     * 微信公众号策略
     */
    @Autowired(required = false)
    private IWechatMPStrategy iWechatMPStrategy;


    /**
     * 微信支付策略
     */
    @Autowired(required = false)
    private IWechatPayStrategy iWechatPayStrategy;


    public IMiniAppStrategy getiMiniAppStrategy() {
        return iMiniAppStrategy;
    }

    public void setiMiniAppStrategy(IMiniAppStrategy iMiniAppStrategy) {
        this.iMiniAppStrategy = iMiniAppStrategy;
    }

    public IWechatMPStrategy getiWechatMPStrategy() {
        return iWechatMPStrategy;
    }

    public void setiWechatMPStrategy(IWechatMPStrategy iWechatMPStrategy) {
        this.iWechatMPStrategy = iWechatMPStrategy;
    }

    public IWechatPayStrategy getiWechatPayStrategy() {
        return iWechatPayStrategy;
    }

    public void setiWechatPayStrategy(IWechatPayStrategy iWechatPayStrategy) {
        this.iWechatPayStrategy = iWechatPayStrategy;
    }
}
