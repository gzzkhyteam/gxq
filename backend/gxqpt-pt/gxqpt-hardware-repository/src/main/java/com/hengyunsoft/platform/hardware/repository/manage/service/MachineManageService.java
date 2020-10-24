package com.hengyunsoft.platform.hardware.repository.manage.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.manage.po.MachineManage;
import com.hengyunsoft.platform.hardware.repository.manage.example.MachineManageExample;

public interface MachineManageService extends BaseService<Long, MachineManage,MachineManageExample> {
    /**
     * 根据applyKeyid 删除数据
     * @param applyKeyid
     * @return
     */
    int deleteByApplyKeyid(Long applyKeyid);
}

