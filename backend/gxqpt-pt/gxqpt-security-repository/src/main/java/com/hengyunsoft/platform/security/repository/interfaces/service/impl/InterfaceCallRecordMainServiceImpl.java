package com.hengyunsoft.platform.security.repository.interfaces.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceCallRecordMain;
import com.hengyunsoft.platform.security.repository.interfaces.dao.InterfaceCallRecordMainMapper;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceCallRecordMainExample;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceCallRecordMainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InterfaceCallRecordMainServiceImpl extends BaseServiceImpl<Long,InterfaceCallRecordMain,InterfaceCallRecordMainExample> implements InterfaceCallRecordMainService {
    @Autowired
    private InterfaceCallRecordMainMapper mapper;

    @Override
    protected BaseNormalDao<Long, InterfaceCallRecordMain, InterfaceCallRecordMainExample> getDao() {
        return mapper;
    }
}
