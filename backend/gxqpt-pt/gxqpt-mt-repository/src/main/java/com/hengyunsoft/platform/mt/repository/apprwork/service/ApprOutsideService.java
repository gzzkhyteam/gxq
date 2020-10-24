package com.hengyunsoft.platform.mt.repository.apprwork.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprOutsideExample;

import java.util.Date;
import java.util.List;

public interface ApprOutsideService extends BaseService<Long, ApprOutside, ApprOutsideExample> {
    /***
     * 根据时间段查询外勤申请
     * @param userId 用户id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<ApprOutside> getApprOutsidesByDate(long userId, String unitId,Date startTime, Date endTime);
    /***
     * 根据时间段查询外勤申请
     * @param userId 用户id
     * @param curState 当前审批状态 1:审批中，2:已驳回，3:已结束，4:已撤销
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<ApprOutside> getApprOutsidesByDateAndState(long userId, String unitId,int curState, Date startTime, Date endTime);
    /***
     * 根据审批申请id查询
     *
     * @param applyId
     * @return
     */
    ApprOutside getApprOutsideByApplyid(long applyId);
}
