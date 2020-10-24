package com.hengyunsoft.platform.developer.repository.fast.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.ApplicationRelation;
import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import com.hengyunsoft.platform.developer.repository.fast.dao.ApplicationRelationMapper;
import com.hengyunsoft.platform.developer.repository.fast.dao.FastMenuMapper;
import com.hengyunsoft.platform.developer.repository.fast.example.ApplicationRelationExample;
import com.hengyunsoft.platform.developer.repository.fast.example.FastMenuExample;
import com.hengyunsoft.platform.developer.repository.fast.service.ApplicationRelationService;
import com.hengyunsoft.platform.developer.repository.fast.service.FastMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApplicationRelationServiceImpl extends BaseAllServiceImpl<Long, ApplicationRelation, ApplicationRelationExample>
        implements ApplicationRelationService {
    @Autowired
    private ApplicationRelationMapper applicationRelationMapper;

    @Override
    protected BaseNormalDao<Long, ApplicationRelation, ApplicationRelationExample> getDao() {
        return applicationRelationMapper;
    }
}
