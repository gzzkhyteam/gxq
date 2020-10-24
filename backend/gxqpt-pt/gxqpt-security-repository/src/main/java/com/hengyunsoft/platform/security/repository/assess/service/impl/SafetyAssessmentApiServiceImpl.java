package com.hengyunsoft.platform.security.repository.assess.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.assess.domain.AssessmentListDO;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessment;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessmentReport;
import com.hengyunsoft.platform.security.repository.assess.dao.SafetyAssessmentMapper;
import com.hengyunsoft.platform.security.repository.assess.example.SafetyAssessmentExample;
import com.hengyunsoft.platform.security.repository.assess.service.SafetyAssessmentApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：安全风险评估管理实现
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Service
@Slf4j
public class SafetyAssessmentApiServiceImpl extends BaseServiceImpl<Long, SafetyAssessment, SafetyAssessmentExample> implements SafetyAssessmentApiService {

    @Autowired
    SafetyAssessmentMapper safetyAssessmentMapper;


    @Override
    protected BaseNormalDao<Long, SafetyAssessment, SafetyAssessmentExample> getDao() {
        return safetyAssessmentMapper;
    }

    @Override
    public List<AssessmentListDO> findAssessmentList(String name, String level) {
        return safetyAssessmentMapper.findAssessmentList(name,level);
    }

    @Override
    public SafetyAssessmentReport getReportAssessmentId(Long assessmentId) {
        return safetyAssessmentMapper.getReportAssessmentId(assessmentId);
    }
}
