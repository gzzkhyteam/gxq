package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElementWare;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetElementWareExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetElementWareService extends BaseAllService<Long, ShareDataSetElementWare, ShareDataSetElementWareExample> {
    /***
     * 根据数据集id查询字段
     * @param setId
     * @return key:字段标识
     */
    Map<String, ShareDataSetElementWare> getShareDataSetElementBySetId(long setId);

    /***
     * 批量插入
     * @param list
     */
    void batchInsert(List<ShareDataSetElementWare> list);
}
