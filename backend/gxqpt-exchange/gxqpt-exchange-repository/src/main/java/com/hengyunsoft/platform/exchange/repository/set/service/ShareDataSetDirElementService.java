package com.hengyunsoft.platform.exchange.repository.set.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetDirElement;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetDirElementExample;

import java.util.List;
import java.util.Map;

public interface ShareDataSetDirElementService extends BaseAllService<Long, ShareDataSetDirElement, ShareDataSetDirElementExample> {
    /***
     * 根据数据集目录关联表的主键查询
     * @param sdId
     * @return key:目录字段id
     */
    Map<Long, ShareDataSetDirElement> getShareDataSetDirElementBySdid(long sdId);

    /***
     * 根据数据集id删除
     * @param setId
     */
    void deleteBySetId(Long setId);

    /***
     * 根据数据集目录关联表的主键查询
     * @param setId
     * @return key:目录字段id
     */
    Map<Long, ShareDataSetDirElement> getShareDataSetDirElementBySetId(long setId);

    /***
     * 根据数据集id和目录id查询
     * @param setId
     * @param dirId
     * @return  key:目录字段id
     */
    Map<Long,ShareDataSetDirElement> getShareDataSetDirElementBySetIdAndDirId(long setId, long dirId);
}
