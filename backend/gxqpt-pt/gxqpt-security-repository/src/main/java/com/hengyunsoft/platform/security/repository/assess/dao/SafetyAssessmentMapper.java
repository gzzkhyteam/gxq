package com.hengyunsoft.platform.security.repository.assess.dao;

import com.hengyunsoft.platform.security.entity.assess.domain.AssessmentListDO;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessmentReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SafetyAssessmentMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessment, com.hengyunsoft.platform.security.repository.assess.example.SafetyAssessmentExample> {

    /**
     * 查询安全风险评估列表
     * @param name 系统名称
     * @param level 安全等级
     * @return
     */
    public List<AssessmentListDO> findAssessmentList(@Param("name") String name, @Param("level") String level);

    /**
     * 根据评估时间排序获取最新一条记录
     * @param assessmentId
     * @return
     */
    SafetyAssessmentReport getReportAssessmentId(@Param("assessmentId") Long assessmentId);
}