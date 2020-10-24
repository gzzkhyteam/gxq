package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetDirElement;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetDirElementMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetDirElementExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetDirElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetDirElementServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetDirElement, ShareDataSetDirElementExample> implements ShareDataSetDirElementService {
    @Autowired
    private ShareDataSetDirElementMapper shareDataSetDirElementMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetDirElement, ShareDataSetDirElementExample> getDao() {
        return shareDataSetDirElementMapper;
    }

    @Override
    public Map<Long, ShareDataSetDirElement> getShareDataSetDirElementBySdid(long sdId) {
        ShareDataSetDirElementExample example = new ShareDataSetDirElementExample();
        ShareDataSetDirElementExample.Criteria criteria = example.createCriteria().andSdIdEqualTo(sdId);
        List<ShareDataSetDirElement> shareDataSetDirElements = find(example);
        Map<Long, ShareDataSetDirElement> map = new HashMap<>();
        for (ShareDataSetDirElement sdds : shareDataSetDirElements) {
            map.put(sdds.getDirFieldId(), sdds);
        }
        return map;
    }

    @Override
    public void deleteBySetId(Long setId) {
        shareDataSetDirElementMapper.deleteBySetId(setId);
    }

    @Override
    public Map<Long, ShareDataSetDirElement> getShareDataSetDirElementBySetId(long setId) {
        ShareDataSetDirElementExample example = new ShareDataSetDirElementExample();
        example.createCriteria().andSetIdEqualTo(setId);
        List<ShareDataSetDirElement> shareDataSetDirElements = find(example);
        Map<Long, ShareDataSetDirElement> map = new HashMap<>();
        for (ShareDataSetDirElement sdds : shareDataSetDirElements) {
            map.put(sdds.getDirFieldId(), sdds);
        }
        return map;
    }

    @Override
    public Map<Long,ShareDataSetDirElement> getShareDataSetDirElementBySetIdAndDirId(long setId, long dirId) {
        ShareDataSetDirElementExample example = new ShareDataSetDirElementExample();
        example.createCriteria().andSetIdEqualTo(setId).andDirIdEqualTo(dirId);
        List<ShareDataSetDirElement> shareDataSetDirElements = find(example);
        Map<Long,ShareDataSetDirElement> map = new HashMap<>();
        for(ShareDataSetDirElement sdd:shareDataSetDirElements){
            map.put(sdd.getDirFieldId(),sdd);
        }
        return map;
    }

}
