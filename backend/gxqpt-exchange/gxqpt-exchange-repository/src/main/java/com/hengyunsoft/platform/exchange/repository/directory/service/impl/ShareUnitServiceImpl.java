package com.hengyunsoft.platform.exchange.repository.directory.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareUnitMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareUnitService;
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
public class ShareUnitServiceImpl extends BaseAllServiceImpl<Long,ShareUnit,ShareUnitExample> implements ShareUnitService{

    @Autowired
    private ShareUnitMapper  shareUnitMapper;

    @Override
    protected BaseNormalDao<Long, ShareUnit, ShareUnitExample> getDao() {
        return shareUnitMapper;
    }
    /**
     * 根据目录id查询共享单位id
     * @param id
     * @return
     */
    @Override
    public List<String> getUnitListByDirId(Long id) {


        return shareUnitMapper.getUnitListByDirId(id);
    }
    /**
     * 删除共享单位
     * @param dirId
     */
    @Override
    public void deleteByDirId(Long dirId) {

        shareUnitMapper.deleteByDirId(dirId);
    }
    /**
     * 批量保存目录共享单位
     * @param shareUnitList
     */
    @Override
    public void batchSave(List<ShareUnit> shareUnitList) {
        shareUnitMapper.batchInsert(shareUnitList);
    }

    /**
     * 批量更新目录共享单位
     * @param shareUnitList
     */
    @Override
    public void batchUpdate(List<ShareUnit> shareUnitList) {
        shareUnitMapper.batchUpdate(shareUnitList);
    }
}
