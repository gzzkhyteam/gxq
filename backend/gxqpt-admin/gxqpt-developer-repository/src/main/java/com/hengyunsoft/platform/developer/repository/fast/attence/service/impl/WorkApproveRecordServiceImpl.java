package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApproveRecord;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApproveRecordMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApproveRecordExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApproveRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkApproveRecordServiceImpl extends BaseAllServiceImpl<Long, WorkApproveRecord, WorkApproveRecordExample>
        implements WorkApproveRecordService {
    @Autowired
    private WorkApproveRecordMapper workApproveRecordMapper;

    @Override
    protected BaseNormalDao<Long, WorkApproveRecord, WorkApproveRecordExample> getDao() {
        return workApproveRecordMapper;
    }
}
