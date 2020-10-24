package com.hengyunsoft.platform.logs.repository.logs.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogStructTogetherDO;
import com.hengyunsoft.platform.logs.repository.logs.dao.LogStructTogetherMapper;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTogetherExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructTogetherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogStructTogetherServiceImpl extends BaseAllServiceImpl<Long, LogStructTogetherDO, LogStructTogetherExample> implements LogStructTogetherService {
    @Autowired
    private LogStructTogetherMapper logStructTogetherMapper;
    @Override
    protected BaseNormalDao<Long, LogStructTogetherDO, LogStructTogetherExample> getDao() {
        return logStructTogetherMapper;
    }
    @Override
    public List<LogStructTogetherDO> pageQueryStructTogether(LogStructTogetherExample example) {
        return logStructTogetherMapper.pageQueryStructTogether(example);
    }
}
