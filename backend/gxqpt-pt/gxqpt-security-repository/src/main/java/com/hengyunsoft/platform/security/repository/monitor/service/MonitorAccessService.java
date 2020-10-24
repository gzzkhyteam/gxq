package com.hengyunsoft.platform.security.repository.monitor.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorAccess;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorAccessExample;

import java.util.List;
import java.util.Map;

public interface MonitorAccessService extends BaseService<Long,MonitorAccess,MonitorAccessExample> {
    /**
     * 根据条件查询服务器访问记录
     * @param param contains 服务器ip、登录名、开始日期、截止日期
     * @return
     */
    List pageServerAccessList(Map param);
}
