package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetFilter;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetFilterMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetFilterExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetFilterServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetFilter, ShareDataSetFilterExample> implements ShareDataSetFilterService {
    @Autowired
    private ShareDataSetFilterMapper shareDataSetFilterMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetFilter, ShareDataSetFilterExample> getDao() {
        return shareDataSetFilterMapper;
    }

    @Override
    public Map<String, ShareDataSetFilter> getShareDataSetFilterMap(long setId) {
        ShareDataSetFilterExample sdsee = new ShareDataSetFilterExample();
        ShareDataSetFilterExample.Criteria sdseec = sdsee.createCriteria();
        sdseec.andSetIdEqualTo(setId);
        List<ShareDataSetFilter> shareDataSetFilters = find(sdsee);
        Map<String, ShareDataSetFilter> map = new HashMap<>();
        for (ShareDataSetFilter sd : shareDataSetFilters) {
            map.put(sd.getFieldCode(), sd);
        }
        return map;
    }

    @Override
    public List<ShareDataSetFilter> getAllBySetIdAndOpt(long setId, int optType) {
        ShareDataSetFilterExample example = new ShareDataSetFilterExample();
        ShareDataSetFilterExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId).andOptTypeEqualTo(optType);
        return find(example);
    }

    @Override
    public List<ShareDataSetFilter> getAllCanUseBySetId(long setId) {
        ShareDataSetFilterExample example = new ShareDataSetFilterExample();
        ShareDataSetFilterExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId).andOptTypeNotEqualTo(3);
        return find(example);
    }
}
