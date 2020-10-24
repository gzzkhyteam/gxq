package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.domain.*;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;

import java.util.List;

public interface LogStructAppService extends BaseAllService<Long, LogStructApp, LogStructAppExample> {
    /**
     *分页查询App结构化日志
     * @param example
     * @return
     */
    List<LogStructApp> pageQueryApp(LogStructAppExample example);

    /**
     *分页查询告警的App结构化日志
     * @param id
     * @return
     */
    List<LogStructApp> pageQueryWarningApp(Long id);

    /**
     * 根据 documentId删除日志
     * @param example
     * @return
     */
    int deleteByDocumentIds (LogStructAppExample example,String conditions);

    /**
     * 当前月份
     * @return
     */
    int currentCount();

    /**
     * 统计每月error数量
     * @return
     */
    List<LogMonthErrorDO> findErrorLogMonthCount();

    /**
     * 统计前十二月数量
     * @param startTime
     * @param endTime
     * @return
     */
    List<LogTypeDO> findMonthCount(String startTime, String endTime);

    /**
     * 日志分类数据
     * @return
     */
    List<LogSortDO> findLogSortCount();

    /**
     * 查询前12月日志级别数量
     * @return
     */
    List<List<LogLevelMonthDO>> findLogLevelMonthCount();

}
