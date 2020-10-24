package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogDeleteApp;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogDeleteAppMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogDeleteAppExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogDeleteAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogDeleteAppServiceImpl extends BaseAllServiceImpl<Long, LogDeleteApp, LogDeleteAppExample> implements LogDeleteAppService {
    @Autowired
    private LogDeleteAppMapper logDeleteAppMapper;
    @Override
    protected BaseNormalDao<Long, LogDeleteApp, LogDeleteAppExample> getDao()  {
        return logDeleteAppMapper;
    }

}
