package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.system.domain.DictDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareDict;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareDictMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareDictExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @todo 数据字典service
 * @author wt
 * @createtime 2018-4-23
 */
@Service
public class ShareDictServiceImpl extends BaseAllServiceImpl<Long,ShareDict,ShareDictExample> implements ShareDictService{
    @Autowired
    ShareDictMapper shareDictMapper;
    @Override
    protected BaseNormalDao<Long, ShareDict,ShareDictExample> getDao() {
        return shareDictMapper;
    }

    @Override
    public List<DictDO> queryDict(String pId) {
        return shareDictMapper.queryDict(pId);
    }

    @Override
    public Integer getCurrIndexNo() { return shareDictMapper.getCurrIndexNo(); }

    @Override
    public Integer getPidCurrLevel(String pId) { return shareDictMapper.getPidCurrLevel(pId); }
}
