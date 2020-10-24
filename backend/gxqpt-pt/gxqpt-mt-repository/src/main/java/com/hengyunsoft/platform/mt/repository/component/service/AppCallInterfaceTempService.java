package com.hengyunsoft.platform.mt.repository.component.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterface;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterfaceTemp;
import com.hengyunsoft.platform.mt.repository.component.example.AppCallInterfaceExample;
import com.hengyunsoft.platform.mt.repository.component.example.AppCallInterfaceTempExample;

public interface AppCallInterfaceTempService extends BaseService<Long, AppCallInterfaceTemp, AppCallInterfaceTempExample> {
    /***
     * 根据应用id删除
     * @param applicationId
     */
    void deleteByAppliId(Long applicationId);
}
