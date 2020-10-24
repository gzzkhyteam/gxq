package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataDemandListDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDataDemandMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataDemand, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataDemandExample> {
    List<ShareDataDemandListDO> selectList(Map<String, Object> param);

}