package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogAppNameDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogWarnAvgTimeDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogWarningDO;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarningExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogWarningMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogWarning, com.hengyunsoft.platform.logs.repository.logs.example.LogWarningExample> {
    List<LogWarningDO> pageQueryWarning(LogWarningExample example);

    Integer currentWarnCount();

    Integer currentWarnDealCount();

    List<LogTypeDO> findWarnLogTypeCount(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<LogTypeDO> findWarnCount(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<LogAppNameDO> logWarningMapper();

    LogWarnAvgTimeDO findWarnAvgTime();

    List<LogTypeDO> findLogWarnMonth(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<LogTypeDO> findLogWarnTypeMonth();

    List<LogTypeDO> findLogWarnLevleCount();
}