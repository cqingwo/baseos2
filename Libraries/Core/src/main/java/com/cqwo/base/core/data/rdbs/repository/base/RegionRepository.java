package com.cqwo.base.core.data.rdbs.repository.base;

import com.cqwo.base.core.data.rdbs.repository.BaseRepository;
import com.cqwo.base.core.domain.base.RegionInfo;

public interface RegionRepository extends BaseRepository<RegionInfo, Integer> {

    Integer countByRegionId(Integer regionId);

}
