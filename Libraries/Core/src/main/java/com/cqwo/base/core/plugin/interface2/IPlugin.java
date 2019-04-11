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

package com.cqwo.base.core.plugin.interface2;

import javax.annotation.PostConstruct;

/**
 * 插件接口
 */
public interface IPlugin {

//
//    /**
//     * 插件配置控制器
//     *
//     * @return
//     */
//    private String configController;
//
//    /**
//     * 插件配置动作方法
//     *
//     * @return
//     */
//    private String configAction;

    /**
     * 获取配置文档
     *
     * @return
     */
    String getConfigUrl();


    /**
     * 初始化插件
     */
    @PostConstruct
    void initPlugin();
}
