package com.hengyunsoft.platform.exchange.repository.screen.service;

import com.hengyunsoft.platform.exchange.entity.screen.po.OrgDO;

import java.util.List;

public interface DataOverviewService {
    /**
     * @todo 查询部门
     * @Author wgj
     * @createtime 2018-4-22
     */
    List<OrgDO> getOrgList();
}
