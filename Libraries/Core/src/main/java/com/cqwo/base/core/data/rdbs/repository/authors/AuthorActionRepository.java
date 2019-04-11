
package com.cqwo.base.core.data.rdbs.repository.authors;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.authors.AuthorActionInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorActionRepository extends BaseRepository<AuthorActionInfo, Integer> {

    /**
     * 获取角色的分组信息
     *
     * @param roleId 角色id
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    @Query("SELECT action FROM AuthorActionInfo action where exists (SELECT 1 FROM AuthorPermissionInfo authorpermission where action.aid = authorpermission.aid and authorpermission.roleId = ?1)")
    List<AuthorActionInfo> getRoleAuthorActionList(Integer roleId);

    /**
     * 获取分组权限
     *
     * @param group 权限
     * @return
     */
    List<AuthorActionInfo> findAllByGroup(String group);

}