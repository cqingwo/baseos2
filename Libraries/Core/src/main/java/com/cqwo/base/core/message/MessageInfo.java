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

package com.cqwo.base.core.message;

import com.alibaba.fastjson.JSON;
import com.cqwo.base.core.helper.StringHelper;
import com.cqwo.ucenter.client.exception.AnalyzeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo implements Serializable {

    /**
     * 消息分类
     */
    private Integer type = 0;


    /**
     * 消息状态
     */
    private Integer state = -1;

    /**
     * 消息说明
     */
    private String message = "英卡欢迎您";


    /**
     * 消息正文
     */
    private String content;


    public MessageInfo(String message) {
        this.message = message;
    }


    public MessageInfo(Integer type, Integer state, String message) {
        this.type = type;
        this.state = state;
        this.message = message;
    }


    /**
     * 生成消息的来构造函数
     *
     * @param state   状态
     * @param message 消息
     * @return
     */
    public static MessageInfo of(Integer state, String message) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessage(message);

        return messageInfo;
    }

    /**
     * 解析Json
     *
     * @param s 原串
     * @return
     */
    public static MessageInfo fromJson(String s) throws AnalyzeException {

        MessageInfo messageInfo = new MessageInfo();

        try {

            if (StringHelper.isNullOrWhiteSpace(s)) {

                throw new AnalyzeException("数据不能为空");
            }

            messageInfo = JSON.parseObject(s, MessageInfo.class);

        } catch (AnalyzeException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception ex) {
            throw new AnalyzeException("数据解析失败");
        }

        return messageInfo;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
