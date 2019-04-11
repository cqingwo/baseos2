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

package com.cqwo.base.core.config.info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
// XML文件中的根标识
@XmlRootElement(name = "WechatConfigInfo")
public class WechatConfigInfo implements IConfigInfo  {

    private String code = "gameplay2018"; //微信识别码
    private String token = "weixin"; //微信Token(令牌)
    private String encodingAesKey = "SvvD8Z9bmJ08J9y5YjDJgj0ZVgd5G08dYJM0gjjG5mz"; //微信EncodingAESKey
    private String appId = "wx21e8c5fddf3b7b77";//开发者ID
    private String appSecret = "d52892a52f80c29b0929adef99540ae2"; //开发者密码

    private String apiKey = "18996085292";
    private String apiSecret = "ifxP0JVAac96xGo4";


    private String mchId = "";//微信支付商户号
    private String mchKey = ""; //微信支付商户密钥
    private String keyPath = "";//apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定

    private String msgDataFormat = "JSON";

    public WechatConfigInfo() {
    }

    public WechatConfigInfo(String code, String token, String encodingAesKey, String appId, String appSecret, String apiKey, String apiSecret, String mchId, String mchKey, String keyPath, String msgDataFormat) {
        this.code = code;
        this.token = token;
        this.encodingAesKey = encodingAesKey;
        this.appId = appId;
        this.appSecret = appSecret;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.mchId = mchId;
        this.mchKey = mchKey;
        this.keyPath = keyPath;
        this.msgDataFormat = msgDataFormat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getMsgDataFormat() {
        return msgDataFormat;
    }

    public void setMsgDataFormat(String msgDataFormat) {
        this.msgDataFormat = msgDataFormat;
    }

    @Override
    public String toString() {
        return "WechatConfigInfo{" +
                "code='" + code + '\'' +
                ", token='" + token + '\'' +
                ", encodingAesKey='" + encodingAesKey + '\'' +
                ", appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", apiKey='" + apiKey + '\'' +
                ", apiSecret='" + apiSecret + '\'' +
                ", mchId='" + mchId + '\'' +
                ", mchKey='" + mchKey + '\'' +
                ", keyPath='" + keyPath + '\'' +
                ", msgDataFormat='" + msgDataFormat + '\'' +
                '}';
    }
}
