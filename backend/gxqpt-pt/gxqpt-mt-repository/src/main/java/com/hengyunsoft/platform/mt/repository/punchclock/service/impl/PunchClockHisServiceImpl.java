package com.hengyunsoft.platform.mt.repository.punchclock.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockHis;
import com.hengyunsoft.platform.mt.repository.punchclock.dao.PunchClockHisMapper;
import com.hengyunsoft.platform.mt.repository.punchclock.example.PunchClockHisExample;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PunchClockHisServiceImpl extends BaseServiceImpl<Long, PunchClockHis, PunchClockHisExample> implements PunchClockHisService {
    @Autowired
    private PunchClockHisMapper punchClockHisMapper;

    @Override
    protected BaseNormalDao<Long, PunchClockHis, PunchClockHisExample> getDao() {
        return punchClockHisMapper;
    }

    @Override
    public List<PunchClockHis> findPageList(Map map) {
        return punchClockHisMapper.findPageList(map);
    }
}
