package com.cqwo.base.web.api.controller;


import com.cqwo.base.core.errors.SateCollect;
import com.cqwo.base.web.api.model.UCenterListModel;
import com.cqwo.base.web.framework.controller.BaseApiController;
import com.cqwo.base.web.framework.model.PageModel;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.pages.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 用户中心
 */
@RestController(value = "ApiUCenterController")
public class UCenterController extends BaseApiController {


    private Lock lock = new ReentrantLock();

    /**
     * Ucenter用户中心首页
     *
     * @return
     */
    @RequestMapping(value = "ucenter/index")
    public String index() {

        return JsonView(SateCollect.SUCCESS, "用户中心首页");

    }

    /**
     * 用户列表测试
     *
     * @return
     */
    @RequestMapping(value = "ucenter/list")
    public String list() {

        PageInfo<PartUserInfo> userList = users.getPartUserList(1, 1, "", "", "");

        PageModel pageModel = new PageModel(userList.getPageSize(), userList.getPageNumber(), userList.getTotalCount());

        System.out.println(userList);

        UCenterListModel model = new UCenterListModel(userList.getList(), pageModel);

        return JsonView(SateCollect.SUCCESS, model, "列表加载");
    }


}
