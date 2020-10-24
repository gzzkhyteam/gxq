package com.hengyunsoft.platform.exchange.repository.set.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbColumnType;
import com.hengyunsoft.platform.exchange.repository.set.dao.ShareDbColumnTypeMapper;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDbColumnTypeExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDbColumnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareDbColumnTypeServiceImpl extends BaseAllServiceImpl<Long, ShareDbColumnType, ShareDbColumnTypeExample> implements ShareDbColumnTypeService {
    @Autowired
    private ShareDbColumnTypeMapper shareDbColumnTypeMapper;

    @Override
    protected BaseNormalDao<Long, ShareDbColumnType, ShareDbColumnTypeExample> getDao() {
        return shareDbColumnTypeMapper;
    }

    @Override
    public Map<String, ShareDbColumnType> getAllShareDbColumnType() {
        Map<String, ShareDbColumnType> map = new HashMap<>();
        List<ShareDbColumnType> shareDbColumnTypes = find(null);
        for (ShareDbColumnType sct : shareDbColumnTypes) {
            map.put(sct.getSourceType(), sct);
        }
        return map;

    }
}
