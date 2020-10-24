package com.hengyunsoft.platform.mt.repository.apprwork.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprOutside;
import com.hengyunsoft.platform.mt.repository.apprwork.dao.ApprOutsideMapper;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprOutsideExample;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprOutsideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprOutsideServiceImpl extends BaseServiceImpl<Long, ApprOutside, ApprOutsideExample> implements ApprOutsideService {
    @Autowired
    private ApprOutsideMapper apprOutsideMapper;

    @Override
    protected BaseNormalDao<Long, ApprOutside, ApprOutsideExample> getDao() {
        return apprOutsideMapper;
    }

    @Override
    public List<ApprOutside> getApprOutsidesByDate(long userId,String unitId, Date startTime, Date endTime) {
        return apprOutsideMapper.getByUserAndTimeTime(userId,unitId,startTime,endTime,null);
    }

    @Override
    public List<ApprOutside> getApprOutsidesByDateAndState(long userId, String unitId,int curState, Date startTime, Date endTime) {
        return apprOutsideMapper.getByUserAndTimeTime(userId,unitId,startTime,endTime,curState);
    }

    @Override
    public ApprOutside getApprOutsideByApplyid(long applyId) {
        ApprOutsideExample example = new ApprOutsideExample();
        ApprOutsideExample.Criteria criteria = example.createCriteria();
        criteria.andApplyIdEqualTo(applyId);
        return getUnique(example);
    }
}
