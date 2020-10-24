package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.FiledSelectDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDataApiElementMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample> {
    List<ShareDataElement> selectElementInfoByApiId(@Param("apiId") Long apiId);

    List<FiledSelectDO> selectFiled(@Param("apiId")Long apiId);
}