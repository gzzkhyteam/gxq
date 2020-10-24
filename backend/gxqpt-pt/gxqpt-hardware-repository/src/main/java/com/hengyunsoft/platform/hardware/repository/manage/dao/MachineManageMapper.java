package com.hengyunsoft.platform.hardware.repository.manage.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface MachineManageMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.hardware.entity.manage.po.MachineManage, com.hengyunsoft.platform.hardware.repository.manage.example.MachineManageExample> {
    /**
     * 删除数据
     * @param applyKeyid
     * @return
     */
    int deleteByApplyKeyid(Long applyKeyid);
}