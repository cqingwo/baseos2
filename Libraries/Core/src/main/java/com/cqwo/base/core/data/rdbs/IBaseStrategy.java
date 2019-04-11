/*
 *
 *  * Copyright (C) 2017.
 *  * 用于JAVA项目开发
 *  * 重庆青沃科技有限公司 版权所有
 *  * Copyright (C)  2017.  CqingWo Systems Incorporated. All rights reserved.
 *
 */

package com.cqwo.base.core.data.rdbs;

import com.cqwo.base.core.domain.base.AttachmentInfo;
import com.cqwo.base.core.domain.base.BannedIPInfo;
import com.cqwo.base.core.domain.base.RegionInfo;
import com.cqwo.base.core.domain.sms.SMSInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/19.
 */
public interface IBaseStrategy {

    //region 区域信息

    /**
     * 获得区域信息数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getRegionCount(Specification<RegionInfo> condition) throws IOException;


    /**
     * 创建一条区域信息数据
     *
     * @param regionInfo 区域信息模型
     * @return 返回创建信息
     **/
    RegionInfo createRegion(RegionInfo regionInfo) throws IOException;


    /**
     * 更新一条区域信息数据
     *
     * @param regionInfo 区域信息模型
     **/
    RegionInfo updateRegion(RegionInfo regionInfo) throws IOException;

    /**
     * 删除一条区域信息数据
     *
     * @param regionid 区域信息模型
     **/
    void deleteRegionByRegionid(Integer regionid) throws IOException;

    /**
     * 批量删除一批区域信息数据
     **/
    void deleteRegionByRegionidList(String regionidList) throws IOException;


    /**
     * 获得区域信息一条记录
     *
     * @param regionid regionid
     * @return 返回一条RegionInfo
     **/
    RegionInfo getRegionByRegionid(Integer regionid) throws IOException;

    /**
     * 获得区域信息数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回RegionInfo
     **/
    List<RegionInfo> getRegionList(Specification<RegionInfo> condition, Sort sort) throws IOException;


    /**
     * 获得区域信息数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回RegionInfo
     **/
    Page<RegionInfo> getRegionList(Integer pageSize, Integer pageNumber, Specification<RegionInfo> condition, Sort sort) throws IOException;


    //endregion 区域信息结束

    //region 禁用IP

    /**
     * 获得禁用IP数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getBannedIPCount(Specification<BannedIPInfo> condition) throws IOException;


    /**
     * 创建一条禁用IP数据
     *
     * @param bannedipInfo 禁用IP模型
     * @return 返回创建信息
     **/
    BannedIPInfo createBannedIP(BannedIPInfo bannedipInfo) throws IOException;


    /**
     * 更新一条禁用IP数据
     *
     * @param bannedipInfo 禁用IP模型
     **/
    BannedIPInfo updateBannedIP(BannedIPInfo bannedipInfo) throws IOException;

    /**
     * 删除一条禁用IP数据
     *
     * @param id 禁用IP模型
     **/
    void deleteBannedIPById(Integer id) throws IOException;

    /**
     * 批量删除一批禁用IP数据
     **/
    void deleteBannedIPByIdList(String idList) throws IOException;


    /**
     * 获得禁用IP一条记录
     *
     * @param id id
     * @return 返回一条BannedIPInfo
     **/
    BannedIPInfo getBannedIPById(Integer id) throws IOException;

    /**
     * 获得禁用IP数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BannedIPInfo
     **/
    List<BannedIPInfo> getBannedIPList(Specification<BannedIPInfo> condition, Sort sort) throws IOException;


    /**
     * 获得禁用IP数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回BannedIPInfo
     **/
    Page<BannedIPInfo> getBannedIPList(Integer pageSize, Integer pageNumber, Specification<BannedIPInfo> condition, Sort sort) throws IOException;


    //endregion 禁用IP结束

    //region 短信

    /**
     * 获得短信数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getSMSCount(Specification<SMSInfo> condition) throws IOException;


    /**
     * 创建一条短信数据
     *
     * @param smsInfo 短信模型
     * @return 返回创建信息
     **/
    SMSInfo createSMS(SMSInfo smsInfo) throws IOException;


    /**
     * 更新一条短信数据
     *
     * @param smsInfo 短信模型
     **/
    SMSInfo updateSMS(SMSInfo smsInfo) throws IOException;

    /**
     * 删除一条短信数据
     *
     * @param id 短信模型
     **/
    void deleteSMSById(Integer id) throws IOException;

    /**
     * 批量删除一批短信数据
     **/
    void deleteSMSByIdList(String idList) throws IOException;


    /**
     * 获得短信一条记录
     *
     * @param id id
     * @return 返回一条SMSInfo
     **/
    SMSInfo getSMSById(Integer id) throws IOException;

    /**
     * 获得短信数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回SMSInfo
     **/
    List<SMSInfo> getSMSList(Specification<SMSInfo> condition, Sort sort) throws IOException;


    /**
     * 获得短信数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回SMSInfo
     **/
    Page<SMSInfo> getSMSList(Integer pageSize, Integer pageNumber, Specification<SMSInfo> condition, Sort sort) throws IOException;


    //endregion 短信结束



    //region 附件表

    /**
     * 获得附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    long getAttachmentCount(Specification<AttachmentInfo> condition) throws IOException;


    /**
     * 创建一条附件表数据
     *
     * @param attachmentInfo 附件表模型
     * @return 返回创建信息
     **/
    AttachmentInfo createAttachment(AttachmentInfo attachmentInfo) throws IOException;


    /**
     * 更新一条附件表数据
     *
     * @param attachmentInfo 附件表模型
     **/
    AttachmentInfo updateAttachment(AttachmentInfo attachmentInfo) throws IOException;

    /**
     * 删除一条附件表数据
     *
     * @param attachId 附件表模型
     **/
    void deleteAttachmentByAttachId(Integer attachId) throws IOException;

    /**
     * 批量删除一批附件表数据
     **/
    void deleteAttachmentByAttachIdList(String attachIdList) throws IOException;


    /**
     * 获得附件表一条记录
     *
     * @param attachId attachid
     * @return 返回一条AttachmentInfo
     **/
    AttachmentInfo getAttachmentByAttachId(Integer attachId) throws IOException;

    /**
     * 获得附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AttachmentInfo
     **/
    List<AttachmentInfo> getAttachmentList(Specification<AttachmentInfo> condition, Sort sort) throws IOException;


    /**
     * 获得附件表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AttachmentInfo
     **/
    Page<AttachmentInfo> getAttachmentList(Integer pageSize, Integer pageNumber, Specification<AttachmentInfo> condition, Sort sort) throws IOException;


    //endregion 附件表结束

}
