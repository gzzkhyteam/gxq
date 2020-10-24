package com.hengyunsoft.platform.security.repository.monitor.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorAccess;
import com.hengyunsoft.platform.security.repository.monitor.dao.MonitorAccessMapper;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorAccessExample;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorAccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MonitorAccessServiceImpl extends BaseServiceImpl<Long,MonitorAccess,MonitorAccessExample> implements MonitorAccessService {

    @Autowired
    private MonitorAccessMapper monitorAccessMapper;

    @Override
    protected BaseNormalDao<Long, MonitorAccess, MonitorAccessExample> getDao() {
        return monitorAccessMapper;
    }

    @Override
    public List pageServerAccessList(Map param) {
        return monitorAccessMapper.pageServerAccessList(param);
    }
}
