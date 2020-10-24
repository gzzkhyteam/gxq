package com.hengyunsoft.platform.hardware.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyResource;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyResourceExample;

public interface ApplyResourceService extends BaseService<Long, ApplyResource, ApplyResourceExample> {

    /**
     * 根据ApplyKeyId删除资源
     * @param ApplyKeyId
     * @return
     */
    int deleteByApplyKeyId(Long ApplyKeyId);
}
