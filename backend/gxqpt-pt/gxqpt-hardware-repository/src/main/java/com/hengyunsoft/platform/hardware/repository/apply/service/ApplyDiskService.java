package com.hengyunsoft.platform.hardware.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyDisk;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyDiskExample;

public interface ApplyDiskService  extends BaseService<Long, ApplyDisk, ApplyDiskExample> {

    int deleteByServerKeyId(Long id);
}
