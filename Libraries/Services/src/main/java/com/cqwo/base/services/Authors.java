package com.cqwo.base.services;


import com.cqwo.base.data.AuthorActions;
import com.cqwo.base.data.AuthorPermissions;
import com.cqwo.base.data.AuthorRoles;
import com.cqwo.base.data.AuthorSessions;
import com.cqwo.base.core.domain.authors.AuthorActionInfo;
import com.cqwo.base.core.domain.authors.AuthorPermissionInfo;
import com.cqwo.base.core.domain.authors.AuthorRoleInfo;
import com.cqwo.base.core.domain.authors.AuthorSessionInfo;
import com.cqwo.base.core.helper.ListHelper;
import com.cqwo.base.core.model.MultiSelectListItem;
import com.cqwo.base.core.model.SelectListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cqnews
 */
@Service(value = "Authors")
public class Authors {

    @Resource(name = "AuthorRolesData")
    private AuthorRoles authorRoles;

    @Resource(name = "AuthorSessionsData")
    private AuthorSessions authorSessions;

    @Resource(name = "AuthorPermissionsData")
    private AuthorPermissions authorPermissions;

    @Resource(name = "AuthorActionsData")
    private AuthorActions authorActions;

    @Autowired
    private Logs logs;


    private Lock lock = new ReentrantLock();

    //region 自定义


    /**
     * 获取用户的角色权限
     *
     * @param uid
     */
    public List<AuthorRoleInfo> getUserAuthorRoleList(String uid) {

        List<AuthorRoleInfo> authorRoleList = new ArrayList<>();

        if (uid.isEmpty()) {
            return authorRoleList;
        }

        try {
            authorRoleList = authorRoles.getUserAuthorRoleList(uid);

        } catch (Exception ex) {
            logs.write(ex, "获取用户的角色权限");
        }

        return authorRoleList;

    }

    /**
     * 获取用户列表
     *
     * @param uid
     * @return
     */
    public List<SelectListItem> getUserAuthorRoleItemList(String uid) {

        List<AuthorRoleInfo> allAuthorActionList = getAllAuthorRoleList();

        List<Integer> roleInfoList = getUserAuthorRoleIdList(uid);

        List<SelectListItem> itemList = new ArrayList<>();

        for (AuthorRoleInfo roleInfo : allAuthorActionList) {


            boolean isSelected = false;

            if (roleInfoList.contains(roleInfo.getRoleId())) {
                isSelected = true;
            }

            SelectListItem item = new SelectListItem(isSelected, roleInfo.getTitle(), roleInfo.getRoleId().toString());

            itemList.add(item);

        }

        return itemList;
    }

    /**
     * 获取解色Id列表
     *
     * @param uid uid
     * @return
     */
    public List<Integer> getUserAuthorRoleIdList(String uid) {

        List<Integer> idList = new ArrayList<>();

        try {

            idList = authorSessions.getUserAuthorRoleIdList(uid);

        } catch (Exception ex) {

            logs.write(ex, "获取解色Id列表");
        }

        return idList;

    }


    /**
     * 获取
     *
     * @param uid
     * @return
     */
    public List<AuthorActionInfo> getUserAuthorActionList(String uid) {

        /**
         * 先获取我拥有的分组
         */
        List<AuthorRoleInfo> authorRoleInfoList = getUserAuthorRoleList(uid);

        List<AuthorActionInfo> authorActionInfoList = new ArrayList<>();

        for (AuthorRoleInfo roleInfo : authorRoleInfoList) {

            List<AuthorActionInfo> actionList = getRoleAuthorActionList(roleInfo.getRoleId());

            authorActionInfoList.addAll(actionList);
        }

        /**
         * 删除重复并按原先排序
         */
        ListHelper.removeDuplicateWithOrder(authorActionInfoList);


        return authorActionInfoList;
    }

    /**
     * 获取角色的分组信息
     *
     * @param roleId
     * @return
     */
    public List<AuthorActionInfo> getRoleAuthorActionList(Integer roleId) {

        List<AuthorActionInfo> authorActionInfoList = new ArrayList<>();

        try {

            authorActionInfoList = authorActions.getRoleAuthorActionList(roleId);

        } catch (Exception ex) {

            logs.write(ex, "获取角色的分组信息");
        }


        return authorActionInfoList;
    }


