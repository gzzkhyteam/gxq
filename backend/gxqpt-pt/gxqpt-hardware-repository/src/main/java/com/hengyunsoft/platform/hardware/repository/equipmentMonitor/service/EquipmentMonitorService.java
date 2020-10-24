package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitor;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example.EquipmentMonitorExample;

public interface EquipmentMonitorService extends BaseService<Long, EquipmentMonitor,EquipmentMonitorExample> {
	/**
     * 查询设备监控数据分页
     * @param obj
     * @return
     */
	List pageNewest(EquipmentMonitor dto);
   
}

