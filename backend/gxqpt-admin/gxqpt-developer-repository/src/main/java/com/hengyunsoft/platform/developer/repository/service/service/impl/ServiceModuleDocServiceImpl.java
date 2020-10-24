package com.hengyunsoft.platform.developer.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModuleDoc;
import com.hengyunsoft.platform.developer.repository.service.dao.ServiceModuleDocMapper;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleDocExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceModuleDocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:帮助文档Service实现
 * @author chb
 * @date 2018/4/2 14:42 
 */
@Service
@Slf4j
public class ServiceModuleDocServiceImpl extends BaseAllServiceImpl<Long, ServiceModuleDoc, ServiceModuleDocExample> implements ServiceModuleDocService {
    @Autowired
    private ServiceModuleDocMapper serviceModuleDocMapper;
    @Override
    protected BaseNormalDao<Long, ServiceModuleDoc, ServiceModuleDocExample> getDao() {
        return serviceModuleDocMapper;
    }

    @Override
    public List<ServiceModuleDoc> getByModuleId(Long moduleId) {
        return serviceModuleDocMapper.getByModuleId(moduleId);
    }
}
