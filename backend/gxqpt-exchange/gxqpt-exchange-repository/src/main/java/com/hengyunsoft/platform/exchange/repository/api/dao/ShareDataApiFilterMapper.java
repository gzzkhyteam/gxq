package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.FiledFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiFilterDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDataApiFilterMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiFilter, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiFilterExample> {
    List<ShareDataApiFilterDO> selectFilterInfoByApiId(@Param("apiId") Long apiId);

    List<FiledFilterDO> selectFilterFiled(@Param("apiId") Long apiId);
}