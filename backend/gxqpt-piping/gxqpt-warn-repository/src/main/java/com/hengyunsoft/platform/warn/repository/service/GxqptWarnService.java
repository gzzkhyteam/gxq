package com.hengyunsoft.platform.warn.repository.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.dto.analysis.PublicSurveyListReqDTO;
import com.hengyunsoft.platform.warn.entity.domain.*;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarn;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GxqptWarnService extends BaseService<Long, GxqptWarn, GxqptWarnExample> {
	/**
	 * 部门预警状态分析
	 * @param warnParamDTO
	 * @return
	 */
	List<WarnStatusCountDO> getStatusByCompany(WarnParamDO warnParamDTO);

	/**
	 * 应用预警状态分析
	 * @param warnParamDTO
	 * @return
	 */
	List<WarnStatusCountDO> getStatusByApp(WarnParamDO warnParamDTO);

	/**
	 * 个人预警状态分析
	 * @param warnParamDTO
	 * @return
	 */
	List<WarnStatusCountDO> getStatusByPersonal(WarnParamDO warnParamDTO);

	/**
	 * 个人预警处理效率分析
	 * @param warnParamDTO
	 * @return
	 */
	List<WarnPersonalCountDO> getHandleByPersonal(WarnParamDO warnParamDTO);

	/**
	 * 部门预警处理效率分析
	 * @param warnParamDTO
	 * @return
	 */
	List<WarnDepartmentCountDO> getHandleByCompany(WarnParamDO warnParamDTO);

	/**
	 * 应用预警处理效率分析
	 * @param warnParamDTO
	 * @return
	 */
	List<WarnAppCountDO> getHandleByApp(WarnParamDO warnParamDTO);

	/**
	 * 预警台账分页查询
	 * @param queryWarnDTO
	 * @return
	 */
	List<GxqptWarnPagingDO> findList (QueryWarnDO queryWarnDO);

	/**
	 * 根据当前用户查询用户所接收到的预警台账信息
	 * @param userId
	 * @return
	 */
	List<GxqptWarnPagingDO> findWarnList (Long userId);
	/**
	 * 预警处理台账分页查询
	 * @param gxqptWarnDTO
	 * @return
	 */
	List<GxqptWarnHandlePagingDO> findHandleList (QueryWarnHandleDO queryWarnHandleDO);

	/**
	 * 根据查询条件查询预警处理台账信息
	 * @return
	 */
	List<GxqptWarnHandlePagingDO> findWarnHandleList (List<Long> warnId);
	/**
	 * 根据查询条件查询预警处理台账信息
	 * @param gxqptWarnDTO
	 * @return
	 */
	List<GxqptWarnResultPagingDO> findResultList (QueryWarnResultDO queryWarnResultDO);

	/**
	 * 查询预警处理结果台账
	 * @return
	 */
	List<GxqptWarnResultPagingDO> findWarnResultList (Long userId);
    /**
     * 数博会统计各状态预警数量
     * @return
     */
	List<FairWarnStatusCountDO> getNumberByAppId(String appid);
    /**
     * 数博会统计各级别预警数量
     * @return
     */
	List<FairWarnLevelCountDO> getLevelByAppId(String appid);
    /**
     * 数博会统计各类型预警数量
     * @return
     */
	List<FairWarnCountDO> getTypeByAppId(String appid);
    /**
     * 数博会获取本月新增、已处理、未处理预警数量
     * @return
     */
	List<FairWarnNumberCountDO> getNewCome(Date beforeTime,Date thisTime);
    /**
     * 获取单位本月新增、已处理、未处理预警数量
     * @return
     */
	List<ObjectWarnCountDO> getOrgWarns(Date beforeTime,Date thisTime);	
    /**
     * 获取部门本月新增、已处理、未处理预警数量
     * @return
     */
	List<ObjectWarnCountDO> getDepWarns(Date beforeTime,Date thisTime);
    /**
     * 获取人员本月新增、已处理、未处理预警数量
     * @return
     */
	List<ObjectWarnCountDO> getEmpWarns(Date beforeTime,Date thisTime);

	/**
	 * 关键内容TOP10
	 * @param map
	 * @return
	 */
	List findContentTop(Map<String, Object> map);

	/**
	 * 个人预警级别情况查询
	 * @return
	 */
	List<WarnLevelDO> findLevelCount(Long userId);

	List<EmpWarnTypeResDO> findWarnType(Long userId);

	/**
	 * @method
	 * @description 查找预警分值前top 10
	 * @date: 2019/5/6 0006 12:45
	 * @author: mdengb
	 * @param surveyReqDTO
	 * @return
	 */
	List<GxqptPublicTopContentDO> findContentTenTop(PublicSurveyListReqDTO surveyReqDTO);
}
