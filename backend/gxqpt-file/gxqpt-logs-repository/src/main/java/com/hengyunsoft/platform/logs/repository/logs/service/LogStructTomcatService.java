package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;

import java.util.List;

public interface LogStructTomcatService extends BaseAllService<Long, LogStructTomcat, LogStructTomcatExample> {
    /**
     *分页查询tomcat结构化日志
     * @param example
     * @return
     */
    List<LogStructTomcat> pageQueryTomcat(LogStructTomcatExample example);
    /**
     *分页查询告警tomcat结构化日志
     * @param id
     * @return
     */
    List<LogStructTomcat> pageQueryWarningTomcat(Long id);
    /**
     * 根据 documentId删除日志
     * @param example
     * @return
     */
    int deleteByDocumentIds (LogStructTomcatExample example,String conditions);

    /**
     * 统计前十二月数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<LogTypeDO> findMonthCount(String startTime, String endTime);

    /**
     * 前十二月响应时间
     * @param startTime
     * @param endTime
     * @return
     */
    List<LogRespondMonthDO> findLogRespondMonth(String startTime, String endTime);
}
