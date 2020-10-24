package com.hengyunsoft.platform.warn.repository.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

@Repository
public interface GxqptDutyMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.warn.entity.po.GxqptDuty, com.hengyunsoft.platform.warn.repository.example.GxqptDutyExample> {

	/**
	 * 根据预警id查询接收人信息表
	 * @param warnId
	 * @return
	 */
	List<Map<String,Object>> getDutyList(@Param("warnId")  Long warnId);

	List<WarnPersonalCountDO> getCountByDepartment(@Param ("warnParamDTO")WarnParamDO warnParamDTO);
	List<WarnDepartmentCountDO> getDepartmentByCompany (@Param("warnParamDTO")WarnParamDO warnParamDTO);
	List<WarnAppCountDO> getByApp(@Param("warnParamDTO") WarnParamDO warnParamDTO);
	/**
	 * 数博会部门、预警、应用关系
	 * @return
	 */
	List<FairRelationshipDO> getRelationshipApp(@Param(value  = "gxqptSendee")GxqptSendee gxqptSendee);
	/**
	 * 数博会部门、预警、应用关系
	 * @return
	 */
	List<FairDepartmentDO> getRelationship(@Param(value  = "thisTime")Date thisTime);
	/**
	 * 数博会统计各应用预警数量
	 * @return
	 */
	List<WarnAppCountDO> getInnerAppByAppId();
	/**
	 * 数博会统计各应用预警数量
	 * @return
	 */
	List<WarnAppCountDO> getOuterAppByAppId();

	/**
	 * 根据单位id集合查询各个单位未处理预警的信息
	 * @param map
	 * @return
	 */
	List findSurvey(@Param(value = "map") Map map);
	/**
	 * 获取部门预警列表
	 * @return
	 */
	List<DepSurveyResDTO> getDepartmentWarns(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 获取部门预警类别列表
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypesResDTO> getDepartmentWarnTypes(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 单个部门预警类型统计分析
	 * @return
	 */
	List<WarnTypeResDTO> getWarnTypes(@Param("depWarnCheckDTO")DepWarnCheckDTO depWarnCheckDTO);
	/**
	 * 单个部门预警级别统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<DepWarnLevelResDTO> getWarnLevels(@Param("depWarnCheckDTO")DepWarnCheckDTO depWarnCheckDTO);
	/**
	 * 获取各部门预警级别列表
	 * @return
	 */
	List<WarnLevelResDTO> getDepartmentWarnLevels(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 获取各人员预警级别列表
	 * @return
	 */
	List<EmpsWarnLevelResDTO> getEmpWarnLevels(@Param("empSurveyReqDTO")EmpSurveyReqDTO empSurveyReqDTO);
	/**
	 * 获取各人员预警类别列表
	 * @return
	 */
	List<WarnTypesResDTO> getEmpsWarnTypes(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 单个人员预警类型统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<EmpWarnTypeResDTO> getEmpWarnTypes(@Param("empWarnTypeCheckDTO")EmpWarnCheckDTO empWarnTypeCheckDTO);
	/**
	 * 单个人员预警级别统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<EmpWarnLevelResDTO> getEmpWarnLevel(@Param("empWarnCheckDTO")EmpWarnCheckDTO empWarnCheckDTO);
	/**
	 * 获取单位预警类别列表
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypesResDTO> getOrgartmentWarnTypes(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 获取各单位预警级别列表
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnLevelResDTO> getOrgartmentWarnLevels(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 单个单位预警类型统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypeResDTO> getOrgWarnTypes(@Param("orgWarnCheckDTO")OrgWarnCheckDTO orgWarnCheckDTO);
	/**
	 * 单个单位预警级别统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnLevelResDTO> getOrgWarnLevels(@Param("orgWarnCheckDTO")OrgWarnCheckDTO orgWarnCheckDTO);
	/**
	 * 获取各应用预警类别列表
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypesResDTO> getAppsWarnTypes(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 获取各应用预警级别列表
	 * @return
	 */
	List<WarnLevelResDTO> getAppsWarnLevels(@Param("surveyReqDTO")SurveyReqDTO surveyReqDTO);
	/**
	 * 单个应用预警类型统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypeResDTO> getAppWarnTypes(@Param("appWarnCheckDTO")AppWarnCheckDTO appWarnCheckDTO);
	/**
	 * 单个应用预警级别统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<DepWarnLevelResDTO> getAppWarnLevels(@Param("appWarnCheckDTO")AppWarnCheckDTO appWarnCheckDTO);

	/**
	 * 根据机构id集合查询各个机构未处理预警的数量（公用）
	 * @param map
	 * @return
	 */
	List findPublicSuperviseStatus(@Param(value = "map") Map<String, Object> map);

	/**
	 * 公用查询处理时长
	 * @param map
	 * @return
	 */
	List findPublicHandle(@Param(value = "map") Map<String, Object> map);

	/**
	 * 公用查询预警级别
	 * @param map
	 * @return
	 */
	List findPublicLevel(@Param(value = "map") Map<String, Object> map);

	/**
	 * 公用查询对比分析
	 * @param map
	 * @return
	 */
	List findPublicContrast(@Param(value = "map") Map<String, Object> map);

	/**
	 * 关联规则挖掘
	 * @param map
	 * @return
	 */
	List<GxqptPublicRulesDO> findAssociationRules(@Param(value = "map") Map<String, Object> map);

	/**
	 * 关联规则挖掘(子)
	 * @param map
	 * @return
	 */
	List<GxqptPublicRulesDO> findAssociationChildRules(@Param(value = "map") Map<String, Object> map);
	/**
	 * 全部应用预警类型平均值统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<WarnTypeResDTO> getAppWarnTypeAvg(@Param(value = "appWarnCheckDTO")AppWarnCheckDTO appWarnCheckDTO);
	/**
	 * 全部应用预警级别平均值统计分析
	 * @param surveyReqDTO
	 * @return
	 */
	List<DepWarnLevelResDTO> getAppWarnLevelAvg(@Param("appWarnCheckDTO")AppWarnCheckDTO appWarnCheckDTO);

	/**
	 * 公用查询对比分析(级别)
	 * @param map
	 * @return
	 */
	List<GxqptPublicContrastLevelDO> findPublicContrastLevel(@Param(value = "map") Map<String, Object> map, @Param(value = "levels") List<Integer> list);
}