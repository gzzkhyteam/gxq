package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElement;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetElementMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetElementExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetElementServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetElement, ShareDataSetElementExample> implements ShareDataSetElementService {

    @Autowired
    private ShareDataSetElementMapper shareDataSetElementMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetElement, ShareDataSetElementExample> getDao() {
        return shareDataSetElementMapper;
    }

    @Override
    public Map<String, ShareDataSetElement> getShareDataSetElementBySetId(long setId) {
        ShareDataSetElementExample sdsee = new ShareDataSetElementExample();
        ShareDataSetElementExample.Criteria sdseec = sdsee.createCriteria();
        sdseec.andSetIdEqualTo(setId);
        List<ShareDataSetElement> dataSetElements = find(sdsee);
        Map<String, ShareDataSetElement> map = new HashMap<>();
        for (ShareDataSetElement ele : dataSetElements) {
            map.put(ele.getFieldCode(), ele);
        }
        return map;
    }

    @Override
    public List<ShareDataSetElement> getAllBySetIdAndOpt(long setId, int optType) {
        ShareDataSetElementExample example = new ShareDataSetElementExample();
        ShareDataSetElementExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId).andOptTypeEqualTo(optType);
        return find(example);
    }

    @Override
    public List<ShareDataSetElement> getAllBySetIdCanUse(long setId) {
        ShareDataSetElementExample example = new ShareDataSetElementExample();
        ShareDataSetElementExample.Criteria criteria = example.createCriteria();
        criteria.andOptTypeNotEqualTo(3).andSetIdEqualTo(setId);
        return find(example);
    }
}
