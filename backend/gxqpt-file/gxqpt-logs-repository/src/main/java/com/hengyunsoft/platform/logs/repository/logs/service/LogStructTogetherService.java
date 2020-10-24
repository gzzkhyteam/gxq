package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogStructTogetherDO;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTogetherExample;

import java.util.List;

public interface LogStructTogetherService {
    /**
     *分页查询结构化日志
     * @param example
     * @return
     */
    List<LogStructTogetherDO> pageQueryStructTogether(LogStructTogetherExample example);
}
