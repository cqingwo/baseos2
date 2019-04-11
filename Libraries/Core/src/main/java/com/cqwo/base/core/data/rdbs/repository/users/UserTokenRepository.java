package com.cqwo.base.core.data.rdbs.repository.users;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.users.UserTokenInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserTokenRepository extends BaseRepository<UserTokenInfo, Integer> {


    /**
     * 删除过期的token
     *
     * @param timestamp
     */
    @Modifying
    @Query("delete from UserTokenInfo where limitTime <= ?1")
    void deleteLitmitToken(Integer timestamp);

    /**
     * 通过用户获取token
     *
     * @param token token
     * @return
     */
    UserTokenInfo findFirstByUidAndToken(String uid, String token);

    /**
     * 通过用户uid获取token
     *
     * @param uid uid
     * @return
     */
    UserTokenInfo findFirstByUid(String uid);

}
