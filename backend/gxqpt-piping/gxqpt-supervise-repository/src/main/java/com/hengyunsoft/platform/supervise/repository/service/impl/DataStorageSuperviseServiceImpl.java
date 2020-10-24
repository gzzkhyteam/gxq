package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.DataStorageSupervise;
import com.hengyunsoft.platform.supervise.repository.dao.DataStorageSuperviseMapper;
import com.hengyunsoft.platform.supervise.repository.example.DataStorageSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.DataStorageSuperviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataStorageSuperviseServiceImpl extends
        BaseServiceImpl<Long, DataStorageSupervise, DataStorageSuperviseExample>
        implements DataStorageSuperviseService {
    @Autowired
    DataStorageSuperviseMapper mapper;

    @Override
    protected BaseNormalDao<Long, DataStorageSupervise, DataStorageSuperviseExample> getDao() {
        return mapper;
    }
}
