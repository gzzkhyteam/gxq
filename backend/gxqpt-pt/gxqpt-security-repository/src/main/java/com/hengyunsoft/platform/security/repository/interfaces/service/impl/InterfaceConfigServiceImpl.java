package com.hengyunsoft.platform.security.repository.interfaces.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.interfaces.domain.ServiceResource;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig;
import com.hengyunsoft.platform.security.repository.interfaces.dao.CopyCoreServiceResourceMapper;
import com.hengyunsoft.platform.security.repository.interfaces.dao.InterfaceConfigMapper;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceConfigExample;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceConfigService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class InterfaceConfigServiceImpl extends BaseServiceImpl<Long, InterfaceConfig, InterfaceConfigExample> implements InterfaceConfigService {

    @Autowired
    private InterfaceConfigMapper interfaceConfigMapper;
    @Autowired
    private CopyCoreServiceResourceMapper copyCoreServiceResourceMapper;

    @Override
    protected BaseNormalDao<Long, InterfaceConfig, InterfaceConfigExample> getDao() {
        return interfaceConfigMapper;
    }

    @Override
    public List pageApiList(Map param) {
        return interfaceConfigMapper.pageApiList(param);
    }

    @Override
    public int updateApiAccessLimitList(List apiIdList, InterfaceConfig interfaceConfig) {
        return interfaceConfigMapper.updateApiAccessLimitList(apiIdList, interfaceConfig);
    }

    @Override
    public List<Long> findNeedFilter() {
        return interfaceConfigMapper.findNeedFilter();
    }

    @Override
    public void batchSaveOrUpdate(List<InterfaceConfig> configList) {
        if (configList != null && !configList.isEmpty()) {
            configList.forEach((config) -> {
                try {
                    interfaceConfigMapper.saveOrUpdate(config);
                }catch (Exception e){
                    log.error("saveOrUpdate", e);
                }
            });
        }
    }

    @Override
    public List<ServiceResource> findAllServiceResource() {
        return copyCoreServiceResourceMapper.findAll();
    }

    @Override
    public List getInterfaceConfigList(Set<Long> apiIdSet) {
        return interfaceConfigMapper.getInterfaceConfigList(apiIdSet);
    }

    @Override
    public List pageInterfaceConfigList(List<Set<Long>> apiIdList) {
        return interfaceConfigMapper.pageInterfaceConfigList(apiIdList);
    }
}
