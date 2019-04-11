/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.strategy.ucenter.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "ucenter.config")
@PropertySource("classpath:ucenterconfig.properties")
public class UCenterConfig {


    /**
     * appId
     */
    private String appId = "";

    /**
     * 用户中心app名称
     */
    private String application = "ucenter";

    /**
     * apikey
     */
    private String apiKey = "";


    /**
     * apiSecret
     */
    private String apiSecret = "";


}
