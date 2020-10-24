package com.hengyunsoft.platform.mt.repository.punchclock.dao;

import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PunchClockHisMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis, com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockHisExample> {
    /***
     * 分析查询历史记录
     * @param map
     * @return
     */
    List<PunchClockHis> findPageList(Map map);
}