package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveSupply;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApproveSupplyMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveSupplyExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveSupplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkApproveSupplyServiceImpl extends BaseAllServiceImpl<Long, WorkApproveSupply, WorkApproveSupplyExample>
        implements WorkApproveSupplyService {
    @Autowired
    private WorkApproveSupplyMapper workApproveSupplyMapper;

    @Override
    protected BaseNormalDao<Long, WorkApproveSupply, WorkApproveSupplyExample> getDao() {
        return workApproveSupplyMapper;
    }
}
