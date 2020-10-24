package com.hengyunsoft.platform.exchange.repository.screen.service.impl;

import com.hengyunsoft.platform.exchange.entity.screen.po.OrgDO;
import com.hengyunsoft.platform.exchange.repository.screen.dao.DataOverviewMapper;
import com.hengyunsoft.platform.exchange.repository.screen.service.DataOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataOverviewServiceImpl implements DataOverviewService{
    @Autowired
    DataOverviewMapper dataOverviewMapper;
    /**
     * @todo 查询部门
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    public List<OrgDO> getOrgList() {

        return dataOverviewMapper.getOrgList();
    }
}
