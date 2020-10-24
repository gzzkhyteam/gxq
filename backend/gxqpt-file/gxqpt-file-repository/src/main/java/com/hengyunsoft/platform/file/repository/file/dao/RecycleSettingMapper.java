package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.platform.file.entity.file.po.RecycleSetting;
import org.springframework.stereotype.Repository;

@Repository
public interface RecycleSettingMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.file.entity.file.po.RecycleSetting, com.hengyunsoft.platform.file.repository.file.example.RecycleSettingExample> {
    RecycleSetting findByUserId(Long userId);
}