package com.hengyunsoft.platform.security.repository.monitor.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcess;
import com.hengyunsoft.platform.security.repository.monitor.dao.MonitorProcessMapper;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessExample;
import com.hengyunsoft.platform.security.repository.monitor.service.MonitorProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MonitorProcessServiceImpl extends BaseServiceImpl<Long,MonitorProcess,MonitorProcessExample> implements MonitorProcessService{

    @Autowired
    private MonitorProcessMapper monitorProcessMapper;
    @Override
    protected BaseNormalDao<Long, MonitorProcess, MonitorProcessExample> getDao() {
        return monitorProcessMapper;
    }

    @Override
    public List pageProcessList(Map param) {
        return monitorProcessMapper.pageProcessList(param);
    }
}
