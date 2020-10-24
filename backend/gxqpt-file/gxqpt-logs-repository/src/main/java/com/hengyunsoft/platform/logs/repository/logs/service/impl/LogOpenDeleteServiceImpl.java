package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogOpenDelete;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogOpenDeleteMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogOpenDeleteExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogOpenDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogOpenDeleteServiceImpl  extends BaseAllServiceImpl<Long, LogOpenDelete, LogOpenDeleteExample> implements LogOpenDeleteService {
    @Autowired
    private LogOpenDeleteMapper logOpenDeleteMapper;
    @Override
    protected BaseNormalDao<Long, LogOpenDelete, LogOpenDeleteExample> getDao()  {
        return logOpenDeleteMapper;
    }
}
