package com.cqwo.base.services;

import com.cqwo.ucenter.client.domain.OauthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cqnews on 2017/4/11.
 */

//第三方登录
@Service(value = "Oauths")
public class Oauths {
    @Resource(name = "OauthsData")
    com.cqwo.base.data.Oauths oauths;

    @Autowired
    private Logs logs;


    //region  第三方登录方法


    /**
     * 通过appid和uid查询第三方登录信息
     *
     * @param uid uid
     * @return
     */
    public OauthInfo findOauthByUid(String uid) {

        try {
            return oauths.findOauthByUid(uid);

        } catch (Exception ex) {
            logs.write(ex, "查询OauthInfo");
        }

        return null;

    }


    //endregion

}
