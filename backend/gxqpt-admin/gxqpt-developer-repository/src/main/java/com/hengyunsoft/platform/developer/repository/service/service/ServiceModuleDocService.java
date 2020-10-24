package com.hengyunsoft.platform.developer.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModuleDoc;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleDocExample;

import java.util.List;

/**
 * 描述:帮助文档Service
 * @author chb
 * @date 2018/4/2 14:41 
 */
public interface ServiceModuleDocService extends BaseService<Long, ServiceModuleDoc, ServiceModuleDocExample> {
    List<ServiceModuleDoc> getByModuleId(Long moduleId);
}
