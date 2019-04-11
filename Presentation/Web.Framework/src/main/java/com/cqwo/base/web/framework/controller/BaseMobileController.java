/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆英卡电子有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.framework.controller;

import com.cqwo.base.core.helper.WebHelper;
import com.cqwo.base.web.framework.workcontext.WebWorkContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "mob")
public class BaseMobileController extends BaseController {


    protected WebWorkContext workContext;

    public BaseMobileController() {

    }

    @Override
    public WebWorkContext getWorkContext() {
        return workContext;
    }

    @ModelAttribute
    public void setInitialize(HttpServletResponse response) throws IOException {

        this.response = response;
        this.workContext = new WebWorkContext();
        this.session = request.getSession();


        this.urlReferer = cwmUtils.getMobileRefererCookie();

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
