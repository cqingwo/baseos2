package com.cqwo.base.strategy.rdbs.service;

import com.cqwo.base.core.data.rdbs.repository.authors.AuthorActionRepository;
import com.cqwo.base.core.data.rdbs.repository.authors.AuthorPermissionRepository;
import com.cqwo.base.core.data.rdbs.repository.authors.AuthorRoleRepository;
import com.cqwo.base.core.data.rdbs.repository.authors.AuthorSessionRepository;
import com.cqwo.base.core.enums.authors.AuthorGroups;
import com.cqwo.base.core.data.rdbs.IAuthorStrategy;
import com.cqwo.base.core.domain.authors.AuthorActionInfo;
import com.cqwo.base.core.domain.authors.AuthorPermissionInfo;
import com.cqwo.base.core.domain.authors.AuthorRoleInfo;
import com.cqwo.base.core.domain.authors.AuthorSessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component(value = "AdminStrategy")
public class AuthorStrategy implements IAuthorStrategy {

    @Autowired
    private AuthorRoleRepository roleRepository;

    //region 用户分组表

    /**
     * 获得用户分组表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getAuthorRoleCount(Specification<AuthorRoleInfo> condition) throws IOException {

        return roleRepository.count();
    }


    /**
     * 创建一条用户分组表数据
     *
     * @param authorroleInfo 用户分组表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public AuthorRoleInfo createAuthorRole(AuthorRoleInfo authorroleInfo) throws IOException {

        return roleRepository.save(authorroleInfo);
    }


    /**
     * 更新一条用户分组表数据
     *
     * @param authorroleInfo 用户分组表模型
     **/
    @Override
    public AuthorRoleInfo updateAuthorRole(AuthorRoleInfo authorroleInfo) throws IOException {

        if (authorroleInfo.getRoleId() >= 1) {
            return roleRepository.save(authorroleInfo);
        }

        return authorroleInfo;

    }


    /**
     * 删除一条用户分组表数据
     *
     * @param roleId 用户分组表模型
     **/
    @Override
    public void deleteAuthorRoleByRoleId(Integer roleId) throws IOException {

        roleRepository.deleteById(roleId);
    }

    /**
     * 批量删除一批用户分组表数据
     **/
    @Override
    public void deleteAuthorRoleByRoleIdList(String roleIdlist) throws IOException {


    }

    /**
     * 获得用户分组表一条记录
     *
     * @param roleId roleid
     * @return 返回一条AuthorRoleInfo
     **/
    @Override
    public AuthorRoleInfo getAuthorRoleByRoleId(Integer roleId) throws IOException {
        return roleRepository.findById(roleId).orElse(null);
    }


