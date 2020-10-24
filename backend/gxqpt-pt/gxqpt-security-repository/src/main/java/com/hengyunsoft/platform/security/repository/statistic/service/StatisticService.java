package com.hengyunsoft.platform.security.repository.statistic.service;

import com.hengyunsoft.platform.security.entity.statistic.po.StatisticResultDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticService {
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
     * 统计最近7天内每天异常服务数量
     * @return
     */
    List<StatisticResultDTO> statisticExceptionServerIn7days();

    /**
     * 统计最近7天内每天异常进程数量
     * @return
     */
    List<StatisticResultDTO> statisticExceptionProcessIn7days();
    /**
     *  统计数据应备份数量和昨天数据应备份数量
     * @return
     */
    Map<String,String> statisticAllBackupsAndYesterday();
}
