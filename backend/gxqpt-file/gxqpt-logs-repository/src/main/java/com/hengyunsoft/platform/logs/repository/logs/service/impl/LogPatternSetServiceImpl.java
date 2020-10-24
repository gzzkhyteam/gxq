package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogPatternSetMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogPatternSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogPatternSetServiceImpl extends BaseAllServiceImpl<Long, LogPatternSet, LogPatternSetExample> implements LogPatternSetService {
    @Autowired
    private LogPatternSetMapper logPatternSetMapper;
    @Override
    protected BaseNormalDao<Long, LogPatternSet, LogPatternSetExample> getDao() {
        return logPatternSetMapper;
    }

    /**
     * 分页查询日志文件格式
     * @return
     */
    public List<LogPatternSet> pageQueryPattern(LogPatternSetExample example){
       return  logPatternSetMapper.pageQueryPattern(example);
    }

}
