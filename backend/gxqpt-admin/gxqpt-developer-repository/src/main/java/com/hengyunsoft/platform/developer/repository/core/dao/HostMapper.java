package com.hengyunsoft.platform.developer.repository.core.dao;

import com.hengyunsoft.platform.developer.entity.core.po.Host;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.core.po.Host, com.hengyunsoft.platform.developer.repository.core.example.HostExample> {
    List<Host> findHostList(@Param("host")Host host,@Param("hostAdmin") Long hostAdmin);
}