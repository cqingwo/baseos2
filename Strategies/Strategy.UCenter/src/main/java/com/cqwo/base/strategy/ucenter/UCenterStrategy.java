/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.strategy.ucenter;

import com.cqwo.base.core.config.AppConfig;
import com.cqwo.base.core.ucenter.IUCenterStrategy;
import com.cqwo.base.strategy.ucenter.config.UCenterConfig;
import com.cqwo.ucenter.client.impl.UcenterClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * 用户中心操作接口
 */
@Component(value = "UCenterStrategy")
public class UCenterStrategy extends UcenterClientImpl implements IUCenterStrategy {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UCenterConfig ucenterConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Override
    public String getAppId() {
        return ucenterConfig.getAppId();
    }

    @Override
    public String getApiKey() {
        return ucenterConfig.getApiKey();
    }

    @Override
    public String getApiSecret() {
        return ucenterConfig.getApiSecret();
    }

    @Override
    public String getApiUrl(String address) {
        return "http://" + ucenterConfig.getApplication() + "/api/" + address;
    }
}
