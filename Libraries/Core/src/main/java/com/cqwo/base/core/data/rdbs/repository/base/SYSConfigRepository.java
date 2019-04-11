
package com.cqwo.base.core.data.rdbs.repository.base;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.base.SYSConfigInfo;

public interface SYSConfigRepository extends BaseRepository<SYSConfigInfo, Integer> {

    /**
     * 找用户名
     * @param name
     * @return
     */
    SYSConfigInfo findByVarName(String name);



}