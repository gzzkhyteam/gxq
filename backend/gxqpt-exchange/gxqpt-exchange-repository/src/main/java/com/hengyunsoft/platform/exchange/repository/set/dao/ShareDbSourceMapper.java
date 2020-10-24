package com.hengyunsoft.platform.exchange.repository.set.dao;

import com.hengyunsoft.platform.exchange.entity.set.domain.DbSourceDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDbSourceMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.set.po.ShareDbSource, com.hengyunsoft.platform.exchange.repository.set.example.ShareDbSourceExample> {

    /**
     * 查询数据源列表
     * @param params
     * @return
     */
    List<DbSourceDO> queryDbSourceList(Map<Object, Object> params);

    /**
     * 根据数据源列表ID查询
     * @param id
     * @return
     */
    DbSourceDO getDbSourceById(@Param("id") Long id);
}