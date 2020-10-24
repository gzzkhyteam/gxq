package com.hengyunsoft.platform.warn.repository.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.dto.analysis.AppWarnCheckDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.DepSurveyResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.DepWarnCheckDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.DepWarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.EmpSurveyReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.EmpWarnCheckDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.EmpWarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.EmpWarnTypeResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.EmpsWarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.OrgWarnCheckDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypeResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypesResDTO;
import com.hengyunsoft.platform.warn.entity.domain.FairDepartmentDO;
import com.hengyunsoft.platform.warn.entity.domain.FairRelationshipDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptPublicContrastLevelDO;
import com.hengyunsoft.platform.warn.entity.domain.GxqptPublicRulesDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnAppCountDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnDepartmentCountDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnParamDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnPersonalCountDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptDuty;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.repository.example.GxqptDutyExample;

public interface GxqptDutyService extends BaseService<Long, GxqptDuty, GxqptDutyExample> {

	List<WarnPersonalCountDO> getCountByDepartment(WarnParamDO warnParamDTO);
	
	
	List<WarnDepartmentCountDO> getDepartmentByCompany(WarnParamDO warnParamDTO);
	
	
	List<WarnAppCountDO> getByApp(WarnParamDO warnParamDTO);	
    /**
     * 数博会部门、预警、应用关系
     * @return
     */
	List<FairRelationshipDO> getRelationshipApp(GxqptSendee gxqptSendee);
    /**
     * 数博会部门、预警、应用关系
     * @return
     */
	List<FairDepartmentDO> getRelationship(Date thisTime);
    /**
     * 数博会统各应用预警数量
     * @return
     */
	List<WarnAppCountDO> getInnerAppByAppId();
    /**
     * 数博会统各应用预警数量
     * @return
     */
	List<WarnAppCountDO> getOuterAppByAppId();

	/**
	 * 根据单位id集合查询各个单位未处理预警的信息
	 * @param map
	 * @return
	 */
    List findSurvey(Map map);

	/**
	 * 获取部门预警列表
	 * @return
	 */
	List<DepSurveyResDTO> getDepartmentWarns(SurveyReqDTO surveyReqDTO);

	/**
	 * 根据机构id集合查询各个机构未处理预警的数量（公用）
	 * @param map
	 * @return
	 */
	List findPublicSuperviseStatus(Map<String, Object> map);
	/**
     * 获取部门预警类别列表
     * @param surveyReqDTO
     * @return
     */
	List<WarnTypesResDTO> getDepartmentWarnTypes(SurveyReqDTO surveyReqDTO);
    /**
     * 单个部门预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	List<WarnTypeResDTO> getWarnTypes(DepWarnCheckDTO depWarnTypeCheckDTO);
    /**
     * 单个部门预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	List<DepWarnLevelResDTO> getWarnLevels(DepWarnCheckDTO depWarnCheckDTO);
	/**
     * 获取各部门预警级别列表
     * @return
     */
	List<WarnLevelResDTO> getDepartmentWarnLevels(SurveyReqDTO surveyReqDTO);
	/**
     * 获取各人员预警级别列表
     * @return
     */
	List<EmpsWarnLevelResDTO> getEmpWarnLevels(EmpSurveyReqDTO empSurveyReqDTO);
	/**
     * 获取各人员预警类别列表
     * @return
     */
	List<WarnTypesResDTO> getEmpWarnTypes(SurveyReqDTO surveyReqDTO);
    /**
     * 单个人员预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	List<EmpWarnTypeResDTO> getWarnTypes(EmpWarnCheckDTO empWarnTypeCheckDTO);
    /**
     * 单个人员预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	List<EmpWarnLevelResDTO> getWarnLevels(EmpWarnCheckDTO empWarnCheckDTO);
	/**
	 * 获取单位预警类别列表
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypesResDTO> getOrgartmentWarnTypes(SurveyReqDTO surveyReqDTO);
	/**
	 * 获取各单位预警级别列表
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnLevelResDTO> getOrgartmentWarnLevels(SurveyReqDTO surveyReqDTO);
    /**
     * 单个单位预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	List<WarnTypeResDTO> getOrgWarnTypes(OrgWarnCheckDTO orgWarnCheckDTO);
    /**
     * 单个单位预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	List<WarnLevelResDTO> getOrgWarnLevels(OrgWarnCheckDTO orgWarnCheckDTO);
    /**
     * 获取各应用预警类别列表
     * @param surveyReqDTO
     * @return
     */
	List<WarnTypesResDTO> getAppWarnTypes(SurveyReqDTO surveyReqDTO);
	/**
     * 获取各应用预警级别列表
     * @return
     */
	List<WarnLevelResDTO> getAppWarnLevels(SurveyReqDTO surveyReqDTO);
    /**
     * 单个应用预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	List<WarnTypeResDTO> getAppWarnTypes(AppWarnCheckDTO appWarnCheckDTO);
    /**
     * 全部应用预警类型平均值统计分析
     * @param surveyReqDTO
     * @return
     */
	List<WarnTypeResDTO> getAppWarnTypeAvg(AppWarnCheckDTO appWarnCheckDTO);
    /**
     * 单个应用预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	List<DepWarnLevelResDTO> getAppWarnLevels(AppWarnCheckDTO appWarnCheckDTO);
    /**
     * 全部应用预警级别平均值统计分析
     * @param surveyReqDTO
     * @return
     */
	List<DepWarnLevelResDTO> getAppWarnLevelAvg(AppWarnCheckDTO appWarnCheckDTO);
	/**
	 * 公用查询处理时长
	 * @param map
	 * @return
	 */
	List findPublicHandle(Map<String, Object> map);

	/**
	 * 公用查询预警级别
	 * @param stringObjectMap
	 * @return
	 */
	List findPublicLevel(Map<String, Object> map);

	/**
	 * 公用查询对比分析
	 * @param map
	 * @return
	 */
    List findPublicContrast(Map<String, Object> map);

	/**
	 * 关联规则挖掘
	 * @param map
	 * @return
	 */
    List<GxqptPublicRulesDO> findAssociationRules(Map<String, Object> map);

	/**
	 * 关联规则挖掘(子)
	 * @param map
	 * @return
	 */
    List<GxqptPublicRulesDO> findAssociationChildRules(Map<String, Object> map);

	/**
	 * 公用查询对比分析(级别)
	 * @param map
	 * @return
	 */
    List<GxqptPublicContrastLevelDO> findPublicContrastLevel(Map<String, Object> map, List<Integer> list);
}
