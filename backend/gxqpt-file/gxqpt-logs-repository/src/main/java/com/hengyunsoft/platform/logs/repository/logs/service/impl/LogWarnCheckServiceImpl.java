package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnCheck;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogWarnCheckMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnCheckExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogWarnCheckServiceImpl extends BaseAllServiceImpl<Long, LogWarnCheck, LogWarnCheckExample> implements LogWarnCheckService {
    @Autowired
    private LogWarnCheckMapper logWarnCheckMapper;

    @Override
    protected BaseNormalDao<Long, LogWarnCheck, LogWarnCheckExample> getDao() {
        return logWarnCheckMapper;
    }
}
