/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.email;

/**
 * Created by cqnews on 2017/4/16.
 */


public interface IEmailStrategy {

    /**
     * 发送邮件
     * @param to 接收邮件
     * @param subject 邮件标题
     * @param body 邮件内容
     * @return 是否发送成功
     */
    boolean send(String to, String subject, String body);

    /**
     * 发送邮件
     * @param to 接收邮件
     * @param subject 邮件标题
     * @param body 邮件内容
     * @param bodyEncoding 邮件内容编码
     * @param isBodyHtml 邮件内容是否html化
     * @return  是否发送成功
     */
    boolean send(String to, String subject, String body, String bodyEncoding, boolean isBodyHtml);
}
