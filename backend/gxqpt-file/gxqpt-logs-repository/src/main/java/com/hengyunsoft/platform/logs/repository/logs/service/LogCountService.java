package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.po.LogCount;
import com.hengyunsoft.platform.logs.repository.logs.example.LogCountExample;

import java.util.Date;
import java.util.List;

public interface LogCountService extends BaseAllService<Long, LogCount, LogCountExample> {
    /**
     * 用户登录数量统计
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getLoginQuantity(Date startDate, Date endDate, String applyId);
    /**
     * 业务分类统计
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getBusinessClassAccount(Date startDate, Date endDate, String applyId);
    /**
     * 日志级别分类统计
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getLogLevelAccount(Date startDate, Date endDate, String applyId);
    /**
     * 统计日志级别数量
     * @param startDate
     * @param endDate
     * @return
     */
    public List<LogCount> getLogLevelNum(Date startDate, Date endDate, String applyId);
    /**
     * 统计各日志类型数量占比
     * @param startDate
     * @param endDate
     * @return
     */
    public List<LogCount> getLogTypeNum(Date startDate, Date endDate, String applyId);

    /**
     * 统计各日志类型响应时间
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getResponseTime(Date startDate, Date endDate, String applyId, String logType);
    /**
     * 获取不同等级告警数量
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getWarnLevelNumber(Date startDate, Date endDate, String applyId);
    /**
     * 统计告警类型数量
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getWarnTypeNumber(Date startDate, Date endDate, String applyId, String logType);
    /**
     * 统计告警类型数量占比
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getWarnTypeAccount(Date startDate, Date endDate, String applyId);

    /**
     * 热门页面访问次数
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getPageAccess(Date startDate, Date endDate, String applyId,String logType);
    /**
     * HTTP状态数量
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getHttpStatus(Date startDate, Date endDate, String applyId,String logType);
    /**
     * 浏览器类型占比
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getBrowserType(Date startDate, Date endDate, String applyId,String logType);
    /**
     * 访问PV/UV统计
     * @param startDate
     * @param endDate
     * @return
     */
    List<LogCount> getPvToUvCount(Date startDate, Date endDate, String applyId,String logType);


}
