package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitorReport;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example.EquipmentMonitorReportExample;

@Repository
public interface EquipmentMonitorReportMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, EquipmentMonitorReport, EquipmentMonitorReportExample> {
	/**
	 * 查询设备监控>报告数据列表
	 * @param emr
	 * @return
	 */
	List pageNewest(@Param(value = "emr")EquipmentMonitorReport emr);
}