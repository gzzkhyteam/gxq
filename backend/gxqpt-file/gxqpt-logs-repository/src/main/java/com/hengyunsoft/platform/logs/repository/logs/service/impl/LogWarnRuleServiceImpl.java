package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogWarnRuleMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnRuleExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogWarnRuleServiceImpl extends BaseAllServiceImpl<Long, LogWarnRule, LogWarnRuleExample> implements LogWarnRuleService {
    @Autowired
    private LogWarnRuleMapper logWarnRuleMapper;
    @Override
    protected BaseNormalDao<Long, LogWarnRule, LogWarnRuleExample> getDao() {
        return logWarnRuleMapper;
    }

    @Override
    public List<LogWarnRule> pageQueryWarnRule(LogWarnRuleExample example) {
        return logWarnRuleMapper.pageQueryWarnRule(example);
    }

    @Override
    public void doWarnRule() {

    }
}
