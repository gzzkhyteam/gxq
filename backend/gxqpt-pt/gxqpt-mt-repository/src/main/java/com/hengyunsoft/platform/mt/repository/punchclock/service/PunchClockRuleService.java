package com.hengyunsoft.platform.mt.repository.punchclock.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockRuleExample;

public interface PunchClockRuleService extends BaseService<Long, PunchClockRule, PunchClockRuleExample> {
    /***
     * 根据单位id获得考勤维护
      * @param unitId
     * @return
     */
    PunchClockRule getPunchClockRuleByUnityid(String unitId);
}
