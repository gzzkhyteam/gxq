package com.hengyunsoft.platform.mt.repository.app.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.app.po.Application;
import com.hengyunsoft.platform.mt.repository.app.dao.ApplicationMapper;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationExample;
import com.hengyunsoft.platform.mt.repository.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Long, Application, ApplicationExample> implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    protected BaseNormalDao<Long, Application, ApplicationExample> getDao() {
        return applicationMapper;
    }

    @Override
    public List<Application> findAppList(Map<String, Object> param) {
        return applicationMapper.findAppList(param);
    }

    @Override
    public void insertApp(Application app) {
        applicationMapper.insertSelective(app);
    }
}

