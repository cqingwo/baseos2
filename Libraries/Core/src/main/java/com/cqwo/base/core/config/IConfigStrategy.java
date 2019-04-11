/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.config;

import com.cqwo.base.core.config.info.BaseConfigInfo;
import com.cqwo.base.core.config.info.EmailConfigInfo;
import com.cqwo.base.core.config.info.SMSConfigInfo;
import com.cqwo.base.core.config.info.WechatConfigInfo;


/**
 * 配置策略接口
 * Created by cqnews on 2017/3/24.
 */
public interface IConfigStrategy {



    /**
     * 保存项目基本配置
     *
     * @param configInfo 项目基本配置
     * @return 是否保存成功
     */
    boolean saveBaseConfig(BaseConfigInfo configInfo);

    /**
     * 获得项目基本配置
     *
     * @return 项目基本配置
     */
    BaseConfigInfo getBaseConfig();

    /**
     * 保存邮件配置
     *
     * @param configInfo 邮件配置信息
     * @return 是否保存成功
     */
    boolean saveEmailConfig(EmailConfigInfo configInfo);

    /**
     * 获得邮件配置
     *
     * @return 邮件配置
     */
    EmailConfigInfo getEmailConfig();

    /**
     * 保存短信配置
     *
     * @param configInfo 短信配置信息
     * @return 是否保存成功
     */
    boolean saveSMSConfig(SMSConfigInfo configInfo);

    /**
     * 获得短信配置
     *
     * @return 短信配置
     */
    SMSConfigInfo getSMSConfig();

    /**
     * 保存微信配置
     *
     * @param configInfo 微信配置信息
     * @return 是否保存成功
     */
    boolean saveWechatConfig(WechatConfigInfo configInfo);

    /**
     * 获得微信配置
     *
     * @return 微信配置
     */
    WechatConfigInfo getWechatConfig();

}
