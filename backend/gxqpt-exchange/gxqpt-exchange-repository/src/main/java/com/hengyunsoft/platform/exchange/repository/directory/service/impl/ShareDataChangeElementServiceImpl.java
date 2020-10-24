package com.hengyunsoft.platform.exchange.repository.directory.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataChangeElementMapper;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeElementService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChangeElement;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeElementExample;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-25
 */
@Service
@Slf4j
public class ShareDataChangeElementServiceImpl extends BaseAllServiceImpl<Long,ShareDataChangeElement,ShareDataChangeElementExample> implements ShareDataChangeElementService {

    @Autowired
    private ShareDataChangeElementMapper shareDataChangeElementMapper;

    @Override
    protected BaseNormalDao<Long,ShareDataChangeElement,ShareDataChangeElementExample> getDao() {
        return shareDataChangeElementMapper;
    }
    /**
     * 根据申请编号查询字段目录信息
     * @param unitId
     * @param applyCode
     * @return
     */
    @Override
    public List<ShareDataChangeElement> findChangeEmtList(String unitId, String applyCode,Integer busType) {
        return shareDataChangeElementMapper.findChangeEmtList(unitId,applyCode,busType);
    }
    /**
     * 删除未发布的变动字段记录信息表
     * @param elementId/字段表id
     */
    @Override
    public void deleteByElementId(Long elementId) {
         shareDataChangeElementMapper.deleteByElementId(elementId);
    }

    /**
     * 删除未发布的变动目录的记录信息表
     * @param dirId
     */
    @Override
    public void deleteByDirId(Long dirId) {
        shareDataChangeElementMapper.deleteByDirId(dirId);
    }

    @Override
    public void batchSave(List<ShareDataChangeElement> dataChangeElementList) {
        shareDataChangeElementMapper.batchInsert(dataChangeElementList);
    }
}
