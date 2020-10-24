package com.hengyunsoft.platform.developer.repository.fast.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.FastBizConfig;
import com.hengyunsoft.platform.developer.repository.fast.dao.FastBizConfigMapper;
import com.hengyunsoft.platform.developer.repository.fast.example.FastBizConfigExample;
import com.hengyunsoft.platform.developer.repository.fast.service.FastBizConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FastBizConfigServiceImpl extends BaseServiceImpl<Long, FastBizConfig, FastBizConfigExample>
        implements FastBizConfigService {
    @Autowired
    private FastBizConfigMapper fastBizConfigMapper;

    @Override
    protected BaseNormalDao<Long, FastBizConfig, FastBizConfigExample> getDao() {
        return fastBizConfigMapper;
    }


    @Override
    public List<FastBizConfig> getBizConfig(Long parentId) {
        return fastBizConfigMapper.getBizConfig(parentId);
    }
}
