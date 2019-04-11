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

package com.cqwo.base.web.framework.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cqwo.base.core.message.MessageInfo;

import javax.servlet.http.HttpServletResponse;

/**
 * JSONView封装
 */
public class JsonView {


    //region JSONView封装

    /**
     * 返回JSON View
     *
     * @return
     */
    public static String view(HttpServletResponse response) {
        return view("青沃科技欢迎您", response);
    }

    /**
     * 返回JSON View
     *
     * @param message 消息
     * @return
     */
    public static String view(String message, HttpServletResponse response) {
        return view(0, message, response);
    }

    /**
     * 返回JSON View
     *
     * @param state   状态
     * @param message 消息
     * @return
     */
    public static String view(Integer state, String message, HttpServletResponse response) {
        return view(state, null, message, response);
    }


    /**
     * 返回JSON View
     *
     * @param state   状态
     * @param content 内容
     * @param message 消息
     * @return
     */
    public static String view(Integer state, Object content, String message, HttpServletResponse response) {


        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setState(state);
        messageInfo.setContent(JSON.toJSONString(content));
        messageInfo.setMessage(message);


        return JSON.toJSONString(messageInfo, SerializerFeature.DisableCircularReferenceDetect);

    }
    //endregion
}
