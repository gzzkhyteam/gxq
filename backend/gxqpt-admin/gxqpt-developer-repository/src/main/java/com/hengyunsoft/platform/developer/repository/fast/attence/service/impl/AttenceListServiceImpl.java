package com.hengyunsoft.platform.developer.repository.fast.attence.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceList;
import com.hengyunsoft.platform.developer.repository.fast.attence.dao.AttenceListMapper;
import com.hengyunsoft.platform.developer.repository.fast.attence.example.AttenceListExample;
import com.hengyunsoft.platform.developer.repository.fast.attence.service.AttenceListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttenceListServiceImpl extends BaseAllServiceImpl<Long, AttenceList, AttenceListExample>
        implements AttenceListService {
    @Autowired
    private AttenceListMapper attenceListMapper;

    @Override
    protected BaseNormalDao<Long, AttenceList, AttenceListExample> getDao() {
        return attenceListMapper;
    }
}
