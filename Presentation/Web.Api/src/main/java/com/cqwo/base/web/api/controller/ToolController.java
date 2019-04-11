package com.cqwo.base.web.api.controller;

import com.cqwo.base.services.Uploads;
import com.cqwo.base.web.framework.controller.BaseApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "ApiToolController")
public class ToolController extends BaseApiController {

    @Autowired
    Uploads uploads;


    @RequestMapping(value = "tool/getuptoken")
    public String getUpToken() {
        return uploads.getUpToken();
    }

}
