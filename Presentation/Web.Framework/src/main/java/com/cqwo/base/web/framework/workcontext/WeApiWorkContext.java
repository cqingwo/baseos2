/*
 *
 *  *
 *  *  * Copyright (C) 2018.
 *  *  * 用于JAVA项目开发
 *  *  * 重庆英卡电子有限公司 版权所有
 *  *  * Copyright (C)  2018.  CqingWo Systems Incorporated. All rights reserved.
 *  *
 *
 */

package com.cqwo.base.web.framework.workcontext;

import lombok.*;

/**
 * @author cqnews
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeApiWorkContext extends BaseAuthorContext {


    private static final long serialVersionUID = -3180484389029129838L;
    /**
     * api账号
     */
    private String apiKey = "1311535288";

    /**
     * 密钥
     */
    private String apiSecret = "7uvF4ZfA7B2JWm0CN8Dm6F7HMIMaYszr";

    /**
     * 用户token 计算出来
     */
    private String accessToken = "";

    /**
     * 接收token
     */
    private String token = "";//Token

    /**
     * 用户openid
     */
    private String openId = "";

    /**
     * 用户sessionId
     */
    private String sessionId = "";


}
