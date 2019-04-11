
package com.cqwo.base.core.data.rdbs.repository.authors;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.authors.AuthorSessionInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @author cqnews
 */
public interface AuthorSessionRepository extends BaseRepository<AuthorSessionInfo, Integer> {


    /**
     * 获取解色Id列表
     *
     * @param uid uid
     */
    @Query(value = "select info.roleId from AuthorSessionInfo info where info.uid = ?1")
    List<Integer> getUserAuthorRoleIdList(String uid);

    /**
     * 删除用户的角色
     *
     * @param uid    uid
     * @param roleId 角色Id
     */
    @Transactional(rollbackFor = IOException.class)
    @Modifying
    @Query(value = "delete from AuthorSessionInfo info where info.uid = ?1 and info.roleId = ?2")
    void deleteUserAuthorRoleInfo(String uid, Integer roleId);

    /**
     * 删除用户的角色id
     *
     * @param uid    uid
     * @param roleId 角色Id
     */
    @Modifying
    @Transactional(rollbackFor = IOException.class)
    void deleteAllByUidAndRoleId(String uid, Integer roleId);

}