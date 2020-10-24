package com.hengyunsoft.platform.hardware.repository.manage.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.manage.po.MachineManage;
import com.hengyunsoft.platform.hardware.repository.manage.dao.MachineManageMapper;
import com.hengyunsoft.platform.hardware.repository.manage.example.MachineManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.MachineManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineManageServiceImpl extends BaseServiceImpl<Long, MachineManage,MachineManageExample> implements MachineManageService {

    @Autowired
    MachineManageMapper machineManageMapper;

    @Override
    protected BaseNormalDao<Long, MachineManage,MachineManageExample> getDao() {
        return machineManageMapper;
    }

    /**
     * 删除数据
     * @param applyKeyid
     * @return
     */
    @Override
    public int deleteByApplyKeyid(Long applyKeyid) {
        return machineManageMapper.deleteByApplyKeyid(applyKeyid);
    }
}
