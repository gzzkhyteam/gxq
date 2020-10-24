package com.hengyunsoft.platform.warn.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendStatus;
import com.hengyunsoft.platform.warn.repository.dao.GxqptSendStatusMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptSendStatusExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendStatusService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GxqptSendStatusServiceImpl extends BaseAllServiceImpl<Long, GxqptSendStatus, GxqptSendStatusExample> implements GxqptSendStatusService {

    @Autowired
    private GxqptSendStatusMapper gxqptSendStatusMapper;

    @Override
    protected BaseNormalDao<Long, GxqptSendStatus, GxqptSendStatusExample> getDao() {
        return gxqptSendStatusMapper;
    }
    


}
