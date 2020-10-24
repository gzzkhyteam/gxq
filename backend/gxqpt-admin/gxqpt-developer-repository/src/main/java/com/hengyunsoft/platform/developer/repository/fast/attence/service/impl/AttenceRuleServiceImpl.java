package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceRule;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceRuleMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceRuleExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttenceRuleServiceImpl extends BaseAllServiceImpl<Long, AttenceRule, AttenceRuleExample>
        implements AttenceRuleService {
    @Autowired
    private AttenceRuleMapper attenceRuleMapper;

    @Override
    protected BaseNormalDao<Long, AttenceRule, AttenceRuleExample> getDao() {
        return attenceRuleMapper;
    }
}
