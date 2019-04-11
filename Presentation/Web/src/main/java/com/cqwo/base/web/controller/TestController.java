package com.cqwo.base.web.controller;

import com.cqwo.base.services.Persons;
import com.cqwo.base.services.Users;
import com.cqwo.base.services.WechatMiniUtils;
import com.cqwo.base.web.framework.controller.BaseWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController(value = "TestController")
public class TestController extends BaseWebController {

    @Autowired
    Persons persons;

    @Autowired
    Users users;

    @Autowired
    WechatMiniUtils wechatMiniUtils;


    /**
     * hellow
     *
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello() {


        return "我喜欢周婷";
    }


}
