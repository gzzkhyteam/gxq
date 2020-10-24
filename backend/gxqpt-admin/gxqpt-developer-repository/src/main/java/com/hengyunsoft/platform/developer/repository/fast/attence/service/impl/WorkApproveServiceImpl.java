package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApprove;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApproveMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkApproveServiceImpl extends BaseAllServiceImpl<Long, WorkApprove, WorkApproveExample>
        implements WorkApproveService {
    @Autowired
    private WorkApproveMapper workApproveMapper;

    @Override
    protected BaseNormalDao<Long, WorkApprove, WorkApproveExample> getDao() {
        return workApproveMapper;
    }
}
