package com.hengyunsoft.platform.mt.repository.app.dao;

import com.hengyunsoft.platform.mt.entity.app.po.Application;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApplicationMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.mt.entity.app.po.Application, com.hengyunsoft.platform.mt.repository.app.example.ApplicationExample> {
    /***
     * 查询
     * @param param
     * @return
     */
    List<Application> findAppList(Map<String, Object> param);
}