package com.cqwo.base.data;

import com.cqwo.base.core.domain.users.CreditLogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//积分日志
@Service(value = "CreditLogsData")
public class CreditLogs extends DataService {


    //region  积分日志方法

    /**
     * 获得积分日志数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getCreditLogCount(Specification<CreditLogInfo> condition) throws IOException {
        return getCwmData().getILog2Strategy().getCreditLogCount(condition);
    }

    /**
     * 创建一条积分日志数据
     *
     * @param creditlogInfo 积分日志模型
     * @return 返回创建信息
     **/
    public CreditLogInfo createCreditLog(CreditLogInfo creditlogInfo) throws IOException {
        return getCwmData().getILog2Strategy().createCreditLog(creditlogInfo);
    }

    /**
     * 更新一条积分日志数据
     *
     * @param creditlogInfo 积分日志模型
     **/
    public CreditLogInfo updateCreditLog(CreditLogInfo creditlogInfo) throws IOException {
        return getCwmData().getILog2Strategy().updateCreditLog(creditlogInfo);
    }

    /**
     * 删除一条积分日志数据
     *
     * @param logid 积分日志模型
     **/
    public void deleteCreditLogByLogid(Integer logid) throws IOException {
        getCwmData().getILog2Strategy().deleteCreditLogByLogid(logid);
    }

    /**
     * 批量删除一批积分日志数据
     **/
    public void deleteCreditLogByLogidList(String logidList) throws IOException {
        getCwmData().getILog2Strategy().deleteCreditLogByLogidList(logidList);
    }

    /**
     * 获取一条积分日志数据
     *
     * @param logid 积分日志模型
     **/
    public CreditLogInfo getCreditLogByLogid(Integer logid) throws IOException {
        return getCwmData().getILog2Strategy().getCreditLogByLogid(logid);
    }


    /**
     * 获得积分日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回CreditLogInfo
     **/
    public List<CreditLogInfo> getCreditLogList(Specification<CreditLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getILog2Strategy().getCreditLogList(condition, sort);
    }


    /**
     * 获得积分日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回CreditLogInfo
     **/
    public Page<CreditLogInfo> getCreditLogList(Integer pageSize, Integer pageNumber, Specification<CreditLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getILog2Strategy().getCreditLogList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
