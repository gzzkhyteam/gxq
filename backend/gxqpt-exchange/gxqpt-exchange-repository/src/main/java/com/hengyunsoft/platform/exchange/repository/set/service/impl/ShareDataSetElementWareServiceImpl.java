package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElementWare;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetElementWareMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetElementWareExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetElementWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetElementWareServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetElementWare, ShareDataSetElementWareExample> implements ShareDataSetElementWareService {
    @Autowired
    private ShareDataSetElementWareMapper shareDataSetElementWareMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetElementWare, ShareDataSetElementWareExample> getDao() {
        return shareDataSetElementWareMapper;
    }

    @Override
    public Map<String, ShareDataSetElementWare> getShareDataSetElementBySetId(long setId) {
        ShareDataSetElementWareExample sdsee = new ShareDataSetElementWareExample();
        ShareDataSetElementWareExample.Criteria sdseec = sdsee.createCriteria();
        sdseec.andSetIdEqualTo(setId);
        List<ShareDataSetElementWare> dataSetElements = find(sdsee);
        Map<String, ShareDataSetElementWare> map = new HashMap<>();
        for (ShareDataSetElementWare ele : dataSetElements) {
            map.put(ele.getFieldCode(), ele);
        }
        return map;
    }

    @Override
    public void batchInsert(List<ShareDataSetElementWare> list) {
        if (list != null && list.size() > 0) {
            shareDataSetElementWareMapper.batchInsert(list);
        }
    }
}
