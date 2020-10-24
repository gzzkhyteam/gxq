package com.hengyunsoft.platform.mt.repository.apprwork.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprLeave;
import com.hengyunsoft.platform.mt.repository.apprwork.dao.ApprLeaveMapper;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprLeaveExample;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprLeaveServiceImpl extends BaseServiceImpl<Long, ApprLeave, ApprLeaveExample> implements ApprLeaveService {
    @Autowired
    private ApprLeaveMapper apprLeaveMapper;

    @Override
    protected BaseNormalDao<Long, ApprLeave, ApprLeaveExample> getDao() {
        return apprLeaveMapper;
    }

    @Override
    public List<ApprLeave> getApprLeaveByTime(long userId, String unitId, Date startTime, Date endTime) {
        return apprLeaveMapper.getApprLeaveByTime(userId, unitId, null, startTime, endTime);
    }

    @Override
    public List<ApprLeave> getApprLeaveByTimeAndState(long userId, String unitId, int curState, Date startTime, Date endTime) {
        return apprLeaveMapper.getApprLeaveByTime(userId, unitId, curState, startTime, endTime);
    }

    @Override
    public ApprLeave getApprLeaveByApplyId(long applyId) {
        ApprLeaveExample example = new ApprLeaveExample();
        ApprLeaveExample.Criteria criteria = example.createCriteria();
        criteria.andApplyIdEqualTo(applyId);
        return getUnique(example);
    }
}
