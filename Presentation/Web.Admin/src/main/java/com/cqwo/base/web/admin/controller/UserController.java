package com.cqwo.base.web.admin.controller;

import com.cqwo.base.services.Authors;
import com.cqwo.base.services.Regions;
import com.cqwo.base.services.UserRanks;
import com.cqwo.base.services.Users;
import com.cqwo.base.web.admin.model.UserEditModel;
import com.cqwo.base.web.admin.model.UserListModel;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.domain.UserRankInfo;
import com.cqwo.ucenter.client.pages.PageInfo;
import com.cqwo.base.core.domain.base.RegionInfo;
import com.cqwo.base.core.helper.StringHelper;
import com.cqwo.base.core.helper.TypeHelper;
import com.cqwo.base.core.model.SelectListItem;
import com.cqwo.base.web.framework.controller.BaseAdminController;
import com.cqwo.base.web.framework.model.PageModel;
import com.cqwo.base.web.framework.validate.ValidateModel;
import com.cqwo.base.web.framework.validate.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 管理中心用户模块
 */
@Controller(value = "AdminUserController")
public class UserController extends BaseAdminController {


    @Autowired
    private Users users;


    @Autowired
    private Regions regions;

    private Lock lock = new ReentrantLock();

    @Autowired
    private UserRanks userRanks;

    @Autowired
    private Authors authors;

    /**
     * 用户中心首页
     *
     * @return
     */
    @RequestMapping(value = "user/index")
    public ModelAndView index() {
        return View();
    }


    /**
     * 用户记中心列表
     *
     * @param pageSize   每页条数
     * @param pageNumber 当前页数
     * @return
     */
    @RequestMapping(value = "user/list")
    public ModelAndView list(@RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "1") Integer pageNumber, UserListModel model) {

        Specification<PartUserInfo> condition = users.getPartUserListCondition(model.getUid(), model.getNickName(), model.getMobile());
        Sort sort = new Sort(Sort.Direction.DESC, "uid");

        PageInfo<PartUserInfo> infoPage = users.getPartUserList(pageSize, pageNumber, "", "", "");

        if (infoPage == null) {
            return PromptView("没有更多的数据");
        }

        List<PartUserInfo> userInfoList = infoPage.getList();

        cwmUtils.setAdminRefererCookie(response, cwmUtils.getRawUrl());

        PageModel pageModel = new PageModel(infoPage.getPageSize(), infoPage.getPageNumber(), infoPage.getTotalCount());

        model = new UserListModel(userInfoList, pageModel);

        return View(model);


    }

    /**
     * 修改用户信息
     *
     * @param uid 用户uid
     * @return
     */
    @RequestMapping(value = "user/edit", method = RequestMethod.GET)
    public ModelAndView editGet(@RequestParam(defaultValue = "0") String uid) {


        if (StringHelper.isNullOrWhiteSpace(uid)) {
            return PromptView("用户uid不正确");
        }

        PartUserInfo userInfo = users.getPartUserByUid(uid);

        if (userInfo == null) {
            return PromptView("用户不存在");
        }

        UserEditModel model = new UserEditModel();

        model.setUid(userInfo.getUid());
        model.setUserName(userInfo.getUserName());
        model.setEmail(userInfo.getEmail());
        model.setMobile(userInfo.getMobile());
        if (!StringHelper.isEmpty(model.getPassword())) {
            model.setPassword(model.getPassword());
        }
        model.setUserRid(userInfo.getUserRid());
        model.setNickName(userInfo.getNickName());
        model.setRealName(userInfo.getRealName());
        model.setRegionId(userInfo.getRegionId());
        model.setAddress(userInfo.getAddress());
        model.setBio("");

        List<SelectListItem> userRankItmeList = new ArrayList<SelectListItem>();


        List<UserRankInfo> userRankInfoList = userRanks.getAllUserRankList();

        for (UserRankInfo info : userRankInfoList) {

            SelectListItem item = new SelectListItem();

            item.setText(info.getTitle());
            item.setValue(TypeHelper.intToString(info.getUserRid()));


            if (info.getUserRid().equals(userInfo.getUserRid())) {
                item.setSelected(true);
            }

            userRankItmeList.add(item);
        }

        model.setUserRankItemList(userRankItmeList);

        RegionInfo regionInfo = regions.getRegionByRegionid(userInfo.getRegionId());

        model.setRegionInfo(regionInfo);

        return View(model);


    }

    /**
     * 修改用户信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "user/edit", method = RequestMethod.POST)
    public ModelAndView editPost(UserEditModel model) {

        lock.lock();
        try {
            ValidationResult result = ValidateModel.validateEntity(model);

            if (result.isNotErrors()) {

                PartUserInfo info = users.updateUser(model.getUid(),
                        model.getNickName(),
                        model.getRealName(),
                        model.getRegionId(),
                        model.getAddress(),
                        model.getBio());

                if (info == null || info.getUid().isEmpty()) {
                    return PromptView("用户信息修改失败");
                }


                return PromptView("用户信息修改成功");

            }

            return PromptView("edit?uid=" + model.getUid(), "用户数据校验失败," + result.toString());

        } catch (Exception ex) {

            logs.write(ex, "用户信息发生故障");
        } finally {
            lock.unlock();
        }


        return PromptView("用户信息修改失败");
    }

}
