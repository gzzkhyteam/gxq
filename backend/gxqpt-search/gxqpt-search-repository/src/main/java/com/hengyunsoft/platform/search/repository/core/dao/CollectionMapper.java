package com.hengyunsoft.platform.search.repository.core.dao;

import com.hengyunsoft.platform.search.entity.core.po.Collection;
import com.hengyunsoft.platform.search.entity.core.po.OptClollection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.search.entity.core.po.Collection, com.hengyunsoft.platform.search.repository.core.example.CollectionExample> {

    List<OptClollection> getAllOptByAppId(String appId);//如果多个参数用@Param("appId")指定参数名称


    List<OptClollection> getAllCanWrite(String appId);


    List<OptClollection> getAllCanRead(String appId);


}