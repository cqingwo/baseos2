package com.cqwo.base.services;

import com.cqwo.base.core.domain.users.UserDetailInfo;
import com.cqwo.base.core.domain.users.UserToken;
import com.cqwo.base.core.domain.users.UserTokenInfo;
import com.cqwo.base.core.exption.token.NoLoginException;
import com.cqwo.base.core.exption.token.TokenDecryptException;
import com.cqwo.base.core.exption.token.TokenException;
import com.cqwo.base.core.helper.*;
import com.cqwo.base.data.UserDetails;
import com.cqwo.base.data.UserTokens;
import com.cqwo.ucenter.client.domain.PartUserInfo;
import com.cqwo.ucenter.client.exception.UCenterException;
import com.cqwo.ucenter.client.exception.UCenterLoginSuccessException;
import com.cqwo.ucenter.client.exception.UCenterPageListSuccessException;
import com.cqwo.ucenter.client.pages.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//用户
@Service(value = "Users")
public class Users {

    @Autowired
    private com.cqwo.base.data.Users users;


    @Resource(name = "UserDetailsData")
    private UserDetails userDetails;

    @Autowired
    private Logs logs;

    @Autowired
    private Oauths oauths;

    @Autowired
    private UserTokens userTokens;


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
                           String nickName, String avatar, Integer gender, Integer regionId) throws UCenterException, NoLoginException {
        //Map<String, Object> maps = new HashMap<>();

        try {

            users.onRegister(account, password, nickName, avatar, gender, regionId);

        } catch (UCenterLoginSuccessException ex) {

            updateUserToken(ex.getUid(), ex.getToken());
            throw ex;

        } catch (UCenterException ex) {

            logs.write(ex, "数据解析异常");
            throw ex;

        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "用户登录失败");
            throw new UCenterException("用户登录失败");
        }
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
    public void onLogin(String openId,
                        String unionId,
                        String nickName, String avatar, Integer gender, Integer regionId) throws NoLoginException, UCenterException {
        onLogin("wechat", openId, unionId, nickName, avatar, gender, regionId);
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
    public void onLogin(String server,
                        String openId,
                        String unionId,
                        String nickName,
                        String avatar,
                        Integer gender,
                        Integer regionId) throws UCenterException, NoLoginException {

        try {

            users.onLogin(server, openId, unionId, nickName, avatar, gender, regionId);


        } catch (UCenterLoginSuccessException ex) {

            updateUserToken(ex.getUid(), ex.getToken());
            throw ex;

        } catch (UCenterException ex) {

            logs.write(ex, "数据解析异常");
            throw ex;

        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "用户登录失败");
            throw new UCenterException("用户登录失败");
        }
    }

    /**
     * 用户登录
     *
     * @param account  账号
     * @param password 密码
     * @return
     * @throws IOException
     */
    public void onLogin(String account, String password) throws UCenterException, NoLoginException {


        try {
            users.onLogin(account, password);

        } catch (UCenterLoginSuccessException ex) {

            updateUserToken(ex.getUid(), ex.getToken());
            throw ex;

        } catch (UCenterException ex) {
            logs.write(ex, "数据解析错误");
            throw ex;

        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "用户登录失败");
            throw new UCenterException("用户登录失败");
        }
    }


    /**
     * 用户token登录
     * token
     *
     * @return
     */
    public void onLogin(String token) throws UCenterException, NoLoginException {

        try {

            users.onLogin(token);

        } catch (UCenterLoginSuccessException ex) {

            updateUserToken(ex.getUid(), ex.getToken());
            throw ex;

        } catch (UCenterException ex) {
            logs.write(ex, "数据解析错误");
            throw ex;

        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "用户登录失败");
            throw new UCenterException("用户登录失败");
        }

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
    public PartUserInfo updateUser(String uid,
                                   String nickName,
                                   String realName,
                                   int regionId,
                                   String address,
                                   String bio
    ) {
        try {
            return users.updateUser(uid, nickName, realName, regionId, address, bio);
        } catch (Exception e) {
            logs.write(e, "更新一条用户信息数据异常");
        }

        return null;
    }


    /**
     * 获取一条用户信息数据
     *
     * @param uid 用户信息模型
     **/
    public PartUserInfo getUserByUid(String uid) {
        try {
            return users.getPartUserByUid(uid);
        } catch (Exception e) {
            logs.write(e, "获取一条用户信息数据");
        }

        return null;
    }


    /**
     * 获得用户信息数据列表
     *
     * @param uid      uid
     * @param nickName 昵称
     * @param mobile   手机号
     * @return 返回UserInfo
     **/
    public List<PartUserInfo> getUserList(String uid, String nickName, String mobile) {

        List<PartUserInfo> userList = new ArrayList<PartUserInfo>();

        try {
            userList = users.getPartUserList(uid, nickName, mobile);
        } catch (Exception e) {
            logs.write(e, "获得用户信息数据列表异常");
        }

        return userList;
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
    public PageInfo<PartUserInfo> getUserList(Integer pageSize, Integer pageNumber, String uid, String nickName, String mobile) {

        List<PartUserInfo> userList = new ArrayList<>();

        try {

            users.getPartUserList(pageSize, pageNumber, uid, nickName, mobile);

        } catch (UCenterPageListSuccessException ex) {

            return ex.getPageInfo();

        } catch (Exception ex) {

            logs.write(ex, "获得用户信息数据列表异常");

        }

        return null;
    }


    //endregion

    /**
     * 获取一条用户数据
     *
     * @param uid 用户模型
     **/
    public PartUserInfo getPartUserByUid(String uid) {


        try {

            if (uid.isEmpty()) {
                return null;
            }

            return users.getPartUserByUid(uid);
        } catch (Exception ex) {
            logs.write(ex, "获取一条用户数据");
        }
        return null;
    }

    public PageInfo<PartUserInfo> getPartUserList(Integer pageSize, Integer pageNumber, String keyword) {

        try {

            if (ValidateHelper.isValidMobile(keyword)) {
                return getPartUserList(pageSize, pageNumber, "", "", keyword);
            } else {
                return getPartUserList(pageSize, pageNumber, "", keyword, "");
            }


        } catch (Exception ex) {

        }

        return null;

    }

    /**
     * 获得用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @return 返回UserInfo
     **/
    public PageInfo<PartUserInfo> getPartUserList(Integer pageSize,
                                                  Integer pageNumber,
                                                  String uid,
                                                  String nickName,
                                                  String mobile) {


        try {

            users.getPartUserList(pageSize, pageNumber, uid, nickName, mobile);

        } catch (UCenterPageListSuccessException ex) {

            return ex.getPageInfo();

        } catch (Exception ex) {

            ex.printStackTrace();
            logs.write(ex, "获取用户数据列表");
        }

        return null;

    }


    /**
     * 通过用户名获取用户信息
     *
     * @param userName
     * @return
     */
    public PartUserInfo getPartUserByUserName(String userName) {

        try {
            return users.getPartUserByUserName(userName);

        } catch (Exception ex) {

            logs.write(ex, "通过用户名获取用户信息");
        }
        return null;
    }

    public String getShowNameByUid(String uid) {

        String showName = "游客";

        try {

            if (StringHelper.isNullOrWhiteSpace(uid)) {
                return showName;
            }

            PartUserInfo userInfo = users.getPartUserByUid(uid);

            if (userInfo == null || StringHelper.isNullOrWhiteSpace(uid)) {
                return showName;
            }

            if (StringHelper.isNotNullOrWhiteSpace(userInfo.getRealName())) {
                return userInfo.getRealName();
            }


            if (StringHelper.isNotNullOrWhiteSpace(userInfo.getNickName())) {
                return userInfo.getNickName();
            }

            if (StringHelper.isNotNullOrWhiteSpace(userInfo.getMobile())) {
                return userInfo.getMobile();
            }

            if (StringHelper.isNotNullOrWhiteSpace(userInfo.getUserName())) {
                return userInfo.getUserName();
            }

            return userInfo.getUid();


        } catch (Exception ex) {

        }

        return showName;

    }

    /**
     * 通过用户名获取用户信息
     *
     * @param email
     * @return
     */
    public PartUserInfo getPartUserByEmail(String email) {
        try {

            return users.getPartUserByEmail(email);

        } catch (Exception ex) {
            logs.write(ex, "通过用户名获取用户信息");
        }
        return null;
    }

    /**
     * 通过用户手机获取用户信息
     *
     * @param mobile
     * @return
     */
    public PartUserInfo getPartUserByMobile(String mobile) {
        try {

            return users.getPartUserByMobile(mobile);

        } catch (Exception ex) {
            logs.write(ex, "通过用户名获取用户信息");
        }
        return null;
    }


    /**
     * 生成盐值
     *
     * @return
     */
    public String createSalt() {
        return RandomHelper.generateString(6);
    }


    /**
     * 创建用户密码
     *
     * @param password 真实密码
     * @param salt     散列盐值
     * @return
     */
    public static String createUserPassword(String password, String salt) {
        return SecureHelper.md5(password + salt);
    }

    public static void main(String[] args) {
    }


    /**
     * 更新用户组
     *
     * @param uid     用户uid
     * @param userRid 用户分组
     */
    public void updateUserRankByUid(String uid, Integer userRid) {

        try {
            users.updateUserRankByUid(uid, userRid);
        } catch (Exception ex) {
            logs.write(ex, "更新用户组失败");
        }
    }


    /**
     * 更新手机
     *
     * @param uid
     * @param mobile
     */
    public void updateUserMobile(String uid, String mobile) {

        try {


            users.updateUserMobile(uid, mobile);


        } catch (Exception ex) {
            logs.write(ex, "更新用户手机失败");
        }

    }

    /**
     * 通过用户openid和联合id查询用户信息
     *
     * @param openId
     * @param unionId
     * @return
     */
    public PartUserInfo getPartUserByWechatOpenId(String openId, String unionId) {

        PartUserInfo userInfo = null;


        try {
            userInfo = users.getPartUserByOpenId(openId);

            if (userInfo == null && StringHelper.isNotNullOrWhiteSpace(unionId)) {
                userInfo = users.getPartUserByUnionId(unionId);
            }


        } catch (Exception ex) {
            logs.write(ex, "通过用户openid和联合id查询用户信息");
        }


        return userInfo;
    }

    public PartUserInfo getGuestPartUserInfo() {
        return new PartUserInfo();
    }

    /**
     * 安全处理用户信息
     *
     * @param userInfo
     * @return
     */
    public PartUserInfo securityUserInfo(PartUserInfo userInfo) {

        if (userInfo == null) {
            return null;
        }

        userInfo.setPassword("*****");
        userInfo.setMobile(StringHelper.replaceWithSpecialChar(userInfo.getMobile()));
        userInfo.setSalt("******");

        return userInfo;
    }


    /**
     * 检验签名
     *
     * @param openId    openId
     * @param rawData   校验串
     * @param signature 签名
     * @return
     */
    public boolean checkSignature(String openId, String rawData, String signature) {

        if (StringHelper.IsNullOrEmpty(openId)) {
            return false;
        }

        if (StringHelper.IsNullOrEmpty(rawData)) {
            return false;
        }


        String s = SecureHelper.sha1(rawData + openId);

        if (signature.equals(s)) {
            return true;
        }


        return false;
    }


    /**
     * 获取用户头像
     *
     * @param uid
     * @return
     */
    public String getUserAvatarUrl(String uid) {

        String avatar = "http://www.510link.com/img/logo.png";

        try {

            String s = users.getUserAvatar(uid);

            if (StringHelper.isNotNullOrWhiteSpace(s)) {
                avatar = s;
            }


        } catch (Exception ex) {

            logs.write("获取头像失败");
        }

        return avatar;

    }


    //region  用户详情方法

    /**
     * 获得用户详情数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getUserDetailCount(Specification<UserDetailInfo> condition) {

        try {
            return userDetails.getUserDetailCount(condition);
        } catch (Exception e) {
            logs.write(e, "获得用户详情数量失败");
        }
        return 0;
    }

    /**
     * 创建一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     * @return 返回创建信息
     **/
    public UserDetailInfo createUserDetail(UserDetailInfo userdetailInfo) {
        try {
            return userDetails.createUserDetail(userdetailInfo);
        } catch (Exception e) {
            logs.write(e, "创建一条用户详情数据失败");
        }
        return null;
    }

    /**
     * 更新一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     **/
    public UserDetailInfo updateUserDetail(UserDetailInfo userdetailInfo) {
        try {
            return userDetails.updateUserDetail(userdetailInfo);
        } catch (Exception e) {
            logs.write(e, "更新一条用户详情数据异常");
        }

        return null;
    }

    /**
     * 删除一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    public void deleteUserDetailById(Integer id) {
        try {
            userDetails.deleteUserDetailById(id);
        } catch (Exception e) {
            logs.write(e, "删除一条用户详情数据异常");
        }
    }

    /**
     * 批量删除一批用户详情数据
     **/
    public void deleteUserDetailByIdList(String idList) {
        try {
            userDetails.deleteUserDetailByIdList(idList);
        } catch (Exception e) {
            logs.write(e, "批量删除一批用户详情数据异常");
        }
    }

    /**
     * 获取一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    public UserDetailInfo getUserDetailById(Integer id) {
        try {
            return userDetails.getUserDetailById(id);
        } catch (Exception e) {
            logs.write(e, "获取一条用户详情数据");
        }

        return null;
    }


    /**
     * 获得用户详情数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserDetailInfo
     **/
    public List<UserDetailInfo> getUserDetailList(Specification<UserDetailInfo> condition, Sort sort) {

        List<UserDetailInfo> userDetailList = new ArrayList<UserDetailInfo>();

        try {
            userDetailList = userDetails.getUserDetailList(condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户详情数据列表异常");
        }

        return userDetailList;
    }


    /**
     * 获得用户详情数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserDetailInfo
     **/
    public Page<UserDetailInfo> getUserDetailList(Integer pageSize, Integer pageNumber, Specification<UserDetailInfo> condition, Sort sort) {

        Page<UserDetailInfo> userDetailList = null;

        try {
            userDetailList = userDetails.getUserDetailList(pageSize, pageNumber, condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户详情数据列表异常");
        }

        return userDetailList;
    }

    /**
     * 获取用户列表的条件
     *
     * @param uid
     * @param nickName
     * @param mobile
     * @return
     */
    public Specification<PartUserInfo> getPartUserListCondition(String uid, String nickName, String mobile) {

        return (Specification<PartUserInfo>) (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();


            if (StringHelper.isNotNullOrWhiteSpace(uid)) {
                list.add(cb.equal(root.get("uid").as(Integer.class), uid));
            }

            if (StringHelper.isNotNullOrWhiteSpace(nickName)) {

                list.add(cb.like(root.get("nickName").as(String.class), "%" + nickName + "%"));
            }

            if (StringHelper.isNotNullOrWhiteSpace(mobile)) {
                list.add(cb.equal(root.get("mobile").as(String.class), mobile));
            }


            Predicate[] p = new Predicate[list.size()];

            query.where(cb.and(list.toArray(p)));


            return query.getGroupRestriction();
        };
    }


    /**
     * 用户奖励发放
     *
     * @param uid
     * @param money
     * @param desc
     */
    public void sendReward(String uid, double money, String desc) {

    }

    public static UserToken decryptUserToken(String token) {
        return null;
    }


    //endregion


    //region token管理

    /**
     * 更新token
     *
     * @param uid   uid
     * @param token token
     * @return
     * @throws NoLoginException
     */
    public void updateUserToken(String uid, String token) throws NoLoginException {

        try {

            if (uid.isEmpty()) {
                throw new NoLoginException("用户uid不能为空");
            }

            UserTokenInfo userTokenInfo = userTokens.findUserToken(uid);

            if (userTokenInfo == null) {
                userTokenInfo = new UserTokenInfo(uid, token);
            } else {
                userTokenInfo.setToken(token);
                userTokenInfo.setLimitTime(UnixTimeHelper.getUnixTimeStamp() + 60 * 60);
            }

            updateUserToken(userTokenInfo);


        } catch (NoLoginException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "token更新失败");
        }


    }

    /**
     * 更新用户的token信息
     *
     * @param userTokenInfo 用户模型
     * @return 返回创建信息
     **/
    public void updateUserToken(UserTokenInfo userTokenInfo) throws IOException {

        try {
            userTokens.updateUserToken(userTokenInfo);
        } catch (Exception ex) {
            logs.write(ex, "token更新失败");
        }
    }


    /**
     * 删除过期token
     */
    public void deleteLitmitToken() throws IOException {
        try {
            userTokens.deleteLitmitToken();
        } catch (Exception ex) {
            logs.write(ex, "token删除失败");
        }
    }


    /**
     * 获取token
     *
     * @param uid uid
     * @return
     */
    public UserTokenInfo findUserToken(String uid) throws TokenException {

        try {

            if (uid.isEmpty()) {
                throw new TokenDecryptException("uid异常");
            }

            return userTokens.findUserToken(uid);

        } catch (TokenException ex) {

            throw ex;

        } catch (Exception ex) {
            logs.write(ex, "获取TOKEN失败");
            throw new TokenException("获取TOKEN失败");
        }
    }


    //endregion
}