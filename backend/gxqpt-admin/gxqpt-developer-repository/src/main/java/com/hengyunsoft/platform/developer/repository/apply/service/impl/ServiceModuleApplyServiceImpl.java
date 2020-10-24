package com.hengyunsoft.platform.developer.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.apply.po.ServiceModuleApply;
import com.hengyunsoft.platform.developer.repository.apply.dao.ServiceModuleApplyMapper;
import com.hengyunsoft.platform.developer.repository.apply.example.ServiceModuleApplyExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceModuleApplyServiceImpl
        extends BaseServiceImpl<Long, ServiceModuleApply, ServiceModuleApplyExample>
        implements ServiceModuleApplyService {

        @Autowired
        private ServiceModuleApplyMapper serviceModuleApplyMapper;

        @Override
        protected BaseNormalDao<Long, ServiceModuleApply, ServiceModuleApplyExample> getDao() {
            return serviceModuleApplyMapper;
        }
}
