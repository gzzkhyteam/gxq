package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseLink;
import com.hengyunsoft.platform.supervise.repository.dao.PowerSuperviseLinkMapper;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseLinkExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerSuperviseLinkServiceImpl extends BaseAllServiceImpl<Long,PowerSuperviseLink,PowerSuperviseLinkExample> implements PowerSuperviseLinkService{

    @Autowired
    private PowerSuperviseLinkMapper mapper;

    @Override
    protected BaseNormalDao<Long, PowerSuperviseLink, PowerSuperviseLinkExample> getDao() {
        return mapper;
    }

    /**
     * 根据主配置ID删除子环节
     * @param parentId
     */
    @Override
    public void deleteByParentId(Long parentId) {
        mapper.deleteByParentId(parentId);
    }
}
