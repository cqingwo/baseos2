/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.data.rdbs;

import com.cqwo.base.core.domain.users.OnlineTimeInfo;
import com.cqwo.base.core.domain.users.OnlineUserInfo;
import com.cqwo.base.core.domain.users.UserDetailInfo;
import com.cqwo.base.core.domain.users.UserTokenInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/12/6.
 */
public interface IUserStrategy {


    //region 用户详情

    /**
     * 获得用户详情数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getUserDetailCount(Specification<UserDetailInfo> condition) throws IOException;


    /**
     * 创建一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     * @return 返回创建信息
     **/
    UserDetailInfo createUserDetail(UserDetailInfo userdetailInfo) throws IOException;


    /**
     * 更新一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     **/
    UserDetailInfo updateUserDetail(UserDetailInfo userdetailInfo) throws IOException;

    /**
     * 删除一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    void deleteUserDetailById(Integer id) throws IOException;

    /**
     * 批量删除一批用户详情数据
     **/
    void deleteUserDetailByIdList(String idList) throws IOException;


    /**
     * 获得用户详情一条记录
     *
     * @param id id
     * @return 返回一条UserDetailInfo
     **/
    UserDetailInfo getUserDetailById(Integer id) throws IOException;

    /**
     * 获得用户详情数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserDetailInfo
     **/
    List<UserDetailInfo> getUserDetailList(Specification<UserDetailInfo> condition, Sort sort) throws IOException;


    /**
     * 获得用户详情数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回UserDetailInfo
     **/
    Page<UserDetailInfo> getUserDetailList(Integer pageSize, Integer pageNumber, Specification<UserDetailInfo> condition, Sort sort) throws IOException;


    //endregion 用户详情结束


    //region 用户token

    /**
     * 更新用户的token信息
     *
     * @param userTokenInfo 用户模型
     * @return 返回创建信息
     **/
    UserTokenInfo updateUserToken(UserTokenInfo userTokenInfo) throws IOException;


    /**
     * 删除过期token
     */
    void deleteLitmitToken() throws IOException;


    /**
     * 获取token
     *
     * @param uid
     * @return
     */
    UserTokenInfo findUserToken(String uid) throws IOException;


    //endregion


    //region 在线时间统计

    /**
     * 获得在线时间统计数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getOnlineTimeCount(Specification<OnlineTimeInfo> condition) throws IOException;


    /**
     * 创建一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     * @return 返回创建信息
     **/
    OnlineTimeInfo createOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException;


    /**
     * 更新一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     **/
    OnlineTimeInfo updateOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException;

    /**
     * 删除一条在线时间统计数据
     *
     * @param id 在线时间统计模型
     **/
    void deleteOnlineTimeById(Integer id) throws IOException;

    /**
     * 批量删除一批在线时间统计数据
     **/
    void deleteOnlineTimeByIdList(String idList) throws IOException;


    /**
     * 获得在线时间统计一条记录
     *
     * @param id id
     * @return 返回一条OnlineTimeInfo
     **/
    OnlineTimeInfo getOnlineTimeById(Integer id) throws IOException;

    /**
     * 获得在线时间统计数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineTimeInfo
     **/
    List<OnlineTimeInfo> getOnlineTimeList(Specification<OnlineTimeInfo> condition, Sort sort) throws IOException;


    /**
     * 获得在线时间统计数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineTimeInfo
     **/
    Page<OnlineTimeInfo> getOnlineTimeList(Integer pageSize, Integer pageNumber, Specification<OnlineTimeInfo> condition, Sort sort) throws IOException;


    //endregion 在线时间统计结束

    //region 在线用户

    /**
     * 获得在线用户数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getOnlineUserCount(Specification<OnlineUserInfo> condition) throws IOException;


    /**
     * 创建一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     * @return 返回创建信息
     **/
    OnlineUserInfo createOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException;


    /**
     * 更新一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     **/
    OnlineUserInfo updateOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException;

    /**
     * 删除一条在线用户数据
     *
     * @param olid 在线用户模型
     **/
    void deleteOnlineUserByOlid(Integer olid) throws IOException;

    /**
     * 批量删除一批在线用户数据
     **/
    void deleteOnlineUserByOlidList(String olidList) throws IOException;


    /**
     * 获得在线用户一条记录
     *
     * @param olid olid
     * @return 返回一条OnlineUserInfo
     **/
    OnlineUserInfo getOnlineUserByOlid(Integer olid) throws IOException;

    /**
     * 获得在线用户数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineUserInfo
     **/
    List<OnlineUserInfo> getOnlineUserList(Specification<OnlineUserInfo> condition, Sort sort) throws IOException;


    /**
     * 获得在线用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineUserInfo
     **/
    Page<OnlineUserInfo> getOnlineUserList(Integer pageSize, Integer pageNumber, Specification<OnlineUserInfo> condition, Sort sort) throws IOException;


    //endregion 在线用户结束


}
