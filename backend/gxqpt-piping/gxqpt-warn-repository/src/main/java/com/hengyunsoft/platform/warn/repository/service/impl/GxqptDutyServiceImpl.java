package com.hengyunsoft.platform.warn.repository.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
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
import com.hengyunsoft.platform.warn.repository.dao.GxqptDutyMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptDutyExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptDutyService;

@Service
public class GxqptDutyServiceImpl extends BaseAllServiceImpl<Long, GxqptDuty, GxqptDutyExample> implements GxqptDutyService {

    @Autowired
    private GxqptDutyMapper gxqptDutyMapper;

    @Override
    protected BaseNormalDao<Long, GxqptDuty, GxqptDutyExample> getDao() {
        return gxqptDutyMapper;
    }
    
    @Override
	public List<WarnPersonalCountDO> getCountByDepartment(WarnParamDO warnParamDTO) {
		return gxqptDutyMapper.getCountByDepartment(warnParamDTO);
	}

	@Override
	public List<WarnDepartmentCountDO> getDepartmentByCompany(WarnParamDO warnParamDTO) {
		return gxqptDutyMapper.getDepartmentByCompany(warnParamDTO);
	}

	@Override
	public List<WarnAppCountDO> getByApp(WarnParamDO warnParamDTO) {
		return gxqptDutyMapper.getByApp(warnParamDTO);
	}
    /**
     * 数博会部门、预警、应用关系
     * @return
     */
	@Override
	public List<FairRelationshipDO> getRelationshipApp(GxqptSendee gxqptSendee) {
		//查询当前登录人所在的部门的体系
		return gxqptDutyMapper.getRelationshipApp(gxqptSendee);
	}
    /**
     * 数博会部门、预警、应用关系
     * @return
     */
	@Override
	public List<FairDepartmentDO> getRelationship(Date thisTime) {
		return gxqptDutyMapper.getRelationship(thisTime);
	}
	/**
     * 数博会统各应用预警数量
     * @return
     */
	@Override
	public List<WarnAppCountDO> getInnerAppByAppId() {
		return gxqptDutyMapper.getInnerAppByAppId();
	}
    /**
     * 数博会统各应用预警数量
     * @return
     */
	@Override
	public List<WarnAppCountDO> getOuterAppByAppId() {
		return gxqptDutyMapper.getOuterAppByAppId();
	}

	/**
	 * 根据单位id集合查询各个单位未处理预警的信息
	 * @param map
	 * @return
	 */
	@Override
	public List findSurvey(Map map) {
		return gxqptDutyMapper.findSurvey(map);
	}
    /**
     * 获取部门预警列表
     * @return
     */
	@Override
	public List<DepSurveyResDTO> getDepartmentWarns(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getDepartmentWarns(surveyReqDTO);
	}

	/**
	 * 根据机构id集合查询各个机构未处理预警的数量（公用）
	 * @param map
	 * @return
	 */
	@Override
	public List findPublicSuperviseStatus(Map<String, Object> map) {
		return gxqptDutyMapper.findPublicSuperviseStatus(map);
	}
	/**
     * 获取部门预警类别列表
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypesResDTO> getDepartmentWarnTypes(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getDepartmentWarnTypes(surveyReqDTO);
	}
    /**
     * 单个部门预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypeResDTO> getWarnTypes(DepWarnCheckDTO depWarnTypeCheckDTO) {
		return gxqptDutyMapper.getWarnTypes(depWarnTypeCheckDTO);
	}
    /**
     * 单个部门预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<DepWarnLevelResDTO> getWarnLevels(DepWarnCheckDTO depWarnCheckDTO) {
		return gxqptDutyMapper.getWarnLevels(depWarnCheckDTO);
	}
	/**
     * 获取各部门预警级别列表
     * @return
     */
	@Override
	public List<WarnLevelResDTO> getDepartmentWarnLevels(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getDepartmentWarnLevels(surveyReqDTO);
	}
	/**
     * 获取各人员预警级别列表
     * @return
     */
	@Override
	public List<EmpsWarnLevelResDTO> getEmpWarnLevels(EmpSurveyReqDTO empSurveyReqDTO) {
		return gxqptDutyMapper.getEmpWarnLevels(empSurveyReqDTO);
	}
    /**
     * 获取各人员预警类别列表
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypesResDTO> getEmpWarnTypes(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getEmpsWarnTypes(surveyReqDTO);
	}
    /**
     * 单个人员预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<EmpWarnTypeResDTO> getWarnTypes(EmpWarnCheckDTO empWarnTypeCheckDTO) {
		return gxqptDutyMapper.getEmpWarnTypes(empWarnTypeCheckDTO);
	}
    /**
     * 单个人员预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<EmpWarnLevelResDTO> getWarnLevels(EmpWarnCheckDTO empWarnCheckDTO) {
		return gxqptDutyMapper.getEmpWarnLevel(empWarnCheckDTO);
	}
	/**
	 * 公用查询处理时长
	 * @param map
	 * @return
	 */
	@Override
	public List findPublicHandle(Map<String, Object> map) {
		return gxqptDutyMapper.findPublicHandle(map);
	}
	/**
	 * 公用查询预警级别
	 * @param map
	 * @return
	 */
	@Override
	public List findPublicLevel(Map<String, Object> map) {
		return gxqptDutyMapper.findPublicLevel(map);
	}

