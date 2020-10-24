package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.BizAppSupervise;
import com.hengyunsoft.platform.supervise.repository.dao.BizAppSuperviseMapper;
import com.hengyunsoft.platform.supervise.repository.example.BizAppSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.BizAppSuperviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BizAppSuperviseServiceImpl extends BaseServiceImpl<Long,BizAppSupervise,BizAppSuperviseExample> implements BizAppSuperviseService{
    @Autowired
    private BizAppSuperviseMapper mapper;

    @Override
    protected BaseNormalDao<Long, BizAppSupervise, BizAppSuperviseExample> getDao() {
        return mapper;
    }
}
