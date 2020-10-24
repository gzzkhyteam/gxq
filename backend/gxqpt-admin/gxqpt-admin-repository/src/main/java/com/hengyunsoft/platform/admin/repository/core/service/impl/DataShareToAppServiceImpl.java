package com.hengyunsoft.platform.admin.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.core.po.DataShareToApp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptShareAndAppInServiceDO;
import com.hengyunsoft.platform.admin.repository.core.dao.DataShareToAppMapper;
import com.hengyunsoft.platform.admin.repository.core.example.DataShareToAppExample;
import com.hengyunsoft.platform.admin.repository.core.service.DataShareToAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataShareToAppServiceImpl extends BaseServiceImpl<Long,DataShareToApp,DataShareToAppExample> implements DataShareToAppService{
    @Autowired
    private DataShareToAppMapper mapper;

    @Override
    protected BaseNormalDao<Long, DataShareToApp, DataShareToAppExample> getDao() {
        return mapper;
    }

    @Override
    public List<GxqptShareAndAppInServiceDO> selectAppByShare(String bizId) {
        return mapper.selectAppByShare(bizId);
    }

    @Override
    public int deleteShare(List<String> deleteIds, String id) {
        return mapper.deleteShare(deleteIds,id);
    }
}
