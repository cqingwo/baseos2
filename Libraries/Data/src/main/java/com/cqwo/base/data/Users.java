package com.cqwo.base.data;

import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.exception.UCenterException;
import com.cqwo.base.core.ucenter.CWMUCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//用户信息
@Service(value = "UsersData")
public class Users extends DataService {

    @Autowired
    private CWMUCenter cwmUCenter;

    //region  用户信息方法

    /**
     * 用户注册
     *
     * @param account  注册账号
     * @param password 密码
     * @param nickName 昵称
     * @param avatar   头像
     * @param gender   性别
     * @param regionId 区域
     */
    public void onRegister(String account,
                           String password,
                           String nickName, String avatar, Integer gender, Integer regionId) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().onRegister(account, password, nickName, avatar, gender, regionId);
    }

    /**
     * 用户登录
     *
     * @param account  账号
     * @param password 密码
     * @return
     * @throws UCenterException
     */
    public void onLogin(String account, String password) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().onLogin(account, password);
    }

    /**
     * 用户token登录
     *
     * @param token token
     * @return
     */
    public void onLogin(String token) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().onLogin(token);
    }

    /**
     * 开发接口登录
     *
     * @param openId   opendId
     * @param unionId  联合id
     * @param nickName 昵称
     * @param avatar   头像
     * @param gender   性别
     * @param regionId 区域
     */
    public void onLogin(String server, String openId, String unionId, String nickName, String avatar, Integer gender, Integer regionId) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().onLogin(server, openId, unionId, nickName, avatar, gender, regionId);
    }

    /**
     * 更新一条用户信息数据
     *
     * @param uid      更新用户uid
     * @param nickName 更新昵称
     * @param realName 更新真实姓名
     * @param regionId 更新区域Id
     * @param address  更新地址
     * @param bio      更新描述
     * @return
     */
    public PartUserInfo updateUser(String uid, String nickName, String realName, int regionId, String address, String bio) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().updateUser(uid, nickName, realName, regionId, address, bio);
    }


    /**
     * 获取一条用户信息数据
     *
     * @param uid 用户信息模型
     **/
    @Cacheable(value = "getPartUserByUid", key = "#uid")
    public PartUserInfo getPartUserByUid(String uid) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getPartUserByUid(uid);
    }


    /**
     * 获得用户信息数据列表
     *
     * @param uid      uid
     * @param nickName 昵称
     * @param mobile   手机号
     * @return 返回UserInfo
     **/
    public List<PartUserInfo> getPartUserList(String uid, String nickName, String mobile) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getPartUserList(uid, nickName, mobile);
    }


    /**
     * 获得用户信息数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param uid        uid
     * @param nickName   昵称
     * @param mobile     手机号
     * @return 返回UserInfo
     **/
    public void getPartUserList(Integer pageSize, Integer pageNumber, String uid, String nickName, String mobile) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().getPartUserList(pageSize, pageNumber, uid, nickName, mobile);
    }


    /**
     * 通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return
     */
    @Cacheable(value = "getPartUserByUserName", key = "#userName")
    public PartUserInfo getPartUserByUserName(String userName) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getPartUserByUserName(userName);
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param email 邮箱
     * @return
     */
    @Cacheable(value = "getPartUserByEmail", key = "#email")
    public PartUserInfo getPartUserByEmail(String email) throws UCenterException {

        return cwmUCenter.getIUCenterStrategy().getPartUserByEmail(email);
    }

    /**
     * 通过用户手机获取用户信息
     *
     * @param mobile 手机
     * @return
     * @throws UCenterException
     */
    @Cacheable(value = "getPartUserByMobile", key = "#mobile")
    public PartUserInfo getPartUserByMobile(String mobile) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getPartUserByMobile(mobile);
    }


    /**
     * 通过topenId获取用户信息
     *
     * @param openId openId
     * @return
     */
    @Cacheable(value = "getPartUserByOpenId", key = "#openId")
    public PartUserInfo getPartUserByOpenId(String openId) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getPartUserByOpenId(openId);
    }


    /**
     * 通过unionId获取用户信息
     *
     * @param unionId unionId
     * @return
     */
    @Cacheable(value = "getPartUserByUnionId", key = "#unionId")
    public PartUserInfo getPartUserByUnionId(String unionId) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getPartUserByUnionId(unionId);
    }


    /**
     * 更新用户组
     *
     * @param uid     用户uid
     * @param userRid 用户分组
     */
    public void updateUserRankByUid(String uid, Integer userRid) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().updateUserRankByUid(uid, userRid);
    }

    /**
     * 更新手机
     *
     * @param uid    uid
     * @param mobile 手机
     */
    public void updateUserMobile(String uid, String mobile) throws UCenterException {
        cwmUCenter.getIUCenterStrategy().updateUserMobile(uid, mobile);
    }


    /**
     * 获取用户头像
     *
     * @param uid uid
     * @return 返回头像
     */
    @Cacheable(value = "getUserAvatar", key = "#uid")
    public String getUserAvatar(String uid) throws UCenterException {
        return cwmUCenter.getIUCenterStrategy().getUserAvatar(uid);
    }


    //endregion

}
