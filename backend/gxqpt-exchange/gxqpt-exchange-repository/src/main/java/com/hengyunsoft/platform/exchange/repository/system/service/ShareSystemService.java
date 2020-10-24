package com.hengyunsoft.platform.exchange.repository.system.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareDict;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareDictExample;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统列表service
 * @author wt
 * @createtime 2018-04-23
 */
public interface ShareSystemService extends BaseAllService<Long,ShareSystem,ShareSystemExample> {
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<ShareSystem> findSystemList(String contractor,Integer status,Integer sysArch,String majorData,String sysName,String orgId);
}
