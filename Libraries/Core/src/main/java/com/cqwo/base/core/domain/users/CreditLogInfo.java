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

//用户日志
@Entity
@Table(name = "w_user_creditlogs")
public class CreditLogInfo implements Serializable {


    private static final long serialVersionUID = 5540483259055734690L;
    /**
     * 日志Id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logid")
    private Integer logId;

    /**
     * Uid
     **/
    @Column(name = "uid", nullable = false)
    private Integer uid = -1;

    /**
     * 支付积分
     **/
    @Column(name = "paycredits", nullable = false)
    private Integer payCredits = 0;

    /**
     * 积分等级
     **/
    @Column(name = "rankcredits", nullable = false)
    private Integer rankCredits = 0;

    /**
     * 动作类型
     **/
    @Column(name = "action", nullable = false)
    private Integer action = 0;

    /**
     * 动作代码
     **/
    @Column(name = "actioncode", nullable = false)
    private Integer actionCode = 0;

    /**
     * 动作时间
     **/
    @Column(name = "actiontime", nullable = false)
    private Integer actionTime = 0;

    /**
     * 动作描述
     **/
    @Column(name = "actiondes", nullable = false, length = 150)
    private String actionDes = "";

    /**
     * 操作人
     **/
    @Column(name = "operator", nullable = false)
    private Integer operator = -1;


    public CreditLogInfo() {
    }

    public CreditLogInfo(Integer logId) {
        this.logId = logId;
    }

    public CreditLogInfo(Integer logId, Integer uid, Integer payCredits, Integer rankCredits, Integer action, Integer actionCode, Integer actionTime, String actionDes, Integer operator) {
        this.logId = logId;
        this.uid = uid;
        this.payCredits = payCredits;
        this.rankCredits = rankCredits;
        this.action = action;
        this.actionCode = actionCode;
        this.actionTime = actionTime;
        this.actionDes = actionDes;
        this.operator = operator;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPayCredits() {
        return payCredits;
    }

    public void setPayCredits(Integer payCredits) {
        this.payCredits = payCredits;
    }

    public Integer getRankCredits() {
        return rankCredits;
    }

    public void setRankCredits(Integer rankCredits) {
        this.rankCredits = rankCredits;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getActionCode() {
        return actionCode;
    }

    public void setActionCode(Integer actionCode) {
        this.actionCode = actionCode;
    }

    public Integer getActionTime() {
        return actionTime;
    }

    public void setActionTime(Integer actionTime) {
        this.actionTime = actionTime;
    }

    public String getActionDes() {
        return actionDes;
    }

    public void setActionDes(String actionDes) {
        this.actionDes = actionDes;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "CreditLogInfo{" +
                "logId=" + logId +
                ", uid=" + uid +
                ", payCredits=" + payCredits +
                ", rankCredits=" + rankCredits +
                ", action=" + action +
                ", actionCode=" + actionCode +
                ", actionTime=" + actionTime +
                ", actionDes='" + actionDes + '\'' +
                ", operator=" + operator +
                '}';
    }
}