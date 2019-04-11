/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.strategy.email;

import com.cqwo.base.core.config.info.SMSConfigInfo;
import com.cqwo.base.core.email.IEmailStrategy;
import com.cqwo.base.core.helper.MailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by cqnews on 2017/4/16.
 */
@Component(value = "EmailStrategy")
@Primary
public class EmailStrategy implements IEmailStrategy {

    @Autowired
    SMSConfigInfo configInfo;

    /**
     * 发送邮件
     *
     * @param to      接收邮件
     * @param subject 邮件标题
     * @param body    邮件内容
     * @return 是否发送成功
     */
    @Override
    public boolean send(String to, String subject, String body) {
        MailHelper se = new MailHelper();
        try {

            se.doSendHtmlEmail(subject, body, to);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 发送邮件
     *
     * @param to           接收邮件
     * @param subject      邮件标题
     * @param body         邮件内容
     * @param bodyEncoding 邮件内容编码
     * @param isBodyHtml   邮件内容是否html化
     * @return 是否发送成功
     */
    @Override
    public boolean send(String to, String subject, String body, String bodyEncoding, boolean isBodyHtml) {

        MailHelper se = new MailHelper();
        try {

            se.doSendHtmlEmail(subject,body,to);

        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
