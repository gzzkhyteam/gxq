package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.PowerSupervise;
import com.hengyunsoft.platform.supervise.repository.dao.PowerSuperviseMapper;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerSuperviseServiceImpl extends BaseAllServiceImpl<Long,PowerSupervise,PowerSuperviseExample> implements PowerSuperviseService {

    @Autowired
    private PowerSuperviseMapper mapper;

    @Override
    protected BaseNormalDao<Long, PowerSupervise, PowerSuperviseExample> getDao() {
        return mapper;
    }
}
