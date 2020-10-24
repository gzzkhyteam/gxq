package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.Attence;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttenceServiceImpl extends BaseAllServiceImpl<Long, Attence, AttenceExample>
        implements AttenceService {
    @Autowired
    private AttenceMapper attenceMapper;

    @Override
    protected BaseNormalDao<Long, Attence, AttenceExample> getDao() {
        return attenceMapper;
    }
}
