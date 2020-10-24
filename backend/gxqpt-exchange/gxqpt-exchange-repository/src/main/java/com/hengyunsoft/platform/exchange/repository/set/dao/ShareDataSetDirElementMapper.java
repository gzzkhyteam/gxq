package com.hengyunsoft.platform.exchange.repository.set.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ShareDataSetDirElementMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetDirElement, com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetDirElementExample> {
    /***
     * 根据数据集id删除
     * @param setId
     */
    void deleteBySetId(Long setId);
}