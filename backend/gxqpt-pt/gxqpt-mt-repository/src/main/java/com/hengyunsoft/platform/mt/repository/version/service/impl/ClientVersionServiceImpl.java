package com.hengyunsoft.platform.mt.repository.version.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.version.po.ClientVersion;
import com.hengyunsoft.platform.mt.repository.version.dao.ClientVersionMapper;
import com.hengyunsoft.platform.mt.repository.version.example.ClientVersionExample;
import com.hengyunsoft.platform.mt.repository.version.service.ClientVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClientVersionServiceImpl extends BaseServiceImpl<Long, ClientVersion, ClientVersionExample> implements ClientVersionService {
    @Autowired
    private ClientVersionMapper clientVersionMapper;

    @Override
    protected BaseNormalDao<Long, ClientVersion, ClientVersionExample> getDao() {
        return clientVersionMapper;
    }

    @Override
    public List<ClientVersion> findClientVersion(Map<String, Object> param) {
        return clientVersionMapper.findClientVersion(param);
    }

    @Override
    public void addUpdateNum(Long id) {
        clientVersionMapper.addUpdateNum(id);
    }

    @Override
    public List<ClientVersion> findPubishVersion() {
        return clientVersionMapper.findPubishVersion();
    }

    @Override
    public ClientVersion getLastVersionInfo() {
        return clientVersionMapper.getLastVersionInfo();
    }
}
