package com.cqwo.base.web.api.model;


import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.domain.UserRankInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户中心首页
 *
 * @author cqnews
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UCenterHomeModel implements Serializable {

    private static final long serialVersionUID = -4108981667836002780L;
    /**
     * 用户uid
     */
    private String uid;

    /**
     * 用户信息
     */
    private PartUserInfo userInfo;


    /**
     * 用户分组
     */
    private UserRankInfo userRankInfo;


}
