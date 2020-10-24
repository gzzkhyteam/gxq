package com.hengyunsoft.platform.hardware.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyServerDO;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyServer;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyServerExample;

import java.util.List;

public interface ApplyServerService extends BaseService<Long, ApplyServer, ApplyServerExample> {
    int deleteByApplyKeyId(Long id);

    /**
     * 联查操作系统和网络
     * @param id
     * @return
     */
    ApplyServerDO getApplyServerById(Long id);

    List<ApplyServerDO> getApplyServerByApplyKeyId(Long id);
}
