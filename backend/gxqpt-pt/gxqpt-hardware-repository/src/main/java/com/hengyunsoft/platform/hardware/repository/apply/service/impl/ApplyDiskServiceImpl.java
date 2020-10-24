package com.hengyunsoft.platform.hardware.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyDisk;
import com.hengyunsoft.platform.hardware.repository.apply.dao.ApplyDiskMapper;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyDiskExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ApplyDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyDiskServiceImpl extends BaseServiceImpl<Long, ApplyDisk, ApplyDiskExample> implements ApplyDiskService {

    @Autowired
    ApplyDiskMapper applyDiskMapper;

    @Override
    protected BaseNormalDao<Long, ApplyDisk, ApplyDiskExample> getDao() {
        return applyDiskMapper;
    }

    @Override
    public int deleteByServerKeyId(Long id) {
        return applyDiskMapper.deleteByServerKeyId(id);
    }
}
