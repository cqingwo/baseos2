/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆英卡电子有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.framework.workcontext;

import com.cqwo.base.core.config.info.BaseConfigInfo;
import com.cqwo.base.core.domain.base.RegionInfo;
import com.cqwo.base.core.CWMVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author cqnews
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseWorkContext implements IWorkContext {

    private static final long serialVersionUID = 6627724574053553179L;
    /**
     * 项目基本配置
     */
    private BaseConfigInfo baseConfigInfo = new BaseConfigInfo();

    /**
     * 标题
     */
    private String title = "英卡电子";

    /**
     * 关键词
     */
    private String keywords = "英卡电子";

    /**
     * 描述
     */
    private String description = "英卡电子";


    /**
     * 当前请求是否为ajax请求
     */
    private boolean isHttpAjax = false;
    /**
     * 用户ip
     */
    private String IP = "127.0.0.1";//用户ip

    /**
     * 区域信息
     */
    private RegionInfo regionInfo = new RegionInfo();//区域信息

    /**
     * 区域id
     */
    private int regionId = 0;//区域id

    /**
     * 当前url
     */
    private String url = "";//当前url

    /**
     * 上一次访问的url
     */
    private String urlReferrer = "";//上一次访问的url


    /**
     * 控制器
     */
    private String controller = "home";//控制器

    /**
     * 动作方法
     */
    private String action = "action";//动作方法

    /**
     * 页面标示符
     */
    private String pageKey = "homeaction";//页面标示符

    /**
     * 图片cdn
     */
    private String imageCDN = "/static/admin/images";//图片cdn

    /**
     * csscdn
     */
    private String cssCDN = "/static/admin/css";//csscdn

    /**
     * 脚本cdn
     */
    private String scriptCDN = "/static/admin/scripts";//脚本cdn

    /**
     * 字体cdn
     */
    private String fontCDN = "/static/admin/fonts";//字体cdn

    /**
     * 插件路径
     */
    private String pluginCDN = "/components";//插件路径

    /**
     * 在线总人数
     */
    private int onlineUserCount = 0;//在线总人数

    /**
     * 在线会员数
     */
    private int onlineMemberCount = 0;//在线会员数

    /**
     * 在线游客数
     */
    private int onlineGuestCount = 0;//在线游客数


    /**
     * 页面执行时间
     */
    private double executeTime = 0;//页面执行时间

    /**
     * 执行的sql语句数目
     */
    private int executeCount = 0;//执行的sql语句数目

    /**
     * 执行的sql语句细节
     */
    private String executeDetail = "";//执行的sql语句细节

    /**
     * 软件版本
     */
    private String version = CWMVersion.VERSION;//软件版本

    /**
     * 软件版权
     */
    private String copyright = CWMVersion.COPYRIGHT;//软件版权


}
