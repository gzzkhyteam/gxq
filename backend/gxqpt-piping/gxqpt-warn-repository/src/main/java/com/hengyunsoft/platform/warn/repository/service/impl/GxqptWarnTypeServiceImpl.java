package com.hengyunsoft.platform.warn.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnTypeMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GxqptWarnTypeServiceImpl extends BaseAllServiceImpl<Long, GxqptWarnType, GxqptWarnTypeExample> implements GxqptWarnTypeService {

    @Autowired
    private GxqptWarnTypeMapper gxqptWarnTypeMapper;

    @Override
    protected BaseNormalDao<Long, GxqptWarnType, GxqptWarnTypeExample> getDao() {
        return gxqptWarnTypeMapper;
    }
}
