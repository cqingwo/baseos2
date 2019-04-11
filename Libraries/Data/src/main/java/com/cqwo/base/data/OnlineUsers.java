package com.cqwo.base.data;

import com.cqwo.base.core.domain.users.OnlineUserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//在线用户
@Service(value = "OnlineUsersData")
public class OnlineUsers extends DataService {


    //region  在线用户方法

    /**
     * 获得在线用户数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getOnlineUserCount(Specification<OnlineUserInfo> condition) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineUserCount(condition);
    }

    /**
     * 创建一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     * @return 返回创建信息
     **/
    public OnlineUserInfo createOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException {
        return getCwmData().getIUserStrategy().createOnlineUser(onlineuserInfo);
    }

    /**
     * 更新一条在线用户数据
     *
     * @param onlineuserInfo 在线用户模型
     **/
    public OnlineUserInfo updateOnlineUser(OnlineUserInfo onlineuserInfo) throws IOException {
        return getCwmData().getIUserStrategy().updateOnlineUser(onlineuserInfo);
    }

    /**
     * 删除一条在线用户数据
     *
     * @param olid 在线用户模型
     **/
    public void deleteOnlineUserByOlid(Integer olid) throws IOException {
        getCwmData().getIUserStrategy().deleteOnlineUserByOlid(olid);
    }

    /**
     * 批量删除一批在线用户数据
     **/
    public void deleteOnlineUserByOlidList(String olidList) throws IOException {
        getCwmData().getIUserStrategy().deleteOnlineUserByOlidList(olidList);
    }

    /**
     * 获取一条在线用户数据
     *
     * @param olid 在线用户模型
     **/
    public OnlineUserInfo getOnlineUserByOlid(Integer olid) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineUserByOlid(olid);
    }


    /**
     * 获得在线用户数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineUserInfo
     **/
    public List<OnlineUserInfo> getOnlineUserList(Specification<OnlineUserInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineUserList(condition, sort);
    }


    /**
     * 获得在线用户数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineUserInfo
     **/
    public Page<OnlineUserInfo> getOnlineUserList(Integer pageSize, Integer pageNumber, Specification<OnlineUserInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineUserList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
