package com.hengyunsoft.platform.supervise.repository.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.entity.domain.PowerSuperviseTempDO;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseTemp;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTempExample;

import java.util.List;

public interface PowerSuperviseTempService extends BaseService<Long,PowerSuperviseTemp,PowerSuperviseTempExample>{

    /**
     * 获取未发送未处理环节
     * @return
     */
    List<PowerSuperviseTempDO> getNotHandleLink();
}
