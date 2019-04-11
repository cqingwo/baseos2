package com.cqwo.base.data;

import com.cqwo.base.core.domain.users.UserTokenInfo;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: cqnews
 * @Date: 2018-09-29 17:43
 * @Version 1.0
 */
@Component(value = "UserTokenDatas")
public class UserTokens extends DataService {


    //region token管理

    /**
     * 更新用户的token信息
     *
     * @param userTokenInfo 用户模型
     * @return 返回创建信息
     **/
    @CachePut(value = "userToken", key = "#userTokenInfo.uid")
    public UserTokenInfo updateUserToken(UserTokenInfo userTokenInfo) throws IOException {
        return getCwmData().getIUserStrategy().updateUserToken(userTokenInfo);
    }


    /**
     * 删除过期token
     */
    public void deleteLitmitToken() throws IOException {
        getCwmData().getIUserStrategy().deleteLitmitToken();
    }


    /**
     * 获取token
     *
     * @param uid uid
     * @return
     */
    @Cacheable(value = "userToken", key = "#uid")
    public UserTokenInfo findUserToken(String uid) throws IOException {
        return getCwmData().getIUserStrategy().findUserToken(uid);
    }


    //endregion

}
