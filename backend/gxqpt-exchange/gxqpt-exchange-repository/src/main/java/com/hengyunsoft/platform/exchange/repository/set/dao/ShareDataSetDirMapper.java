package com.hengyunsoft.platform.exchange.repository.set.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareDataSetDirMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetDir, com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetDirExample> {
    /***
     * 根据数据集id删除
     * @param setId
     */
    void deleteBySetId(@Param("setId") Long setId);
}