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

//        List<AuthorRoleInfo> authorRoleList = authors.getUserAuthorRoleList(1);
//
//        System.out.println("authorRoleList:" + authorRoleList.toString());
//
//        cwmConfig.getIconfigstrategy().saveBaseConfig(new BaseConfigInfo());
//        cwmConfig.getIconfigstrategy().saveEmailConfig(new EmailConfigInfo());
//        cwmConfig.getIconfigstrategy().saveSMSConfig(new SMSConfigInfo());
//        cwmConfig.getIconfigstrategy().saveWechatConfig(new WechatConfigInfo());
//
//        System.out.println(cwmConfig.getIconfigstrategy().getBaseConfig());
//
//
//        List<AuthorActionInfo> ationList = authors.getUserAuthorActionList(1);
//
//        System.out.println("ationList:" + ationList.toString());
//
//        Sort sort = new Sort(Sort.Direction.DESC, "uid");
//
//        Page<PartUserInfo> userInfoPage = users.getPartUserList(10, 1, new Specification<PartUserInfo>() {
//            @Override
//            public Predicate toPredicate(Root<PartUserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//                List<Predicate> list = new ArrayList<Predicate>();
//
//                Predicate[] p = new Predicate[list.size()];
//
//                query.where(cb.and(list.toArray(p)));
//
//                model.addAttribute("paymentInfo", 1);
//                model.addAttribute("re", 2);
//
//                return query.getGroupRestriction();
//            }
//        }, sort);
//
//        for (PartUserInfo info : userInfoPage.getContent()) {
//
//            System.out.println("Success List :" + info.toString());
//
//        }
//

        return Redirect("/login");

        //return View("index");
    }


    @RequestMapping(value = "/403")
    public ModelAndView err403() {
        return View("403");
    }



}
