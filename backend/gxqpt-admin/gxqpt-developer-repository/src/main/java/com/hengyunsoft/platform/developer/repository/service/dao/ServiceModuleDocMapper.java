package com.hengyunsoft.platform.developer.repository.service.dao;

import com.hengyunsoft.platform.developer.entity.service.po.ServiceModuleDoc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceModuleDocMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.developer.entity.service.po.ServiceModuleDoc, com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleDocExample> {
    List<ServiceModuleDoc> getByModuleId(Long moduleId);
}