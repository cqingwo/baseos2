/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.framework;


public class PromptModel {

    private Integer error = 0;

    /**
     * 提示信息
     */
    private String message = "";

    /**
     * 返回地址
     */
    private String backUrl = "";


    /**
     * 倒计时模型
     */
    private int countDownModel = 0;

    /**
     * 倒计时时间
     */
    private int countDownTime = 2;

    /**
     * 是否显示返回地址
     */
    private boolean showBackLink = true;

    /**
     * 是否自动返回
     */
    private boolean autoBack = true;


    /**
     * 模型构造函数
     *
     * @param message 消息
     */
    public PromptModel(String message) {
        this.message = message;
    }

    /**
     * 模型构造函数
     *
     * @param message 消息
     * @param backUrl 返回地址
     */
    public PromptModel(String message, String backUrl) {
        this.backUrl = backUrl;
        this.message = message;
    }

    /**
     * 模型构造函数
     *
     * @param error   错误类型
     * @param message 消息
     * @param backUrl 返回地址
     */
    public PromptModel(Integer error, String message, String backUrl) {
        this.error = error;
        this.message = message;
        this.backUrl = backUrl;
    }

    /**
     * 模型构造函数
     *
     * @param backUrl  返回地址
     * @param message  消息
     * @param autoBack 是否自动返回
     */
    public PromptModel(String message, String backUrl, boolean autoBack) {
        this.message = message;
        this.backUrl = backUrl;
        this.autoBack = autoBack;
    }

    /**
     * 模型构造函数
     *
     * @param error   错误类型
     * @param message 消息
     * @param backUrl 返回地址
     * @param autoBack 是否自动返回
     */
    public PromptModel(Integer error, String message, String backUrl, boolean autoBack) {
        this.error = error;
        this.message = message;
        this.backUrl = backUrl;
        this.autoBack = autoBack;
    }

    /**
     * 模型构造函数
     *
     * @param message        消息
     * @param backUrl        返回地址
     * @param countDownModel 倒计时时间
     */
    public PromptModel(String message, String backUrl, int countDownModel) {
        this.message = message;
        this.backUrl = backUrl;
        this.countDownModel = countDownModel;
    }


    /**
     * 模型构造函数
     *
     * @param error   错误类型
     * @param message 消息
     * @param backUrl 返回地址
     * @param countDownModel 倒计时时间
     */
    public PromptModel(Integer error, String message, String backUrl, int countDownModel) {
        this.error = error;
        this.message = message;
        this.backUrl = backUrl;
        this.countDownModel = countDownModel;
    }

    /**
     * 模型构造函数
     *
     * @param backUrl        返回地址
     * @param message        消息
     * @param countDownModel 计数模型
     * @param countDownModel 倒计时时间
     * @param showBackLink   是否显示返回地址
     * @param autoBack       是否自动返回
     */
    public PromptModel(String message, String backUrl, int countDownModel, int countDownTime, boolean showBackLink, boolean autoBack) {
        this.message = message;
        this.backUrl = backUrl;
        this.countDownModel = countDownModel;
        this.countDownTime = countDownTime;
        this.showBackLink = showBackLink;
        this.autoBack = autoBack;
    }




    /**
     * 模型构造函数
     *
     * @param error   错误类型
     * @param message 消息
     * @param backUrl 返回地址
     * @param countDownModel 倒计时时间
     */
    public PromptModel(Integer error, String message, String backUrl, int countDownModel, int countDownTime, boolean showBackLink, boolean autoBack) {
        this.error = error;
        this.message = message;
        this.backUrl = backUrl;
        this.countDownModel = countDownModel;
        this.countDownTime = countDownTime;
        this.showBackLink = showBackLink;
        this.autoBack = autoBack;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public int getCountDownModel() {
        return countDownModel;
    }

    public void setCountDownModel(int countDownModel) {
        this.countDownModel = countDownModel;
    }

    public int getCountDownTime() {
        return countDownTime;
    }

    public void setCountDownTime(int countDownTime) {
        this.countDownTime = countDownTime;
    }

    public boolean isShowBackLink() {
        return showBackLink;
    }

    public void setShowBackLink(boolean showBackLink) {
        this.showBackLink = showBackLink;
    }

    public boolean isAutoBack() {
        return autoBack;
    }

    public void setAutoBack(boolean autoBack) {
        this.autoBack = autoBack;
    }
}
