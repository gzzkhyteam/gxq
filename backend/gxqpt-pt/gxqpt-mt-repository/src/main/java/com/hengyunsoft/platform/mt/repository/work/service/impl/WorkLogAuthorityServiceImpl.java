package com.hengyunsoft.platform.mt.repository.work.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogAuthority;
import com.hengyunsoft.platform.mt.repository.work.dao.WorkLogAuthorityMapper;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogAuthorityExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkLogAuthorityServiceImpl extends BaseServiceImpl<Long,WorkLogAuthority,WorkLogAuthorityExample> implements WorkLogAuthorityService{
    @Autowired
    private WorkLogAuthorityMapper workLogAuthorityMapper;
    @Override
    protected BaseNormalDao<Long, WorkLogAuthority, WorkLogAuthorityExample> getDao() {
        return workLogAuthorityMapper;
    }
}
