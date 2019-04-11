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

package com.cqwo.base.core.push;

import com.cqwo.base.core.message.MessageInfo;

import java.io.IOException;

/**
 * Created by cqnews on 2017/4/16.
 */


public interface IPushStrategy {


    /**
     * 发送消息
     *
     * @param deviceToken 机器
     * @param title       通知标题
     * @param text        通知内容
     * @param messageInfo 自定义消息的内容
     * @return
     * @throws IOException
     */
    boolean send(String deviceToken, String title, String text, MessageInfo messageInfo) throws IOException;


    /**
     * 发送广播
     *
     * @param title 通知标题
     * @param text  通知内容
     * @return
     * @throws IOException
     */
    boolean send(String title, String text, MessageInfo messageInfo) throws IOException;

}
