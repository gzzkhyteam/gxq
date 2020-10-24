package com.hengyunsoft.platform.developer.repository.fast.dao;

import com.hengyunsoft.platform.developer.entity.fast.po.FastBizConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FastBizConfigMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.fast.po.FastBizConfig, com.hengyunsoft.platform.developer.repository.fast.example.FastBizConfigExample> {
    List<FastBizConfig> getBizConfig(Long parentId);
}