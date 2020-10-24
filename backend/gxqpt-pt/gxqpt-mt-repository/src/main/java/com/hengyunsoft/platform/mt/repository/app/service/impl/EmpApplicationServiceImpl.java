package com.hengyunsoft.platform.mt.repository.app.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.app.po.EmpApplication;
import com.hengyunsoft.platform.mt.repository.app.dao.EmpApplicationMapper;
import com.hengyunsoft.platform.mt.repository.app.example.EmpApplicationExample;
import com.hengyunsoft.platform.mt.repository.app.service.EmpApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpApplicationServiceImpl extends BaseServiceImpl<Long, EmpApplication, EmpApplicationExample> implements EmpApplicationService {
    @Autowired
    private EmpApplicationMapper empApplicationMapper;

    @Override
    protected BaseNormalDao<Long, EmpApplication, EmpApplicationExample> getDao() {
        return empApplicationMapper;
    }
}
