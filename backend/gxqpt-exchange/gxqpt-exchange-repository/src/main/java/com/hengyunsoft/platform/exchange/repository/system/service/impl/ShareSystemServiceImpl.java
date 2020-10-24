package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareSystemMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @todo 系统列表service
 * @author wt
 * @createtime 2018-4-23
 */
@Service
public class ShareSystemServiceImpl extends BaseAllServiceImpl<Long,ShareSystem,ShareSystemExample> implements ShareSystemService {
    @Autowired
    ShareSystemMapper shareSystemMapper;
    @Override
    protected BaseNormalDao<Long, ShareSystem,ShareSystemExample> getDao() {
        return shareSystemMapper;
    }

    @Override
    public List<ShareSystem> findSystemList(String contractor,Integer status,Integer sysArch,String majorData,String sysName,String orgId) {
        return shareSystemMapper.findSystemList(contractor,status,sysArch,majorData,sysName,orgId);
    }
}
