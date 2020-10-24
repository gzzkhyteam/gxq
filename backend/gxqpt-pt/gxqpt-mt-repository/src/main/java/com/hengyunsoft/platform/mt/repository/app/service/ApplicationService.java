package com.hengyunsoft.platform.mt.repository.app.service;


import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.app.po.Application;
import com.hengyunsoft.platform.mt.repository.app.example.ApplicationExample;

import java.util.List;
import java.util.Map;

public interface ApplicationService extends BaseService<Long, Application, ApplicationExample> {

    /***
     * 查询应用列表
     * @param param
     * @return
     */
    List<Application> findAppList(Map<String, Object> param);


     void insertApp(Application app);
}
