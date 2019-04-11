package com.cqwo.base.data;

import com.cqwo.base.core.domain.sms.SMSInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//短信
@Service(value = "SMSesData")
public class SMSes extends DataService {


    //region  短信方法

    /**
     * 获得短信数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getSMSCount(Specification<SMSInfo> condition) throws IOException {
        return getCwmData().getIBaseStrategy().getSMSCount(condition);
    }

    /**
     * 创建一条短信数据
     *
     * @param smsInfo 短信模型
     * @return 返回创建信息
     **/
    public SMSInfo createSMS(SMSInfo smsInfo) throws IOException {
        return getCwmData().getIBaseStrategy().createSMS(smsInfo);
    }

    /**
     * 更新一条短信数据
     *
     * @param smsInfo 短信模型
     **/
    public SMSInfo updateSMS(SMSInfo smsInfo) throws IOException {
        return getCwmData().getIBaseStrategy().updateSMS(smsInfo);
    }

    /**
     * 删除一条短信数据
     *
     * @param id 短信模型
     **/
    public void deleteSMSById(Integer id) throws IOException {
        getCwmData().getIBaseStrategy().deleteSMSById(id);
    }

    /**
     * 批量删除一批短信数据
     **/
    public void deleteSMSByIdList(String idList) throws IOException {
        getCwmData().getIBaseStrategy().deleteSMSByIdList(idList);
    }

    /**
     * 获取一条短信数据
     *
     * @param id 短信模型
     **/
    public SMSInfo getSMSById(Integer id) throws IOException {
        return getCwmData().getIBaseStrategy().getSMSById(id);
    }


    /**
     * 获得短信数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回SMSInfo
     **/
    public List<SMSInfo> getSMSList(Specification<SMSInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getSMSList(condition, sort);
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
    public Page<SMSInfo> getSMSList(Integer pageSize, Integer pageNumber, Specification<SMSInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIBaseStrategy().getSMSList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
