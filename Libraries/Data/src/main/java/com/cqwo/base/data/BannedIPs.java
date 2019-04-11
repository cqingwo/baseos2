package com.cqwo.base.data;

import com.cqwo.base.core.domain.base.BannedIPInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//禁用IP
@Service(value = "BannedIPsData")
public class BannedIPs extends DataService {


    //region  禁用IP方法

    /**
     * 获得禁用IP数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getBannedIPCount(Specification<BannedIPInfo> condition) throws IOException {
        return getCwmData().getIBaseStrategy().getBannedIPCount(condition);
    }

    /**
     * 创建一条禁用IP数据
     *
     * @param bannedipInfo 禁用IP模型
     * @return 返回创建信息
     **/
    public BannedIPInfo createBannedIP(BannedIPInfo bannedipInfo) throws IOException {
        return getCwmData().getIBaseStrategy().createBannedIP(bannedipInfo);
    }

    /**
     * 更新一条禁用IP数据
     *
     * @param bannedipInfo 禁用IP模型
     **/
    public BannedIPInfo updateBannedIP(BannedIPInfo bannedipInfo) throws IOException {
        return getCwmData().getIBaseStrategy().updateBannedIP(bannedipInfo);
    }

    /**
     * 删除一条禁用IP数据
     *
     * @param id 禁用IP模型
     **/
    public void deleteBannedIPById(Integer id) throws IOException {
        getCwmData().getIBaseStrategy().deleteBannedIPById(id);
    }

    /**
     * 批量删除一批禁用IP数据
     **/
    public void deleteBannedIPByIdList(String idList) throws IOException {
        getCwmData().getIBaseStrategy().deleteBannedIPByIdList(idList);
    }

    /**
     * 获取一条禁用IP数据
     *
     * @param id 禁用IP模型
     **/
    public BannedIPInfo getBannedIPById(Integer id) throws IOException {
        return getCwmData().getIBaseStrategy().getBannedIPById(id);
    }


    /**
     * 获得禁用IP数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BannedIPInfo
     **/
    public List<BannedIPInfo> getBannedIPList(Specification<BannedIPInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getBannedIPList(condition, sort);
    }


    /**
     * 获得禁用IP数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回BannedIPInfo
     **/
    public Page<BannedIPInfo> getBannedIPList(Integer pageSize, Integer pageNumber, Specification<BannedIPInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getBannedIPList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
