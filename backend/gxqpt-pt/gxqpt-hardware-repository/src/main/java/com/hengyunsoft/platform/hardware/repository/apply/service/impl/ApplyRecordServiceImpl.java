package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyRecord;
import com.hengyunsoft.platform.hardware.repository.apply.dao.ApplyRecordMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyRecordExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ApplyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyRecordServiceImpl extends BaseServiceImpl<Long, ApplyRecord, ApplyRecordExample> implements ApplyRecordService {

    @Autowired
    ApplyRecordMapper applyRecordMapper;

    @Override
    protected BaseNormalDao<Long, ApplyRecord, ApplyRecordExample> getDao() {
        return applyRecordMapper;
    }

}
