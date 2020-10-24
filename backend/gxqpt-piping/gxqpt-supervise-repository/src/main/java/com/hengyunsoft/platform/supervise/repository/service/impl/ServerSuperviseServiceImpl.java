package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.ServerSupervise;
import com.hengyunsoft.platform.supervise.repository.dao.ServerSuperviseMapper;
import com.hengyunsoft.platform.supervise.repository.example.ServerSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.service.ServerSuperviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerSuperviseServiceImpl extends BaseAllServiceImpl<Long,ServerSupervise,ServerSuperviseExample> implements ServerSuperviseService {

    @Autowired
    private ServerSuperviseMapper mapper;

    @Override
    protected BaseNormalDao<Long, ServerSupervise, ServerSuperviseExample> getDao() {
        return mapper;
    }

    /**
     * 查询符合当前时间，并且为启用状态
     * @return
     */
    @Override
    public List<ServerSupervise> getUsableConfig() {
        return mapper.getUsableConfig();
    }
}
