package com.hengyunsoft.platform.security.repository.monitor.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorServer;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorServerExample;

import java.util.List;
import java.util.Map;

public interface MonitorServerService extends BaseService<Long,MonitorServer,MonitorServerExample>{
    /**
     * 获取服务异常记录列表
     * @param param contains 服务器IP、服务名，处理状态
     * @return
     */
    List pageMonitorServer(Map param);
}
