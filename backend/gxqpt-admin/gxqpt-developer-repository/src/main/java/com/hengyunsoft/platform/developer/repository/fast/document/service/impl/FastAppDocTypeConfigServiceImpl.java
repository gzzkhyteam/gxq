package com.hengyunsoft.platform.developer.repository.fast.document.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocTypeConfig;
import com.hengyunsoft.platform.developer.repository.fast.document.dao.FastAppDocTypeConfigMapper;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocTypeConfigExample;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocTypeConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastAppDocTypeConfigServiceImpl extends BaseAllServiceImpl<Long, FastAppDocTypeConfig, FastAppDocTypeConfigExample>
        implements FastAppDocTypeConfigService {
    @Autowired
    private FastAppDocTypeConfigMapper fastAppDocTypeConfigMapper;

    @Override
    protected BaseNormalDao<Long, FastAppDocTypeConfig, FastAppDocTypeConfigExample> getDao() {
        return fastAppDocTypeConfigMapper;
    }

}
