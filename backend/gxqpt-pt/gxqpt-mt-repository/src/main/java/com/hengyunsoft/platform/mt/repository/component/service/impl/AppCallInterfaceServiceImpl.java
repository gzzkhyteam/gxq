package com.hengyunsoft.platform.mt.repository.component.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterface;
import com.hengyunsoft.platform.mt.repository.component.dao.AppCallInterfaceMapper;
import com.hengyunsoft.platform.mt.repository.component.example.AppCallInterfaceExample;
import com.hengyunsoft.platform.mt.repository.component.service.AppCallInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppCallInterfaceServiceImpl extends BaseServiceImpl<Long, AppCallInterface, AppCallInterfaceExample> implements AppCallInterfaceService {
    @Autowired
    private AppCallInterfaceMapper appCallInterfaceMapper;

    @Override
    protected BaseNormalDao<Long, AppCallInterface, AppCallInterfaceExample> getDao() {
        return appCallInterfaceMapper;
    }

    @Override
    public void deleteByAppliId(Long applicationId) {
        AppCallInterfaceExample example = new AppCallInterfaceExample();
        AppCallInterfaceExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationIdEqualTo(applicationId);
        appCallInterfaceMapper.deleteByExample(example);
    }
}
