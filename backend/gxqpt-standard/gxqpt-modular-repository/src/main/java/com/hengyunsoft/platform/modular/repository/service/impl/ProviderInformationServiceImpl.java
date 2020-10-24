package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.po.ProviderInformation;
import com.hengyunsoft.platform.modular.repository.modular.dao.ProviderInformationMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ProviderInformationExample;
import com.hengyunsoft.platform.modular.repository.service.ProviderInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProviderInformationServiceImpl extends BaseServiceImpl<Long, ProviderInformation, ProviderInformationExample> implements ProviderInformationService {
    @Autowired
    private ProviderInformationMapper mapper;

    @Override
    protected BaseNormalDao<Long, ProviderInformation, ProviderInformationExample> getDao() {
        return mapper;
    }
}