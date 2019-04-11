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

/**
 * 微信Session
 */
public class WeChatSession {


    private String openId = "";
    private String unionId = "";
    private String sessionKey = "";


    public WeChatSession() {
    }

    public WeChatSession(String openId, String unionId, String sessionKey) {
        this.openId = openId;
        this.unionId = unionId;
        this.sessionKey = sessionKey;
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }


    @Override
    public String toString() {
        return "WeChatSession{" +
                "openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                '}';
    }
}
