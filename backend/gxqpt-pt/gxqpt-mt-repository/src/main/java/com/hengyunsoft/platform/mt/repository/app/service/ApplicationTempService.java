package com.hengyunsoft.platform.mt.repository.app.service;


import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.app.po.Application;
import com.hengyunsoft.platform.mt.entity.app.po.ApplicationTemp;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationTempExample;

import java.util.List;
import java.util.Map;

public interface ApplicationTempService extends BaseService<Long, ApplicationTemp, ApplicationTempExample> {
    /***
     * 查询应用列表
     * @param param
     * @return
     */
    List<ApplicationTemp> findAppList(Map<String, Object> param);
}
