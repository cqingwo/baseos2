/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.sms;


import com.cqwo.base.core.domain.sms.SMSInfo;

/**
 * Created by cqnews on 2017/3/20.
 */
public interface ISMSStrategy {


    /**
     * 发送短信
     *
     * @param to   接收人号码
     * @param body 短信内容
     * @return 是否发送成功
     */
    Boolean send(String to, String body);

    /**
     * 发送短信
     *
     * @param uid  接收人的UID
     * @param type 发送短信的类型
     * @param code 发送短信的CODE
     * @param to   接收人号码
     * @param body 短信内容
     * @return 是否发送成功
     */
    Boolean send(Integer uid, Integer type, String code, String to, String body);


    /**
     * 创建短信
     *
     * @param smsInfo 短信模型
     * @return
     */
    Integer createSMS(SMSInfo smsInfo);


}
