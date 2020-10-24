package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.domain.DSFlowTaskInfoDO;
import com.hengyunsoft.platform.exchange.entity.set.domain.ShareDataSetDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShareDataSetServiceImpl extends BaseAllServiceImpl<Long, ShareDataSet, ShareDataSetExample> implements ShareDataSetService {

    @Autowired
    private ShareDataSetMapper shareDataSetMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSet, ShareDataSetExample> getDao() {
        return shareDataSetMapper;
    }

    @Override
    public List<ShareDataSetDO> findAuditList(Map<String, Object> param) {
        return shareDataSetMapper.findAuditList(param);
    }


    @Override
    public DSFlowTaskInfoDO getNowFlowTsakInfo(Long taskId) {
        return shareDataSetMapper.getNowFlowTsakInfo(taskId);
    }

    @Override
    public DSFlowTaskInfoDO getHiFlowTsakInfo(Long taskId) {
        return shareDataSetMapper.getHiFlowTsakInfo(taskId);
    }

    @Override
    public List<ShareDataSetDO> findAllDataSetList(Map<String, Object> param) {
        return shareDataSetMapper.findAllDataSetList(param);
    }

    /**
     * 根据单位查询数据量
     *
     * @param unitId 单位id
     * @return
     */
    @Override
    public int getSetCountByUnitId(String unitId) {
        return shareDataSetMapper.getSetCountByUnitId(unitId);
    }

    @Override
    public boolean isAuditPass(Long dataSetId) {
        ShareDataSet dataSet = getById(dataSetId);
        if (dataSet != null && dataSet.getStatus() != null && dataSet.getStatus().equals(3)) {
            return true;
        }
        return false;
    }

    @Override
    public ShareDataSet getShareDataSetByApplyCod(String applyCode) {
        ShareDataSetExample sdsee = new ShareDataSetExample();
        ShareDataSetExample.Criteria sdseec = sdsee.createCriteria();
        sdseec.andApplyCodeEqualTo(applyCode);
        ShareDataSet shareDataSet = getUnique(sdsee);
        return shareDataSet;
    }

    @Override
    public ShareDataSet getShareDataSetBySetCode(String setCode) {
        ShareDataSetExample sdsee = new ShareDataSetExample();
        ShareDataSetExample.Criteria sdseec = sdsee.createCriteria();
        sdseec.andSetCodeEqualTo(setCode);
        ShareDataSet shareDataSet = getUnique(sdsee);
        return shareDataSet;
    }
}
