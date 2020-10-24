package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyResource;
import com.hengyunsoft.platform.hardware.repository.apply.dao.ApplyResourceMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyResourceExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ApplyResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyResourceServiceImpl extends BaseServiceImpl<Long, ApplyResource, ApplyResourceExample> implements ApplyResourceService {

    @Autowired
    ApplyResourceMapper applyRecordMapper;

    @Override
    protected BaseNormalDao<Long, ApplyResource, ApplyResourceExample> getDao() {
        return applyRecordMapper;
    }

    /**
     * 根据ApplyKeyId删除资源
     * @param ApplyKeyId
     * @return
     */
    @Override
    public int deleteByApplyKeyId(Long ApplyKeyId) {
        return applyRecordMapper.deleteByApplyKeyId(ApplyKeyId);
    }
}