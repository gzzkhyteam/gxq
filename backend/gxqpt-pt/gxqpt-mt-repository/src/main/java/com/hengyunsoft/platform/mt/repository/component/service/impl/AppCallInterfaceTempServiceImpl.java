package com.hengyunsoft.platform.mt.repository.component.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterfaceTemp;
import com.hengyunsoft.platform.mt.repository.component.dao.AppCallInterfaceTempMapper;
import com.hengyunsoft.platform.mt.repository.component.example.AppCallInterfaceTempExample;
import com.hengyunsoft.platform.mt.repository.component.service.AppCallInterfaceTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppCallInterfaceTempServiceImpl extends BaseServiceImpl<Long, AppCallInterfaceTemp, AppCallInterfaceTempExample> implements AppCallInterfaceTempService {
    @Autowired
    private AppCallInterfaceTempMapper appCallInterfaceMapper;

    @Override
    protected BaseNormalDao<Long, AppCallInterfaceTemp, AppCallInterfaceTempExample> getDao() {
        return appCallInterfaceMapper;
    }

    @Override
    public void deleteByAppliId(Long applicationId) {
        AppCallInterfaceTempExample example = new AppCallInterfaceTempExample();
        AppCallInterfaceTempExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationIdEqualTo(applicationId);
        appCallInterfaceMapper.deleteByExample(example);
    }
}
