package com.hengyunsoft.platform.security.repository.monitor.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcess;
import com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessExample;

import java.util.List;
import java.util.Map;

public interface MonitorProcessService extends BaseService<Long,MonitorProcess,MonitorProcessExample> {
    /**
     * 根据条件查询进程列表
     * @param param contains 服务器IP、进程名、处理状态
     * @return
     */
    List pageProcessList(Map param);

}
