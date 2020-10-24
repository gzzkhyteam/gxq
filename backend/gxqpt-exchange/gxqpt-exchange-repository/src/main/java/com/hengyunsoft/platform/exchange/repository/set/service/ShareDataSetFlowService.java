package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetFlow;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetFlowExample;

public interface ShareDataSetFlowService extends BaseAllService<Long, ShareDataSetFlow, ShareDataSetFlowExample> {

    /***
     * 根据申请编码
     * @param applyCode
     * @return
     */
    ShareDataSetFlow getShareDataSetFlowByApplyCode(String applyCode);

}