    //endregion

    //region 常规增删改查

    //region  用户分组表方法

    /**
     * 获得用户分组表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorRoleCount(Specification<AuthorRoleInfo> condition) {

        try {
            return authorRoles.getAuthorRoleCount(condition);
        } catch (Exception e) {
            logs.write(e, "获得用户分组表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条用户分组表数据
     *
     * @param authorroleInfo 用户分组表模型
     * @return 返回创建信息
     **/
    public AuthorRoleInfo createAuthorRole(AuthorRoleInfo authorroleInfo) {
        try {
            return authorRoles.createAuthorRole(authorroleInfo);
        } catch (Exception e) {
            logs.write(e, "创建一条用户分组表数据失败");
        }
        return null;
    }

    /**
     * 更新一条用户分组表数据
     *
     * @param authorroleInfo 用户分组表模型
     **/
    public AuthorRoleInfo updateAuthorRole(AuthorRoleInfo authorroleInfo) {
        try {
            return authorRoles.updateAuthorRole(authorroleInfo);
        } catch (Exception ex) {

            ex.printStackTrace();
            logs.write(ex, "更新一条用户分组表数据异常");
        }

        return null;
    }

    /**
     * 删除一条用户分组表数据
     *
     * @param roleId 用户分组表模型
     **/
    public void deleteAuthorRoleByRoleId(Integer roleId) {
        try {
            authorRoles.deleteAuthorRoleByRoleId(roleId);
        } catch (Exception e) {
            logs.write(e, "删除一条用户分组表数据异常");
        }
    }

    /**
     * 批量删除一批用户分组表数据
     **/
    public void deleteAuthorRoleByRoleIdList(String roleIdList) {
        try {
            authorRoles.deleteAuthorRoleByRoleIdList(roleIdList);
        } catch (Exception e) {
            logs.write(e, "批量删除一批用户分组表数据异常");
        }
    }

    /**
     * 获取一条用户分组表数据
     *
     * @param roleId 用户分组表模型
     **/
    public AuthorRoleInfo getAuthorRoleByRoleId(Integer roleId) {
        try {
            return authorRoles.getAuthorRoleByRoleId(roleId);
        } catch (Exception e) {
            logs.write(e, "获取一条用户分组表数据");
        }

        return null;
    }

    /**
     * 获得用户分组表数据列表
     *
     * @return 返回AuthorRoleInfo
     **/
    public List<AuthorRoleInfo> getAllAuthorRoleList() {

        Specification<AuthorRoleInfo> condition = (Specification<AuthorRoleInfo>) (root, query, cb) -> null;

        Sort sort = new Sort(Sort.Direction.DESC, "displayOrder");

        return getAuthorRoleList(condition, sort);
    }

