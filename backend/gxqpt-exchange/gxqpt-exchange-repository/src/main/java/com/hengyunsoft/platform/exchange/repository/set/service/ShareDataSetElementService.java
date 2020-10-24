package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElement;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetElementExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetElementService extends BaseAllService<Long, ShareDataSetElement, ShareDataSetElementExample> {
    /***
     * 根据数据集id查询字段
     * @param setId
     * @return key:字段标识
     */
    Map<String, ShareDataSetElement> getShareDataSetElementBySetId(long setId);

    /***
     * 根据数据集id和操作类型查询
     * @param setId  数据集id
     * @param optType  操作类型：1,新增；2，修改；3，删除；4，正常,
     * @return
     */
    List<ShareDataSetElement> getAllBySetIdAndOpt(long setId, int optType);
    /***
     * 根据数据集id和操作类型查询出删除以外的字段
     * @param setId  数据集id
     * @return
     */
    List<ShareDataSetElement> getAllBySetIdCanUse(long setId);
}
