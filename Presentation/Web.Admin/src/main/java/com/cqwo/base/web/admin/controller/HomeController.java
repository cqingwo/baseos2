package com.cqwo.base.web.admin.controller;

import com.cqwo.base.web.framework.controller.BaseAdminController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller(value = "AdminHomeController")
public class HomeController extends BaseAdminController {

    //必须同时复核index:hello和index:world权限要求
//    @RequiresPermissions(value = "home:index")
    @RequestMapping("index")
    public ModelAndView index() {

        return View();
    }


    /**
     * 运行
     *
     * @return
     */
    @RequestMapping("runinfo")
    public ModelAndView runinfo() {

        return View();
    }
}
