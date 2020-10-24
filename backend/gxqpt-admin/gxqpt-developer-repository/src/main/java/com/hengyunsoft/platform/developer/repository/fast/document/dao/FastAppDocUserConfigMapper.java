package com.hengyunsoft.platform.developer.repository.fast.document.dao;

import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocUserConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface FastAppDocUserConfigMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocUserConfig, com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocUserConfigExample> {
    FastAppDocUserConfig getByUserId(Long userId);
}