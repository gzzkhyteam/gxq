package com.hengyunsoft.platform.mt.repository.component.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterface;
import com.hengyunsoft.platform.mt.repository.component.example.AppCallInterfaceExample;

public interface AppCallInterfaceService extends BaseService<Long, AppCallInterface, AppCallInterfaceExample> {
    /***
     * 根据应用id删除
     * @param applicationId
     */
    void deleteByAppliId(Long applicationId);
}
