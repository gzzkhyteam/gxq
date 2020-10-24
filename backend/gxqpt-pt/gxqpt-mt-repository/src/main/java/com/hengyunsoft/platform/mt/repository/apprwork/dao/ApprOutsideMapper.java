package com.hengyunsoft.platform.mt.repository.apprwork.dao;

import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApprOutsideMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside, com.hengyunsoft.platform.mt.repository.apprwork.example.ApprOutsideExample> {
    /***
     * 根据时间查询外勤申请
      * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApprOutside> getByUserAndTimeTime(@Param("userId") long userId,@Param("unitId") String unitId, @Param("startTime") Date startTime, @Param("endTime") Date endTime,@Param("curState") Integer curState);
}