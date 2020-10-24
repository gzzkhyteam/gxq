package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnSet;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogWarnSetMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnSetExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogWarnSetServiceImpl extends BaseAllServiceImpl<Long, LogWarnSet, LogWarnSetExample> implements LogWarnSetService {
    @Autowired
    private LogWarnSetMapper logWarnSetMapper;
    @Override
    protected BaseNormalDao<Long, LogWarnSet, LogWarnSetExample> getDao() {
        return logWarnSetMapper;
    }
}
