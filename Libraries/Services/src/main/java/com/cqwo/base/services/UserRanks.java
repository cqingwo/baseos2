package com.cqwo.base.services;

import com.cqwo.ucenter.client.domain.UserRankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */

//用户等级
@Service(value = "UserRanks")
public class UserRanks {


    @Autowired
    private Logs logs;

    public UserRankInfo getUserRankByUserRid(int i) {
        return new UserRankInfo();
    }

    public UserRankInfo getUserRankByCredits(Integer payCredits) {
        return new UserRankInfo();
    }

    public List<UserRankInfo> getAllUserRankList() {
        return new ArrayList<>();
    }


}
