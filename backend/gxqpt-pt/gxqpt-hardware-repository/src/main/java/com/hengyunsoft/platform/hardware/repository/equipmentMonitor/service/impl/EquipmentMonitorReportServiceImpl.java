package com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitorReport;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.dao.EquipmentMonitorReportMapper;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.example.EquipmentMonitorReportExample;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service.EquipmentMonitorReportService;

@Service
public class EquipmentMonitorReportServiceImpl extends BaseServiceImpl<Long, EquipmentMonitorReport,EquipmentMonitorReportExample> implements EquipmentMonitorReportService {

    @Autowired
    EquipmentMonitorReportMapper equipmentMonitorReportMapper;

    @Override
    protected BaseNormalDao<Long, EquipmentMonitorReport,EquipmentMonitorReportExample> getDao() {
    	
        return equipmentMonitorReportMapper;
    }
    /**
     * 查询设备监控>报告数据列表
     */
	@Override
	public List pageNewest(EquipmentMonitorReport emr) {
		
		return equipmentMonitorReportMapper.pageNewest(emr);
	}

}
