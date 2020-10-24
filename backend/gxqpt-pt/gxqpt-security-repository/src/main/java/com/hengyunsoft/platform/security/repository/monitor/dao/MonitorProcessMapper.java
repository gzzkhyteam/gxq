package com.hengyunsoft.platform.security.repository.monitor.dao;

import com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcess;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MonitorProcessMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.security.entity.monitor.po.MonitorProcess, com.hengyunsoft.platform.security.repository.monitor.example.MonitorProcessExample> {
    /**
     * 根据条件查询进程列表
     * @param param contains 服务器IP、进程名、处理状态
     * @return
     */
    List pageProcessList(@Param("param") Map param);

    /**
     *  处理异常进程信息
     * @param monitorProcess 进程信息（包含处理相关信息）
     * @return
     */
    int updateById(@Param("monitorProcess")MonitorProcess monitorProcess);
}