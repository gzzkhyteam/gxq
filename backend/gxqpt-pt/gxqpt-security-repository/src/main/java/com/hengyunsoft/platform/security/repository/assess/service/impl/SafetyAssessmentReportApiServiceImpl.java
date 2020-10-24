package com.hengyunsoft.platform.security.repository.assess.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessmentReport;
import com.hengyunsoft.platform.security.repository.assess.dao.SafetyAssessmentReportMapper;
import com.hengyunsoft.platform.security.repository.assess.example.SafetyAssessmentReportExample;
import com.hengyunsoft.platform.security.repository.assess.service.SafetyAssessmentReportApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：安全风险评估管理-报告实现
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Service
@Slf4j
public class SafetyAssessmentReportApiServiceImpl extends BaseServiceImpl<Long, SafetyAssessmentReport, SafetyAssessmentReportExample> implements SafetyAssessmentReportApiService {

    @Autowired
    SafetyAssessmentReportMapper safetyAssessmentReportMapper;


    @Override
    protected BaseNormalDao<Long, SafetyAssessmentReport, SafetyAssessmentReportExample> getDao() {
        return safetyAssessmentReportMapper;
    }

}
