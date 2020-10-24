package com.hengyunsoft.platform.piping.repository.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptPingpingWarnTypeMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.piping.entity.message.GxqptPingpingWarnType, com.hengyunsoft.platform.piping.repository.example.GxqptPingpingWarnTypeExample> {

    List<Long> getTypeId();
}