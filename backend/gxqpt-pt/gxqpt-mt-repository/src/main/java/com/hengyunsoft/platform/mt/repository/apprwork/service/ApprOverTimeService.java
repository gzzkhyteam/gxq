package com.hengyunsoft.platform.mt.repository.apprwork.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprOverTimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ApprOverTimeService extends BaseService<Long, ApprOverTime, ApprOverTimeExample> {
    /***
     * 查找用户时间段内的加班申请
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApprOverTime> getApprOverTimeByTime(Long userId, String unitId, Date startTime, Date endTime);

    /***
     *查找用户时间段内的加班申请
     * @param userId
     * @param curState  当前审批状态
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApprOverTime> getApprOverTimeByTimeAndState(Long userId,String unitId,int curState, Date startTime, Date endTime);

    /***
     * 根据申请id查询
     *
     * @param applyId
     * @return
     */
    ApprOverTime getApprOverTimeByApplyId(Long applyId);
}
