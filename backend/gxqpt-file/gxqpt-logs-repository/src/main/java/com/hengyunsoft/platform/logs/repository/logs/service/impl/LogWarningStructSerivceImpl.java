package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarningStruct;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogWarningStructMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarningStructExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarningStructSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class LogWarningStructSerivceImpl extends BaseAllServiceImpl<Long, LogWarningStruct, LogWarningStructExample> implements LogWarningStructSerivce,Serializable {
    @Autowired
    private LogWarningStructMapper logWarningStructMapper;
    @Override
    protected BaseNormalDao<Long, LogWarningStruct, LogWarningStructExample> getDao() {
        return logWarningStructMapper;
    }
}
