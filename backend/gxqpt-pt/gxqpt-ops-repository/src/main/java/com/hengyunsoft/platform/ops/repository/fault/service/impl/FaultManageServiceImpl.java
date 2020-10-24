package com.hengyunsoft.platform.ops.repository.fault.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.fault.domain.FaultMonitoringDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.FaultReportTopDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.OperationReportDO;
import com.hengyunsoft.platform.ops.entity.fault.domain.ReportTopDO;
import com.hengyunsoft.platform.ops.entity.fault.po.FaultManage;
import com.hengyunsoft.platform.ops.repository.fault.dao.FaultManageMapper;
import com.hengyunsoft.platform.ops.repository.fault.example.FaultManageExample;
import com.hengyunsoft.platform.ops.repository.fault.service.FaultManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FaultManageServiceImpl extends BaseServiceImpl<Long,FaultManage,FaultManageExample> implements FaultManageService {
    @Autowired
    private FaultManageMapper faultManageMapper;
    @Override
    protected BaseNormalDao<Long, FaultManage, FaultManageExample> getDao() {
        return faultManageMapper;
    }


    @Override
    public List<FaultManage> getPageList(Map map) {
        return faultManageMapper.getPageList(map);
    }

    @Override
    public List<FaultManage> pageMyFaultList(Map map) {
        return faultManageMapper.pageMyFaultList(map);
    }

    @Override
    public List<FaultManage> pageKnowledgeBase(Map map) {
        return faultManageMapper.pageKnowledgeBase(map);
    }

    @Override
    public Date findMaxHappenTime() {
        return faultManageMapper.findMaxHappenTime();
    }

    @Override
    public Date findMinHappenTime() {
        return faultManageMapper.findMinHappenTime();
    }

    @Override
    public FaultMonitoringDO findCountAndHour() {
        return faultManageMapper.findCountAndHour();
    }

    @Override
    public List<OperationReportDO> getReport() {
        return faultManageMapper.getReport();
    }

    @Override
    public List<OperationReportDO> getWclReport() {
        return faultManageMapper.getWclReport();
    }

    @Override
    public List<ReportTopDO> getReportTop() {
        return faultManageMapper.getReportTop();
    }

    @Override
    public List<OperationReportDO> getYearServiceReport() {
        return faultManageMapper.getYearServiceReport();
    }

    @Override
    public List<OperationReportDO> getYearFaultReport() {
        return faultManageMapper.getYearFaultReport();
    }

    @Override
    public List<OperationReportDO> getMonthFaultReport() {
        return faultManageMapper.getMonthFaultReport();
    }

    @Override
    public List<FaultReportTopDO> getFaultReportTop() {
        return faultManageMapper.getFaultReportTop();
    }

    @Override
    public FaultManage findMaxHappenTimeEntity(String systemId) {
        return faultManageMapper.findMaxHappenTimeEntity(systemId);
    }

    @Override
    public Integer getApplicationRatioSum(List<String> appIdList, Date startDate, Date endDate) {
        String[] strings = new String[appIdList.size()];
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("appIdList",appIdList.toArray(strings));
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return faultManageMapper.getApplicationRatioSum(map);
    }
}
