package com.hengyunsoft.platform.security.repository.interfaces.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceAccessStat;
import com.hengyunsoft.platform.security.repository.interfaces.dao.InterfaceAccessStatMapper;
import com.hengyunsoft.platform.security.repository.interfaces.example.InterfaceAccessStatExample;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceAccessStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InterfaceAccessStatServiceImpl extends BaseServiceImpl<Long,InterfaceAccessStat,InterfaceAccessStatExample> implements InterfaceAccessStatService {

    @Autowired
    private InterfaceAccessStatMapper interfaceAccessStatMapper;

    @Override
    protected BaseNormalDao<Long, InterfaceAccessStat, InterfaceAccessStatExample> getDao() {
        return interfaceAccessStatMapper;
    }

    @Override
    public List getApiAccessStatisticList(Long interfaceConfigId, String statDate) {
        return interfaceAccessStatMapper.getApiAccessStatisticList(interfaceConfigId,statDate);
    }
}
