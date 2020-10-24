package com.hengyunsoft.platform.security.repository.assess.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.security.entity.assess.domain.AssessmentListDO;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessment;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessmentReport;
import com.hengyunsoft.platform.security.repository.assess.example.SafetyAssessmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：安全风险评估管理-报告Service
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */

public interface SafetyAssessmentApiService extends BaseService<Long, SafetyAssessment, SafetyAssessmentExample> {

    /**
     * 查询安全风险评估列表
     * @param name 系统名称
     * @param level 安全等级
     * @return
     */
    public List<AssessmentListDO> findAssessmentList(@Param("name")String name,@Param("level")String level);

    /**
     * 根据评估时间排序获取最新一条记录
     * @param assessmentId
     * @return
     */
    SafetyAssessmentReport getReportAssessmentId(@Param("assessmentId") Long assessmentId);
}
