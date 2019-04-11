/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.services;


import com.cqwo.base.core.config.info.SMSConfigInfo;
import com.cqwo.base.core.domain.sms.SMSType;
import com.cqwo.base.core.sms.CWMSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by cqnews on 2017/4/11.
 */
@Service(value = "SMSes")
public class SMSes {


    @Resource
    private CWMSMS cwmsms;


    @Autowired
    private SMSConfigInfo configInfo;


    /**
     * 发送找回密码短信
     *
     * @param to   接收手机
     * @param code 验证值
     * @param uid  用户ID
     * @return
     */
    public boolean sendFindPwdMobile(String to, String code, Integer uid) {
        String body = configInfo.getFindpwdbody();

        body.replace("{mallname}", configInfo.getSign());
        body.replace("{code}", code);
        return send(uid, SMSType.FindPwd.value(), code, to, body.toString());
    }

    /**
     * 安全中心发送验证手机短信
     *
     * @param to   接收手机
     * @param code 验证值
     * @param uid  用户ID
     * @return 返回发送状态
     */
    public boolean sendSCVerifySMS(String to, String code, Integer uid) {
        String body = configInfo.getScverifybody();
        body.replace("{mallname}", configInfo.getSign());
        body.replace("{code}", code);
        return send(uid, SMSType.SCVerify.value(), code, to, body.toString());
    }

    /**
     * 安全中心发送确认更新手机短信
     *
     * @param to   接收手机
     * @param code 验证值
     * @param uid  用户ID
     * @return
     */
    public boolean sendSCUpdateSMS(String to, String code, Integer uid) {
        String body = configInfo.getScupdatebody();
        body.replace("{mallname}", configInfo.getSign());
        body.replace("{code}", code);
        return send(uid, SMSType.SCUpdate.value(), code, to, body.toString());
    }

    /**
     * 发送注册欢迎短信
     *
     * @param to  接收手机
     * @param uid 用户ID
     * @return
     */
    public boolean sendWebcomeSMS(String to, Integer uid) {
        String body = configInfo.getWebcomebody();
        body.replace("{mallname}", configInfo.getSign());
        body.replace("{regtime}", new Date().toString());
        body.replace("{mobile}", to);
        return send(uid, SMSType.Welcome.value(), "", to, body.toString());
    }


    /**
     * 发送找回密码短信
     *
     * @param to   接收手机
     * @param code 验证值
     * @param uid  用户ID
     * @return
     */
    public boolean sendFindPwdBody(String to, String code, Integer uid) {
        String body = configInfo.getFindpwdbody();
        body.replace("{mallname}", configInfo.getSign());
        body.replace("{code}", code);
        return send(uid, (Integer ) SMSType.FindPwd.value(), code, to, body.toString());
    }

    /**
     * 发送短信
     *
     * @param uid  接收人的UID
     * @param type 发送短信的类型
     * @param code 发送短信的CODE
     * @param to   接收人号码
     * @param body 短信内容
     * @return 是否发送成功
     */
    Boolean send(Integer uid, Integer type, String code, String to, String body) {
        return cwmsms.getIsmsStrategy().send(uid, type, code, to, body);
    }


    /**
     * 发送短信
     *
     * @param to   接收人号码
     * @param body 短信内容
     * @return 是否发送成功
     */
    public boolean sendBaseSMS(String to, String body) {

        return cwmsms.getIsmsStrategy().send(to, body);
    }


}
