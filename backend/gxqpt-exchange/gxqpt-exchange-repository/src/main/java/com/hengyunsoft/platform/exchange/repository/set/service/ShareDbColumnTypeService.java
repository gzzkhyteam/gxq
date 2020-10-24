package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDbColumnType;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDbColumnTypeExample;

import java.util.Map;

public interface ShareDbColumnTypeService extends BaseAllService<Long, ShareDbColumnType, ShareDbColumnTypeExample> {
    /***
     * 得到全部支持的数据类型
     * @return key:类型名称
     */
    Map<String, ShareDbColumnType> getAllShareDbColumnType();
}
