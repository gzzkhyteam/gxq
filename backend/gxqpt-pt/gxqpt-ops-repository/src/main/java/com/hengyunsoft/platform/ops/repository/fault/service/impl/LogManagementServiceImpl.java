package com.hengyunsoft.platform.ops.repository.fault.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.fault.po.LogManagement;
import com.hengyunsoft.platform.ops.faultdto.LogManagementPageDTO;
import com.hengyunsoft.platform.ops.repository.fault.dao.LogManagementMapper;
import com.hengyunsoft.platform.ops.repository.fault.example.LogManagementExample;
import com.hengyunsoft.platform.ops.repository.fault.service.LogManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LogManagementServiceImpl extends BaseServiceImpl<Long, LogManagement, LogManagementExample> implements LogManagementService {
    @Autowired
    private LogManagementMapper mapper;

    @Override
    protected BaseNormalDao<Long, LogManagement, LogManagementExample> getDao() {
        return mapper;
    }

    @Override
    public List<LogManagementPageDTO> findPage(Map map) {
        return mapper.findPage(map);
    }
}