package com.cqwo.base.core.data.rdbs.repository.users;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.users.LoginFailLogInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface LoginFailLogRepository extends BaseRepository<LoginFailLogInfo, Integer> {

    @Modifying
    @Transactional(rollbackFor = IOException.class)
    @Query("DELETE FROM LoginFailLogInfo where loginIP=?1")
    void deleteLoginFailLogByIP(Integer ip);
}
