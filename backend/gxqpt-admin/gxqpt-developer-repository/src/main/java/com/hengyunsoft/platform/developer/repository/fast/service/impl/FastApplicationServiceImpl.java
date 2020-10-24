package com.hengyunsoft.platform.developer.repository.fast.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.FastApplication;
import com.hengyunsoft.platform.developer.repository.fast.dao.FastApplicationMapper;
import com.hengyunsoft.platform.developer.repository.fast.example.FastApplicationExample;
import com.hengyunsoft.platform.developer.repository.fast.service.FastApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastApplicationServiceImpl
        extends BaseAllServiceImpl<Long, FastApplication, FastApplicationExample>
        implements FastApplicationService {
    @Autowired
    private FastApplicationMapper fastApplicationMapper;

    @Override
    protected BaseNormalDao<Long, FastApplication, FastApplicationExample> getDao() {
        return fastApplicationMapper;
    }


}
