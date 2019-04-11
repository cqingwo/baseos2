package com.cqwo.base.data;

import com.cqwo.base.core.domain.base.AttachmentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 附件表
 *
 * @author cqnews
 * @date 2017/4/11
 */
@Service(value = "AttachmentsData")
public class Attachments extends DataService {


    //region  附件表方法

    /**
     * 获得附件表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAttachmentCount(Specification<AttachmentInfo> condition) throws IOException {
        return getCwmData().getIBaseStrategy().getAttachmentCount(condition);
    }

    /**
     * 创建一条附件表数据
     *
     * @param attachmentInfo 附件表模型
     * @return 返回创建信息
     **/
    public AttachmentInfo createAttachment(AttachmentInfo attachmentInfo) throws IOException {
        return getCwmData().getIBaseStrategy().createAttachment(attachmentInfo);
    }


    /**
     * 更新一条附件表数据
     *
     * @param attachmentInfo 附件表模型
     **/
    public AttachmentInfo updateAttachment(AttachmentInfo attachmentInfo) throws IOException {
        return getCwmData().getIBaseStrategy().updateAttachment(attachmentInfo);
    }

    /**
     * 删除一条附件表数据
     *
     * @param attachId 附件表模型
     **/
    public void deleteAttachmentByAttachId(int attachId) throws IOException {
        getCwmData().getIBaseStrategy().deleteAttachmentByAttachId(attachId);
    }

    /**
     * 批量删除一批附件表数据
     **/
    public void deleteAttachmentByAttachIdList(String attachIdList) throws IOException {
        getCwmData().getIBaseStrategy().deleteAttachmentByAttachIdList(attachIdList);
    }

    /**
     * 获取一条附件表数据
     *
     * @param attachId 附件表模型
     **/
    public AttachmentInfo getAttachmentByAttachId(int attachId) throws IOException {
        return getCwmData().getIBaseStrategy().getAttachmentByAttachId(attachId);
    }


    /**
     * 获得附件表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AttachmentInfo
     **/
    public List<AttachmentInfo> getAttachmentList(Specification<AttachmentInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getAttachmentList(condition, sort);
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
    public Page<AttachmentInfo> getAttachmentList(Integer pageSize, Integer pageNumber, Specification<AttachmentInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getAttachmentList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
