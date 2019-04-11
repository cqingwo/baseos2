/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.data.rdbs;

import com.cqwo.base.core.domain.authors.AuthorLogInfo;
import com.cqwo.base.core.domain.users.CreditLogInfo;
import com.cqwo.base.core.domain.users.LoginFailLogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/12/6.
 */
public interface ILog2Strategy {

    //region 管理员日志

    /**
     * 获得管理员日志数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getAuthorLogCount(Specification<AuthorLogInfo> condition) throws IOException;


    /**
     * 创建一条管理员日志数据
     *
     * @param authorLogInfo 管理员日志模型
     * @return 返回创建信息
     **/
    AuthorLogInfo createAuthorLog(AuthorLogInfo authorLogInfo) throws IOException;


    /**
     * 更新一条管理员日志数据
     *
     * @param authorLogInfo 管理员日志模型
     **/
    AuthorLogInfo updateAuthorLog(AuthorLogInfo authorLogInfo) throws IOException;

    /**
     * 删除一条管理员日志数据
     *
     * @param logid 管理员日志模型
     **/
    void deleteAuthorLogByLogid(Integer logid) throws IOException;

    /**
     * 批量删除一批管理员日志数据
     **/
    void deleteAuthorLogByLogidList(String logidList) throws IOException;


    /**
     * 获得管理员日志一条记录
     *
     * @param logid logid
     * @return 返回一条AuthorLogInfo
     **/
    AuthorLogInfo getAuthorLogByLogid(Integer logid) throws IOException;

    /**
     * 获得管理员日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorLogInfo
     **/
    List<AuthorLogInfo> getAuthorLogList(Specification<AuthorLogInfo> condition, Sort sort) throws IOException;


    /**
     * 获得管理员日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorLogInfo
     **/
    Page<AuthorLogInfo> getAuthorLogList(Integer pageSize, Integer pageNumber, Specification<AuthorLogInfo> condition, Sort sort) throws IOException;


    //endregion 管理员日志结束

    //region 积分日志

    /**
     * 获得积分日志数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getCreditLogCount(Specification<CreditLogInfo> condition) throws IOException;


    /**
     * 创建一条积分日志数据
     *
     * @param creditlogInfo 积分日志模型
     * @return 返回创建信息
     **/
    CreditLogInfo createCreditLog(CreditLogInfo creditlogInfo) throws IOException;


    /**
     * 更新一条积分日志数据
     *
     * @param creditlogInfo 积分日志模型
     **/
    CreditLogInfo updateCreditLog(CreditLogInfo creditlogInfo) throws IOException;

    /**
     * 删除一条积分日志数据
     *
     * @param logid 积分日志模型
     **/
    void deleteCreditLogByLogid(Integer logid) throws IOException;

    /**
     * 批量删除一批积分日志数据
     **/
    void deleteCreditLogByLogidList(String logidList) throws IOException;


    /**
     * 获得积分日志一条记录
     *
     * @param logid logid
     * @return 返回一条CreditLogInfo
     **/
    CreditLogInfo getCreditLogByLogid(Integer logid) throws IOException;

    /**
     * 获得积分日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回CreditLogInfo
     **/
    List<CreditLogInfo> getCreditLogList(Specification<CreditLogInfo> condition, Sort sort) throws IOException;


    /**
     * 获得积分日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回CreditLogInfo
     **/
    Page<CreditLogInfo> getCreditLogList(Integer pageSize, Integer pageNumber, Specification<CreditLogInfo> condition, Sort sort) throws IOException;


    //endregion 积分日志结束

    //region 登录日志

    /**
     * 获得登录日志数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getLoginFailLogCount(Specification<LoginFailLogInfo> condition) throws IOException;


    /**
     * 创建一条登录日志数据
     *
     * @param loginfaillogInfo 登录日志模型
     * @return 返回创建信息
     **/
    LoginFailLogInfo createLoginFailLog(LoginFailLogInfo loginfaillogInfo) throws IOException;


    /**
     * 更新一条登录日志数据
     *
     * @param loginfaillogInfo 登录日志模型
     **/
    LoginFailLogInfo updateLoginFailLog(LoginFailLogInfo loginfaillogInfo) throws IOException;

    /**
     * 删除一条登录日志数据
     *
     * @param id 登录日志模型
     **/
    void deleteLoginFailLogById(Integer id) throws IOException;

    /**
     * 批量删除一批登录日志数据
     **/
    void deleteLoginFailLogByIdList(String idList) throws IOException;


    /**
     * 获得登录日志一条记录
     *
     * @param id id
     * @return 返回一条LoginFailLogInfo
     **/
    LoginFailLogInfo getLoginFailLogById(Integer id) throws IOException;

    /**
     * 获得登录日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回LoginFailLogInfo
     **/
    List<LoginFailLogInfo> getLoginFailLogList(Specification<LoginFailLogInfo> condition, Sort sort) throws IOException;


    /**
     * 获得登录日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回LoginFailLogInfo
     **/
    Page<LoginFailLogInfo> getLoginFailLogList(Integer pageSize, Integer pageNumber, Specification<LoginFailLogInfo> condition, Sort sort) throws IOException;


    /**
     * 删除登录ip地址
     *
     * @param ip
     */
    void deleteLoginFailLogByIP(Integer ip) throws IOException;

    //endregion 登录日志结束
}
