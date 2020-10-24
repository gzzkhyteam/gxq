package com.hengyunsoft.platform.exchange.repository.system.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.system.domain.JoinOrgDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareJoinOrg;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareJoinOrgExample;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample;

import java.util.List;

/**
 * 数据共享交换接入部门接口
 * @author wgj
 * @createtime 2018-5-01
 */
public interface ShareJoinOrgService extends BaseAllService<Long,ShareJoinOrg,ShareJoinOrgExample> {
    /**
     * 插入接入部门
     * @param unitId 单位id
     * @param unitId 用户id
     * @author wgj
     * @createtime 2018-5-01
     */
    public void insertJoinOrg(String unitId,Long userId);

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
