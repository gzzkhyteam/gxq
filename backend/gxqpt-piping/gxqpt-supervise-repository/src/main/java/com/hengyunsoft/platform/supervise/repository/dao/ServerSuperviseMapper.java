package com.hengyunsoft.platform.supervise.repository.dao;

import com.hengyunsoft.platform.supervise.entity.po.ServerSupervise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerSuperviseMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.supervise.entity.po.ServerSupervise, com.hengyunsoft.platform.supervise.repository.example.ServerSuperviseExample> {
    List<ServerSupervise> getUsableConfig();
}