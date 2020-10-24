package com.hengyunsoft.platform.ops.repository.fault.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.fault.domain.FaultMonitoringDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.FaultReportTopDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.OperationReportDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.ReportTopDO;
import com.hengyunsoft.platform.ops.entity.fault.po.FaultManage;
import com.hengyunsoft.platform.ops.repository.fault.example.FaultManageExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FaultManageService extends BaseService<Long,FaultManage,FaultManageExample> {
    /**
     * 查询故障分页信息
     * @param map
     * @return
     */
    List<FaultManage> getPageList(Map map);
    /**
     * 查询我的任务故障信息
     * @param map
     * @return
     */
    List<FaultManage> pageMyFaultList(Map map);
    /**
     * 查询故障知识库分页信息
     * @param map
     * @return
     */
    List<FaultManage> pageKnowledgeBase(Map map);

    /**
     * 查询最新故障产生时间记录
     * @return
     */
     Date findMaxHappenTime();

    /**
     * 查询故障产生时间最早记录
     * @return
     */
     Date findMinHappenTime();


    /**
     *  查询故障数和处理时长
     * @return
     */
    FaultMonitoringDO findCountAndHour();
    /**
     * 查询已处理故障数量分析（年）
     */
    List<OperationReportDO> getReport();

    /**
     * 查询未处理故障数量分析（年）
     */
    List<OperationReportDO> getWclReport();


    /**
     * 查询故障TOP5统计
     * @return
     */
    List<ReportTopDO> getReportTop();


    /**
     * 查询运维服务数量分析（年）
     */
    List<OperationReportDO> getYearServiceReport();

    /**
     * 查询故障数量分析（年）
     */
    List<OperationReportDO> getYearFaultReport();

    /**
     * 查询已处理故障数量分析（年）
     */
    List<OperationReportDO> getMonthFaultReport();



    /**
     * 按应用查询故障TOP5统计
     * @return
     */
    List<FaultReportTopDO> getFaultReportTop();

    /**
     * 按应用查询最新产生的故障
     * @return
     */
   FaultManage findMaxHappenTimeEntity(String systemId);

    /**
     * 获取应用占比数
     * @return
     */
    public Integer getApplicationRatioSum(List<String> appIdList,Date startDate,Date endDate);

}
