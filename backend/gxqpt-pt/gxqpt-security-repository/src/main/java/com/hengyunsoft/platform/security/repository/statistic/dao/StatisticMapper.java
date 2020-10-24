package com.hengyunsoft.platform.security.repository.statistic.dao;

import com.hengyunsoft.platform.security.entity.statistic.po.StatisticResultDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StatisticMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.security.entity.monitor.po.MonitorServer, com.hengyunsoft.platform.security.repository.monitor.example.MonitorServerExample> {

    /**
     * 获取接口总数量和配置接口数量
     * @return
     */
     Map<String,String> statisticInterfaceConfig();

    /**
     * 获取总异常进程数量和本月异常进程数量
     * @return
     */
     Map<String,String> statisticExceptionProcess();

    /**
     * 获取总异常服务数量和本月异常服务数量
     * @return
     */
     Map<String,String> statisticExceptionServer();

    /**
     * 统计接口调用数量排行前10位
     * @return
     */
     List<Map<String,String>> statisticInterfaceExecuteTop10();

    /**
     * 统计间隔当日第几天的异常服务数量
     * @param days
     * @return
     */
     StatisticResultDTO statisticExceptionServerIntervalToToday(@Param("days") int days);

    /**
     * 统计间隔当日第几天的异常进程数量
     * @param days
     * @return
     */
    StatisticResultDTO statisticExceptionProcessIntervalToToday(@Param("days") int days);
    /**
     *  统计数据应备份数量和昨天数据应备份数量
     * @return
     */
    Map<String,String> statisticAllBackupsAndYesterday();
}