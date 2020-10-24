package com.hengyunsoft.platform.ops.repository.fault.dao;

import com.hengyunsoft.platform.ops.entity.fault.po.LogManagement;
import com.hengyunsoft.platform.ops.faultdto.LogManagementPageDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LogManagementMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, LogManagement, com.hengyunsoft.platform.ops.repository.fault.example.LogManagementExample> {

    /**
     * 查询运维日志分页信息
     * @param map
     * @return
     */
    List<LogManagementPageDTO> findPage(Map map);


}