    /**
     * 获得用户分组表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorRoleInfo
     **/
    public List<AuthorRoleInfo> getAuthorRoleList(Specification<AuthorRoleInfo> condition, Sort sort) {

        List<AuthorRoleInfo> authorRoleList = new ArrayList<AuthorRoleInfo>();

        try {
            authorRoleList = authorRoles.getAuthorRoleList(condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户分组表数据列表异常");
        }

        return authorRoleList;
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
    public Page<AuthorRoleInfo> getAuthorRoleList(Integer pageSize, Integer pageNumber, Specification<AuthorRoleInfo> condition, Sort sort) {

        Page<AuthorRoleInfo> authorRoleList = null;

        try {
            authorRoleList = authorRoles.getAuthorRoleList(pageSize, pageNumber, condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户分组表数据列表异常");
        }

        return authorRoleList;
    }


    //endregion

    //region  用户-组关联表方法

    /**
     * 获得用户-组关联表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorSessionCount(Specification<AuthorSessionInfo> condition) {

        try {
            return authorSessions.getAuthorSessionCount(condition);
        } catch (Exception e) {
            logs.write(e, "获得用户-组关联表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     * @return 返回创建信息
     **/

    public AuthorSessionInfo createAuthorSession(AuthorSessionInfo authorsessionInfo) {
        try {
            return authorSessions.createAuthorSession(authorsessionInfo);
        } catch (Exception e) {
            logs.write(e, "创建一条用户-组关联表数据失败");
        }
        return null;
    }

    /**
     * 更新一条用户-组关联表数据
     *
     * @param authorsessionInfo 用户-组关联表模型
     **/
    public AuthorSessionInfo updateAuthorSession(AuthorSessionInfo authorsessionInfo) {
        try {
            return authorSessions.updateAuthorSession(authorsessionInfo);
        } catch (Exception e) {
            logs.write(e, "更新一条用户-组关联表数据异常");
        }

        return null;
    }

    /**
     * 删除一条用户-组关联表数据
     *
     * @param uid
     * @param roleId 用户-组关联表模型
     **/
    @CacheEvict(value = "getUserAuthorRoleList", key = "#uid")
    public void deleteAuthorSessionByRoleId(String uid, Integer roleId) {
        try {
            authorSessions.deleteAuthorSessionByRoleId(uid, roleId);
        } catch (Exception e) {
            logs.write(e, "删除一条用户-组关联表数据异常");
        }
    }

    /**
     * 批量删除一批用户-组关联表数据
     **/
    public void deleteAuthorSessionByIdList(String idList) {
        try {
            authorSessions.deleteAuthorSessionByIdList(idList);
        } catch (Exception e) {
            logs.write(e, "批量删除一批用户-组关联表数据异常");
        }
    }

    /**
     * 批量删除一批用户-组关联表数据
     **/
    public void deleteAuthorSessionByIdList(String uid, List<Integer> idList) {

        for (Integer id : idList) {
            deleteAuthorSessionByRoleId(uid, id);
        }
    }

    /**
     * 获取一条用户-组关联表数据
     *
     * @param id 用户-组关联表模型
     **/
    public AuthorSessionInfo getAuthorSessionById(Integer id) {
        try {
            return authorSessions.getAuthorSessionById(id);
        } catch (Exception e) {
            logs.write(e, "获取一条用户-组关联表数据");
        }

        return null;
    }


    /**
     * 获得用户-组关联表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorSessionInfo
     **/
    public List<AuthorSessionInfo> getAuthorSessionList(Specification<AuthorSessionInfo> condition, Sort sort) {

        List<AuthorSessionInfo> authorSessionList = new ArrayList<AuthorSessionInfo>();

        try {
            authorSessionList = authorSessions.getAuthorSessionList(condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户-组关联表数据列表异常");
        }

        return authorSessionList;
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
    public Page<AuthorSessionInfo> getAuthorSessionList(Integer pageSize, Integer pageNumber, Specification<AuthorSessionInfo> condition, Sort sort) {

        Page<AuthorSessionInfo> authorSessionList = null;

        try {
            authorSessionList = authorSessions.getAuthorSessionList(pageSize, pageNumber, condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户-组关联表数据列表异常");
        }

        return authorSessionList;
    }


    //endregion

    //region  角色许可表方法

    /**
     * 获得角色许可表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorPermissionCount(Specification<AuthorPermissionInfo> condition) {

        try {
            return authorPermissions.getAuthorPermissionCount(condition);
        } catch (Exception e) {
            logs.write(e, "获得角色许可表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     * @return 返回创建信息
     **/
    public AuthorPermissionInfo createAuthorPermission(AuthorPermissionInfo authorpermissionInfo) {
        try {
            return authorPermissions.createAuthorPermission(authorpermissionInfo);
        } catch (Exception e) {

            logs.write(e, "创建一条角色许可表数据失败");
        }
        return null;
    }

    /**
     * 更新一条角色许可表数据
     *
     * @param authorpermissionInfo 角色许可表模型
     **/
    public AuthorPermissionInfo updateAuthorPermission(AuthorPermissionInfo authorpermissionInfo) {
        try {
            return authorPermissions.updateAuthorPermission(authorpermissionInfo);
        } catch (Exception e) {
            logs.write(e, "更新一条角色许可表数据异常");
        }

        return null;
    }

    /**
     * 删除一条角色许可表数据
     *
     * @param id 角色许可表模型
     **/
    public void deleteAuthorPermissionById(Integer id) {
        try {
            authorPermissions.deleteAuthorPermissionById(id);
        } catch (Exception e) {
            logs.write(e, "删除一条角色许可表数据异常");
        }
    }

    /**
     * 批量删除一批角色许可表数据
     **/
    public void deleteAuthorPermissionByIdList(String idList) {
        try {
            authorPermissions.deleteAuthorPermissionByIdList(idList);
        } catch (Exception e) {
            logs.write(e, "批量删除一批角色许可表数据异常");
        }
    }

    /**
     * 获取一条角色许可表数据
     *
     * @param id 角色许可表模型
     **/
    public AuthorPermissionInfo getAuthorPermissionById(Integer id) {
        try {
            return authorPermissions.getAuthorPermissionById(id);
        } catch (Exception e) {
            logs.write(e, "获取一条角色许可表数据");
        }

        return null;
    }


    /**
     * 获得角色许可表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorPermissionInfo
     **/
    public List<AuthorPermissionInfo> getAuthorPermissionList(Specification<AuthorPermissionInfo> condition, Sort sort) {

        List<AuthorPermissionInfo> authorPermissionList = new ArrayList<AuthorPermissionInfo>();

        try {
            authorPermissionList = authorPermissions.getAuthorPermissionList(condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得角色许可表数据列表异常");
        }

        return authorPermissionList;
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
    public Page<AuthorPermissionInfo> getAuthorPermissionList(Integer pageSize, Integer pageNumber, Specification<AuthorPermissionInfo> condition, Sort sort) {

        Page<AuthorPermissionInfo> authorPermissionList = null;

        try {
            authorPermissionList = authorPermissions.getAuthorPermissionList(pageSize, pageNumber, condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得角色许可表数据列表异常");
        }

        return authorPermissionList;
    }

    /**
     * 获得角色许可表数据列表
     *
     * @param roleId 角色
     * @return 返回AuthorPermissionInfo
     **/
    public List<AuthorPermissionInfo> getAuthorPermissionListByRoleId(Integer roleId) {


        List<AuthorPermissionInfo> permissionInfoList = new ArrayList<>();

        try {
            permissionInfoList = authorPermissions.getAuthorPermissionListByRoleId(roleId);
        } catch (IOException ex) {

            logs.write(ex, "获得角色许可表数据列表");
            ex.printStackTrace();
        }

        return permissionInfoList;

    }


    //endregion

    //region  用户动作表方法

    /**
     * 获得用户动作表数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getAuthorActionCount(Specification<AuthorActionInfo> condition) {

        try {
            return authorActions.getAuthorActionCount(condition);
        } catch (Exception e) {
            logs.write(e, "获得用户动作表数量失败");
        }
        return 0;
    }

    /**
     * 创建一条用户动作表数据
     *
     * @param authoractionInfo 用户动作表模型
     * @return 返回创建信息
     **/
    public AuthorActionInfo createAuthorAction(AuthorActionInfo authoractionInfo) {
        try {
            return authorActions.createAuthorAction(authoractionInfo);
        } catch (Exception e) {
            logs.write(e, "创建一条用户动作表数据失败");
        }
        return null;
    }

    /**
     * 更新一条用户动作表数据
     *
     * @param authoractionInfo 用户动作表模型
     **/
    public AuthorActionInfo updateAuthorAction(AuthorActionInfo authoractionInfo) {
        try {
            return authorActions.updateAuthorAction(authoractionInfo);
        } catch (Exception e) {
            logs.write(e, "更新一条用户动作表数据异常");
        }

        return null;
    }

    /**
     * 删除一条用户动作表数据
     *
     * @param aid 用户动作表模型
     **/
    public void deleteAuthorActionByAid(Integer aid) {
        try {
            authorActions.deleteAuthorActionByAid(aid);
        } catch (Exception e) {
            logs.write(e, "删除一条用户动作表数据异常");
        }
    }

    /**
     * 批量删除一批用户动作表数据
     **/
    public void deleteAuthorActionByAidList(String aidList) {
        try {
            authorActions.deleteAuthorActionByAidList(aidList);
        } catch (Exception e) {
            logs.write(e, "批量删除一批用户动作表数据异常");
        }
    }

    /**
     * 获取一条用户动作表数据
     *
     * @param aid 用户动作表模型
     **/
    public AuthorActionInfo getAuthorActionByAid(Integer aid) {
        try {
            return authorActions.getAuthorActionByAid(aid);
        } catch (Exception e) {
            logs.write(e, "获取一条用户动作表数据");
        }

        return null;
    }


    /**
     * 获得用户动作表数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回AuthorActionInfo
     **/
    public List<AuthorActionInfo> getAuthorActionList(Specification<AuthorActionInfo> condition, Sort sort) {

        List<AuthorActionInfo> authorActionList = new ArrayList<AuthorActionInfo>();

        try {
            authorActionList = authorActions.getAuthorActionList(condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户动作表数据列表异常");
        }

        return authorActionList;
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
    public Page<AuthorActionInfo> getAuthorActionList(Integer pageSize, Integer pageNumber, Specification<AuthorActionInfo> condition, Sort sort) {

        Page<AuthorActionInfo> authorActionList = null;

        try {
            authorActionList = authorActions.getAuthorActionList(pageSize, pageNumber, condition, sort);
        } catch (Exception e) {
            logs.write(e, "获得用户动作表数据列表异常");
        }

        return authorActionList;
    }

    /**
     * 获取所有的节点列表
     *
     * @return
     */
    public List<AuthorActionInfo> getAllAuthorActionList() {

        List<AuthorActionInfo> authorActionInfoList = new ArrayList<>();

        try {
            authorActionInfoList = authorActions.getAllAuthorActionList();

        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "获取所有的节点列表");
        }

        return authorActionInfoList;
    }

    /**
     * 获取所有的节点列表
     *
     * @param group 分组名称
     * @return
     */
    public List<AuthorActionInfo> getGroupAuthorActionList(String group) {

        List<AuthorActionInfo> authorActionInfoList = new ArrayList<>();

        try {
            authorActionInfoList = authorActions.getGroupAuthorActionList(group);

        } catch (Exception ex) {
            ex.printStackTrace();
            logs.write(ex, "获取所有的节点列表");
        }

        return authorActionInfoList;
    }


    /**
     * 获取所有的代理权限
     *
     * @param agentId
     * @return
     */
    public List<AuthorActionInfo> getAgentAuthorActionList(Integer agentId) {

        return getAllAgentAuthorActionList();
    }

    /**
     * 获取所有的代理权限
     *
     * @return
     */
    public List<AuthorActionInfo> getAllAgentAuthorActionList() {

        List<AuthorActionInfo> actionInfoList = new ArrayList<>();

        try {
            actionInfoList = authorActions.getAllAgentAuthorActionList();
        } catch (Exception ex) {
            logs.write(ex, "获取所有的代理权限");
        }

        return actionInfoList;

    }

    /**
     * 获取权限结构树
     *
     * @param actionInfoList     权限结构树
     * @param permissionInfoList 已有权限
     * @return
     */
    public List<MultiSelectListItem> getActionItemList(List<AuthorActionInfo> actionInfoList, List<AuthorPermissionInfo> permissionInfoList) {

        List<MultiSelectListItem> multiSelectListItemList = new ArrayList<>();

        List<AuthorActionInfo> tempActionInfoList = new ArrayList<>(actionInfoList);


        for (AuthorActionInfo actionInfo : actionInfoList) {


            if (actionInfo.getParentId() == 0) {

                MultiSelectListItem multiItem = new MultiSelectListItem();


                boolean isComprise = isComprise(actionInfo.getAid(), permissionInfoList);
                multiItem.item = new SelectListItem(isComprise, actionInfo.getTitle(), actionInfo.getAid().toString());

                List<AuthorActionInfo> runActionList = new ArrayList<>(tempActionInfoList);

                for (AuthorActionInfo subActionInfo : runActionList) {
                    if (actionInfo.getAid().equals(subActionInfo.getParentId())) {

                        multiItem.itemList.add(new SelectListItem(isComprise ? isComprise : isComprise(subActionInfo.getAid(), permissionInfoList), subActionInfo.getTitle(), subActionInfo.getAid().toString()));
                        tempActionInfoList.remove(subActionInfo);
                    }
                }

                tempActionInfoList.remove(actionInfo);

                multiSelectListItemList.add(multiItem);

            }
        }

        return multiSelectListItemList;

    }

    private boolean isComprise(Integer aid, List<AuthorPermissionInfo> permissionInfoList) {

        for (AuthorPermissionInfo permissionInfo : permissionInfoList) {

            if (aid.equals(permissionInfo.getAid())) {
                return true;
            }
        }

        return false;
    }

    /**
     * 更新角色权限
     *
     * @param roleId  角色Id
     * @param aidList 动作列表
     */
    public boolean updateAuthorRolePermission(Integer roleId, List<Integer> aidList) {

        lock.lock();

        try {

            List<AuthorPermissionInfo> permissionInfoList = getAuthorPermissionListByRoleId(roleId);

            List<AuthorPermissionInfo> containGroupInfoList = new ArrayList<>();

            for (AuthorPermissionInfo permissionInfo : permissionInfoList) {

                for (Integer aid : aidList) {
                    /*
                     * 查找对比现在的列表是否包含在groupIdList中
                     */
                    if (aid.equals(permissionInfo.getAid())) {
                        aidList.remove(aid);
                        containGroupInfoList.add(permissionInfo);
                        break;
                    }
                }
            }


            /*
             * 删除已经包含的那一部分
             */
            permissionInfoList.removeAll(containGroupInfoList);

            /**
             * 删除多的那一部分
             */
            if (permissionInfoList.size() >= 1) {
                deletePermissionList(roleId, permissionInfoList);
            }

            /**
             * 增加没有的那一部分
             */
            if (aidList.size() >= 1) {
                batchCreatePermission(roleId, aidList);
            }

            return true;

        } catch (Exception ex) {

            logs.write(ex, "更新角色权限");

        } finally {

            lock.unlock();

        }


        return false;

    }

    private void batchCreatePermission(Integer roleId, List<Integer> aidList) {

        for (Integer aid : aidList) {
            AuthorPermissionInfo permissionInfo = new AuthorPermissionInfo();
            permissionInfo.setAid(aid);
            permissionInfo.setRoleId(roleId);
            createAuthorPermission(permissionInfo);
        }

    }

    /**
     * 删除列表
     *
     * @param roleId
     * @param list   列表
     */
    private void deletePermissionList(Integer roleId, List<AuthorPermissionInfo> list) {

        for (AuthorPermissionInfo info : list) {

            if (roleId.equals(info.getRoleId())) {
                deleteAuthorPermissionById(info.getId());
            }
        }
    }

    /**
     * 更新用户角色
     *
     * @param uid        uid
     * @param roleIdList roleIdList
     */
    public void updateAuthorSession(String uid, List<Integer> roleIdList) {

        try {

            List<Integer> authorRoleIdList = getUserAuthorRoleIdList(uid);

            List<Integer> containAuthorRoleIdList = new ArrayList<>();

            for (Integer roleId : authorRoleIdList) {

                for (Integer currentRoleId : roleIdList) {
                    if (roleId.equals(currentRoleId)) {
                        roleIdList.remove(roleId);
                        containAuthorRoleIdList.add(currentRoleId);
                        break;
                    }
                }
            }

            /**
             * 去掉已经包含的部分
             */
            authorRoleIdList.removeAll(containAuthorRoleIdList);


            /**
             * 删除多的那一部分
             */
            if (authorRoleIdList.size() >= 1) {
                deleteAuthorSessionByIdList(uid, authorRoleIdList);
            }

            /**
             * 增加没有的那一部分
             */
            if (roleIdList.size() >= 1) {
                batchUserAuthorRole(uid, roleIdList);
            }


        } catch (Exception ex) {
            logs.write(ex, "更新用户角色");
        }

    }


    /**
     * 批量新增用户角色
     *
     * @param uid        uid
     * @param roleIdList 角色Id
     */
    private void batchUserAuthorRole(String uid, List<Integer> roleIdList) {

        for (Integer roleId : roleIdList) {

            AuthorRoleInfo roleInfo = getAuthorRoleByRoleId(roleId);
            if (roleInfo == null || roleInfo.getRoleId() <= 0) {
                continue;
            }

            AuthorSessionInfo authorSessionInfo = new AuthorSessionInfo(uid, roleId);
            createAuthorSession(authorSessionInfo);
        }
    }

    /**
     * 删除用户的角色
     *
     * @param uid          uid
     * @param roleInfoList 角色列表
     */
    private void deleteUserAuthorRoleInfoList(String uid, List<AuthorSessionInfo> roleInfoList) {

        for (AuthorSessionInfo roleInfo : roleInfoList) {
            try {
                if (uid.equals(roleInfo.getUid())) {
                    authorSessions.deleteUserAuthorRoleInfo(uid, roleInfo.getRoleId());
                }
            } catch (IOException ex) {
                logs.write(ex, "删除用户的角色");
            }
        }
    }


    //endregion

    //endregion

}
