package com.hengyunsoft.platform.warn.repository.dao;

import com.hengyunsoft.platform.supervise.dto.analysis.PublicSurveyListReqDTO;
import com.hengyunsoft.platform.warn.entity.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Repository
public interface GxqptWarnMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.warn.entity.po.GxqptWarn, com.hengyunsoft.platform.warn.repository.example.GxqptWarnExample> {

    /**
     * 部门预警状态分析
     * @param warnParamDTO
     * @return
     */
    List<WarnStatusCountDO> getStatusByCompany(@Param("warnParamDTO")WarnParamDO warnParamDTO);

    /**
     * 应用预警状态分析
     * @param warnParamDTO
     * @return
     */
    List<WarnStatusCountDO> getStatusByApp(@Param("warnParamDTO")WarnParamDO warnParamDTO);

    /**
     * 个人预警状态分析
     * @param warnParamDTO
     * @return
     */
    List<WarnStatusCountDO> getStatusByPersonal(@Param("warnParamDTO")WarnParamDO warnParamDTO);

    /**
     * 个人预警处理效率分析
     * @param warnParamDTO
     * @return
     */
    List<WarnPersonalCountDO> getHandleByPersonal(@Param("warnParamDTO")WarnParamDO warnParamDTO);

    /**
     * 部门预警处理效率分析
     * @param warnParamDTO
     * @return
     */
    List<WarnDepartmentCountDO> getHandleByCompany(@Param("warnParamDTO")WarnParamDO warnParamDTO);

    /**
     * 应用预警处理效率分析
     * @param warnParamDTO
     * @return
     */
    List<WarnAppCountDO> getHandleByApp(@Param("warnParamDTO")WarnParamDO warnParamDTO);

    /**
     * 预警台账分页查询
     * @param
     * @return
     */
    List<GxqptWarnPagingDO> findList (@Param("queryWarnDO")QueryWarnDO queryWarnDO);

    /**
     * 根据当前用户查询用户所接收到的预警台账信息
     * @param userId
     * @return
     */
    List<GxqptWarnPagingDO> findWarnList (@Param(value = "userId") Long userId);

    /**
     * 预警处理台账台账分页查询
     * @param
     * @return
     */
    List<GxqptWarnHandlePagingDO> findHandleList (@Param("queryWarnHandleDO")QueryWarnHandleDO queryWarnHandleDO);

    /**
     * 根据查询条件查询预警处理台账信息
     * @param
     * @return
     */
    List<GxqptWarnHandlePagingDO> findWarnHandleList (@Param(value = "warnId") List<Long> warnId);
    /**
     * 预警处理结果台账分页查询
     * @param
     * @return
     */
    List<GxqptWarnResultPagingDO> findResultList (@Param("queryWarnResultDO") QueryWarnResultDO queryWarnResultDO);

    /**
     * 根据查询条件查询预警处理台账信息
     * @return
     */
    List<GxqptWarnResultPagingDO> findWarnResultList (@Param(value = "userId") Long userId);

    /**
     * 数博会统计各状态预警数量
     * @return
     */
    List<FairWarnStatusCountDO> getNumberByAppId(@Param(value = "appid")String appid);
    /**
     * 数博会统计各级别预警数量
     * @return
     */
    List<FairWarnLevelCountDO> getLevelByAppId(@Param(value = "appid")String appid);
    /**
     * 数博会统计各类型预警数量
     * @return
     */
    List<FairWarnCountDO> getTypeByAppId(@Param(value = "appid")String appid);
    /**
     * 数博会获取本月新增、已处理、未处理预警数量
     * @return
     */
    List<FairWarnNumberCountDO> getNewCome(@Param(value = "beforeTime")Date beforeTime, @Param(value = "thisTime")Date thisTime);
    /**
     * 获取单位本月新增、已处理、未处理预警数量
     * @return
     */
    List<ObjectWarnCountDO> getOrgWarns(@Param(value = "beforeTime")Date beforeTime,@Param(value = "thisTime")Date thisTime);
    /**
     * 获取部门本月新增、已处理、未处理预警数量
     * @return
     */
    List<ObjectWarnCountDO> getDepWarns(@Param(value = "beforeTime")Date beforeTime,@Param(value = "thisTime")Date thisTime);
    /**
     * 获取人员本月新增、已处理、未处理预警数量
     * @return
     */
    List<ObjectWarnCountDO> getEmpWarns(@Param(value = "beforeTime")Date beforeTime, @Param(value = "thisTime")Date thisTime);
    /**
     * 获取预警台账分页列表
     * @param
     * @return
     */
    List<QueryWarnLedgerResDO> getWarnLedgerList(@Param(value = "warnLedgerPagingReqDO") WarnLedgerPagingReqDO warnLedgerPagingReqDO);

    /**
     * 获取预警处理台账分页列表
     * @param
     * @return
     */
    List<QueryWarnHandleLedgerResDO> getWarnHandleLedgerList(@Param(value = "warnLedgerHandlePagingReqDO") WarnLedgerHandlePagingReqDO warnLedgerHandlePagingReqDO);

    /**
     * 获取预警处理结果台账分页列表
     * @param
     * @return
     */
    List<QueryWarnHandleResultLedgerResDO> getWarnHandleResultLedgerList(@Param(value = "warnLedgerHandleResultPagingReqDO") WarnLedgerHandleResultPagingReqDO warnLedgerHandleResultPagingReqDO);

    /**
     * 关键内容TOP
     * @param map
     * @return
     */
    List findContentTop(@Param(value = "map") Map<String, Object> map);

    List<WarnLevelDO> findLevelCount(@Param(value = "userId") Long userId);

    List<EmpWarnTypeResDO> findWarnType(@Param(value = "userId") Long userId);

    /**
     * @method
     * @description 查找预警分值前top 10
     * @date: 2019/5/6 0006 12:45
     * @author: mdengb
     * @param surveyReqDTO
     * @return
     */
    List<GxqptPublicTopContentDO> findContentTenTop( @Param(value = "surveyReqDTO") PublicSurveyListReqDTO surveyReqDTO);
}