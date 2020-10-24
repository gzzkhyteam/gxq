package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataFile;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataFileMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataFileExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataFileServiceImpl extends BaseAllServiceImpl<Long, ShareDataFile, ShareDataFileExample> implements ShareDataFileService {
    @Autowired
    private ShareDataFileMapper shareDataFileMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataFile, ShareDataFileExample> getDao() {
        return shareDataFileMapper;
    }

    @Override
    public Map<Long, ShareDataFile> getShareDataFileBySetId(long setId) {
        ShareDataFileExample example = new ShareDataFileExample();
        example.createCriteria().andSetIdEqualTo(setId);
        List<ShareDataFile> shareDataFiles = find(example);
        Map<Long, ShareDataFile> map = new HashMap<>();
        for (ShareDataFile sdf : shareDataFiles) {
            map.put(sdf.getBusId(), sdf);
        }
        return map;
    }

    @Override
    public void deleteOptDeleBySetId(long setId) {
        ShareDataFileExample example = new ShareDataFileExample();
        example.createCriteria().andSetIdEqualTo(setId).andOptTypeEqualTo(2);
        shareDataFileMapper.deleteByExample(example);
    }

    @Override
    public void saveBatch(List<ShareDataFile> shareDataFiles) {
        shareDataFileMapper.batchInsert(shareDataFiles);
    }
}
