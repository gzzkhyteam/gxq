package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogStructTomcatMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat, com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample> {
    List<LogStructTomcat> selectByExample(LogStructTomcatExample example);

    List<LogStructTomcat> pageQueryWarningTomcat(Long id);

    List<LogStructTomcat> queryTomcatWarn(Long pageSize);

    int deleteByDocumentIds(LogStructTomcatExample example);

    List<LogTypeDO> findMonthCount(@Param("startTime") String startTime,@Param("endTime") String endTime);

    List<LogRespondMonthDO> findLogRespondMonth(@Param("startTime") String startTime, @Param("endTime") String endTime);
}