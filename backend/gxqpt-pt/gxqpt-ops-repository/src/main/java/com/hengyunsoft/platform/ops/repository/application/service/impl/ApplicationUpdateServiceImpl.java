package com.hengyunsoft.platform.ops.repository.application.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.application.po.ApplicationUpdate;
import com.hengyunsoft.platform.ops.repository.application.dao.ApplicationUpdateMapper;
import com.hengyunsoft.platform.ops.repository.application.example.ApplicationUpdateExample;
import com.hengyunsoft.platform.ops.repository.application.service.ApplicationUpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ApplicationUpdateServiceImpl extends BaseServiceImpl<Long,ApplicationUpdate,ApplicationUpdateExample> implements ApplicationUpdateService {

    @Autowired
    private ApplicationUpdateMapper applicationUpdateMapper;





    @Override
    protected BaseNormalDao<Long, ApplicationUpdate, ApplicationUpdateExample> getDao() {
        return applicationUpdateMapper;
    }

    @Override
    public List<ApplicationUpdate> getPageList(Map map) {
        return applicationUpdateMapper.getPageList(map);
    }
}
