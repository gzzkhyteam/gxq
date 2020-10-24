package com.hengyunsoft.platform.exchange.repository.system.dao;

import com.hengyunsoft.platform.exchange.entity.system.domain.JoinOrgDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareJoinOrg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareJoinOrgMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.system.po.ShareJoinOrg, com.hengyunsoft.platform.exchange.repository.system.example.ShareJoinOrgExample> {
    /**
     * 查询接入单位
     * @return
     */
    List<JoinOrgDO> getJoinUnitList();
    /**
     * 查询单位的目录数量
     * @return
     */
    List<JoinOrgDO> getUnitDirList();
}