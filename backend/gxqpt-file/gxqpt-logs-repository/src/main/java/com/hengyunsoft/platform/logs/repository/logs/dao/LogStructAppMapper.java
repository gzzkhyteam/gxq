package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogLevelMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogMonthErrorDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogSortDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogStructAppMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp, com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample> {
    List<LogStructApp> pageQueryApp(LogStructAppExample example);

    List<LogStructApp> pageQueryWarningApp(Long id);

    List<LogStructApp> selectByExample(LogStructAppExample example);

    List<LogStructApp> queryAppWarn(Long pageSize);

    int deleteByDocumentIds(LogStructAppExample example);

    int currentCount();

    List<LogMonthErrorDO> findErrorLogMonthCount(@Param("startTime") String startTime,@Param("endTime")String endTime);

    List<LogTypeDO> findMonthCount(@Param("startTime") String startTime,@Param("endTime")String endTime);

    List<LogSortDO> findLogSortCount();

    List<LogLevelMonthDO> findLogLevelMonthCount(@Param("startTime") String startTime,@Param("endTime")String endTime);
}