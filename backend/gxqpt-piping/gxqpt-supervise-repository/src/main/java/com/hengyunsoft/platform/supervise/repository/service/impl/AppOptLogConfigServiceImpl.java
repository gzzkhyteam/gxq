package com.hengyunsoft.platform.supervise.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.AppOptLogConfig;
import com.hengyunsoft.platform.supervise.repository.dao.AppOptLogConfigMapper;
import com.hengyunsoft.platform.supervise.repository.example.AppOptLogConfigExample;
import com.hengyunsoft.platform.supervise.repository.service.AppOptLogConfigService;
import org.springframework.stereotype.Service;

@Service
public class AppOptLogConfigServiceImpl extends BaseServiceImpl<Long,AppOptLogConfig,AppOptLogConfigExample> implements AppOptLogConfigService{
    @Autowired
    private AppOptLogConfigMapper mapper;

    @Override
    protected BaseNormalDao<Long, AppOptLogConfig, AppOptLogConfigExample> getDao() {
        return mapper;
    }
}