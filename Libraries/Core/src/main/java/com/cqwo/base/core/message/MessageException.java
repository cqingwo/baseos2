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

public class MessageException extends Exception {


    /**
     * 消息状态
     */
    private Integer state = 0;

    /**
     * 消息说明
     */
    private String message = "青沃科技欢迎您";


    /**
     * 消息正文
     */
    private Object content;

    public MessageException() {
    }

    public MessageException(String message) {
        this.message = message;
    }


    public MessageException(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public MessageException(Integer state, String message, Object content) {

        this.state = state;
        this.message = message;
        this.content = content;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                ", state=" + state +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
