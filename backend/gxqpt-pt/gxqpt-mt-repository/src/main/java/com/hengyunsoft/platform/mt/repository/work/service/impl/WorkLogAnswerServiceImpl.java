package com.hengyunsoft.platform.mt.repository.work.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.work.po.WorkLogAnswer;
import com.hengyunsoft.platform.mt.repository.work.dao.WorkLogAnswerMapper;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogAnswerExample;
import com.hengyunsoft.platform.mt.repository.work.service.WorkLogAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkLogAnswerServiceImpl extends BaseServiceImpl<Long,WorkLogAnswer,WorkLogAnswerExample> implements WorkLogAnswerService{
    @Autowired
    private WorkLogAnswerMapper workLogAnswerMapper;
    @Override
    protected BaseNormalDao<Long, WorkLogAnswer, WorkLogAnswerExample> getDao() {
        return workLogAnswerMapper;
    }
}
