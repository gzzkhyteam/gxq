package com.hengyunsoft.platform.security.repository.monitor.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcessWhitelist;
import com.hengyunsoft.platform.security.repository.monitor.dao.MonitorProcessWhitelistMapper;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessWhitelistExample;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorProcessWhitelistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MonitorProcessWhitelistServiceImpl extends BaseServiceImpl<Long,MonitorProcessWhitelist,MonitorProcessWhitelistExample> implements MonitorProcessWhitelistService{

    @Autowired
    private MonitorProcessWhitelistMapper monitorProcessWhitelistMapper;
    @Override
    protected BaseNormalDao<Long, MonitorProcessWhitelist, MonitorProcessWhitelistExample> getDao() {
        return monitorProcessWhitelistMapper;
    }

    @Override
    public List pageProcessWhitelist(Map param) {
        return monitorProcessWhitelistMapper.pageProcessWhitelist(param);
    }
}
