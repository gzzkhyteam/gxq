package com.hengyunsoft.platform.supervise.repository.dao;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.supervise.entity.po.AppOptLogConfig;
import com.hengyunsoft.platform.supervise.repository.example.AppOptLogConfigExample;
@Repository
public interface AppOptLogConfigMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, AppOptLogConfig, AppOptLogConfigExample> {
}
