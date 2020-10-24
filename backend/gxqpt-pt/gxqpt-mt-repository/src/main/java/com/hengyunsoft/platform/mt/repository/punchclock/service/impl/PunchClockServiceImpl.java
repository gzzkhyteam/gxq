package com.hengyunsoft.platform.mt.repository.punchclock.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.repository.punchclock.dao.PunchClockMapper;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockExample;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PunchClockServiceImpl extends BaseServiceImpl<Long, PunchClock, PunchClockExample> implements PunchClockService {
    @Autowired
    private PunchClockMapper punchClockMapper;

    @Override
    protected BaseNormalDao<Long, PunchClock, PunchClockExample> getDao() {
        return punchClockMapper;
    }

    @Override
    public PunchClock getPunchClockByUserAndUnitIdAndDate(Long userId, String unitId, Date date) {
        PunchClockExample example = new PunchClockExample();
        PunchClockExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andUnitIdEqualTo(unitId);
        //criteria.andClockTypeEqualTo(clockType);
        criteria.andClockDateEqualTo(date);
        PunchClock unique = getUnique(example);
        return unique;
    }
}
