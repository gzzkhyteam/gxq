package com.hengyunsoft.platform.mt.repository.apprwork.dao;

import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApprBusinessMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness, com.hengyunsoft.platform.mt.repository.apprwork.example.ApprBusinessExample> {
    /***
     * 根据时间段查询出差申请
     * @param userId
     * @param curState 当前审批状态
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApprBusiness> getApprBusinessByTime(@Param("userId") long userId,@Param("unitId") String unitId, @Param("curState") Integer curState, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

}