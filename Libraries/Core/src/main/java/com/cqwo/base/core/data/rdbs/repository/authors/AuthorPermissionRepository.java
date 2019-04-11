
package com.cqwo.base.core.data.rdbs.repository.authors;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.authors.AuthorPermissionInfo;

import java.util.List;

public interface AuthorPermissionRepository extends BaseRepository<AuthorPermissionInfo, Integer> {

    List<AuthorPermissionInfo> findAllByRoleId(Integer roleId);
}