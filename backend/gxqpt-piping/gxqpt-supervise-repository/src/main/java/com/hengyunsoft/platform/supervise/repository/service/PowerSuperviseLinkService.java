package com.hengyunsoft.platform.supervise.repository.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseLink;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseLinkExample;

public interface PowerSuperviseLinkService extends BaseService<Long,PowerSuperviseLink,PowerSuperviseLinkExample>{

    /**
     * 根据主配置ID删除子环节
     * @param parentId
     */
    void deleteByParentId(Long parentId);
}
