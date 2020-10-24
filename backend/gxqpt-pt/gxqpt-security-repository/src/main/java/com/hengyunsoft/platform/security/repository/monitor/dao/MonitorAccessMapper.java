package com.hengyunsoft.platform.security.repository.monitor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MonitorAccessMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.security.entity.monitor.po.MonitorAccess, com.hengyunsoft.platform.security.repository.monitor.example.MonitorAccessExample> {
   /**
    * 根据条件查询服务器访问列表
    * @param param
    * @return
    */
   List pageServerAccessList(@Param("param") Map param);
}