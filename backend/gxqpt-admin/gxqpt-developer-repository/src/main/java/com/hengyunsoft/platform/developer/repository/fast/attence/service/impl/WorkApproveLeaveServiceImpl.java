package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApprove;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveLeave;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApproveLeaveMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApproveMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveLeaveExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveLeaveService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkApproveLeaveServiceImpl extends BaseAllServiceImpl<Long, WorkApproveLeave, WorkApproveLeaveExample>
        implements WorkApproveLeaveService {
    @Autowired
    private WorkApproveLeaveMapper workApproveLeaveMapper;

    @Override
    protected BaseNormalDao<Long, WorkApproveLeave, WorkApproveLeaveExample> getDao() {
        return workApproveLeaveMapper;
    }
}
