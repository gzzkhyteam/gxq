package com.hengyunsoft.platform.developer.repository.fast.attence.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceStatistic;
import com.hengyunsoft.platform.developer.entity.fast.po.domain.AttenceStatisticDO;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceStatisticExample;

import java.util.List;

public interface AttenceStatisticService extends BaseAllService<Long, AttenceStatistic, AttenceStatisticExample> {
    /**
     * 查询考勤统计列表
     * @param attenceStatisticDO
     * @return
     */
    List<AttenceStatisticDO> queryStatistic(AttenceStatisticDO attenceStatisticDO);
}
