package com.cqwo.base.data;

import com.cqwo.base.core.domain.base.RegionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//区域信息
@Service(value = "RegionsData")
public class Regions extends DataService {


    //region  区域信息方法

    /**
     * 获得区域信息数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getRegionCount(Specification<RegionInfo> condition) throws IOException {
        return getCwmData().getIBaseStrategy().getRegionCount(condition);
    }

    /**
     * 创建一条区域信息数据
     *
     * @param regionInfo 区域信息模型
     * @return 返回创建信息
     **/
    public RegionInfo createRegion(RegionInfo regionInfo) throws IOException {
        return getCwmData().getIBaseStrategy().createRegion(regionInfo);
    }

    /**
     * 更新一条区域信息数据
     *
     * @param regionInfo 区域信息模型
     **/
    public RegionInfo updateRegion(RegionInfo regionInfo) throws IOException {
        return getCwmData().getIBaseStrategy().updateRegion(regionInfo);
    }

    /**
     * 删除一条区域信息数据
     *
     * @param regionid 区域信息模型
     **/
    public void deleteRegionByRegionid(Integer regionid) throws IOException {
        getCwmData().getIBaseStrategy().deleteRegionByRegionid(regionid);
    }

    /**
     * 批量删除一批区域信息数据
     **/
    public void deleteRegionByRegionidList(String regionidList) throws IOException {
        getCwmData().getIBaseStrategy().deleteRegionByRegionidList(regionidList);
    }

    /**
     * 获取一条区域信息数据
     *
     * @param regionid 区域信息模型
     **/
    public RegionInfo getRegionByRegionid(Integer regionid) throws IOException {
        return getCwmData().getIBaseStrategy().getRegionByRegionid(regionid);
    }


    /**
     * 获得区域信息数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回RegionInfo
     **/
    public List<RegionInfo> getRegionList(Specification<RegionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getRegionList(condition, sort);
    }


    /**
     * 获得区域信息数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回RegionInfo
     **/
    public Page<RegionInfo> getRegionList(Integer pageSize, Integer pageNumber, Specification<RegionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getRegionList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
