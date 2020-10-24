package com.hengyunsoft.platform.mt.repository.punchclock.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.repository.punchclock.dao.PunchClockRuleMapper;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockRuleExample;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunchClockRuleServiceImpl extends BaseServiceImpl<Long, PunchClockRule, PunchClockRuleExample> implements PunchClockRuleService {
    @Autowired
    private PunchClockRuleMapper punchClockRuleMapper;

    @Override
    protected BaseNormalDao<Long, PunchClockRule, PunchClockRuleExample> getDao() {
        return punchClockRuleMapper;
    }

    @Override
    public PunchClockRule getPunchClockRuleByUnityid(String unitId) {
        PunchClockRuleExample example = new PunchClockRuleExample();
        PunchClockRuleExample.Criteria criteria = example.createCriteria();
        criteria.andUnitIdEqualTo(unitId);
        PunchClockRule unique = getUnique(example);
        if (unique == null) {
            throw new BizException(MtExceptionCode.UNIOTY_HAS_ATEPUNCHCLOCK_ROLE.getCode(), "单位id:"+unitId + ":该单位没有创建考勤规则");
        }
        return unique;
    }
}
