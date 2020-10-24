package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface LogStructNginxMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx, com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample> {
    List<LogStructNginx> selectByExample(LogStructNginxExample example);

    List<LogStructNginx> pageQueryWarningNginx(Long id);

    List<LogStructNginx> queryNginxWarn(Long pageSize);

    int deleteByDocumentIds(LogStructNginxExample example);

    List<LogTypeDO> findMonthCount(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<LogRespondMonthDO> findLogRespondMonth(@Param("startTime") String startTime, @Param("endTime") String endTime);
}