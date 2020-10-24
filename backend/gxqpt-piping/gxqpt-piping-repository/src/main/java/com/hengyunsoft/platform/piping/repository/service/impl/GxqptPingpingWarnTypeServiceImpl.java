package com.hengyunsoft.platform.piping.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.piping.entity.message.GxqptPingpingWarnType;
import com.hengyunsoft.platform.piping.repository.dao.GxqptPingpingWarnTypeMapper;
import com.hengyunsoft.platform.piping.repository.example.GxqptPingpingWarnTypeExample;
import com.hengyunsoft.platform.piping.repository.service.GxqptPingpingWarnTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class GxqptPingpingWarnTypeServiceImpl extends BaseAllServiceImpl<Long, GxqptPingpingWarnType, GxqptPingpingWarnTypeExample> implements GxqptPingpingWarnTypeService {

    @Autowired
    private GxqptPingpingWarnTypeMapper gxqptPingpingWarnTypeMapper;

    @Override
    public List<Long> getTypeId(){
        return gxqptPingpingWarnTypeMapper.getTypeId();
    }

    @Override
    protected BaseNormalDao<Long, GxqptPingpingWarnType, GxqptPingpingWarnTypeExample> getDao() {
        return gxqptPingpingWarnTypeMapper;
    }
}
