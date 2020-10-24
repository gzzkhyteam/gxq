package com.hengyunsoft.platform.warn.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.dto.analysis.PublicSurveyListReqDTO;
import com.hengyunsoft.platform.warn.entity.domain.*;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarn;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GxqptWarnServiceImpl extends BaseAllServiceImpl<Long, GxqptWarn, GxqptWarnExample> implements GxqptWarnService {

    @Autowired
    private GxqptWarnMapper gxqptWarnMapper;

    @Override
    protected BaseNormalDao<Long, GxqptWarn, GxqptWarnExample> getDao() {
        return gxqptWarnMapper;
    }

	/**
	 * 部门预警状态分析
	 * @param warnParamDTO
	 * @return
	 */
	@Override
	public List<WarnStatusCountDO> getStatusByCompany(WarnParamDO warnParamDTO) {
		return gxqptWarnMapper.getStatusByCompany(warnParamDTO);
	}

	/**
	 * 应用预警状态分析
	 * @param warnParamDTO
	 * @return
	 */
	@Override
	public List<WarnStatusCountDO> getStatusByApp(WarnParamDO warnParamDTO) {
		return gxqptWarnMapper.getStatusByApp(warnParamDTO);
	}

	/**
	 * 个人预警状态分析
	 * @param warnParamDTO
	 * @return
	 */
	@Override
	public List<WarnStatusCountDO> getStatusByPersonal(WarnParamDO warnParamDTO) {
		return gxqptWarnMapper.getStatusByPersonal(warnParamDTO);
	}

	/**
	 * 个人预警处理效率分析
	 * @param warnParamDTO
	 * @return
	 */
	@Override
	public List<WarnPersonalCountDO> getHandleByPersonal(WarnParamDO warnParamDTO) {
		return gxqptWarnMapper.getHandleByPersonal(warnParamDTO);
	}

	/**
	 * 部门预警处理效率分析
	 * @param warnParamDTO
	 * @return
	 */
	@Override
	public List<WarnDepartmentCountDO> getHandleByCompany(WarnParamDO warnParamDTO) {
		return gxqptWarnMapper.getHandleByCompany(warnParamDTO);
	}

	/**
	 * 应用预警处理效率分析
	 * @param warnParamDTO
	 * @return
	 */
	@Override
	public List<WarnAppCountDO> getHandleByApp(WarnParamDO warnParamDTO) {
		return gxqptWarnMapper.getHandleByApp(warnParamDTO);
	}

	/**
	 * 预警台账分页查询
	 * @param queryWarnDTO
	 * @return
	 */
	@Override
    public List<GxqptWarnPagingDO> findList(@Param(value = "queryWarnDO") QueryWarnDO queryWarnDO) {
        return gxqptWarnMapper.findList(queryWarnDO);
    }

	/**
	 * 根据当前用户查询用户所接收到的预警台账信息
	 * @param userId
	 * @return
	 */
	@Override
	public List<GxqptWarnPagingDO> findWarnList(Long userId) {
		return gxqptWarnMapper.findWarnList(userId);
	}

	/**
	 * 预警处理台账分页查询
	 * @param queryWarnDTO
	 * @return
	 */
	@Override
	public List<GxqptWarnHandlePagingDO> findHandleList(@Param(value = "queryWarnHandleDTO") QueryWarnHandleDO queryWarnHandleDO) {
		return gxqptWarnMapper.findHandleList(queryWarnHandleDO);
	}

	/**
	 * 根据当前用户查询用户所接收到的预警处理台账信息
	 * @param userId
	 * @return
	 */
	@Override
	public List<GxqptWarnHandlePagingDO> findWarnHandleList(@Param(value = "warnId") List<Long> warnId) {
		return gxqptWarnMapper.findWarnHandleList(warnId);
	}
	/**
	 * 根据查询条件查询预警处理台账信息
	 * @param gxqptWarnDTO
	 * @return
	 */
	public List<GxqptWarnResultPagingDO> findResultList (QueryWarnResultDO queryWarnResultDO){
		return gxqptWarnMapper.findResultList(queryWarnResultDO);
	}

	/**
	 * 查询预警处理结果台账
	 * @return
	 */
	public List<GxqptWarnResultPagingDO> findWarnResultList (Long userId){
		return gxqptWarnMapper.findWarnResultList(userId);
	}

    /**
     * 数博会统计各状态预警数量
     * @return
     */
	@Override
	public List<FairWarnStatusCountDO> getNumberByAppId(String appid) {
		return gxqptWarnMapper.getNumberByAppId(appid);
	}
    /**
     * 数博会统计各级别预警数量
     * @return
     */
	@Override
	public List<FairWarnLevelCountDO> getLevelByAppId(String appid) {
		return gxqptWarnMapper.getLevelByAppId(appid);
	}
    /**
     * 数博会统计各类型预警数量
     * @return
     */
	@Override
	public List<FairWarnCountDO> getTypeByAppId(String appid) {
		return gxqptWarnMapper.getTypeByAppId(appid);
	}   
    /**
     * 数博会获取本月新增、已处理、未处理预警数量
     * @return
     */
	@Override
	public List<FairWarnNumberCountDO> getNewCome(Date beforeTime,Date thisTime) {
		return gxqptWarnMapper.getNewCome(beforeTime,thisTime);
	}
    /**
     * 获取单位本月新增、已处理、未处理预警数量
     * @return
     */
	@Override
	public List<ObjectWarnCountDO> getOrgWarns(Date beforeTime, Date thisTime) {
		return gxqptWarnMapper.getOrgWarns(beforeTime,thisTime);
	}
    /**
     * 获取部门本月新增、已处理、未处理预警数量
     * @return
     */
	@Override
	public List<ObjectWarnCountDO> getDepWarns(Date beforeTime, Date thisTime) {
		return gxqptWarnMapper.getDepWarns(beforeTime,thisTime);
	}
    /**
     * 获取人员本月新增、已处理、未处理预警数量
     * @return
     */
	@Override
	public List<ObjectWarnCountDO> getEmpWarns(Date beforeTime, Date thisTime) {
		return gxqptWarnMapper.getEmpWarns(beforeTime,thisTime);
	}

	/**
	 * 关键内容TOP10
	 * @param map
	 * @return
	 */
	@Override
	public List findContentTop(Map<String, Object> map) {
		return gxqptWarnMapper.findContentTop(map);
	}

	@Override
	public List<WarnLevelDO> findLevelCount(Long userId) {
		return gxqptWarnMapper.findLevelCount(userId);
	}

	@Override
	public List<EmpWarnTypeResDO> findWarnType(Long userId) {
		return gxqptWarnMapper.findWarnType(userId);
	}


	/**
	 * @method
	 * @description 查找预警分值前top 10
	 * @date: 2019/5/6 0006 12:45
	 * @author: mdengb
	 * @param surveyReqDTO
	 * @return
	 */
	@Override
	public List<GxqptPublicTopContentDO> findContentTenTop(PublicSurveyListReqDTO surveyReqDTO) {
		return gxqptWarnMapper.findContentTenTop(surveyReqDTO);
	}
}
