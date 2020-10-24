package com.hengyunsoft.platform.exchange.repository.system.dao;

import com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareSystemMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem, com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample> {
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<ShareSystem> findSystemList(@Param("contractor") String contractor, @Param("status")Integer status, @Param("sysArch")Integer sysArch, @Param("majorData")String majorData, @Param("sysName")String sysName,@Param("orgId")String orgId);
}