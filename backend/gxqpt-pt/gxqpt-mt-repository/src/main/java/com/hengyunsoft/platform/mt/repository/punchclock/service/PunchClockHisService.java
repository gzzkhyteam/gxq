package com.hengyunsoft.platform.mt.repository.punchclock.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClock;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockHisExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PunchClockHisService extends BaseService<Long, PunchClockHis, PunchClockHisExample> {
    /***
     * 分页查询打卡历史记录
     * @param map
     * @return
     */
    List<PunchClockHis> findPageList(Map map);
}
