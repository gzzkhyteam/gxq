package com.hengyunsoft.platform.supervise.repository.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface PowerSuperviseLinkMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseLink, com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseLinkExample> {

    void deleteByParentId(Long parentId);
}