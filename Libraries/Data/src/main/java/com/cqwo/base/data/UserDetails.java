package com.cqwo.base.data;

import com.cqwo.base.core.domain.users.UserDetailInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//用户详情
@Service(value = "UserDetailsData")
public class UserDetails extends DataService {


    //region  用户详情方法

    /**
     * 获得用户详情数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getUserDetailCount(Specification<UserDetailInfo> condition) throws IOException {
        return getCwmData().getIUserStrategy().getUserDetailCount(condition);
    }

    /**
     * 创建一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     * @return 返回创建信息
     **/
    public UserDetailInfo createUserDetail(UserDetailInfo userdetailInfo) throws IOException {
        return getCwmData().getIUserStrategy().createUserDetail(userdetailInfo);
    }

    /**
     * 更新一条用户详情数据
     *
     * @param userdetailInfo 用户详情模型
     **/
    public UserDetailInfo updateUserDetail(UserDetailInfo userdetailInfo) throws IOException {
        return getCwmData().getIUserStrategy().updateUserDetail(userdetailInfo);
    }

    /**
     * 删除一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    public void deleteUserDetailById(Integer id) throws IOException {
        getCwmData().getIUserStrategy().deleteUserDetailById(id);
    }

    /**
     * 批量删除一批用户详情数据
     **/
    public void deleteUserDetailByIdList(String idList) throws IOException {
        getCwmData().getIUserStrategy().deleteUserDetailByIdList(idList);
    }

    /**
     * 获取一条用户详情数据
     *
     * @param id 用户详情模型
     **/
    public UserDetailInfo getUserDetailById(Integer id) throws IOException {
        return getCwmData().getIUserStrategy().getUserDetailById(id);
    }


    /**
     * 获得用户详情数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回UserDetailInfo
     **/
    public List<UserDetailInfo> getUserDetailList(Specification<UserDetailInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getUserDetailList(condition, sort);
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
    public Page<UserDetailInfo> getUserDetailList(Integer pageSize, Integer pageNumber, Specification<UserDetailInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getUserDetailList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
