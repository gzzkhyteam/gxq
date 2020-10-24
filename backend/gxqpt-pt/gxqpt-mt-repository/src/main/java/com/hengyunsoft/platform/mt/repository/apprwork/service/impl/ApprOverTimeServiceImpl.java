package com.hengyunsoft.platform.mt.repository.apprwork.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOverTime;
import com.hengyunsoft.platform.mt.repository.apprwork.dao.ApprOverTimeMapper;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprOverTimeExample;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOverTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprOverTimeServiceImpl extends BaseServiceImpl<Long, ApprOverTime, ApprOverTimeExample> implements ApprOverTimeService {
    @Autowired
    private ApprOverTimeMapper apprOverTimeMapper;

    @Override
    protected BaseNormalDao<Long, ApprOverTime, ApprOverTimeExample> getDao() {
        return apprOverTimeMapper;
    }

    @Override
    public List<ApprOverTime> getApprOverTimeByTime(Long userId,String unitId ,Date startTime, Date endTime) {
        return apprOverTimeMapper.getByUserAndTimeTime(userId,unitId,null,startTime,endTime);
    }

    @Override
    public List<ApprOverTime> getApprOverTimeByTimeAndState(Long userId,String unitId, int curState, Date startTime, Date endTime) {
        return apprOverTimeMapper.getByUserAndTimeTime(userId,unitId,curState,startTime,endTime);
    }

    @Override
    public ApprOverTime getApprOverTimeByApplyId(Long applyId) {
        ApprOverTimeExample example = new ApprOverTimeExample();
        ApprOverTimeExample.Criteria criteria = example.createCriteria();
        criteria.andApplyIdEqualTo(applyId);
        return getUnique(example);
    }
}
