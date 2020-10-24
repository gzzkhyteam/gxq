package com.hengyunsoft.platform.ops.repository.consult.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.repository.consult.service.DealService;
import com.hengyunsoft.platform.ops.repository.person.dao.DealUserMapper;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DealServiceImpl extends BaseServiceImpl<Long,DealUser,DealUserExample> implements DealService {
    @Autowired
    private DealUserMapper dealUserMapper;
    @Override
    protected BaseNormalDao<Long, DealUser, DealUserExample> getDao() {
        return dealUserMapper;
    }
}
