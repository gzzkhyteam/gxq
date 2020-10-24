package com.hengyunsoft.platform.mt.repository.feedback.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBackMsg;
import com.hengyunsoft.platform.mt.repository.feedback.dao.FeedBackMsgMapper;
import com.hengyunsoft.platform.mt.repository.feedback.example.FeedBackMsgExample;
import com.hengyunsoft.platform.mt.repository.feedback.service.FeedBackMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackMsgServiceImpl extends BaseServiceImpl<Long, FeedBackMsg, FeedBackMsgExample> implements FeedBackMsgService {
    @Autowired
    private FeedBackMsgMapper feedBackMsgMapper;

    @Override
    protected BaseNormalDao<Long, FeedBackMsg, FeedBackMsgExample> getDao() {
        return feedBackMsgMapper;
    }
}
