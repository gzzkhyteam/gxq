package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.entity.file.po.RecycleSetting;
import com.hengyunsoft.platform.file.repository.file.dao.RecycleSettingMapper;
import com.hengyunsoft.platform.file.repository.file.example.RecycleSettingExample;
import com.hengyunsoft.platform.file.repository.file.service.RecycleSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mdengbo
 * @createTime 2018-09-03 10:44
 */
@Service
@Slf4j
public class RecycleSettingServiceImpl extends BaseAllServiceImpl<Long, RecycleSetting, RecycleSettingExample> implements RecycleSettingService{


    @Autowired
    private RecycleSettingMapper recycleSettingMapper ;


    @Override
    protected BaseNormalDao<Long, RecycleSetting, RecycleSettingExample> getDao() {
        return recycleSettingMapper;
    }

    @Override
    public RecycleSetting findByUserId(Long userId) {
        RecycleSetting recycleSetting = recycleSettingMapper.findByUserId(userId);
        return recycleSetting;

    }
}
