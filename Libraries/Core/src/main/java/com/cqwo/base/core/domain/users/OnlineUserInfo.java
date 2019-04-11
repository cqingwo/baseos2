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

//在线用户
@Entity
@Table(name = "w_user_onlineusers")
public class OnlineUserInfo implements Serializable {

    private static final long serialVersionUID = 512440548844532098L;
    /**
     * 在线用户编号
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "olid")
    private Integer olId = 0;
    /**
     * 在线用户id
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = 0;
    /**
     * 在线用户sid
     **/
    @Column(name = "sid", nullable = false, length = 30)
    private String sid = "";
    /**
     * 用户昵称
     **/
    @Column(name = "nickname", nullable = false, length = 30)
    private String nickName = "";
    /**
     * 在线用户ip
     **/
    @Column(name = "ip", nullable = false, length = 30)
    private String ip = "";

    /**
     * 注册区域
     **/
    @Column(name = "regionid", nullable = false)
    private Integer regionId = 0;
    /**
     * 更新时间
     **/
    @Column(name = "updatetime", nullable = false)
    private Integer updateTime = 0;

    public OnlineUserInfo() {
    }

    public OnlineUserInfo(Integer olId) {
        this.olId = olId;
    }

    public OnlineUserInfo(Integer uid, String sid, String nickName, String ip, Integer regionId, Integer updateTime) {
        this.uid = uid;
        this.sid = sid;
        this.nickName = nickName;
        this.ip = ip;
        this.regionId = regionId;
        this.updateTime = updateTime;
    }

    public Integer getOlId() {
        return olId;
    }

    public void setOlId(Integer olId) {
        this.olId = olId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OnlineUserInfo{" +
                "olId=" + olId +
                ", uid=" + uid +
                ", sid='" + sid + '\'' +
                ", nickName='" + nickName + '\'' +
                ", ip='" + ip + '\'' +
                ", regionId=" + regionId +
                ", updateTime=" + updateTime +
                '}';
    }
}