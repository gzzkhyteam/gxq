package com.hengyunsoft.platform.mt.repository.app.dao;

import com.hengyunsoft.platform.mt.entity.app.po.ApplicationTemp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApplicationTempMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, ApplicationTemp, com.hengyunsoft.platform.mt.repository.app.example.ApplicationTempExample> {

    List<ApplicationTemp> findAppList(Map<String, Object> param);
}