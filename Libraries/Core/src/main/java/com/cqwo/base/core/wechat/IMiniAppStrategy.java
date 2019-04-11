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

import cn.binarywang.wx.miniapp.api.WxMaMsgService;
import cn.binarywang.wx.miniapp.api.WxMaQrcodeService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;

/**
 * 微信策略
 */
public interface IMiniAppStrategy {


    /**
     * 获取用户token
     *
     * @return
     * @throws Exception
     */
    String getAccessToken() throws Exception;

    /**
     * 获取用户的服务
     * @return
     */
    WxMaUserService getUserService();

    /**
     * 获取二维码的服务
     * @return
     */
    WxMaQrcodeService getQrcodeService();

    /**
     * 获取消息服务
     *
     * @return
     */
    WxMaMsgService getMsgService();


}
