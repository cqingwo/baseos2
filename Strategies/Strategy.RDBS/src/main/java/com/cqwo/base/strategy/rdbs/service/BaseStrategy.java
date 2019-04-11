package com.cqwo.base.strategy.rdbs.service;

import com.cqwo.base.core.data.rdbs.repository.base.AttachmentRepository;
import com.cqwo.base.core.data.rdbs.repository.base.BannedIPRepository;
import com.cqwo.base.core.data.rdbs.repository.base.RegionRepository;
import com.cqwo.base.core.data.rdbs.repository.base.SMSRepository;
import com.cqwo.base.core.data.rdbs.IBaseStrategy;
import com.cqwo.base.core.domain.base.AttachmentInfo;
import com.cqwo.base.core.domain.base.BannedIPInfo;
import com.cqwo.base.core.domain.base.RegionInfo;
import com.cqwo.base.core.domain.sms.SMSInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component(value = "BaseStrategy")
public class BaseStrategy extends RDBSService implements IBaseStrategy {


    @Autowired
    RegionRepository regionRepository;

    public Specification<RegionInfo> getRegionListCondition() {

        Specification<RegionInfo> condition = new Specification<RegionInfo>() {
            @Override
            public Predicate toPredicate(Root<RegionInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<Predicate>();


//                list.add(cb.equal(root.get("id").get("regiondId").as(String.class), regionId));//主键中某字段


                //ORDER BY packdate DESC,packtime DESC
                Predicate[] p = new Predicate[list.size()];
                query.where(cb.and(list.toArray(p)));
                query.orderBy(cb.desc(root.get("packDate")), cb.desc(root.get("packTime")));

                return query.getRestriction();
            }
        };

        return condition;

    }

    //region 区域信息

    /**
     * 获得区域信息数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getRegionCount(Specification<RegionInfo> condition) throws IOException {

        return regionRepository.count();
    }


    /**
     * 创建一条区域信息数据
     *
     * @param regionInfo 区域信息模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public RegionInfo createRegion(RegionInfo regionInfo) throws IOException {

        return regionRepository.save(regionInfo);
    }


    /**
     * 更新一条区域信息数据
     *
     * @param regionInfo 区域信息模型
     **/
    @Override
    public RegionInfo updateRegion(RegionInfo regionInfo) throws IOException {

        if (regionInfo.getRegionId() >= 1) {
            return regionRepository.save(regionInfo);
        }

        return regionInfo;

    }


    /**
     * 删除一条区域信息数据
     *
     * @param regionid 区域信息模型
     **/
    @Override
    public void deleteRegionByRegionid(Integer regionid) throws IOException {

        regionRepository.deleteById(regionid);
    }

    /**
     * 批量删除一批区域信息数据
     **/
    @Override
    public void deleteRegionByRegionidList(String regionidlist) throws IOException {


    }

    /**
     * 获得区域信息一条记录
     *
     * @param regionid regionid
     * @return 返回一条RegionInfo
     **/
    @Override
    public RegionInfo getRegionByRegionid(Integer regionid) throws IOException {
        return regionRepository.findById(regionid).get();
    }


