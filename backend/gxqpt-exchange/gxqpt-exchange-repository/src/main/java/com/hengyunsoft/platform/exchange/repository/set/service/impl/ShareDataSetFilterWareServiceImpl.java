package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetFilterWare;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetFilterWareMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetFilterWareExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetFilterWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetFilterWareServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetFilterWare, ShareDataSetFilterWareExample> implements ShareDataSetFilterWareService {
    @Autowired
    private ShareDataSetFilterWareMapper shareDataSetFilterWareMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetFilterWare, ShareDataSetFilterWareExample> getDao() {
        return shareDataSetFilterWareMapper;
    }

    @Override
    public Map<String, ShareDataSetFilterWare> getShareDataSetFilterMap(long setId) {
        ShareDataSetFilterWareExample sdsee = new ShareDataSetFilterWareExample();
        ShareDataSetFilterWareExample.Criteria sdseec = sdsee.createCriteria();
        sdseec.andSetIdEqualTo(setId);
        List<ShareDataSetFilterWare> shareDataSetFilters = find(sdsee);
        Map<String, ShareDataSetFilterWare> map = new HashMap<>();
        for (ShareDataSetFilterWare sd : shareDataSetFilters) {
            map.put(sd.getFieldCode(), sd);
        }
        return map;
    }

    @Override
    public void batchInsert(List<ShareDataSetFilterWare> list) {
        if (list != null && list.size() > 0) {
            shareDataSetFilterWareMapper.batchInsert(list);
        }
    }
}
