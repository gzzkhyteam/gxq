package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowHiTask;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowHiTaskMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowHiTaskExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowHiTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @todo 办理历史任务service
 * @author wgj
 * @createtime 2018-4-22
 */
@Service
public class ShareFlowHiTaskServiceImpl extends BaseAllServiceImpl<Long,ShareFlowHiTask,ShareFlowHiTaskExample> implements ShareFlowHiTaskService {
    @Autowired
    ShareFlowHiTaskMapper shareFlowHiTaskMapper;

    @Override
    protected BaseNormalDao<Long, ShareFlowHiTask, ShareFlowHiTaskExample> getDao() {
        return shareFlowHiTaskMapper;
    }



}