    /**
     * 获得用户分组表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorRoleInfo
     **/
    @Override
    public List<AuthorRoleInfo> getAuthorRoleList(Specification<AuthorRoleInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "roleId");
        }

        return roleRepository.findAll(condition, sort);

    }


    /**
     * 获得用户分组表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorRoleInfo
     **/
    @Override
    public Page<AuthorRoleInfo> getAuthorRoleList(Integer pageSize, Integer pageNumber, Specification<AuthorRoleInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1) {
            pageNumber--;
        }

        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "roleId");
        }


        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return roleRepository.findAll(condition, pageable);


    }


    /**
     * 获取用户的角色权限
     *
     * @param uid
     */
    @Override
    public List<AuthorRoleInfo> getUserAuthorRoleList(String uid) throws IOException {

        return roleRepository.getUserAuthorRoleList(uid);
    }

    //endregion

    @Autowired
    private AuthorSessionRepository sessionRepository;

    //region 用户-组关联表

    /**
     * 获得用户-组关联表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getAuthorSessionCount(Specification<AuthorSessionInfo> condition) throws IOException {

        return sessionRepository.count();
    }


    /**
     * 创建一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public AuthorSessionInfo createAuthorSession(AuthorSessionInfo authorsessionInfo) throws IOException {

        return sessionRepository.save(authorsessionInfo);
    }


    /**
     * 更新一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     **/
    @Override
    public AuthorSessionInfo updateAuthorSession(AuthorSessionInfo authorsessionInfo) throws IOException {

        if (authorsessionInfo.getId() >= 1) {
            return sessionRepository.save(authorsessionInfo);
        }

        return authorsessionInfo;

    }


    /**
     * 删除一条用户-组关联表数据
     *
     * @param uid
     * @param roleId 用户-组关联表模型
     **/
    @Override
    public void deleteAuthorSessionByRoleId(String uid, Integer roleId) throws IOException {

        sessionRepository.deleteAllByUidAndRoleId(uid, roleId);
    }

    /**
     * 删除用户的角色
     *
     * @param uid    uid
     * @param roleId 角色Id
     */
    @Override
    public void deleteUserAuthorRoleInfo(String uid, Integer roleId) throws IOException {
        sessionRepository.deleteUserAuthorRoleInfo(uid, roleId);
    }

    /**
     * 批量删除一批用户-组关联表数据
     **/
    @Override
    public void deleteAuthorSessionByIdList(String idlist) throws IOException {


    }

    /**
     * 获得用户-组关联表一条记录
     *
     * @param id deviceId
     * @return 返回一条AuthorSessionInfo
     **/
    @Override
    public AuthorSessionInfo getAuthorSessionById(Integer id) throws IOException {
        return sessionRepository.findById(id).orElse(null);
    }


    /**
     * 获得用户-组关联表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorSessionInfo
     **/
    @Override
    public List<AuthorSessionInfo> getAuthorSessionList(Specification<AuthorSessionInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return sessionRepository.findAll(condition, sort);

    }


    /**
     * 获得用户-组关联表数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorSessionInfo
     **/
    @Override
    public Page<AuthorSessionInfo> getAuthorSessionList(Integer pageSize, Integer pageNumber, Specification<AuthorSessionInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1) {
            pageNumber--;
        }

        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }


        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return sessionRepository.findAll(condition, pageable);


    }

    /**
     * 获取解色Id列表
     *
     * @param uid uid
     */
    @Override
    public List<Integer> getUserAuthorRoleIdList(String uid) throws IOException {

        return sessionRepository.getUserAuthorRoleIdList(uid);
    }

    //endregion

    @Autowired
    private AuthorPermissionRepository permissionRepository;

    //region 角色许可表

    /**
     * 获得角色许可表数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getAuthorPermissionCount(Specification<AuthorPermissionInfo> condition) throws IOException {

        return permissionRepository.count();
    }


    /**
     * 创建一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public AuthorPermissionInfo createAuthorPermission(AuthorPermissionInfo authorpermissionInfo) throws IOException {

        return permissionRepository.save(authorpermissionInfo);
    }


    /**
     * 更新一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     **/
    @Override
    public AuthorPermissionInfo updateAuthorPermission(AuthorPermissionInfo authorpermissionInfo) throws IOException {

        if (authorpermissionInfo.getId() >= 1) {
            return permissionRepository.save(authorpermissionInfo);
        }

        return authorpermissionInfo;

    }


    /**
     * 删除一条角色许可表数据
     *
     * @param id 角色许可表模型
     **/
    @Override
    public void deleteAuthorPermissionById(Integer id) throws IOException {

        permissionRepository.deleteById(id);
    }

    /**
     * 批量删除一批角色许可表数据
     **/
    @Override
    public void deleteAuthorPermissionByIdList(String idlist) throws IOException {


    }

    /**
     * 获得角色许可表一条记录
     *
     * @param id deviceId
     * @return 返回一条AuthorPermissionInfo
     **/
    @Override
    public AuthorPermissionInfo getAuthorPermissionById(Integer id) throws IOException {
        return permissionRepository.findById(id).orElse(null);
    }


    /**
     * 获得角色许可表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorPermissionInfo
     **/
    @Override
    public List<AuthorPermissionInfo> getAuthorPermissionList(Specification<AuthorPermissionInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        return permissionRepository.findAll(condition, sort);

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
    @Override
    public Page<AuthorPermissionInfo> getAuthorPermissionList(Integer pageSize, Integer pageNumber, Specification<AuthorPermissionInfo> condition, Sort sort) throws IOException {


        if (pageNumber >= 1) {
            pageNumber--;
        }

        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "id");
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return permissionRepository.findAll(condition, pageable);


    }

    /**
     * 获得角色许可表数据列表
     *
     * @param roleId 角色
     * @return 返回AuthorPermissionInfo
     **/
    @Override
    public List<AuthorPermissionInfo> getAuthorPermissionListByRoleId(Integer roleId) throws IOException {
        return permissionRepository.findAllByRoleId(roleId);
    }

    //endregion

    @Autowired
    private AuthorActionRepository actionRepository;

    //region 动作管理

    /**
     * 获得动作管理数量
     *
     * @param condition 条件
     * @return 返回数量
     * @throws IOException
     **/
    @Override
    public long getAuthorActionCount(Specification<AuthorActionInfo> condition) throws IOException {

        return actionRepository.count();
    }


    /**
     * 创建一条动作管理数据
     *
     * @param authorActionInfo 动作管理模型
     * @return 返回创建信息
     * @throws IOException
     **/
    @Override
    public AuthorActionInfo createAuthorAction(AuthorActionInfo authorActionInfo) throws IOException {

        return actionRepository.save(authorActionInfo);
    }


    /**
     * 更新一条动作管理数据
     *
     * @param actionInfo 动作管理模型
     **/
    @Override
    public AuthorActionInfo updateAuthorAction(AuthorActionInfo actionInfo) throws IOException {

        if (actionInfo.getAid() >= 1) {
            return actionRepository.save(actionInfo);
        }

        return actionInfo;

    }


    /**
     * 删除一条动作管理数据
     *
     * @param aid 动作管理模型
     **/
    @Override
    public void deleteAuthorActionByAid(Integer aid) throws IOException {

        actionRepository.deleteById(aid);
    }

    /**
     * 批量删除一批动作管理数据
     **/
    @Override
    public void deleteAuthorActionByAidList(String aidlist) throws IOException {


    }

    /**
     * 获得动作管理一条记录
     *
     * @param aid aid
     * @return 返回一条AuthorActionInfo
     **/
    @Override
    public AuthorActionInfo getAuthorActionByAid(Integer aid) throws IOException {
        return actionRepository.findById(aid).orElse(null);
    }


    /**
     * 获得动作管理数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorActionInfo
     **/
    @Override
    public List<AuthorActionInfo> getAuthorActionList(Specification<AuthorActionInfo> condition, Sort sort) throws IOException {


        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "aid");
        }

        return actionRepository.findAll(condition, sort);

    }


    /**
     * 获得动作管理数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回AuthorActionInfo
     **/
    @Override
    public Page<AuthorActionInfo> getAuthorActionList(Integer pageSize, Integer pageNumber, Specification<AuthorActionInfo> condition, Sort sort) throws IOException {

        if (pageNumber >= 1) {
            pageNumber--;
        }

        if (sort == null) {
            sort = new Sort(Sort.Direction.DESC, "aid");
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return actionRepository.findAll(condition, pageable);


    }

    /**
     * 获取角色的分组信息
     *
     * @param roleId 权限id
     * @return
     */
    @Override
    public List<AuthorActionInfo> getRoleAuthorActionList(Integer roleId) throws IOException {
        return actionRepository.getRoleAuthorActionList(roleId);
    }

    /**
     * 获取所有的节点列表
     *
     * @param group 分组名称
     * @return
     */
    @Override
    public List<AuthorActionInfo> getGroupAuthorActionList(String group) throws IOException {
        Sort sort = new Sort(Sort.Direction.ASC, "displayOrder");

        Specification<AuthorActionInfo> condition = (Specification<AuthorActionInfo>) (root, query, cb) -> {

            List<Predicate> list = new ArrayList<>();

            list.add(cb.equal(root.get("group").as(String.class), group));

            Predicate[] p = new Predicate[list.size()];

            query.where(cb.and(list.toArray(p)));

            return query.getGroupRestriction();
        };

        return actionRepository.findAll(condition, sort);
    }

    /**
     * 获取所有的节点列表
     *
     * @return
     */
    @Override
    public List<AuthorActionInfo> getAllAuthorActionList() throws IOException {

        Sort sort = new Sort(Sort.Direction.ASC, "displayOrder");
        return actionRepository.findAll(sort);
    }

    /**
     * 获取所有的代理权限
     *
     * @return
     */
    @Override
    public List<AuthorActionInfo> getAllAgentAuthorActionList() throws IOException {

        return actionRepository.findAllByGroup(AuthorGroups.Agent.getCode());
    }
    //endregion


}
