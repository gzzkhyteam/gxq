package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.po.ServerStatistics;
import com.hengyunsoft.platform.hardware.repository.apply.dao.ServerStatisticsMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.ServerStatisticsExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ServerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerStatisticsServiceImpl extends BaseServiceImpl<Long,ServerStatistics,ServerStatisticsExample> implements ServerStatisticsService{
    @Autowired
    private ServerStatisticsMapper mapper;
    @Override
    protected BaseNormalDao<Long, ServerStatistics, ServerStatisticsExample> getDao() {
        return mapper;
    }
}
