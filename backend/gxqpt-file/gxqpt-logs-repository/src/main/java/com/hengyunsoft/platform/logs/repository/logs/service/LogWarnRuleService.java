package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnRuleExample;

import java.util.List;

public interface LogWarnRuleService extends BaseAllService<Long, LogWarnRule, LogWarnRuleExample> {
    /**
     * 分页查询告警规则
     * @return
     */
    List<LogWarnRule> pageQueryWarnRule(LogWarnRuleExample example);

    /**
     * 执行告警规则
     */
    void doWarnRule();
}
