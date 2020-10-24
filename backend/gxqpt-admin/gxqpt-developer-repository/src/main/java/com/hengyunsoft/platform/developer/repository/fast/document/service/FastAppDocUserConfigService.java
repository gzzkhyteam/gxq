package com.hengyunsoft.platform.developer.repository.fast.document.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.developer.entity.fast.po.document.FastAppDocUserConfig;
import com.hengyunsoft.platform.developer.repository.fast.document.example.FastAppDocUserConfigExample;

public interface FastAppDocUserConfigService extends BaseAllService<Long, FastAppDocUserConfig, FastAppDocUserConfigExample> {


    FastAppDocUserConfig getByUserId(Long userId);
}
