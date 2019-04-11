/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.config.info;

/**
 * Created by cqnews on 2017/4/13.
 */
public class EmailConfigInfo implements IConfigInfo {

    /**
     *服务器地址
     */
    private String host = "mail.163.com";//服务器地址
    /**
     *服务器端口
     */
    private Integer port = 23;//服务器端口
    /**
     *邮箱账号
     */
    private String username  = "yjwwtu";//邮箱账号
    /**
     *邮箱密码
     */
    private String password = "12345678";//邮箱密码
    /**
     *发送邮箱
     */
    private String from = "yjwwtu@163.com";//发送邮箱
    /**
     *发送邮箱的昵称
     */
    private String fromname = "青沃科技";//发送邮箱的昵称
    /**
     *找回密码内容
     */
    private String findpwdbody = "找回密码内容";//找回密码内容
    /**
     *安全中心验证邮箱内容
     */
    private String scverifybody = "安全中心验证邮箱内容";//安全中心验证邮箱内容
    /**
     *安全中心确认更新邮箱内容
     */
    private String scupdatebody = "安全更新";//安全中心确认更新邮箱内容
    /**
     *注册欢迎信息
     */
    private String webcomebody = "欢迎注册";//注册欢迎信息

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getFindpwdbody() {
        return findpwdbody;
    }

    public void setFindpwdbody(String findpwdbody) {
        this.findpwdbody = findpwdbody;
    }

    public String getScverifybody() {
        return scverifybody;
    }

    public void setScverifybody(String scverifybody) {
        this.scverifybody = scverifybody;
    }

    public String getScupdatebody() {
        return scupdatebody;
    }

    public void setScupdatebody(String scupdatebody) {
        this.scupdatebody = scupdatebody;
    }

    public String getWebcomebody() {
        return webcomebody;
    }

    public void setWebcomebody(String webcomebody) {
        this.webcomebody = webcomebody;
    }

    public EmailConfigInfo() {
    }

    public EmailConfigInfo(String host, Integer port, String username, String password, String from, String fromname, String findpwdbody, String scverifybody, String scupdatebody, String webcomebody) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.from = from;
        this.fromname = fromname;
        this.findpwdbody = findpwdbody;
        this.scverifybody = scverifybody;
        this.scupdatebody = scupdatebody;
        this.webcomebody = webcomebody;
    }
}
