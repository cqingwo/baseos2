package com.cqwo.base.data;

import com.cqwo.base.core.ucenter.CWMUCenter;
import com.cqwo.ucenter.client.domain.OauthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by cqnews on 2017/4/11.
 */


//第三方登录
@Service(value = "OauthsData")
public class Oauths extends DataService {

    @Autowired
    CWMUCenter cwmuCenter;

    /**
     * 通过appid和uid查询第三方登录信息
     *
     * @param uid uid
     * @return
     */
    @Cacheable(value = "findOauthByUid", key = "#uid")
    public OauthInfo findOauthByUid(String uid) throws Exception {


        return cwmuCenter.getIUCenterStrategy().findOauthByUid(uid);

    }

}
