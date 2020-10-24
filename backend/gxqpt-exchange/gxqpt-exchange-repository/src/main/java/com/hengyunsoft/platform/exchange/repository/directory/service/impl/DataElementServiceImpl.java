package com.hengyunsoft.platform.exchange.repository.directory.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataDirectoryMapper;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataElementMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Service
@Slf4j
public class DataElementServiceImpl extends BaseAllServiceImpl<Long,ShareDataElement,ShareDataElementExample> implements DataElementService {

    @Autowired
    private ShareDataElementMapper shareDataElementMapper;
    @Override
    protected BaseNormalDao<Long, ShareDataElement, ShareDataElementExample> getDao() {
        return shareDataElementMapper;
    }

    @Override
    public int deleteByDirId(Long dirId) {
        return shareDataElementMapper.deleteByDirId(dirId);
    }

    /**
     * 更新元数据数据集字段setField
     * @param
     */
    @Override
    public  void updateSetFieldByPrimaryKey(ShareDataElement shareDataElement){
        shareDataElementMapper.updateSetFieldByPrimaryKey(shareDataElement);
    }
    /**
     * 查询申请发布元数据变动记录
     * @param
     */
    @Override
    public List<ShareDataElement> getElementChangeListApply(String unitId,Integer status) {
        return shareDataElementMapper.getElementChangeListApply(unitId,status);
    }

    /**
     * 查询数据元数据变动记录
     * @param
     */
    @Override
    public List<ShareDataElement> getElementChangeList(String applyCode) {
        return shareDataElementMapper.getElementChangeList(applyCode);
    }
    /**
     * 查询数据元数据列表
     * @param
     */
    @Override
    public List<ShareDataElement> getElementWareList(Long dirId) {
        return shareDataElementMapper.getElementWareList(dirId);
    }
    /**
     * 根据目录id查询字段
     * @param id
     * @return
     */
    @Override
    public List<Long> getEltListByDirId(Long id) {

        return shareDataElementMapper.getEltListByDirId(id);
    }

    @Override
    public void updateSetFiled2Null(long dirId) {
        shareDataElementMapper.updateSetFiled2Null(dirId);
    }

    @Override
    public void updateSetFiled(long dirId, String fieldCode, String setField) {
        shareDataElementMapper. updateSetFiled(dirId, fieldCode, setField);
    }

    @Override
    public ShareDataElement getByDirId(Long dirId) {
        return shareDataElementMapper.getByDirId(dirId);
    }

    @Override
    public void batchSave(List<ShareDataElement> dataElementList) {
        shareDataElementMapper.batchInsert(dataElementList);
    }

    @Override
    public void batchUpdate(List<ShareDataElement> dataElementList) {
        shareDataElementMapper.batchUpdate(dataElementList);
    }
}
