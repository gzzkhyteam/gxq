package com.hengyunsoft.platform.mt.repository.apprwork.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprAttenceSupply;
import com.hengyunsoft.platform.mt.repository.apprwork.dao.ApprAttenceSupplyMapper;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprAttenceSupplyExample;
import com.hengyunsoft.platform.mt.repository.apprwork.service.ApprAttenceSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprAttenceSupplyServiceImpl extends BaseServiceImpl<Long, ApprAttenceSupply, ApprAttenceSupplyExample> implements ApprAttenceSupplyService {
    @Autowired
    private ApprAttenceSupplyMapper apprAttenceSupplyMapper;

    @Override
    protected BaseNormalDao<Long, ApprAttenceSupply, ApprAttenceSupplyExample> getDao() {
        return apprAttenceSupplyMapper;
    }

    @Override
    public List<ApprAttenceSupply> getApprAttenceSupplysByDate(Long userId, Date date) {
        return getApprAttenceSupplysByDateAndType(userId, date, null);
    }

    @Override
    public ApprAttenceSupply getApprAttenceSupplyByApplyId(long applyId) {
        ApprAttenceSupplyExample example = new ApprAttenceSupplyExample();
        ApprAttenceSupplyExample.Criteria criteria = example.createCriteria();
        criteria.andApplyIdEqualTo(applyId);
        ApprAttenceSupply unique = getUnique(example);
        return unique;
    }

    @Override
    public List<ApprAttenceSupply> getApprAttenceSupplysByDateAndType(Long userId, Date date, Integer supplyType) {
        Date starTime = DateUtils.getDateTime(date, "00:00:00");
        Date endTime = DateUtils.getDateTime(date, "23:59:59");
        ApprAttenceSupplyExample example = new ApprAttenceSupplyExample();
        ApprAttenceSupplyExample.Criteria criteria = example.createCriteria();//补签类型(1:签到、2:签退)
        criteria.andCreateUserEqualTo(userId).andEndTimeGreaterThanOrEqualTo(starTime).andEndTimeLessThanOrEqualTo(endTime);
        if (supplyType != null) {
            criteria.andSupplyTypeEqualTo(supplyType);
        }
        List<ApprAttenceSupply> apprAttenceSupplies = find(example);
        return apprAttenceSupplies;
    }
}
