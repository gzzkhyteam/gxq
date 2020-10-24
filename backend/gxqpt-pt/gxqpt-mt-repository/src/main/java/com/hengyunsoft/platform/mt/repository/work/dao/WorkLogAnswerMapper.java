package com.hengyunsoft.platform.mt.repository.work.dao;

import com.hengyunsoft.platform.mt.entity.work.po.WorkLogAnswer;
import com.hengyunsoft.platform.mt.repository.work.example.WorkLogAnswerExample;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkLogAnswerMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, WorkLogAnswer, WorkLogAnswerExample> {
}