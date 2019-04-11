/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.web.framework.controller;

import com.cqwo.base.services.UserRanks;
import com.cqwo.base.services.Users;
import com.cqwo.base.web.framework.workcontext.ApiWorkContext;
import com.cqwo.base.core.exption.CWMException;
import com.cqwo.base.core.helper.WebHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "api")
public class BaseApiController extends BaseController {

    protected ApiWorkContext workContext;


    @Autowired
    protected Users users;

    @Autowired
    protected UserRanks userRanks;




    public BaseApiController() {

    }

    @Override
    ApiWorkContext getWorkContext() {
        return workContext;
    }

    @ModelAttribute
    public void setInitialize(HttpServletResponse response) throws CWMException {

        this.response = response;
        this.workContext = new ApiWorkContext();
        this.session = request.getSession();


        /**
         * 获取当前URL
         */
        this.workContext.setUrl(WebHelper.getUrl(request));

        /**
         * 获取当前controller
         */
        this.workContext.setController(this.getClass().getName());

        /**
         * 获取当前action 暂时不能实现
         */
        this.workContext.setAction(WebHelper.getRawUrl(request));


        /**
         * 判断是否为ajax
         */
        if (WebHelper.isAjax(request)) {
            this.workContext.setHttpAjax(true);
        }

        /**
         * 获取IP
         */
        this.workContext.setIP(WebHelper.getIP(request));


        this.workContext.setUrlReferrer(WebHelper.getUrlReferrer(request));


        try {


            String apiKey = cwmUtils.getApiKeyHeader();

            String apiSecret = cwmUtils.getApiSecretHeader();


        } catch (Exception ex) {

            logs.write(ex, "上午文处理报错");

            throw new CWMException("异常退出");
        }


        this.workContext.setImageCDN("/static/admin/images");
        this.workContext.setCssCDN("/static/admin/css");
        this.workContext.setScriptCDN("/static/admin/scripts");
        this.workContext.setFontCDN("/static/admin/fonts");


        //Log.e("URL",request.getRequestURI());
    }


    @ModelAttribute
    public void inspectInitialize() { //System.out.println("inspectInitialize被执行了");
    }
}
