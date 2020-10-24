package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetWare;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetWareExample;

public interface ShareDataSetWareService extends BaseAllService<Long, ShareDataSetWare, ShareDataSetWareExample> {
    /***
     * 插入数据
     * @param entity
     */
    void insert(ShareDataSetWare entity);
}
