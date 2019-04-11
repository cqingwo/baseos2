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

package com.cqwo.base.core.plugin.interface2;

import com.cqwo.ucenter.client.domain.PartUserInfo;

import java.sql.Timestamp;

/**
 * 支付接口
 */
public interface IPayPlugin extends IPlugin {

    /**
     * 获取支付地址
     *
     * @return
     */
    String getPayUrl();

    /**
     * 获取支付模式
     *
     * @return
     */
    Integer getPayMode();


    /**
     * 获得支付手续费
     *
     * @param recordAmount 订单合计
     * @param buyTime      购买时间
     * @param partUserInfo 用户信息
     * @return 返回支付手续费
     */
    double getPayFee(double recordAmount, Timestamp buyTime, PartUserInfo partUserInfo);
}
