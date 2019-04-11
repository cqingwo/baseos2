package com.cqwo.base.data;

import com.cqwo.base.core.domain.users.OnlineTimeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//在线时间统计
@Service(value = "OnlineTimesData")
public class OnlineTimes extends DataService {


    //region  在线时间统计方法

    /**
     * 获得在线时间统计数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getOnlineTimeCount(Specification<OnlineTimeInfo> condition) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineTimeCount(condition);
    }

    /**
     * 创建一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     * @return 返回创建信息
     **/
    public OnlineTimeInfo createOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException {
        return getCwmData().getIUserStrategy().createOnlineTime(onlinetimeInfo);
    }

    /**
     * 更新一条在线时间统计数据
     *
     * @param onlinetimeInfo 在线时间统计模型
     **/
    public OnlineTimeInfo updateOnlineTime(OnlineTimeInfo onlinetimeInfo) throws IOException {
        return getCwmData().getIUserStrategy().updateOnlineTime(onlinetimeInfo);
    }

    /**
     * 删除一条在线时间统计数据
     *
     * @param id 在线时间统计模型
     **/
    public void deleteOnlineTimeById(Integer id) throws IOException {
        getCwmData().getIUserStrategy().deleteOnlineTimeById(id);
    }

    /**
     * 批量删除一批在线时间统计数据
     **/
    public void deleteOnlineTimeByIdList(String idList) throws IOException {
        getCwmData().getIUserStrategy().deleteOnlineTimeByIdList(idList);
    }

    /**
     * 获取一条在线时间统计数据
     *
     * @param id 在线时间统计模型
     **/
    public OnlineTimeInfo getOnlineTimeById(Integer id) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineTimeById(id);
    }


    /**
     * 获得在线时间统计数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回OnlineTimeInfo
     **/
    public List<OnlineTimeInfo> getOnlineTimeList(Specification<OnlineTimeInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineTimeList(condition, sort);
    }


    /**
     * 获得在线时间统计数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回OnlineTimeInfo
     **/
    public Page<OnlineTimeInfo> getOnlineTimeList(Integer pageSize, Integer pageNumber, Specification<OnlineTimeInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIUserStrategy().getOnlineTimeList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
