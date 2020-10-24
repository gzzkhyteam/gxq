package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetFlow;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDataSetFlowMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetFlowExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareDataSetFlowServiceImpl extends BaseAllServiceImpl<Long, ShareDataSetFlow, ShareDataSetFlowExample> implements ShareDataSetFlowService {
    @Autowired
    private ShareDataSetFlowMapper shareDataSetFlowMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataSetFlow, ShareDataSetFlowExample> getDao() {
        return shareDataSetFlowMapper;
    }

    @Override
    public ShareDataSetFlow getShareDataSetFlowByApplyCode(String applyCode) {
        ShareDataSetFlowExample example = new ShareDataSetFlowExample();
        ShareDataSetFlowExample.Criteria criteria = example.createCriteria();
        criteria.andApplyCodeEqualTo(applyCode);
        return getUnique(example);
    }
}
