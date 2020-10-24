package com.hengyunsoft.platform.mt.repository.apprwork.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprBusinessExample;

import java.util.Date;
import java.util.List;

public interface ApprBusinessService extends BaseService<Long, ApprBusiness, ApprBusinessExample> {
    /**
     * 根据申请id获取
     *
     * @param applyId
     * @return
     */
    ApprBusiness getApprBusinessByApplyId(long applyId);

    /***
     * 根据时间段查询出差申请
     * @param userId 用户id
     * @param curState 当前审批状态 1:审批中，2:已驳回，3:已结束，4:已撤销
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<ApprBusiness> getApprBusinessByTimeAndState(long userId,String unitId, int curState, Date startTime, Date endTime);
}
