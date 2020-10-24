package com.hengyunsoft.platform.security.repository.monitor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MonitorProcessWhitelistMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcessWhitelist, com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessWhitelistExample> {
    List pageProcessWhitelist(@Param("param") Map param);
}