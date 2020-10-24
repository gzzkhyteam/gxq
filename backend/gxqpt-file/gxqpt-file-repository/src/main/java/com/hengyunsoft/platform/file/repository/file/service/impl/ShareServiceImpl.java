package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareNumDO;
import com.hengyunsoft.platform.file.entity.file.po.Share;
import com.hengyunsoft.platform.file.repository.file.dao.ShareMapper;
import com.hengyunsoft.platform.file.repository.file.example.ShareExample;
import com.hengyunsoft.platform.file.repository.file.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl extends BaseAllServiceImpl<Long, Share, ShareExample> implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    protected BaseAllDao<Long, Share, ShareExample> getDao() {
        return shareMapper;
    }

    @Override
    public Share saveNoId(Share entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        Date nowDate = new Date();
        entity.setCreateTime(nowDate);
        entity.setUpdateTime(nowDate);
        getDao().insert(entity);
        return entity;
    }

    @Override
    public int updateBrowsTimesById(Long id) {
        return shareMapper.updateBrowsTimesById(id);
    }

    @Override
    public int updateDownloadTimesById(Long id) {
        return shareMapper.updateDownloadTimesById(id);
    }

    @Override
    public int updateSaveTimesById(Long id) {
        return shareMapper.updateSaveTimesById(id);
    }

    @Override
    public List<FileShareNumDO> getMyShare(Long userId, String appId) {
        return shareMapper.getMyShare(userId, appId);
    }


}
