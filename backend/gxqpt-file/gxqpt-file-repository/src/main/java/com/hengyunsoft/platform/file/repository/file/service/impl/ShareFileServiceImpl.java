package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.entity.file.domain.ShareFileRateDO;
import com.hengyunsoft.platform.file.entity.file.domain.SynFileDataDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.ShareFile;
import com.hengyunsoft.platform.file.repository.file.dao.ShareFileMapper;
import com.hengyunsoft.platform.file.repository.file.example.ShareFileExample;
import com.hengyunsoft.platform.file.repository.file.service.ShareFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ShareFileServiceImpl extends BaseAllServiceImpl<Long, ShareFile, ShareFileExample> implements ShareFileService {
    @Autowired
    private ShareFileMapper shareFileMapper;

    @Override
    protected BaseAllDao<Long, ShareFile, ShareFileExample> getDao() {
        return shareFileMapper;
    }

    @Override
    public List<File> selectFileByShare(Long id,String name) {
        return shareFileMapper.selectFileByShare(id,name);
    }

    @Override
    public int deleteByShareIds(String appId, Collection<Long> list) {
        return shareFileMapper.deleteByShareIds(appId, list);
    }

    @Override
    public int deleteByShareIds(Collection<Long> list) {
        return shareFileMapper.deleteByShareIds(null,list);
    }

    @Override
    public List<File> selectFileTree(long id,String name) {
        return shareFileMapper.selectFileTree(id,name);
    }

    @Override
    public List<SynFileDataDO> findSynFileData(Date startDate, Date endDate) {
        return shareFileMapper.findSynFileData(startDate,endDate);
    }

    @Override
    public List<ShareFileRateDO> findFileShareRateN(Long userId, String appId) {
        return shareFileMapper.findFileShareRateN(userId, appId);
    }

    @Override
    public List<ShareFileRateDO> findFileShareRateY(Long userId, String appId) {
        return shareFileMapper.findFileShareRateY(userId,appId);
    }


}
