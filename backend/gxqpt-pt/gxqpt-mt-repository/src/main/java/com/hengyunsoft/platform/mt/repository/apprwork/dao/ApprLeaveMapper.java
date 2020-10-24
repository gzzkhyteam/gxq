package com.hengyunsoft.platform.mt.repository.apprwork.dao;

import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApprLeaveMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave, com.hengyunsoft.platform.mt.repository.apprwork.example.ApprLeaveExample> {
    /***
     * 根据时间段查询用户的请假
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApprLeave> getApprLeaveByTime(@Param("userId") long userId,@Param("unitId") String unitId, @Param("curState") Integer curState, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}