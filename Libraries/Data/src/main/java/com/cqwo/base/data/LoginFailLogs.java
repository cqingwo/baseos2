package com.cqwo.base.data;

import com.cqwo.base.core.domain.users.LoginFailLogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//登录日志
@Service(value = "LoginFailLogsData")
public class LoginFailLogs extends DataService {


    //region  登录日志方法

    /**
     * 获得登录日志数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getLoginFailLogCount(Specification<LoginFailLogInfo> condition) throws IOException {
        return getCwmData().getILog2Strategy().getLoginFailLogCount(condition);
    }

    /**
     * 创建一条登录日志数据
     *
     * @param loginfaillogInfo 登录日志模型
     * @return 返回创建信息
     **/
    public LoginFailLogInfo createLoginFailLog(LoginFailLogInfo loginfaillogInfo) throws IOException {
        return getCwmData().getILog2Strategy().createLoginFailLog(loginfaillogInfo);
    }

    /**
     * 更新一条登录日志数据
     *
     * @param loginfaillogInfo 登录日志模型
     **/
    public LoginFailLogInfo updateLoginFailLog(LoginFailLogInfo loginfaillogInfo) throws IOException {
        return getCwmData().getILog2Strategy().updateLoginFailLog(loginfaillogInfo);
    }

    /**
     * 删除一条登录日志数据
     *
     * @param id 登录日志模型
     **/
    public void deleteLoginFailLogById(Integer id) throws IOException {
        getCwmData().getILog2Strategy().deleteLoginFailLogById(id);
    }

    /**
     * 批量删除一批登录日志数据
     **/
    public void deleteLoginFailLogByIdList(String idList) throws IOException {
        getCwmData().getILog2Strategy().deleteLoginFailLogByIdList(idList);
    }

    /**
     * 获取一条登录日志数据
     *
     * @param id 登录日志模型
     **/
    public LoginFailLogInfo getLoginFailLogById(Integer id) throws IOException {
        return getCwmData().getILog2Strategy().getLoginFailLogById(id);
    }


    /**
     * 获得登录日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回LoginFailLogInfo
     **/
    public List<LoginFailLogInfo> getLoginFailLogList(Specification<LoginFailLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getILog2Strategy().getLoginFailLogList(condition, sort);
    }


    /**
     * 获得登录日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回LoginFailLogInfo
     **/
    public Page<LoginFailLogInfo> getLoginFailLogList(Integer pageSize, Integer pageNumber, Specification<LoginFailLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getILog2Strategy().getLoginFailLogList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 删除登录ip地址
     *
     * @param ip
     */
    public void deleteLoginFailLogByIP(Integer ip) throws IOException {
        getCwmData().getILog2Strategy().deleteLoginFailLogByIP(ip);
    }


    //endregion

}
