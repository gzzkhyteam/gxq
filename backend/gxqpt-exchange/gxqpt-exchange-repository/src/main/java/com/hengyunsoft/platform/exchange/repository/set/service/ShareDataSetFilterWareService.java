package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetFilterWare;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetFilterWareExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetFilterWareService extends BaseAllService<Long, ShareDataSetFilterWare, ShareDataSetFilterWareExample> {

    /***
     * 根据数据集id查询
     * @param setId
     * @return key:字段标识fieldCode
     */
    Map<String, ShareDataSetFilterWare> getShareDataSetFilterMap(long setId);

    /***
     * 批量保存
     * @param list
     */
    void batchInsert(List<ShareDataSetFilterWare> list);
}
