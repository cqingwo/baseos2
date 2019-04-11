///*
// *
// *  * Copyright (C) 2017.
// *  * 用于JAVA项目开发
// *  * 重庆青沃科技有限公司 版权所有
// *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
// *
// */
//
//package com.cqwo.base.core.domain.users;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
////开放授权
//@Entity
//@Table(name = "w_user_oauth")
//public class OauthInfo implements Serializable {
//
//    private static final long serialVersionUID = -6406139675956385119L;
//
//    /**
//     * 开放授权Id
//     **/
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//
//     /**
//     * Uid
//     **/
//    @Column(name = "uid", nullable = false)
//    private Integer uid = -1;
//
//    /**
//     * appid
//     **/
//    @Column(name = "appid", nullable = false)
//    private Integer appId = -1;
//
//    /**
//     * openid
//     **/
//    @Column(name = "openid", nullable = false, unique = true, length = 80)
//    private String openId = "";
//
//    /**
//     * unionid
//     **/
//    @Column(name = "unionid", nullable = false, length = 80)
//    private String unionId = "";
//
//    /**
//     * 服务商
//     **/
//    @Column(name = "server", nullable = false, length = 30)
//    private String server = "wechat";
//
//    public OauthInfo() {
//    }
//
//    public OauthInfo(Integer id) {
//        this.id = id;
//    }
//
//    public OauthInfo(Integer id, Integer uid, String openId, String unionId, String server) {
//        this.id = id;
//        this.uid = uid;
//        this.openId = openId;
//        this.unionId = unionId;
//        this.server = server;
//    }
//
//    public OauthInfo(Integer uid, String openId, String unionId, String server) {
//        this.uid = uid;
//        this.openId = openId;
//        this.unionId = unionId;
//        this.server = server;
//    }
//
//
//
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getUid() {
//        return uid;
//    }
//
//    public void setUid(Integer uid) {
//        this.uid = uid;
//    }
//
//    public String getOpenId() {
//        return openId;
//    }
//
//    public void setOpenId(String openId) {
//        this.openId = openId;
//    }
//
//    public String getUnionId() {
//        return unionId;
//    }
//
//    public void setUnionId(String unionId) {
//        this.unionId = unionId;
//    }
//
//    public String getServer() {
//        return server;
//    }
//
//    public void setServer(String server) {
//        this.server = server;
//    }
//
//    public Integer getAppId() {
//        return appId;
//    }
//
//    public void setAppId(Integer appId) {
//        this.appId = appId;
//    }
//
//    @Override
//    public String toString() {
//        return "OauthInfo{" +
//                "id=" + id +
//                ", uid=" + uid +
//                ", openId='" + openId + '\'' +
//                ", unionId='" + unionId + '\'' +
//                ", server='" + server + '\'' +
//                '}';
//    }
//}