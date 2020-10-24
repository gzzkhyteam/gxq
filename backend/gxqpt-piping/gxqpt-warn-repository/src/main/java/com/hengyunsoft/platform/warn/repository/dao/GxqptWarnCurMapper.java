package com.hengyunsoft.platform.warn.repository.dao;

import com.hengyunsoft.platform.warn.entity.po.GxqptWarnCur;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptWarnCurMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.warn.entity.po.GxqptWarnCur, com.hengyunsoft.platform.warn.repository.example.GxqptWarnCurExample> {
    List<GxqptWarnCur> getAll();
}