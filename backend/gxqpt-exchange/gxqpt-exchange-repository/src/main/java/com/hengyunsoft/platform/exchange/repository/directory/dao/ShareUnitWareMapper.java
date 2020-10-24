package com.hengyunsoft.platform.exchange.repository.directory.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareUnitWareMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnitWare, com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitWareExample> {
    /**
     * 删除共享单位
     * @param dirId
     */
    void deleteWareByDirId(@Param("dirId") Long dirId);
}