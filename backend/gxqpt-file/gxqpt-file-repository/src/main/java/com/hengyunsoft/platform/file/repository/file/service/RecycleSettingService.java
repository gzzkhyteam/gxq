package com.hengyunsoft.platform.file.repository.file.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.file.entity.file.po.RecycleSetting;
import com.hengyunsoft.platform.file.repository.file.example.RecycleSettingExample;

/**
 * @author mdengbo
 * @createTime 2018-09-3 10:44
 */
public interface RecycleSettingService extends BaseService<Long, RecycleSetting, RecycleSettingExample> {

    RecycleSetting findByUserId(Long userId);
}
