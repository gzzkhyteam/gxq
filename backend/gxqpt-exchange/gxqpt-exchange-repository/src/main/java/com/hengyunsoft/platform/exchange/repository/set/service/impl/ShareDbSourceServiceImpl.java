package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.domain.DbSourceDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbSource;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDbSourceMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDbSourceExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDbSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @todo 数据源管理serviceImpl
 * @author wt
 * @createtime 2018-4-23
 */
@Service
public class ShareDbSourceServiceImpl extends BaseAllServiceImpl<Long,ShareDbSource,ShareDbSourceExample> implements ShareDbSourceService{
    @Autowired
    ShareDbSourceMapper shareDbSourceMapper;
    @Override
    protected BaseNormalDao<Long, ShareDbSource,ShareDbSourceExample> getDao() {
        return shareDbSourceMapper;
    }

    @Override
    public List<DbSourceDO> queryDbSourceList(Map<Object, Object> params) {
        return shareDbSourceMapper.queryDbSourceList(params);
    }

    @Override
    public DbSourceDO getDbSourceById(Long id) {
        return shareDbSourceMapper.getDbSourceById(id);
    }
}
