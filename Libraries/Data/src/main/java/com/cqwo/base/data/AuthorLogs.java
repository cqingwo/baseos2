package com.cqwo.base.data;

import com.cqwo.base.core.domain.authors.AuthorLogInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */


//管理员日志
@Service(value = "AuthorLogsData")
public class AuthorLogs extends DataService {


    //region  管理员日志方法

    /**
     * 获得管理员日志数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorLogCount(Specification<AuthorLogInfo> condition) throws IOException {
        return getCwmData().getILog2Strategy().getAuthorLogCount(condition);
    }

    /**
     * 创建一条管理员日志数据
     *
     * @param authorLogInfo 管理员日志模型
     * @return 返回创建信息
     **/
    public AuthorLogInfo createAuthorLog(AuthorLogInfo authorLogInfo) throws IOException {
        return getCwmData().getILog2Strategy().createAuthorLog(authorLogInfo);
    }

    /**
     * 更新一条管理员日志数据
     *
     * @param authorLogInfo 管理员日志模型
     **/
    public AuthorLogInfo updateAuthorLog(AuthorLogInfo authorLogInfo) throws IOException {
        return getCwmData().getILog2Strategy().updateAuthorLog(authorLogInfo);
    }

    /**
     * 删除一条管理员日志数据
     *
     * @param logid 管理员日志模型
     **/
    public void deleteAuthorLogByLogid(Integer logid) throws IOException {
        getCwmData().getILog2Strategy().deleteAuthorLogByLogid(logid);
    }

    /**
     * 批量删除一批管理员日志数据
     **/
    public void deleteAuthorLogByLogidList(String logidList) throws IOException {
        getCwmData().getILog2Strategy().deleteAuthorLogByLogidList(logidList);
    }

    /**
     * 获取一条管理员日志数据
     *
     * @param logid 管理员日志模型
     **/
    public AuthorLogInfo getAuthorLogByLogid(Integer logid) throws IOException {
        return getCwmData().getILog2Strategy().getAuthorLogByLogid(logid);
    }


    /**
     * 获得管理员日志数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorLogInfo
     **/
    public List<AuthorLogInfo> getAuthorLogList(Specification<AuthorLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getILog2Strategy().getAuthorLogList(condition, sort);
    }


    /**
     * 获得管理员日志数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorLogInfo
     **/
    public Page<AuthorLogInfo> getAuthorLogList(Integer pageSize, Integer pageNumber, Specification<AuthorLogInfo> condition, Sort sort) throws IOException {
        return getCwmData().getILog2Strategy().getAuthorLogList(pageSize, pageNumber, condition, sort);
    }


    //endregion

}
