package com.hengyunsoft.platform.security.repository.monitor.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorServer;
import com.hengyunsoft.platform.security.repository.monitor.dao.MonitorServerMapper;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorServerExample;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MonitorServerServiceImpl extends BaseServiceImpl<Long,MonitorServer,MonitorServerExample> implements MonitorServerService {

    @Autowired
    private MonitorServerMapper monitorServerMapper;
    @Override
    protected BaseNormalDao<Long, MonitorServer, MonitorServerExample> getDao() {
        return monitorServerMapper;
    }

    @Override
    public List pageMonitorServer(Map param) {
        return monitorServerMapper.pageMonitorServer(param);
    }
}
