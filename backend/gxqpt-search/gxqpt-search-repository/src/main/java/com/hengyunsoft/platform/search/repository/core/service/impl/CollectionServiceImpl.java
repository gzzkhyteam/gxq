package com.hengyunsoft.platform.search.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.search.entity.core.po.Collection;
import com.hengyunsoft.platform.search.entity.core.po.OptClollection;
import com.hengyunsoft.platform.search.repository.core.dao.CollectionMapper;
import com.hengyunsoft.platform.search.repository.core.example.CollectionExample;
import com.hengyunsoft.platform.search.repository.core.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl extends BaseServiceImpl<Long, Collection, CollectionExample> implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    protected BaseNormalDao<Long, Collection, CollectionExample> getDao() {
        return collectionMapper;
    }

    @Override
    public Collection getById(long id) {
        return collectionMapper.selectByPrimaryKey(id);
    }

    public List<Collection> getByCode(String code) {
        CollectionExample ce = new CollectionExample();
        CollectionExample.Criteria criteria = ce.createCriteria();
        criteria.andCollectionCodeEqualTo(code);
        List<Collection> list = collectionMapper.selectByExample(ce);
        return list;
    }

    @Override
    public List<OptClollection> getAllOptByAppId(String appId) {
        return collectionMapper.getAllOptByAppId(appId);
    }

    @Override
    public List<OptClollection> getAllCanWrite(String appId) {
        return collectionMapper.getAllCanWrite(appId);
    }

    @Override
    public List<OptClollection> getAllCanRead(String appId) {
        return collectionMapper.getAllCanRead(appId);
    }

    @Override
    public List<Collection> getAll() {
        CollectionExample ce = new CollectionExample();
        return collectionMapper.selectByExample(ce);
    }

    @Override
    public Collection saveCollection(Collection collection) {
        collectionMapper.insertSelective(collection);
        List<Collection> list = getByCode(collection.getCollectionCode());
        return list.get(0);
    }
}
