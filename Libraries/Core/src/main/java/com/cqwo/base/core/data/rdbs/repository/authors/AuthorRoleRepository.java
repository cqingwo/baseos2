
package com.cqwo.base.core.data.rdbs.repository.authors;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.authors.AuthorRoleInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRoleRepository extends BaseRepository<AuthorRoleInfo, Integer> {

    /**
     * 获取用户的角色权限
     *
     * @param uid
     */
    @Query("SELECT role FROM AuthorRoleInfo role where  exists (SELECT 1 FROM AuthorSessionInfo authorsession where role.roleId = authorsession.roleId and authorsession.uid = ?1)")
    List<AuthorRoleInfo> getUserAuthorRoleList(String uid);
}