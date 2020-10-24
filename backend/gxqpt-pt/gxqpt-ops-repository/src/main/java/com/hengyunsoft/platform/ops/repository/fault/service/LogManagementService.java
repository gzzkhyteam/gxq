package com.hengyunsoft.platform.ops.repository.fault.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.fault.po.LogManagement;
import com.hengyunsoft.platform.ops.faultdto.LogManagementPageDTO;
import com.hengyunsoft.platform.ops.repository.fault.example.LogManagementExample;

import java.util.List;
import java.util.Map;

public interface LogManagementService extends BaseService<Long, LogManagement, LogManagementExample> {
    /**
     * 查询运维日志分页信息
     * @param map
     * @return
     */
    List<LogManagementPageDTO> findPage(Map map);
}