package com.hengyunsoft.platform.exchange.repository.screen.dao;

import com.hengyunsoft.platform.exchange.entity.screen.po.OrgDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataOverviewMapper {
    /**
     * @todo 查询部门
     * @Author wgj
     * @createtime 2018-4-22
     */
    List<OrgDO> getOrgList();
}

