package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnRuleExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogWarnRuleMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule, com.hengyunsoft.platform.logs.repository.logs.example.LogWarnRuleExample> {
     List<LogWarnRule> pageQueryWarnRule(LogWarnRuleExample example);
}