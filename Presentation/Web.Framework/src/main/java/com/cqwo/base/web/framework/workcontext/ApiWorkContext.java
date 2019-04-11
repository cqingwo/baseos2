/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.web.framework.workcontext;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 接口上下文
 *
 * @author cqnews
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiWorkContext extends BaseWorkContext {


    private static final long serialVersionUID = -3586372588079126207L;

    /**
     * api账号
     */
    private String apiKey = "";

    /**
     * 密钥
     */
    private String apiSecret = "";

    /**
     * 单位编号
     */
    private String unitCode = "";


}