    /**
     * 获得区域信息数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回RegionInfo
     **/
    @Override
    public List<RegionInfo> getRegionList(Specification<RegionInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "regionId");
        }

        return regionRepository.findAll(condition, sort);

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
    @Override
    public Page<RegionInfo> getRegionList(Integer pageSize, Integer pageNumber, Specification<RegionInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "regionId");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return regionRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    BannedIPRepository bannedipRepository;

    //region 禁用IP

    /**
     * 获得禁用IP数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getBannedIPCount(Specification<BannedIPInfo> condition) throws IOException {

        return bannedipRepository.count();
    }


    /**
     * 创建一条禁用IP数据
     *
     * @param bannedipInfo 禁用IP模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public BannedIPInfo createBannedIP(BannedIPInfo bannedipInfo) throws IOException {

        return bannedipRepository.save(bannedipInfo);
    }


    /**
     * 更新一条禁用IP数据
     *
     * @param bannedipInfo 禁用IP模型
     **/
    @Override
    public BannedIPInfo updateBannedIP(BannedIPInfo bannedipInfo) throws IOException {

        if (bannedipInfo.getId() >= 1) {
            return bannedipRepository.save(bannedipInfo);
        }

        return bannedipInfo;

    }


    /**
     * 删除一条禁用IP数据
     *
     * @param id 禁用IP模型
     **/
    @Override
    public void deleteBannedIPById(Integer id) throws IOException {

        bannedipRepository.deleteById(id);
    }

    /**
     * 批量删除一批禁用IP数据
     **/
    @Override
    public void deleteBannedIPByIdList(String idlist) throws IOException {


    }

    /**
     * 获得禁用IP一条记录
     *
     * @param id id
     * @return 返回一条BannedIPInfo
     **/
    @Override
    public BannedIPInfo getBannedIPById(Integer id) throws IOException {
        return bannedipRepository.findById(id).get();
    }


    /**
     * 获得禁用IP数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回BannedIPInfo
     **/
    @Override
    public List<BannedIPInfo> getBannedIPList(Specification<BannedIPInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return bannedipRepository.findAll(condition, sort);

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
    @Override
    public Page<BannedIPInfo> getBannedIPList(Integer pageSize, Integer pageNumber, Specification<BannedIPInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return bannedipRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    SMSRepository smsRepository;

    //region 短信

    /**
     * 获得短信数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getSMSCount(Specification<SMSInfo> condition) throws IOException {

        return smsRepository.count();
    }


    /**
     * 创建一条短信数据
     *
     * @param smsInfo 短信模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public SMSInfo createSMS(SMSInfo smsInfo) throws IOException {

        return smsRepository.save(smsInfo);
    }


    /**
     * 更新一条短信数据
     *
     * @param smsInfo 短信模型
     **/
    @Override
    public SMSInfo updateSMS(SMSInfo smsInfo) throws IOException {

        if (smsInfo.getId() >= 1) {
            return smsRepository.save(smsInfo);
        }

        return smsInfo;

    }


    /**
     * 删除一条短信数据
     *
     * @param id 短信模型
     **/
    @Override
    public void deleteSMSById(Integer id) throws IOException {

        smsRepository.deleteById(id);
    }

    /**
     * 批量删除一批短信数据
     **/
    @Override
    public void deleteSMSByIdList(String idlist) throws IOException {


    }

    /**
     * 获得短信一条记录
     *
     * @param id id
     * @return 返回一条SMSInfo
     **/
    @Override
    public SMSInfo getSMSById(Integer id) throws IOException {
        return smsRepository.findById(id).get();
    }


    /**
     * 获得短信数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回SMSInfo
     **/
    @Override
    public List<SMSInfo> getSMSList(Specification<SMSInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return smsRepository.findAll(condition, sort);

    }


    /**
     * 获得短信数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回SMSInfo
     **/
    @Override
    public Page<SMSInfo> getSMSList(Integer pageSize, Integer pageNumber, Specification<SMSInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return smsRepository.findAll(condition, pageable);


    }


    //endregion


    @Autowired
    AttachmentRepository attachmentRepository;


    //region 附件表

    /**
     * 获得附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getAttachmentCount(Specification<AttachmentInfo> condition) throws IOException {

        return attachmentRepository.count();
    }


    /**
     * 创建一条附件表数据
     *
     * @param attachmentInfo 附件表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public AttachmentInfo createAttachment(AttachmentInfo attachmentInfo) throws IOException {

        return attachmentRepository.save(attachmentInfo);
    }


    /**
     * 更新一条附件表数据
     *
     * @param attachmentInfo 附件表模型
     **/
    @Override
    public AttachmentInfo updateAttachment(AttachmentInfo attachmentInfo) throws IOException {

        if (attachmentInfo.getAttachId() >= 1) {
            return attachmentRepository.save(attachmentInfo);
        }

        return attachmentInfo;

    }


    /**
     * 删除一条附件表数据
     *
     * @param attachId 附件表模型
     **/
    @Override
    public void deleteAttachmentByAttachId(Integer attachId) throws IOException {

        attachmentRepository.deleteById(attachId);
    }

    /**
     * 批量删除一批附件表数据
     **/
    @Override
    public void deleteAttachmentByAttachIdList(String attachIdlist) throws IOException {


    }

    /**
     * 获得附件表一条记录
     *
     * @param attachId attachid
     * @return 返回一条AttachmentInfo
     **/
    @Override
    public AttachmentInfo getAttachmentByAttachId(Integer attachId) throws IOException {
        return attachmentRepository.findById(attachId).get();
    }


    /**
     * 获得附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AttachmentInfo
     **/
    @Override
    public List<AttachmentInfo> getAttachmentList(Specification<AttachmentInfo> condition, Sort sort) throws IOException {

        return attachmentRepository.findAll(condition, sort);

    }


    /**
     * 获得附件表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AttachmentInfo
     **/
    @Override
    public Page<AttachmentInfo> getAttachmentList(Integer pageSize, Integer pageNumber, Specification<AttachmentInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1) {
            pageNumber--;
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return attachmentRepository.findAll(condition, pageable);


    }


    //endregion
}
