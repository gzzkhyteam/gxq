package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Repository
public interface LogPatternSetMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet, com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample> {
    List<LogPatternSet> pageQueryPattern(LogPatternSetExample example);

}