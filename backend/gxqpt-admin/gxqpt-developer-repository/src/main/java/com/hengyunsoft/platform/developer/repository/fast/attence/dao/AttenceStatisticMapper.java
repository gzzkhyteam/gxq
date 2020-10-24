package com.hengyunsoft.platform.developer.repository.fast.attence.dao;

import com.hengyunsoft.platform.developer.entity.fast.po.domain.AttenceStatisticDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttenceStatisticMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceStatistic, com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceStatisticExample> {
    /**
     * 查询考勤统计列表
     * @param attenceStatisticDO
     * @return
     */
    List<AttenceStatisticDO> queryStatistic(AttenceStatisticDO attenceStatisticDO);
}