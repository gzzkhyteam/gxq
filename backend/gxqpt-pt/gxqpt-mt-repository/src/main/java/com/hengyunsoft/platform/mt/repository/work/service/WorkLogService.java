package com.hengyunsoft.platform.mt.repository.work.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLog;
import com.hengyunsoft.platform.mt.entity.work.po.domain.WorkLogCountDO;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogExample;

import java.util.List;
import java.util.Map;

public interface WorkLogService extends BaseService<Long,WorkLog,WorkLogExample> {
    /**
     * 查询日志列表信息
     * @param
     */
    List<WorkLog> getPageList(Map map);


    /**
     * 查询本周日志统计记录
     * @param
     */
    WorkLogCountDO getCountList(Map map);

    WorkLog getByUserId(Long userId,String unitId);
    /***
     * 查询用户当前月日志数量
     * @param userId
     * @return
     */
    int getMonthCount(Long userId, String unitId) ;

}
