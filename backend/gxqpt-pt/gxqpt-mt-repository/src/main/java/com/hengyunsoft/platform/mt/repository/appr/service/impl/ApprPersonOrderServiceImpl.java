package com.hengyunsoft.platform.mt.repository.appr.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprPersonOrder;
import com.hengyunsoft.platform.mt.repository.appr.dao.ApprPersonOrderMapper;
import com.hengyunsoft.platform.mt.repository.appr.example.ApprPersonOrderExample;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprPersonOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprPersonOrderServiceImpl extends BaseServiceImpl<Long, ApprPersonOrder, ApprPersonOrderExample> implements ApprPersonOrderService {
    @Autowired
    private ApprPersonOrderMapper apprPersonOrderMapper;

    @Override
    protected BaseNormalDao<Long, ApprPersonOrder, ApprPersonOrderExample> getDao() {
        return apprPersonOrderMapper;
    }
}
