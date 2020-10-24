package com.hengyunsoft.platform.security.repository.monitor.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcessWhitelist;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessWhitelistExample;

import java.util.List;
import java.util.Map;

public interface MonitorProcessWhitelistService extends BaseService<Long,MonitorProcessWhitelist,MonitorProcessWhitelistExample> {
    /**
     * 分页查询白名单
     * @param param
     * @return
     */
    List pageProcessWhitelist(Map param);
}
