package com.cqwo.base.web.api.controller;


import com.cqwo.base.core.errors.SateCollect;
import com.cqwo.base.web.framework.controller.BaseApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * banner
 */
@RestController(value = "ApiBannerController")
public class BannerController extends BaseApiController {



    @RequestMapping(value = "banner/list")
    public String list(){

        List<String> bannerList = new ArrayList<>();

        return JsonView(SateCollect.SUCCESS, bannerList, "banner加载成功");

    }
}

