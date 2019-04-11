/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.domain.users;

import javax.persistence.*;
import java.io.Serializable;

//登录日志
@Entity
@Table(name = "w_user_loginfaillogs")
public class LoginFailLogInfo implements Serializable {

    private static final long serialVersionUID = 5100659918606336335L;
    /**
     * 日志Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 登录IP
     **/
    @Column(name = "loginip", nullable = false)
    private long loginIP = 0;
    /**
     * 失败的次数
     **/
    @Column(name = "failtimes", nullable = false)
    private Integer failTimes = 0;
    /**
     * 最后登陆时间
     **/
    @Column(name = "lastlogintime", nullable = false)
    private Integer lastLoginTime = 0;

    public LoginFailLogInfo() {
    }

    public LoginFailLogInfo(Integer id) {
        this.id = id;
    }

    public LoginFailLogInfo(Integer id, Integer loginIP, Integer failTimes, Integer lastLoginTime) {
        this.id = id;
        this.loginIP = loginIP;
        this.failTimes = failTimes;
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(long loginIP) {
        this.loginIP = loginIP;
    }

    public Integer getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }

    public Integer getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Integer lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "LoginFailLogInfo{" +
                "id=" + id +
                ", loginIP=" + loginIP +
                ", failTimes=" + failTimes +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}