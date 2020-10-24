package com.hengyunsoft.platform.mt.repository.punchclock.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockExample;

import java.util.Date;

public interface PunchClockService extends BaseService<Long, PunchClock, PunchClockExample> {
    /***
     * 根据用户id,日期获取打卡记录
     * @param userId
     * @return
     */
    PunchClock getPunchClockByUserAndUnitIdAndDate(Long userId, String unitId, Date date);

}
