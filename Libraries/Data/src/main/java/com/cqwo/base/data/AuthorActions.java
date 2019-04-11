package com.cqwo.base.data;

import com.cqwo.base.core.cache.CacheKeys;
import com.cqwo.base.core.domain.authors.AuthorActionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 *用户动作表
 * @author cqnews
 * @date 2017/4/11
 */
@Service(value = "AuthorActionsData")
public class AuthorActions extends DataService {


    //region  用户动作表方法

    /**
     * 获得用户动作表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorActionCount(Specification<AuthorActionInfo> condition) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorActionCount(condition);
    }

    /**
     * 创建一条用户动作表数据
     *
     * @param authoractionInfo 用户动作表模型
     * @return 返回创建信息
     **/
    public AuthorActionInfo createAuthorAction(AuthorActionInfo authoractionInfo) throws IOException {
        return getCwmData().getIAuthorStrategy().createAuthorAction(authoractionInfo);
    }

    /**
     * 更新一条用户动作表数据
     *
     * @param authoractionInfo 用户动作表模型
     **/
    public AuthorActionInfo updateAuthorAction(AuthorActionInfo authoractionInfo) throws IOException {

        AuthorActionInfo authorActionInfo = getCwmData().getIAuthorStrategy().updateAuthorAction(authoractionInfo);
        getCwmCache().getIcachestrategy().delete(CacheKeys.GET_AUTHOR_ACTION_AID + authoractionInfo.getAid());

        return authorActionInfo;
    }

    /**
     * 删除一条用户动作表数据
     *
     * @param aid 用户动作表模型
     **/
    public void deleteAuthorActionByAid(Integer aid) throws IOException {
        getCwmData().getIAuthorStrategy().deleteAuthorActionByAid(aid);
    }

    /**
     * 批量删除一批用户动作表数据
     **/
    public void deleteAuthorActionByAidList(String aidList) throws IOException {
        getCwmData().getIAuthorStrategy().deleteAuthorActionByAidList(aidList);
    }

    /**
     * 获取一条用户动作表数据
     *
     * @param aid 用户动作表模型
     **/
//    @Cacheable(value = "getAuthorActionByAid", key = "#aid")
    public AuthorActionInfo getAuthorActionByAid(Integer aid) throws IOException {

        AuthorActionInfo authorActionInfo = getCwmCache().getIcachestrategy().getValue(CacheKeys.GET_AUTHOR_ACTION_AID + aid, AuthorActionInfo.class);

        if (authorActionInfo == null) {

            authorActionInfo = getCwmData().getIAuthorStrategy().getAuthorActionByAid(aid);

            getCwmCache().getIcachestrategy().setValue(CacheKeys.GET_AUTHOR_ACTION_AID + aid, authorActionInfo);

        }

        return authorActionInfo;
    }


    /**
     * 获得用户动作表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorActionInfo
     **/
    public List<AuthorActionInfo> getAuthorActionList(Specification<AuthorActionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorActionList(condition, sort);
    }


    /**
     * 获得用户动作表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorActionInfo
     **/
    public Page<AuthorActionInfo> getAuthorActionList(Integer pageSize, Integer pageNumber, Specification<AuthorActionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorActionList(pageSize, pageNumber, condition, sort);
    }


    /**
     * 获取角色的分组信息
     *
     * @param roleId
     * @return
     */
//    @Cacheable(value = "getRoleAuthorActionList", key = "#roleId")
    public List<AuthorActionInfo> getRoleAuthorActionList(Integer roleId) throws IOException {

        List<AuthorActionInfo> authorActionInfoList = getCwmCache().getIcachestrategy().getListValue(CacheKeys.GET_ROLE_AUTHOR_ACTION_LIST + roleId, AuthorActionInfo.class);

        if (authorActionInfoList == null) {

            authorActionInfoList = getCwmData().getIAuthorStrategy().getRoleAuthorActionList(roleId);

            getCwmCache().getIcachestrategy().setValue(CacheKeys.GET_ROLE_AUTHOR_ACTION_LIST + roleId, authorActionInfoList);

        }

        return authorActionInfoList;

    }

    /**
     * 获取所有的节点列表
     *
     * @param group 分组名称
     * @return
     */
//    @Cacheable(value = "getGroupAuthorActionList", key = "#group")
    public List<AuthorActionInfo> getGroupAuthorActionList(String group) throws IOException {

        List<AuthorActionInfo> authorActionInfoList = getCwmCache().getIcachestrategy().getListValue(CacheKeys.GET_RGROUP_AUTHOR_ACTION_LIST + group, AuthorActionInfo.class);

        if (authorActionInfoList == null) {

            authorActionInfoList = getCwmData().getIAuthorStrategy().getGroupAuthorActionList(group);

            getCwmCache().getIcachestrategy().setValue(CacheKeys.GET_RGROUP_AUTHOR_ACTION_LIST + group, authorActionInfoList);

        }

        return authorActionInfoList;

    }

    /**
     * 获取所有的节点列表
     *
     * @return
     */
//    @Cacheable(value = "getAllAuthorActionList")
    public List<AuthorActionInfo> getAllAuthorActionList() throws IOException {

        List<AuthorActionInfo> authorActionInfoList = getCwmCache().getIcachestrategy().getListValue(CacheKeys.GET_ALL_AUTHOR_ACTION_LIST, AuthorActionInfo.class);

        if (authorActionInfoList == null) {

            authorActionInfoList = getCwmData().getIAuthorStrategy().getAllAuthorActionList();

            getCwmCache().getIcachestrategy().setValue(CacheKeys.GET_ALL_AUTHOR_ACTION_LIST, authorActionInfoList);

        }

        return authorActionInfoList;

    }

    /**
     * 获取所有的代理权限
     *
     * @return
     */
    public List<AuthorActionInfo> getAllAgentAuthorActionList() throws IOException {


        List<AuthorActionInfo> authorActionInfoList = getCwmCache().getIcachestrategy().getListValue(CacheKeys.GET_ALL_AGENT_AUTHOR_ACTION_LIST, AuthorActionInfo.class);

        if (authorActionInfoList == null) {

            authorActionInfoList = getCwmData().getIAuthorStrategy().getAllAgentAuthorActionList();

            getCwmCache().getIcachestrategy().setValue(CacheKeys.GET_ALL_AGENT_AUTHOR_ACTION_LIST, authorActionInfoList);

        }

        return authorActionInfoList;

    }
    //endregion

}
