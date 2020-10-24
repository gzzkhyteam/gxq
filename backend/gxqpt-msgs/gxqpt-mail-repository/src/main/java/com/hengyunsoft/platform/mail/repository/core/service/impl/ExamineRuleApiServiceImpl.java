package com.hengyunsoft.platform.mail.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mail.entity.core.po.ExamineRule;
import com.hengyunsoft.platform.mail.repository.core.dao.ExamineRuleMapper;
import com.hengyunsoft.platform.mail.repository.core.example.ExamineRuleExample;
import com.hengyunsoft.platform.mail.repository.core.service.ExamineRuleApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：邮件审核规则impl
 * 修改人：wt
 * 修改时间：2018/8/24
 * 修改内容：
 */
@Service
@Slf4j
public class ExamineRuleApiServiceImpl extends BaseServiceImpl<Long, ExamineRule, ExamineRuleExample> implements ExamineRuleApiService {

    @Autowired
    ExamineRuleMapper examineRuleMapper;


    @Override
    protected BaseNormalDao<Long,ExamineRule, ExamineRuleExample> getDao() {
        return examineRuleMapper;
    }
}
