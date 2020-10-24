package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetRule;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetRuleExample;

public interface ShareDataSetRuleService extends BaseAllService<Long, ShareDataSetRule, ShareDataSetRuleExample> {
    /***
     * 根据数据集id删除
     * @param setId
     */
    void deleteBySetId(long setId);
}
