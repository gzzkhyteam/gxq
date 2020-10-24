package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.entity.domain.PowerSuperviseTempDO;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseTemp;
import com.hengyunsoft.platform.supervise.repository.dao.PowerSuperviseTempMapper;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTempExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSuperviseTempServiceImpl extends BaseAllServiceImpl<Long,PowerSuperviseTemp,PowerSuperviseTempExample> implements PowerSuperviseTempService {

    @Autowired
    private PowerSuperviseTempMapper mapper;

    @Override
    protected BaseNormalDao<Long, PowerSuperviseTemp, PowerSuperviseTempExample> getDao() {
        return mapper;
    }

    @Override
    public List<PowerSuperviseTempDO> getNotHandleLink() {
        return mapper.getNotHandleLink();
    }
}
