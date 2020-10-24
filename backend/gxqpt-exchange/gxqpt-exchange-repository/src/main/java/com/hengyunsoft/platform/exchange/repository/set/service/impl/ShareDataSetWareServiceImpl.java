package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetWare;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetWareMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetWareExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareDataSetWareServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetWare, ShareDataSetWareExample> implements ShareDataSetWareService {
    @Autowired
    private ShareDataSetWareMapper shareDataSetWareMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetWare, ShareDataSetWareExample> getDao() {
        return shareDataSetWareMapper;
    }

    @Override
    public void insert(ShareDataSetWare entity) {
        shareDataSetWareMapper.insertSelective(entity);
        //shareDataSetWareMapper.insert(entity);
    }
}
