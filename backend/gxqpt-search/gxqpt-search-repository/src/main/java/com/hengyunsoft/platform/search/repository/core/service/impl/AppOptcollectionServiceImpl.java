package com.hengyunsoft.platform.search.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.search.entity.core.po.AppOptCollection;
import com.hengyunsoft.platform.search.repository.core.dao.AppOptCollectionMapper;
import com.hengyunsoft.platform.search.repository.core.example.AppOptCollectionExample;
import com.hengyunsoft.platform.search.repository.core.service.AppOptcollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppOptcollectionServiceImpl extends BaseServiceImpl<Long, AppOptCollection, AppOptCollectionExample> implements AppOptcollectionService {
    @Autowired
    private AppOptCollectionMapper appOptCollectionMapper;

    @Override
    protected BaseNormalDao<Long, AppOptCollection, AppOptCollectionExample> getDao() {
        return appOptCollectionMapper;
    }

    @Override
    public void saveOrUpdate(AppOptCollection appOptCollection) {
        appOptCollectionMapper.saveOrUpdate(appOptCollection);
    }

    @Override
    public List<AppOptCollection> getByAppIdAndCollectionid(Long collectionId, String appId) {
        AppOptCollectionExample ac = new AppOptCollectionExample();
        AppOptCollectionExample.Criteria criteria = ac.createCriteria();
        criteria.andCollectionIdEqualTo(collectionId);
        criteria.andAppIdEqualTo(appId);
        return appOptCollectionMapper.selectByExample(ac);
    }

    @Override
    public List<AppOptCollection> getByCollectionid(Long collectionId) {
        AppOptCollectionExample ac = new AppOptCollectionExample();
        AppOptCollectionExample.Criteria criteria = ac.createCriteria();
        criteria.andCollectionIdEqualTo(collectionId);
        return appOptCollectionMapper.selectByExample(ac);
    }
}
