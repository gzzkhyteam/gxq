package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogStructApacheMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache, com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample> {
    List<LogStructApache> pageQueryApache(LogStructApacheExample example);

    List<LogStructApache> pageQueryWarningApache(Long id);

    List<LogStructApache> queryApacheWarn(Long pageSize);

    int deleteByDocumentIds(LogStructApacheExample example);

    List<LogTypeDO> findMonthCount(@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<LogRespondMonthDO> findLogRespondMonth(@Param("startTime")String startTime,@Param("endTime")String endTime);
}