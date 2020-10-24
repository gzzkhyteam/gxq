package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;

import java.util.List;

public interface LogStructApacheService extends BaseAllService<Long, LogStructApache, LogStructApacheExample> {
    /**
     *分页查询Apache结构化日志
     * @param example
     * @return
     */
    List<LogStructApache> pageQueryApache(LogStructApacheExample example);
    /**
     *分页查询告警Apache结构化日志
     * @param id
     * @return
     */
    List<LogStructApache> pageQueryWarningApache(Long id);
    /**
     * 根据 documentId删除日志
     * @param example
     * @return
     */
    int deleteByDocumentIds (LogStructApacheExample example,String conditions);

    /**
     * 前十二月数量统计
     * @return
     */
    List<LogTypeDO> findMonthCount(String startTime,String endTime);

    /**
     * 日志前十二月响应时间
     * @param startTime
     * @param endTime
     * @return
     */
    List<LogRespondMonthDO> findLogRespondMonth(String startTime, String endTime);
}
