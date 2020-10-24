package com.hengyunsoft.platform.search.repository.developer.dao;

import com.hengyunsoft.platform.search.entity.core.po.ServiceModuleDoc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceModuleDocMapper{
    List<ServiceModuleDoc> selectAll();
}