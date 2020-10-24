package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowAudit;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowAuditMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowAuditExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @todo 流程审批service
 * @author wgj
 * @createtime 2018-4-22
 */
@Service
public class ShareFlowAuditServiceImpl extends BaseAllServiceImpl<Long,ShareFlowAudit,ShareFlowAuditExample> implements ShareFlowAuditService{
    @Autowired
    ShareFlowAuditMapper shareFlowAuditMapper;
    @Override
    protected BaseNormalDao<Long, ShareFlowAudit, ShareFlowAuditExample> getDao() {
        return shareFlowAuditMapper;
    }
}
