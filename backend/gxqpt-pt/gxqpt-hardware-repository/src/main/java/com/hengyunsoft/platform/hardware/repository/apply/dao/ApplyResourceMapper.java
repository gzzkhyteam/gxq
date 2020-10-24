package com.hengyunsoft.platform.hardware.repository.apply.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ApplyResourceMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.apply.po.ApplyResource, com.hengyunsoft.platform.hardware.repository.apply.example.ApplyResourceExample> {
    /**
     * 根据ApplyKeyId删除资源
     * @param applyKeyId
     * @return
     */
    int deleteByApplyKeyId(Long applyKeyId);
}