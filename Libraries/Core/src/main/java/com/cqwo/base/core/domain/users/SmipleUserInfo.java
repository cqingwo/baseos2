/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.users;

/**
 * Created by cqnews on 2017/12/22.
 */
public class SmipleUserInfo {

    /**
     * 用户姓名
     */
    private String realName="";

    /**
     * 手机号码
     */
    private String mobile="127.0.0.1";

    /**
     * ip
     */
    private String ip="";

    public SmipleUserInfo() {
    }

    public SmipleUserInfo(String realName, String mobile) {
        this.realName=realName;
        this.mobile=mobile;
    }

    public SmipleUserInfo(String realName, String mobile, String ip) {
        this.realName=realName;
        this.mobile=mobile;
        this.ip=ip;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName=realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile=mobile;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip=ip;
    }

    @Override
    public String toString() {
        return "SmipleUserInfo{" +
                "realName='" + realName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
