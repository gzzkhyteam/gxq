package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;

import java.util.List;

public interface LogPatternSetService extends BaseAllService<Long, LogPatternSet, LogPatternSetExample> {
    /**
     * 分页查询日志文件格式
     * @return
     */
    List<LogPatternSet> pageQueryPattern(LogPatternSetExample example);

}
