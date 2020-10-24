package com.hengyunsoft.platform.mt.repository.apprwork.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprBusiness;
import com.hengyunsoft.platform.mt.repository.apprwork.dao.ApprBusinessMapper;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprBusinessExample;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprBusinessServiceImpl extends BaseServiceImpl<Long, ApprBusiness, ApprBusinessExample> implements ApprBusinessService {
    @Autowired
    private ApprBusinessMapper apprBusinessMapper;

    @Override
    protected BaseNormalDao<Long, ApprBusiness, ApprBusinessExample> getDao() {
        return apprBusinessMapper;
    }

    @Override
    public ApprBusiness getApprBusinessByApplyId(long applyId) {
        ApprBusinessExample example = new ApprBusinessExample();
        ApprBusinessExample.Criteria criteria = example.createCriteria();
        criteria.andApplyIdEqualTo(applyId);
        return getUnique(example);
    }

    @Override
    public List<ApprBusiness> getApprBusinessByTimeAndState(long userId,String unitId, int curState, Date startTime, Date endTime) {
        return apprBusinessMapper.getApprBusinessByTime(userId, unitId,curState, startTime, endTime);
    }
}
