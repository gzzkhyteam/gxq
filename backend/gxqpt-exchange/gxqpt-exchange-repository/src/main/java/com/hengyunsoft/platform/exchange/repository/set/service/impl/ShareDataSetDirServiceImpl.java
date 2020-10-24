package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetDir;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetDirMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetDirExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetDirServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetDir, ShareDataSetDirExample> implements ShareDataSetDirService {
    @Autowired
    private ShareDataSetDirMapper shareDataSetDirMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetDir, ShareDataSetDirExample> getDao() {
        return shareDataSetDirMapper;
    }

    @Override
    public ShareDataSetDir getShareDataSetDirByDirIdAndSetId(long dirId, long setId) {
        ShareDataSetDirExample example = new ShareDataSetDirExample();
        ShareDataSetDirExample.Criteria criteria = example.createCriteria();
        criteria.andDirIdEqualTo(dirId).andSetIdEqualTo(setId);
        return getUnique(example);
    }

    @Override
    public Map<Long, ShareDataSetDir> getShareDataSetDirBySetId(long setId) {
        ShareDataSetDirExample example = new ShareDataSetDirExample();
        ShareDataSetDirExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId);
        List<ShareDataSetDir> shareDataSetDirs = find(example);
        Map<Long, ShareDataSetDir> map = new HashMap<>();
        for (ShareDataSetDir sd : shareDataSetDirs) {
            map.put(sd.getDirId(), sd);
        }
        return map;
    }

    @Override
    public Map<Long, ShareDataSetDir> getShareDataSetDirBySetIdNotDele(long setId) {
        ShareDataSetDirExample example = new ShareDataSetDirExample();
        ShareDataSetDirExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId).andOptTypeNotEqualTo(2);
        List<ShareDataSetDir> shareDataSetDirs = find(example);
        Map<Long, ShareDataSetDir> map = new HashMap<>();
        for (ShareDataSetDir sd : shareDataSetDirs) {
            map.put(sd.getDirId(), sd);
        }
        return map;
    }

    @Override
    public List<ShareDataSetDir> getShareDataSetDirBySetIdAndOpt(long setId, int optType) {
        ShareDataSetDirExample example = new ShareDataSetDirExample();
        ShareDataSetDirExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId).andOptTypeEqualTo(optType);
        return find(example);
    }

    @Override
    public void deleteBySetId(Long setId) {
        shareDataSetDirMapper.deleteBySetId(setId);
    }

}
