package com.hengyunsoft.platform.developer.repository.fast.document.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocUserConfig;
import com.hengyunsoft.platform.developer.repository.fast.document.dao.FastAppDocUserConfigMapper;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocUserConfigExample;
import com.hengyunsoft.platform.developer.repository.fast.document.service.FastAppDocUserConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastAppDocUserConfigServiceImpl extends BaseAllServiceImpl<Long, FastAppDocUserConfig, FastAppDocUserConfigExample>
        implements FastAppDocUserConfigService {
    @Autowired
    private FastAppDocUserConfigMapper fastAppDocUserConfigMapper;

    @Override
    protected BaseNormalDao<Long, FastAppDocUserConfig, FastAppDocUserConfigExample> getDao() {
        return fastAppDocUserConfigMapper;
    }

    @Override
    public FastAppDocUserConfig getByUserId(Long userId) {
        return fastAppDocUserConfigMapper.getByUserId(userId);
    }
}
