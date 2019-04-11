package com.cqwo.base.web.controller;


import com.cqwo.base.core.cache.CWMCache;
import com.cqwo.base.core.config.CWMConfig;
import com.cqwo.base.services.Authors;
import com.cqwo.base.services.SMSes;
import com.cqwo.base.services.Users;
import com.cqwo.base.web.framework.controller.BaseWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeController")
public class HomeController extends BaseWebController {

    @Autowired
    SMSes smSes;


    @Autowired
    CWMCache cwmCache;

    @Autowired
    Users users;

    @Autowired
    Authors authors;

    @Autowired
    CWMConfig cwmConfig;

    @RequestMapping(value = "/")
    public ModelAndView index() {

        return Redirect("/login");

    }


    @RequestMapping(value = "/403")
    public ModelAndView err403() {
        return View("403");
    }



}
