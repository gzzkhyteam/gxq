package com.hengyunsoft.platform.ops.repository.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.fault.domain.FaultMonitoringDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.ScoreCountDO;
import com.hengyunsoft.platform.ops.entity.person.po.ChargeSystem;
import com.hengyunsoft.platform.ops.repository.person.dao.ChargeSystemMapper;
import com.hengyunsoft.platform.ops.repository.person.example.ChargeSystemExample;
import com.hengyunsoft.platform.ops.repository.person.service.ChargeSystemService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChargeSystemServiceImpl extends BaseServiceImpl<Long,ChargeSystem,ChargeSystemExample> implements ChargeSystemService{
    @Autowired
    private ChargeSystemMapper chargeSystemMapper;

    @Override
    protected BaseNormalDao<Long, ChargeSystem, ChargeSystemExample> getDao() {
        return chargeSystemMapper;
    }
    /**
     * 根据用户id、查询当天已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    @Override
    public FaultMonitoringDO faultCountAndHour(Long userId) {
        return chargeSystemMapper.faultCountAndHour(userId);
    }
    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    @Override
    public List<ChargeSystem> findBySystemId(Long userId) {
        return chargeSystemMapper.findBySystemId(userId);
    }
    /**
     * 根据用户id、查询当天的未处理故障数
     * @param userId
     * @return
     */
    @Override
    public Integer faultCount(Long userId) {
        return chargeSystemMapper.faultCount(userId);
    }
    /**
     * 根据用户id、查询当天的产生故障数量
     * @param userId
     * @return
     */
    @Override
    public Integer faultAllCount(Long userId) {
        return chargeSystemMapper.faultAllCount(userId);
    }
    /**
     * 根据用户id查询、当天的服务评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO serviceScore(Long userId) {
        return chargeSystemMapper.serviceScore(userId);
    }
    /**
     * 根据用户id查询、当天的培训评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO trainScore(Long userId) {
        return chargeSystemMapper.trainScore(userId);
    }
    /**
     * 根据用户id查询、当天的咨询评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO consulttationScore(Long userId) {
        return chargeSystemMapper.consulttationScore(userId);
    }
    /**
     * 根据用户id、查询-本周已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    @Override
    public FaultMonitoringDO faultCountAndHourWeek(Long userId) {
        return chargeSystemMapper.faultCountAndHourWeek(userId);
    }
    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    @Override
    public List<ChargeSystem> findBySystemIdWeek(Long userId) {
        return chargeSystemMapper.findBySystemIdWeek(userId);
    }
    /**
     * 根据用户id、查询-本周的未处理故障数
     * @param userId
     * @return
     */
    @Override
    public Integer faultCountWeek(Long userId) {
        return chargeSystemMapper.faultCountWeek(userId);
    }
    /**
     * 根据用户id、查询-本周的产生故障数量
     * @param userId
     * @return
     */
    @Override
    public Integer faultAllCountWeek(Long userId) {
        return chargeSystemMapper.faultAllCountWeek(userId);
    }

    /**
     * 根据用户id查询-本周的服务评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO serviceScoreWeek(Long userId) {
        return chargeSystemMapper.serviceScoreWeek(userId);
    }
    /**
     * 根据用户id查询-本周的培训评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO trainScoreWeek(Long userId) {
        return chargeSystemMapper.trainScoreWeek(userId);
    }
    /**
     * 根据用户id查询-本周的咨询评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO consulttationScoreWeek(Long userId) {
        return chargeSystemMapper.consulttationScoreWeek(userId);
    }
    /**
     * 根据用户id、查询-本月已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    @Override
    public FaultMonitoringDO faultCountAndHourMonth(Long userId) {
        return chargeSystemMapper.faultCountAndHourMonth(userId);
    }
    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    @Override
    public List<ChargeSystem> findBySystemIdMonth(Long userId) {
        return chargeSystemMapper.findBySystemIdMonth(userId);
    }
    /**
     * 根据用户id、查询-本月的未处理故障数
     * @param userId
     * @return
     */
    @Override
    public Integer faultCountMonth(Long userId) {
        return chargeSystemMapper.faultCountMonth(userId);
    }
    /**
     * 根据用户id、查询-本月的产生故障数量
     * @param userId
     * @return
     */
    @Override
    public Integer faultAllCountMonth(Long userId) {
        return chargeSystemMapper.faultAllCountMonth(userId);
    }
    /**
     * 根据用户id查询-本月的服务评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO serviceScoreMonth(Long userId) {
        return chargeSystemMapper.serviceScoreMonth(userId);
    }
    /**
     * 根据用户id查询-本月的培训评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO trainScoreMonth(Long userId) {
        return chargeSystemMapper.trainScoreMonth(userId);
    }
    /**
     * 根据用户id查询-本月的咨询评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO consulttationScoreMonth(Long userId) {
        return chargeSystemMapper.consulttationScoreMonth(userId);
    }
    /**
     * 根据用户id、查询-本年已处理故障数和处理时长（按应用）
     * @param userId
     * @return
     */
    @Override
    public FaultMonitoringDO faultCountAndHourYear(Long userId) {
        return chargeSystemMapper.faultCountAndHourYear(userId);
    }
    /**
     * 根据用户id、查询产生故障的应用数
     * @param userId
     * @return
     */
    @Override
    public List<ChargeSystem> findBySystemIdYear(Long userId) {
        return chargeSystemMapper.findBySystemIdYear(userId);
    }
    /**
     * 根据用户id、查询-本年的未处理故障数
     * @param userId
     * @return
     */
    @Override
    public Integer faultCountYear(Long userId) {
        return chargeSystemMapper.faultCountYear(userId);
    }
    /**
     * 根据用户id、查询-本年的产生故障数量
     * @param userId
     * @return
     */
    @Override
    public Integer faultAllCountYear(Long userId) {
        return chargeSystemMapper.faultAllCountYear(userId);
    }
    /**
     * 根据用户id查询-本年的服务评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO serviceScoreYear(Long userId) {
        return chargeSystemMapper.serviceScoreYear(userId);
    }

    /**
     * 根据用户id查询-本年的培训评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO trainScoreYear(Long userId) {
        return chargeSystemMapper.trainScoreYear(userId);
    }
    /**
     * 根据用户id查询-本年的咨询评分
     * @param userId
     * @return
     */
    @Override
    public ScoreCountDO consulttationScoreYear(Long userId) {
        return chargeSystemMapper.consulttationScoreYear(userId);
    }

    @Override
    public FaultMonitoringDO faultCountAndHourLast(Long userId) {
        return chargeSystemMapper.faultCountAndHourLast(userId);
    }

    @Override
    public List<ChargeSystem> findBySystemIdLast(Long userId) {
        return chargeSystemMapper.findBySystemIdLast(userId);
    }

    @Override
    public Integer faultCountLast(Long userId) {
        return chargeSystemMapper.faultCountLast(userId);
    }

    @Override
    public Integer faultAllCountLast(Long userId) {
        return chargeSystemMapper.faultAllCountLast(userId);
    }

    @Override
    public ScoreCountDO serviceScoreLast(Long userId) {
        return chargeSystemMapper.serviceScoreLast(userId);
    }

    @Override
    public ScoreCountDO trainScoreLast(Long userId) {
        return chargeSystemMapper.trainScoreLast(userId);
    }

    @Override
    public ScoreCountDO consulttationScoreLast(Long userId) {
        return chargeSystemMapper.consulttationScoreLast(userId);
    }

    @Override
    public FaultMonitoringDO faultCountAndHourWeekLast(Long userId) {
        return chargeSystemMapper.faultCountAndHourWeekLast(userId);
    }

    @Override
    public List<ChargeSystem> findBySystemIdWeekLast(Long userId) {
        return chargeSystemMapper.findBySystemIdWeekLast(userId);
    }

    @Override
    public Integer faultCountWeekLast(Long userId) {
        return chargeSystemMapper.faultCountWeekLast(userId);
    }

    @Override
    public Integer faultAllCountWeekLast(Long userId) {
        return chargeSystemMapper.faultAllCountWeekLast(userId);
    }

    @Override
    public ScoreCountDO serviceScoreWeekLast(Long userId) {
        return chargeSystemMapper.serviceScoreWeekLast(userId);
    }

    @Override
    public ScoreCountDO trainScoreWeekLast(Long userId) {
        return chargeSystemMapper.trainScoreWeekLast(userId);
    }

    @Override
    public ScoreCountDO consulttationScoreWeekLast(Long userId) {
        return chargeSystemMapper.consulttationScoreWeekLast(userId);
    }

    @Override
    public FaultMonitoringDO faultCountAndHourMonthLast(Long userId) {
        return chargeSystemMapper.faultCountAndHourMonthLast(userId);
    }

    @Override
    public List<ChargeSystem> findBySystemIdMonthLast(Long userId) {
        return chargeSystemMapper.findBySystemIdMonthLast(userId);
    }

    @Override
    public Integer faultCountMonthLast(Long userId) {
        return chargeSystemMapper.faultCountMonthLast(userId);
    }

    @Override
    public Integer faultAllCountMonthLast(Long userId) {
        return chargeSystemMapper.faultAllCountMonthLast(userId);
    }

    @Override
    public ScoreCountDO serviceScoreMonthLast(Long userId) {
        return chargeSystemMapper.serviceScoreMonthLast(userId);
    }

    @Override
    public ScoreCountDO trainScoreMonthLast(Long userId) {
        return chargeSystemMapper.trainScoreMonthLast(userId);
    }

    @Override
    public ScoreCountDO consulttationScoreMonthLast(Long userId) {
        return chargeSystemMapper.consulttationScoreMonthLast(userId);
    }

    @Override
    public FaultMonitoringDO faultCountAndHourYearLast(Long userId) {
        return chargeSystemMapper.faultCountAndHourYearLast(userId);
    }

    @Override
    public List<ChargeSystem> findBySystemIdYearLast(Long userId) {
        return chargeSystemMapper.findBySystemIdYearLast(userId);
    }

    @Override
    public Integer faultCountYearLast(Long userId) {
        return chargeSystemMapper.faultCountYearLast(userId);
    }

    @Override
    public Integer faultAllCountYearLast(Long userId) {
        return chargeSystemMapper.faultAllCountYearLast(userId);
    }

    @Override
    public ScoreCountDO serviceScoreYearLast(Long userId) {
        return chargeSystemMapper.serviceScoreYearLast(userId);
    }

    @Override
    public ScoreCountDO trainScoreYearLast(Long userId) {
        return chargeSystemMapper.trainScoreYearLast(userId);
    }

    @Override
    public ScoreCountDO consulttationScoreYearLast(Long userId) {
        return chargeSystemMapper.consulttationScoreYearLast(userId);
    }
}
