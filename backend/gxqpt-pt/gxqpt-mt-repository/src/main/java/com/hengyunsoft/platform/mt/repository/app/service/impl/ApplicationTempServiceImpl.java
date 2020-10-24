package com.hengyunsoft.platform.mt.repository.app.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.app.po.Application;
import com.hengyunsoft.platform.mt.entity.app.po.ApplicationTemp;
import com.hengyunsoft.platform.mt.repository.app.dao.ApplicationTempMapper;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationTempExample;
import com.hengyunsoft.platform.mt.repository.app.service.ApplicationTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApplicationTempServiceImpl extends BaseServiceImpl<Long, ApplicationTemp, ApplicationTempExample> implements ApplicationTempService {

    @Autowired
    private ApplicationTempMapper applicationMapper;

    @Override
    protected BaseNormalDao<Long, ApplicationTemp, ApplicationTempExample> getDao() {
        return applicationMapper;
    }


    @Override
    public List<ApplicationTemp> findAppList(Map<String, Object> param) {
        return applicationMapper.findAppList(param);
    }
}

