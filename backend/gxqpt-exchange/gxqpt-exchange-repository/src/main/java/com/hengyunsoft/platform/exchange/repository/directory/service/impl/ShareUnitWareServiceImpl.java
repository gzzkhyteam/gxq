package com.hengyunsoft.platform.exchange.repository.directory.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnitWare;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareUnitMapper;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareUnitWareMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareUnitService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareUnitWareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-22
 */
@Service
@Slf4j
public class ShareUnitWareServiceImpl extends BaseAllServiceImpl<Long,ShareUnitWare,ShareUnitWareExample> implements ShareUnitWareService{

    @Autowired
    private ShareUnitWareMapper shareUnitWareMapper;

    @Override
    protected BaseNormalDao<Long, ShareUnitWare, ShareUnitWareExample> getDao() {
        return shareUnitWareMapper;
    }
    /**
     * 删除共享单位
     * @param dirId
     */
    @Override
    public void deleteWareByDirId(Long dirId) {

        shareUnitWareMapper.deleteWareByDirId(dirId);

    }

    @Override
    public void batchSave(List<ShareUnitWare> shareUnitWareList) {
        shareUnitWareMapper.batchInsert(shareUnitWareList);
    }
}
