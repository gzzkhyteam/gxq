package com.hengyunsoft.platform.mt.repository.apprwork.dao;

import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApprOverTimeMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime, com.hengyunsoft.platform.mt.repository.apprwork.example.ApprOverTimeExample> {
    /***
     * 根据时间端查询用户的加班申请
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApprOverTime> getByUserAndTimeTime(@Param("userId") long userId,@Param("unitId") String unitId,@Param("curState")Integer curState, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}