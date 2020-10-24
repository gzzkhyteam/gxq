package com.hengyunsoft.platform.ops.repository.person.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.ops.entity.fault.domain.FaultMonitoringDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.ScoreCountDO;
import com.hengyunsoft.platform.ops.entity.person.po.ChargeSystem;

@Repository
public interface ChargeSystemMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.person.po.ChargeSystem, com.hengyunsoft.platform.ops.repository.person.example.ChargeSystemExample> {
    /**
     * 根据用户id、查询当天已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHour(Long userId);



    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemId(Long userId);
    /**
     * 根据用户id、查询当天的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCount(Long userId);
    /**
     * 根据用户id、查询当天的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCount(Long userId);
    /**
     * 根据用户id查询、当天的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScore(Long userId);
    /**
     * 根据用户id查询、当天的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScore(Long userId);

    /**
     * 根据用户id查询、当天的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScore(Long userId);

    /*查询本周start-------------------------------------------------------------------------*/
    /**
     * 根据用户id、查询-本周已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourWeek(Long userId);
    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdWeek(Long userId);
    /**
     * 根据用户id、查询-本周的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountWeek(Long userId);

    /**
     * 根据用户id、查询-本周的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountWeek(Long userId);



    /**
     * 根据用户id查询-本周的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreWeek(Long userId);


    /**
     * 根据用户id查询-本周的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreWeek(Long userId);

    /**
     * 根据用户id查询-本周的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreWeek(Long userId);
    /*查询本周end-------------------------------------------------------------------------*/


    /*查询本月start-------------------------------------------------------------------------*/
    /**
     * 根据用户id、查询-本月已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourMonth(Long userId);

    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdMonth(Long userId);

    /**
     * 根据用户id、查询-本月的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountMonth(Long userId);

    /**
     * 根据用户id、查询-本月的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountMonth(Long userId);



    /**
     * 根据用户id查询-本月的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreMonth(Long userId);


    /**
     * 根据用户id查询-本月的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreMonth(Long userId);

    /**
     * 根据用户id查询-本月的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreMonth(Long userId);
    /*查询本月end-------------------------------------------------------------------------*/



    /*查询本年start-------------------------------------------------------------------------*/
    /**
     * 根据用户id、查询-本年已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourYear(Long userId);

    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdYear(Long userId);

    /**
     * 根据用户id、查询-本年的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountYear(Long userId);

    /**
     * 根据用户id、查询-本年的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountYear(Long userId);



    /**
     * 根据用户id查询-本年的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreYear(Long userId);


    /**
     * 根据用户id查询-本年的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreYear(Long userId);

    /**
     * 根据用户id查询-本年的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreYear(Long userId);
    /*查询本年end-------------------------------------------------------------------------*/

    /**
     * 根据用户id、查询昨天已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourLast(Long userId);

    /**
     * 根据用户id、查询昨天产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdLast(Long userId);

    /**
     * 根据用户id、查询昨天的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountLast(Long userId);

    /**
     * 根据用户id、查询昨天的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountLast(Long userId);



    /**
     * 根据用户id查询、昨天的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreLast(Long userId);


    /**
     * 根据用户id查询、昨天的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreLast(Long userId);

    /**
     * 根据用户id查询、昨天的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreLast(Long userId);


    /*查询本周start-------------------------------------------------------------------------*/
    /**
     * 根据用户id、查询-上周已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourWeekLast(Long userId);

    /**
     * 根据用户id、查询上周产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdWeekLast(Long userId);
    /**
     * 根据用户id、查询-上周的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountWeekLast(Long userId);

    /**
     * 根据用户id、查询-上周的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountWeekLast(Long userId);



    /**
     * 根据用户id查询-上周的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreWeekLast(Long userId);


    /**
     * 根据用户id查询-上周的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreWeekLast(Long userId);

    /**
     * 根据用户id查询-上周的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreWeekLast(Long userId);
    /*查询上周end-------------------------------------------------------------------------*/


    /*查询上月start-------------------------------------------------------------------------*/
    /**
     * 根据用户id、查询-上月已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourMonthLast(Long userId);
    /**
     * 根据用户id、查询上月产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdMonthLast(Long userId);

    /**
     * 根据用户id、查询-上月的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountMonthLast(Long userId);

    /**
     * 根据用户id、查询-上月的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountMonthLast(Long userId);



    /**
     * 根据用户id查询-上月的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreMonthLast(Long userId);


    /**
     * 根据用户id查询-上月的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreMonthLast(Long userId);

    /**
     * 根据用户id查询-上月的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreMonthLast(Long userId);
    /*查询上月end-------------------------------------------------------------------------*/



    /*查询去年start-------------------------------------------------------------------------*/
    /**
     * 根据用户id、查询-去年已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    FaultMonitoringDO faultCountAndHourYearLast(Long userId);
    /**
     * 根据用户id、查询去年产生故障的应用数
     * @param userId
     * @return
     */
    List<ChargeSystem> findBySystemIdYearLast(Long userId);

    /**
     * 根据用户id、查询-去年的未处理故障数
     * @param userId
     * @return
     */
    Integer faultCountYearLast(Long userId);

    /**
     * 根据用户id、查询-去年的产生故障数量
     * @param userId
     * @return
     */
    Integer faultAllCountYearLast(Long userId);



    /**
     * 根据用户id查询-去年的服务评分
     * @param userId
     * @return
     */
    ScoreCountDO serviceScoreYearLast(Long userId);


    /**
     * 根据用户id查询-去年的培训评分
     * @param userId
     * @return
     */
    ScoreCountDO trainScoreYearLast(Long userId);

    /**
     * 根据用户id查询-去年的咨询评分
     * @param userId
     * @return
     */
    ScoreCountDO consulttationScoreYearLast(Long userId);
    /*查询去年end-------------------------------------------------------------------------*/
}