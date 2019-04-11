/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆英卡电子有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.web.framework.controller;

import com.cqwo.base.core.domain.authors.AuthUserInfo;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.base.core.exption.CWMException;
import com.cqwo.base.core.helper.WebHelper;
import com.cqwo.base.web.framework.workcontext.AdminWorkContext;
import com.cqwo.base.web.framework.workcontext.IWorkContext;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "admin")
public class BaseAdminController extends BaseController {

    protected AdminWorkContext workContext;

    public BaseAdminController() {

    }

    @Override
    IWorkContext getWorkContext() {
        return workContext;
    }

    @ModelAttribute
    public void setInitialize(HttpServletResponse response) throws IOException {


        this.response = response;
        this.workContext = new AdminWorkContext();
        this.session = request.getSession();

        this.urlReferer = cwmUtils.getAdminRefererCookie();

        /*
         * 获取当前URL
         */
        this.workContext.setUrl(WebHelper.getUrl(request));

        /*
         * 获取当前controller
         */
        this.workContext.setController(this.getClass().getName());

        /*
         * 获取当前action 暂时不能实现
         */
        this.workContext.setAction(WebHelper.getRawUrl(request));

        /*
         * 获取sessionid
         */
        this.workContext.setSid(session.getId());

        /*
         * 判断是否为ajax
         */
        if (WebHelper.isAjax(request)) {
            this.workContext.setHttpAjax(true);
        }

        /*
         * 获取IP
         */
        this.workContext.setIP(WebHelper.getIP(request));


        this.workContext.setUrlReferrer(WebHelper.getUrlReferrer(request));

        this.workContext.setSid(session.getId());


        try {

            AuthUserInfo authUserInfo = (AuthUserInfo) SecurityUtils.getSubject().getPrincipal();

            PartUserInfo userInfo = authUserInfo.getUserInfo();

            if (userInfo == null || userInfo.getUid().isEmpty()) {
                throw new CWMException("用户读取失败");
            }


            String uid = userInfo.getUid();
            String token = users.findUserToken(uid).getToken();

            this.workContext.setUid(uid);
            this.workContext.setPartUserInfo(userInfo);
            this.workContext.setToken(token);

            this.workContext.setUserRankInfo(userRanks.getUserRankByCredits(userInfo.getPayCredits()));

            if (this.workContext.getUserRankInfo() != null) {


                this.workContext.setUserRid(this.workContext.getUserRankInfo().getUserRid());
                if (!this.workContext.getUserRankInfo().getUserRid().equals(userInfo.getUserRid())) {

                    userInfo.setUserRid(this.workContext.getUserRankInfo().getUserRid());
                    users.updateUserRankByUid(userInfo.getUid(), this.workContext.getUserRid());
                }


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (this.workContext.getPartUserInfo() == null || this.workContext.getPartUserInfo().getUid().isEmpty()) {

            this.workContext.setPartUserInfo(users.getGuestPartUserInfo());
            this.workContext.setUserRankInfo(userRanks.getUserRankByUserRid(6));


        }

        this.workContext.setUserRid(workContext.getUserRankInfo().getUserRid());
        this.workContext.setNickName(workContext.getPartUserInfo().getNickName());


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


