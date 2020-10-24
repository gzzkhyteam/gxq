package com.hengyunsoft.platform.developer.repository.service.dao;

import com.hengyunsoft.platform.developer.entity.service.po.ServiceResourceDoc;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceResourceDocMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.service.po.ServiceResourceDoc, com.hengyunsoft.platform.developer.repository.service.example.ServiceResourceDocExample> {
    ServiceResourceDoc getByModuleId(Long moduleId);
}