package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.po.LogCount;
import com.hengyunsoft.platform.logs.repository.logs.example.LogCountExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LogCountMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, LogCount, LogCountExample> {
    List<LogCount> getLoginQuantity(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getBusinessClassAccount(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getLogLevelAccount(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getTypeNum(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getLevelNum(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getResponseTime(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId, @Param("logType")String logType);
    List<LogCount> getWarnLevelNumber(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getWarnTypeNumber(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId, @Param("logType")String logType);
    List<LogCount> getWarnTypeAccount(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId);
    List<LogCount> getPageAccess(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId, @Param("logType")String logType);
    List<LogCount> getHttpStatus(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId, @Param("logType")String logType);
    List<LogCount> getBrowserType(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId, @Param("logType")String logType);
    List<LogCount> getPvToUvCount(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("applyId")String applyId, @Param("logType")String logType);


}