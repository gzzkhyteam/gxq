package com.hengyunsoft.platform.exchange.repository.directory.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataElementWareMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementWareService;
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
public class DataElementWareServiceImpl extends BaseAllServiceImpl<Long, ShareDataElementWare, ShareDataElementWareExample> implements DataElementWareService {

    @Autowired
    private ShareDataElementWareMapper shareDataElementWareMapper;


    @Override
    protected BaseNormalDao<Long, ShareDataElementWare, ShareDataElementWareExample> getDao() {
        return shareDataElementWareMapper;
    }

    /**
     * 目录审批通过后，同步保存元数据字段表
     *
     * @return
     * @Author tianai
     * @createtime 2018-05-07
     */
    @Override
    public int saveElementWare(ShareDataElementWare entity) {
        return shareDataElementWareMapper.insertSelective(entity);
    }

    @Override
    public void updateSetFiled2Null(long dirId) {
        shareDataElementWareMapper.updateSetFiled2Null(dirId);
    }

    @Override
    public void updateSetFiled(long dirId, String fieldCode, String setField) {
        shareDataElementWareMapper.updateSetFiled(dirId, fieldCode, setField);
    }

    @Override
    public List<ShareDataElementWare> queryByDirId(long dirId) {
        ShareDataElementWareExample example = new ShareDataElementWareExample();
        example.createCriteria().andDirIdEqualTo(dirId);
        return find(example);
    }

    @Override
    public void batchSave(List<ShareDataElementWare> dataElementList) {
        shareDataElementWareMapper.batchInsert(dataElementList);
    }

    @Override
    public void batchUpdate(List<ShareDataElementWare> dataElementList) {
        shareDataElementWareMapper.batchUpdate(dataElementList);
    }
}
