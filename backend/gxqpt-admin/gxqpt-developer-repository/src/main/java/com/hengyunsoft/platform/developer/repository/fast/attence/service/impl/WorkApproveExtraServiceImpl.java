package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveExtra;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApproveExtraMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveExtraExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveExtraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkApproveExtraServiceImpl extends BaseAllServiceImpl<Long, WorkApproveExtra, WorkApproveExtraExample>
        implements WorkApproveExtraService {
    @Autowired
    private WorkApproveExtraMapper workApproveExtraMapper;

    @Override
    protected BaseNormalDao<Long, WorkApproveExtra, WorkApproveExtraExample> getDao() {
        return workApproveExtraMapper;
    }
}
