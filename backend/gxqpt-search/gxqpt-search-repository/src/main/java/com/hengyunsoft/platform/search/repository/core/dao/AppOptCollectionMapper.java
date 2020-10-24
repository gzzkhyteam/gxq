package com.hengyunsoft.platform.search.repository.core.dao;

import com.hengyunsoft.platform.search.entity.core.po.AppOptCollection;
import org.springframework.stereotype.Repository;

@Repository
public interface AppOptCollectionMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.search.entity.core.po.AppOptCollection, com.hengyunsoft.platform.search.repository.core.example.AppOptCollectionExample> {
    void saveOrUpdate(AppOptCollection appOptCollection);
}