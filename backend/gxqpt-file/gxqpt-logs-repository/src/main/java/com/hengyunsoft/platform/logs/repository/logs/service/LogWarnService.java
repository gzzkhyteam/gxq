package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.domain.*;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarning;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarningExample;

import java.util.List;
import java.util.Map;

public interface LogWarnService extends BaseAllService<Long, LogWarning, LogWarningExample> {
    /**
     * 分页查询日志告警的记录
     * @param example
     * @return
     */
    List<LogWarningDO> pageQueryWarning(LogWarningExample example);

    /**
     * 统计当前月份告警数
     * @return
     */
    Integer currentWarnCount();

    /**
     * 统计当月已处理警告数
     * @return
     */
    Integer currentWarnDealCount();

    /**
     * 统计日志类型数量
     * @return
     */
    Map<String ,List<LogTypeDO>> findLogTypeCount();

    /**
     * 查新告警前12月数量
     * @return
     */
    List<LogTypeDO> findWarnCount();

    /**
     * 统计前20日志应用
     * @return
     */
    List<LogAppNameDO> findWarnAppName();

    /**
     * 查询告警平均处理时间
     * @return
     */
    LogWarnAvgTimeDO findWarnAvgTime();

    /**
     * 查询日志前十二月每月总数
     * @return
     */
    List<LogTypeDO> findLogAvgMonth();

    /**
     * 查询前十二月日志响应时间
     * @return
     */
    List<LogRespondMonthDO> findLogRespondMonth();

    /**
     * 查询前十二月告警数量等级统计
     * @return
     */
    List< List<LogTypeDO>> findLogWarnMonth();

    /**
     * 查询前十二月告警数量类型统计
     * @return
     */
    List<LogTypeDO> findLogWarnTypeMonth();

    /**
     * 统计告警类型数量
     * @return
     */
    List<LogTypeDO> findLogWarnLevleCount();
}
