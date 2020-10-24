package com.hengyunsoft.platform.mt.repository.work.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogLook;
import com.hengyunsoft.platform.mt.repository.work.dao.WorkLogLookMapper;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogLookExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogLookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkLogLookServiceImpl extends BaseServiceImpl<Long,WorkLogLook,WorkLogLookExample> implements WorkLogLookService{
    @Autowired
    private WorkLogLookMapper workLogLookMapper;
    @Override
    protected BaseNormalDao<Long, WorkLogLook, WorkLogLookExample> getDao() {
        return workLogLookMapper;
    }
}
