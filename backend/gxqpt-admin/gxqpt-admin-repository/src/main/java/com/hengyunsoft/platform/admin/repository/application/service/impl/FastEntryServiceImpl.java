package com.hengyunsoft.platform.admin.repository.application.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.application.po.FastEntry;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.FastEntryRankDO;
import com.hengyunsoft.platform.admin.repository.application.dao.FastEntryMapper;
import com.hengyunsoft.platform.admin.repository.application.example.FastEntryExample;
import com.hengyunsoft.platform.admin.repository.application.service.FastEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FastEntryServiceImpl
        extends BaseServiceImpl<Long, FastEntry, FastEntryExample>
        implements FastEntryService {
    @Autowired
    private FastEntryMapper fastEntryMapper;

    @Override
    protected BaseNormalDao<Long, FastEntry, FastEntryExample> getDao() {
        return fastEntryMapper;
    }

    @Override
    public List<FastEntry> queryAppByUserId(Long userId) {
        return fastEntryMapper.selectAppByUserId(userId);
    }

    @Override
    public void update(FastEntry fastEntry) {
        fastEntryMapper.update(fastEntry);
    }

    @Override
    public List<FastEntryRankDO> getFastEntryRank(Long resultNum) {
        return fastEntryMapper.getFastEntryRank(resultNum);
    }
}
