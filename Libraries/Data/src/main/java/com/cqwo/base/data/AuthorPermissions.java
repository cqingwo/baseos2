package com.cqwo.base.data;

import com.cqwo.base.core.domain.authors.AuthorPermissionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 角色许可表
 *
 * @author cqnews
 * @date 2017/4/11
 */
@Service(value = "AuthorPermissionsData")
public class AuthorPermissions extends DataService {


    //region  角色许可表方法

    /**
     * 获得角色许可表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorPermissionCount(Specification<AuthorPermissionInfo> condition) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorPermissionCount(condition);
    }

    /**
     * 创建一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     * @return 返回创建信息
     **/
    public AuthorPermissionInfo createAuthorPermission(AuthorPermissionInfo authorpermissionInfo) throws IOException {
        return getCwmData().getIAuthorStrategy().createAuthorPermission(authorpermissionInfo);
    }

    /**
     * 更新一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     **/
    public AuthorPermissionInfo updateAuthorPermission(AuthorPermissionInfo authorpermissionInfo) throws IOException {
        return getCwmData().getIAuthorStrategy().updateAuthorPermission(authorpermissionInfo);
    }

    /**
     * 删除一条角色许可表数据
     *
     * @param id 角色许可表模型
     **/
    public void deleteAuthorPermissionById(Integer id) throws IOException {
        getCwmData().getIAuthorStrategy().deleteAuthorPermissionById(id);
    }

    /**
     * 批量删除一批角色许可表数据
     **/
    public void deleteAuthorPermissionByIdList(String idList) throws IOException {
        getCwmData().getIAuthorStrategy().deleteAuthorPermissionByIdList(idList);
    }

    /**
     * 获取一条角色许可表数据
     *
     * @param id 角色许可表模型
     **/
    public AuthorPermissionInfo getAuthorPermissionById(Integer id) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorPermissionById(id);
    }


    /**
     * 获得角色许可表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorPermissionInfo
     **/
    public List<AuthorPermissionInfo> getAuthorPermissionList(Specification<AuthorPermissionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorPermissionList(condition, sort);
    }


    /**
     * 获得角色许可表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorPermissionInfo
     **/
    public Page<AuthorPermissionInfo> getAuthorPermissionList(Integer pageSize, Integer pageNumber, Specification<AuthorPermissionInfo> condition, Sort sort) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorPermissionList(pageSize, pageNumber, condition, sort);
    }

    /**
     * 获得角色许可表数据列表
     *
     * @param roleId 角色
     * @return 返回AuthorPermissionInfo
     **/
    public List<AuthorPermissionInfo> getAuthorPermissionListByRoleId(Integer roleId) throws IOException {
        return getCwmData().getIAuthorStrategy().getAuthorPermissionListByRoleId(roleId);
    }


    //endregion

}
