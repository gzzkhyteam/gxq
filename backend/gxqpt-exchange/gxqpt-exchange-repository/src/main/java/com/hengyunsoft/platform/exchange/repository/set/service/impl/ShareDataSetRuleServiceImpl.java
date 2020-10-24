package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetRule;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetRuleMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetRuleExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareDataSetRuleServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetRule, ShareDataSetRuleExample> implements ShareDataSetRuleService {
    @Autowired
    private ShareDataSetRuleMapper shareDataSetRuleMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetRule, ShareDataSetRuleExample> getDao() {
        return shareDataSetRuleMapper;
    }

    @Override
    public void deleteBySetId(long setId) {
        ShareDataSetRuleExample example = new ShareDataSetRuleExample();
        ShareDataSetRuleExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId);
        shareDataSetRuleMapper.deleteByExample(example);
    }
}