	/**
	 * 公用查询对比分析
	 * @param map
	 * @return
	 */
	@Override
	public List findPublicContrast(Map<String, Object> map) {
		return gxqptDutyMapper.findPublicContrast(map);
	}
    /**
     * 获取单位预警类别列表
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypesResDTO> getOrgartmentWarnTypes(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getOrgartmentWarnTypes(surveyReqDTO);
	}
	/**
     * 获取部门预警级别列表
     * @return
     */
	@Override
	public List<WarnLevelResDTO> getOrgartmentWarnLevels(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getOrgartmentWarnLevels(surveyReqDTO);
	}
    /**
     * 单个单位预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypeResDTO> getOrgWarnTypes(OrgWarnCheckDTO orgWarnCheckDTO) {
		return gxqptDutyMapper.getOrgWarnTypes(orgWarnCheckDTO);
	}
    /**
     * 单个单位预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnLevelResDTO> getOrgWarnLevels(OrgWarnCheckDTO orgWarnCheckDTO) {
		return gxqptDutyMapper.getOrgWarnLevels(orgWarnCheckDTO);
	}
    /**
     * 获取各应用预警类别列表
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypesResDTO> getAppWarnTypes(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getAppsWarnTypes(surveyReqDTO);
	}
	/**
     * 获取各应用预警级别列表
     * @return
     */
	@Override
	public List<WarnLevelResDTO> getAppWarnLevels(SurveyReqDTO surveyReqDTO) {
		return gxqptDutyMapper.getAppsWarnLevels(surveyReqDTO);
	}

	@Override
	public List<WarnTypeResDTO> getAppWarnTypes(AppWarnCheckDTO appWarnCheckDTO) {
		return gxqptDutyMapper.getAppWarnTypes(appWarnCheckDTO);
	}

	@Override
	public List<DepWarnLevelResDTO> getAppWarnLevels(AppWarnCheckDTO appWarnCheckDTO) {
		return gxqptDutyMapper.getAppWarnLevels(appWarnCheckDTO);
	}

	/**
	 * 关联规则挖掘
	 * @param map
	 * @return
	 */
	@Override
	public List<GxqptPublicRulesDO> findAssociationRules(Map<String, Object> map) {
		return gxqptDutyMapper.findAssociationRules(map);
	}

	/**
	 * 关联规则挖掘(子)
	 * @param map
	 * @return
	 */
	@Override
	public List<GxqptPublicRulesDO> findAssociationChildRules(Map<String, Object> map) {
		return gxqptDutyMapper.findAssociationChildRules(map);
	}
    /**
     * 全部应用预警类型平均值统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<WarnTypeResDTO> getAppWarnTypeAvg(AppWarnCheckDTO appWarnCheckDTO) {
		return gxqptDutyMapper.getAppWarnTypeAvg(appWarnCheckDTO);
	}
    /**
     * 全部应用预警级别平均值统计分析
     * @param surveyReqDTO
     * @return
     */
	@Override
	public List<DepWarnLevelResDTO> getAppWarnLevelAvg(AppWarnCheckDTO appWarnCheckDTO) {
		return gxqptDutyMapper.getAppWarnLevelAvg(appWarnCheckDTO);
	}

	/**
	 * 公用查询对比分析(级别)
	 * @param map
	 * @return
	 */
	@Override
	public List<GxqptPublicContrastLevelDO> findPublicContrastLevel(Map<String, Object> map, List<Integer> list) {
		return gxqptDutyMapper.findPublicContrastLevel(map, list);
	}


}
