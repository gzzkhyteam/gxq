package com.hengyunsoft.platform.developer.repository.fast.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.FastAppRelation;
import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import com.hengyunsoft.platform.developer.repository.fast.dao.FastAppRelationMapper;
import com.hengyunsoft.platform.developer.repository.fast.dao.FastMenuMapper;
import com.hengyunsoft.platform.developer.repository.fast.example.FastAppRelationExample;
import com.hengyunsoft.platform.developer.repository.fast.example.FastMenuExample;
import com.hengyunsoft.platform.developer.repository.fast.service.FastAppRelationService;
import com.hengyunsoft.platform.developer.repository.fast.service.FastMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FastAppRelationServiceImpl extends BaseAllServiceImpl<Long, FastAppRelation, FastAppRelationExample>
        implements FastAppRelationService {
    @Autowired
    private FastAppRelationMapper fastAppRelationMapper;

    @Override
    protected BaseNormalDao<Long, FastAppRelation, FastAppRelationExample> getDao() {
        return fastAppRelationMapper;
    }
}
