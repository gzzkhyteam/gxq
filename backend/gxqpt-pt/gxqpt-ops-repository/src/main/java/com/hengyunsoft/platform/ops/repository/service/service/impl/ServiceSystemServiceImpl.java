package com.hengyunsoft.platform.ops.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceSystem;
import com.hengyunsoft.platform.ops.repository.service.dao.ServiceSystemMapper;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceSystemExample;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceSystemServiceImpl extends BaseServiceImpl<Long,ServiceSystem,ServiceSystemExample> implements ServiceSystemService{
    @Autowired
    private ServiceSystemMapper serviceSystemMapper;

    @Override
    protected BaseNormalDao<Long, ServiceSystem, ServiceSystemExample> getDao() {
        return serviceSystemMapper;
    }
}
