package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitor;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.dao.EquipmentMonitorMapper;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example.EquipmentMonitorExample;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service.EquipmentMonitorService;

@Service
public class EquipmentMonitorServiceImpl extends BaseServiceImpl<Long, EquipmentMonitor,EquipmentMonitorExample> implements EquipmentMonitorService {

    @Autowired
    EquipmentMonitorMapper equipmentMonitorMapper;

    @Override
    protected BaseNormalDao<Long, EquipmentMonitor,EquipmentMonitorExample> getDao() {
        return equipmentMonitorMapper;
    }
    /**
     * 查询设备监控数据分页
     * @param obj
     * @return
     */
	@Override
	public List pageNewest(EquipmentMonitor dto) {
		
		return equipmentMonitorMapper.pageNewest(dto);
	}
}
