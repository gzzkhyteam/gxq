package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitor;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example.EquipmentMonitorExample;

@Repository
public interface EquipmentMonitorMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, EquipmentMonitor, EquipmentMonitorExample> {
	/**
     * 查询设备监控数据分页
     * @param obj
     * @return
     */
	List pageNewest(@Param(value = "dto") EquipmentMonitor dto);
}