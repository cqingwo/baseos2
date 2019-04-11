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

package com.cqwo.base.core.plugin;

import com.cqwo.base.core.context.SpringContext;
import com.cqwo.base.core.plugin.interface2.IOAuthPlugin;
import com.cqwo.base.core.plugin.interface2.IPayPlugin;
import com.cqwo.base.core.plugin.interface2.IPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;


@Component(value = "CWMPlugin")
public class CWMPlugin {

    @Autowired
    SpringContext springConext;


    /**
     * 定时器列表
     */
    private Map<String, IPlugin> pluginList;


    /**
     * 定时器列表
     */
    private Map<String, IPayPlugin> payList;

    /**
     * 授权列表
     */
    private Map<String, IOAuthPlugin> oauthList;


    /**
     * 初始化插件
     */
    @PostConstruct
    public void init() {
        this.pluginList = SpringContext.getApplicationContext().getBeansOfType(IPlugin.class);
        this.payList = SpringContext.getApplicationContext().getBeansOfType(IPayPlugin.class);
        this.oauthList = SpringContext.getApplicationContext().getBeansOfType(IOAuthPlugin.class);
    }


    /**
     * 所有插件列表
     *
     * @return
     */
    public Map<String, IPlugin> pluginList() {
        return pluginList;
    }


    /**
     * 所有插件列表
     *
     * @return
     */
    public Map<String, IPayPlugin> payList() {
        return payList;
    }

    /**
     * 所有插件列表
     *
     * @return
     */
    public Map<String, IOAuthPlugin> oauthList() {
        return oauthList;
    }
}
