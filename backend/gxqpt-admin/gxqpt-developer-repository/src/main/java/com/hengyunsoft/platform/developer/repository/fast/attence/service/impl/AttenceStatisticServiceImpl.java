package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceStatistic;
import com.hengyunsoft.platform.developer.entity.fast.po.domain.AttenceStatisticDO;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceStatisticMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceStatisticExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceStatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AttenceStatisticServiceImpl extends BaseAllServiceImpl<Long, AttenceStatistic, AttenceStatisticExample>
        implements AttenceStatisticService {
    @Autowired
    private AttenceStatisticMapper attenceStatisticMapper;

    @Override
    protected BaseNormalDao<Long, AttenceStatistic, AttenceStatisticExample> getDao() {
        return attenceStatisticMapper;
    }

    @Override
    public List<AttenceStatisticDO> queryStatistic(AttenceStatisticDO attenceStatisticDO) {
        return attenceStatisticMapper.queryStatistic(attenceStatisticDO);
    }
}
