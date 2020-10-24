package com.hengyunsoft.platform.developer.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResourceDoc;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceResourceDocService;
import com.hengyunsoft.platform.developer.repository.service.dao.ServiceResourceDocMapper;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceResourceDocExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceResourceDocServiceImpl
        extends BaseServiceImpl<Long, ServiceResourceDoc, ServiceResourceDocExample>
        implements ServiceResourceDocService {

        @Autowired
        private ServiceResourceDocMapper ServiceResourceDocMapper;

        @Override
        protected BaseNormalDao<Long, ServiceResourceDoc, ServiceResourceDocExample> getDao() {
            return ServiceResourceDocMapper;
        }

        @Override
        public ServiceResourceDoc getByModuleId(Long moduleId) {
                return ServiceResourceDocMapper.getByModuleId(moduleId);
        }
}
