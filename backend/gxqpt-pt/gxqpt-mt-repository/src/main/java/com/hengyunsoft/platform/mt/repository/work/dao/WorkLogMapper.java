package com.hengyunsoft.platform.mt.repository.work.dao;

import com.hengyunsoft.platform.mt.entity.work.po.WorkLog;
import com.hengyunsoft.platform.mt.entity.work.po.domain.WorkLogCountDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WorkLogMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.work.po.WorkLog, com.hengyunsoft.platform.mt.repository.work.example.WorkLogExample> {
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

    WorkLog getByUserId(@Param("userId")Long userId,@Param("unitId") String unitId);

    /***
     * 查询本月用户写的日志数量
     * @param userId
     * @param unitId
     * @return
     */
    int getMonthCount(@Param("userId") Long userId,@Param("unitId") String unitId);

    int selectNoViewNum(@Param("userId") Long userId,@Param("unitId") String unitId);
}