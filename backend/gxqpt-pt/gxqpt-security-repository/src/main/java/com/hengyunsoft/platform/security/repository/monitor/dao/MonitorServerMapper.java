package com.hengyunsoft.platform.security.repository.monitor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MonitorServerMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.security.entity.monitor.po.MonitorServer, com.hengyunsoft.platform.security.repository.monitor.example.MonitorServerExample> {

    /**
     * 获取服务异常记录列表
     *
     * @param param contains 服务器IP、服务名，处理状态
     * @return
     */
     List pageMonitorServer(@Param("param") Map param);

}