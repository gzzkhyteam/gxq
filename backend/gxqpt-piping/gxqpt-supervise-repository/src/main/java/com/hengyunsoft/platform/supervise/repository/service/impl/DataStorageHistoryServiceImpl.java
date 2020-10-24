package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.DataStorageHistory;
import com.hengyunsoft.platform.supervise.repository.dao.DataStorageHistoryMapper;
import com.hengyunsoft.platform.supervise.repository.example.DataStorageHistoryExample;
import com.hengyunsoft.platform.supervise.repository.service.DataStorageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataStorageHistoryServiceImpl extends BaseServiceImpl<Long, DataStorageHistory, DataStorageHistoryExample> implements DataStorageHistoryService {
    @Autowired
    DataStorageHistoryMapper mapper;

    @Override
    protected BaseNormalDao<Long, DataStorageHistory, DataStorageHistoryExample> getDao() {
        return mapper;
    }
}