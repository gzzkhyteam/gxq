package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitorReport;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example.EquipmentMonitorReportExample;

public interface EquipmentMonitorReportService extends BaseService<Long, EquipmentMonitorReport,EquipmentMonitorReportExample> {
	/**
	 * 查询设备监控>报告数据列表
	 * @param em
	 * @return
	 */
	List pageNewest(EquipmentMonitorReport emr);
   
}
