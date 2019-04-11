package com.cqwo.base.web.admin.model;

import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.base.web.framework.model.PageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author cqnews
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListModel implements Serializable {


    private static final long serialVersionUID = 7312247272374429704L;
    /**
     * 用户uid
     */
    private String uid = "";

    /**
     * 用户昵称
     */
    private String nickName = "";

    /**
     * 手机号码
     */
    private String mobile = "";

    /**
     * 用户列表
     */
    private List<PartUserInfo> userInfoList;

    /**
     * 分页模型
     */
    private PageModel pageModel;


    public UserListModel(List<PartUserInfo> userInfoList, PageModel pageModel) {
        this.userInfoList = userInfoList;
        this.pageModel = pageModel;
    }

    public UserListModel(String uid, String nickName, String mobile) {
        this.uid = uid;
        this.nickName = nickName;
        this.mobile = mobile;
    }


}
