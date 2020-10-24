package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogStructTogetherDO;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTogetherExample;

import java.util.List;

public interface LogStructTogetherMapper  extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.domain.LogStructTogetherDO, com.hengyunsoft.platform.logs.repository.logs.example.LogStructTogetherExample> {
    List<LogStructTogetherDO> pageQueryStructTogether(LogStructTogetherExample example);
}
