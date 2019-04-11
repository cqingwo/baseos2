/*
 *  *  Copyright  2019.
 *  *  用于JAVA项目开发
 *  *  重庆英卡电子有限公司 版权所有
 *  *  Copyright  2019.  510Link.com Iniot All rights reserved.
 */

package com.cqwo.base.web.framework.workcontext;

import com.cqwo.base.core.domain.authors.AuthorSessionInfo;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.domain.UserRankInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseAuthorContext extends BaseWorkContext {

    private static final long serialVersionUID = 5328946635309464975L;


    /**
     * 用户sid
     */
    private String sid = "";//用户sid

    /**
     * 用户id
     */
    private String uid = "";//用户id


    /**
     * 用户token
     */
    private String token = "";

    /**
     * 用户名
     */
    private String userName = "agent";//用户名

    /**
     * 用户邮箱
     */
    private String userEmail = "123@163.com";//用户邮箱

    /**
     * 用户手机号
     */
    private String userMobile = "138";//用户手机号

    /**
     * 用户昵称
     */
    private String nickName = "游客";//用户昵称

    /**
     * 用户头像
     */
    private String avatar = "";//用户头像

    /**
     * 用户密码
     */
    private String password = "";//用户密码

    /**
     * 加密密码
     */
    private String encryptPwd = "";//加密密码

    /**
     * 支付积分名称
     */
    private String payCreditName = "";//支付积分名称

    /**
     * 支付积分数量
     */
    private int payCreditCount = 0;//支付积分数量

    /**
     * 等级积分名称
     */
    private String rankCreditName = "金币";//等级积分名称

    /**
     * 等级积分数量
     */
    private int rankCreditCount = 0;//等级积分数量

    /**
     * 用户信息
     */
    private PartUserInfo partUserInfo;//用户信息

    /**
     * 用户等级id
     */
    private int userRid = -1;//用户等级id

    /**
     * 用户等级信息
     */
    private UserRankInfo userRankInfo;//用户等级信息

    /**
     * 用户等级标题
     */
    private String userRTitle = "游客";//用户等级标题


    /**
     * 用户软件管理员组信息
     */
    private List<AuthorSessionInfo> authorSessionList;//用户软件管理员组信息

}
