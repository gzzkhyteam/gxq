package com.hengyunsoft.platform.modular.repository.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.apply.ApplicationProvider;
import com.hengyunsoft.platform.modular.repository.modular.dao.ApplicationProviderMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ApplicationProviderExample;
import com.hengyunsoft.platform.modular.repository.service.ApplicationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author luchanghong
 * @create 2019-02-15 10:35
 * @desc 应用提供商
 **/
@Service
public class ApplicationProviderServiceImpl extends BaseServiceImpl<Long, ApplicationProvider, ApplicationProviderExample> implements ApplicationProviderService {
    @Autowired
    private ApplicationProviderMapper mapper;
    @Override
    protected BaseNormalDao<Long, ApplicationProvider, ApplicationProviderExample> getDao() {
        return mapper;
    }

}