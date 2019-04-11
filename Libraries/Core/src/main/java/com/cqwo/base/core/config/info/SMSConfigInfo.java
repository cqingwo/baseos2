
/*
 * Copyright (C) 2017.
 * 用于配置信息
 * 重庆青沃科技有限公司 版权所有
 * Copyright © 2017.  CqingWo Systems Incorporated. All rights reserved.
 */

package com.cqwo.base.core.config.info;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by cqnews on 2017/4/13.
 */
@Component(value = "SMSConfigInfo")
@ConfigurationProperties(prefix = "sms.config")
public class SMSConfigInfo implements IConfigInfo {

    /**
     * 短信服务器地址
     */
    private String url = "http://sms.ht3g.com/sms.aspx";//短信服务器地址
    /**
     * 企业id
     */
    private Integer userid = 305;//企业id
    /**
     * 短信账号
     */
    private String account = "huilianadmin";//短信账号
    /**
     * 短信密码
     */
    private String password = "19870214?liyu";//短信密码
    /**
     * 短信签名
     */
    private String sign = "惠联商务";//短信签名

    /**
     * 找回密码内容
     */
    private String findpwdbody = "找回密码{mallname}{code}";//找回密码内容
    /**
     * 安全中心验证手机内容
     */
    private String scverifybody = "安全中心验证校验码{code}";//安全中心验证手机内容
    /**
     * 安全中心提现验证手机内容
     */
    private String sctraverifybody = "安全中心验证校验码{code}";//安全中心提现验证手机内容
    /**
     * 安全中心确认更新手机内容
     */
    private String scupdatebody = "安全中心更新手机校验码{poname}{code}";//安全中心确认更新手机内容
    /**
     * 注册欢迎信息
     */
    private String webcomebody = "欢迎注册{mallname}{regtime}{mobile}";//注册欢迎信息

    public SMSConfigInfo() {

        /**
         this.url = "http://sms.ht3g.com/sms.aspx";//短信服务器地址
         this.userid = 305;//企业id
         this.account = "huilianadmin";//短信账号
         this.password = "19870214?liyu";//短信密码
         this.sign = "惠联商务";//短信签名
         this.findpwdbody = "找回密码{mallname}{code}";//找回密码内容
         this.scverifybody = "安全中心验证校验码{code}";//安全中心验证手机内容
         this.sctraverifybody = "安全中心验证校验码{code}";//安全中心提现验证手机内容
         this.scupdatebody = "安全中心更新手机校验码{poname}{code}";//安全中心确认更新手机内容
         this.webcomebody = "欢迎注册{mallname}{regtime}{mobile}";//注册欢迎信息
         **/

    }

    public SMSConfigInfo(String url, Integer userid, String account, String password, String sign, String findpwdbody, String scverifybody, String sctraverifybody, String scupdatebody, String webcomebody) {
        this.url = url;
        this.userid = userid;
        this.account = account;
        this.password = password;
        this.sign = sign;
        this.findpwdbody = findpwdbody;
        this.scverifybody = scverifybody;
        this.sctraverifybody = sctraverifybody;
        this.scupdatebody = scupdatebody;
        this.webcomebody = webcomebody;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public String getSctraverifybody() {
        return sctraverifybody;
    }

    public void setSctraverifybody(String sctraverifybody) {
        this.sctraverifybody = sctraverifybody;
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

    @Override
    public String toString() {
        return "SMSConfigInfo{" + "url='" + url + '\'' + ", userid=" + userid + ", account='" + account + '\'' + ", password='" + password + '\'' + ", sign='" + sign + '\'' + ", findpwdbody='" + findpwdbody + '\'' + ", scverifybody='" + scverifybody + '\'' + ", sctraverifybody='" + sctraverifybody + '\'' + ", scupdatebody='" + scupdatebody + '\'' + ", webcomebody='" + webcomebody + '\'' + '}';
    }
}
