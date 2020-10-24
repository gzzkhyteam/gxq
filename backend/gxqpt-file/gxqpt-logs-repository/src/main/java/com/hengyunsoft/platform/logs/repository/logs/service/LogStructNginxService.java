package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogRespondMonthDO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogTypeDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;

import java.util.List;

public interface LogStructNginxService extends BaseAllService<Long, LogStructNginx, LogStructNginxExample> {
    /**
     *分页查询nginx结构化日志
     * @param example
     * @return
     */
    List<LogStructNginx> pageQueryNginx(LogStructNginxExample example);
    /**
     * 分页查询告警nginx的构化日志列表（nginx）
     * @param id
     * @return
     */
    List<LogStructNginx> pageQueryWarningNginx(Long id);
    /**
     * 根据 documentId删除日志
     * @param example
     * @return
     */
    int deleteByDocumentIds (LogStructNginxExample example,String conditions);

    /**
     * 统计前十二月数据
     * @param startTime
     * @param endTime
     * @return
     */
    List<LogTypeDO> findMonthCount(String startTime, String endTime);

    List<LogRespondMonthDO> findLogRespondMonth(String startTime, String endTime);
}
