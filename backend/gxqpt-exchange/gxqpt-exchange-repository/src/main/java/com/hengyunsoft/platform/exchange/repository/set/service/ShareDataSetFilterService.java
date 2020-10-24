package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetFilter;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetFilterExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetFilterService extends BaseAllService<Long, ShareDataSetFilter, ShareDataSetFilterExample> {


    /***
     * 根据数据集id查询
     * @param setId
     * @return key:字段标识fieldCode
     */
    Map<String, ShareDataSetFilter> getShareDataSetFilterMap(long setId);

    /***
     * 根据数据集和操作类型查询
     * @param setId  数据集id
     * @param optType  操作类型(最近一次)：1,新增；2，修改；3，删除；4，正常,
     * @return
     */
    List<ShareDataSetFilter> getAllBySetIdAndOpt(long setId, int optType);

    /***
     * 根据数据集和操作类型查询非删除的字段
     * @param setId  数据集id
     * @return
     */
    List<ShareDataSetFilter> getAllCanUseBySetId(long setId);
}
