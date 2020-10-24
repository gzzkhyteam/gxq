package com.hengyunsoft.platform.ops.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceDirectory;
import com.hengyunsoft.platform.ops.repository.service.dao.ServiceDirectoryMapper;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceDirectoryExample;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceDirectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceDirectoryServiceImpl extends BaseServiceImpl<Long, ServiceDirectory, ServiceDirectoryExample> implements ServiceDirectoryService {

    @Autowired
    private ServiceDirectoryMapper serviceDirectoryMapper;

    @Override
    protected BaseNormalDao<Long, ServiceDirectory, ServiceDirectoryExample> getDao() {
        return serviceDirectoryMapper;
    }

    @Override
    public List<ServiceDirectory> selectParentsById(Long id) {
        return serviceDirectoryMapper.selectParentsById(id);
    }

    @Override
    public List<ServiceDirectory> getPageList(String serviceName) {
        return serviceDirectoryMapper.getPageList(serviceName);
    }

}