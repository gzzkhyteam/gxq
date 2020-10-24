package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.WorkApprovePerson;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.WorkApprovePersonMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.WorkApprovePersonExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.WorkApprovePersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkApprovePersonServiceImpl extends BaseAllServiceImpl<Long, WorkApprovePerson, WorkApprovePersonExample>
        implements WorkApprovePersonService {
    @Autowired
    private WorkApprovePersonMapper workApprovePersonMapper;

    @Override
    protected BaseNormalDao<Long, WorkApprovePerson, WorkApprovePersonExample> getDao() {
        return workApprovePersonMapper;
    }
}
