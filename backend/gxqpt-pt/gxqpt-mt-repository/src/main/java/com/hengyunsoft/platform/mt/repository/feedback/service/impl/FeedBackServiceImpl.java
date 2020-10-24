package com.hengyunsoft.platform.mt.repository.feedback.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBack;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBackBase;
import com.hengyunsoft.platform.mt.repository.feedback.dao.FeedBackMapper;
import com.hengyunsoft.platform.mt.repository.feedback.example.FeedBackExample;
import com.hengyunsoft.platform.mt.repository.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedBackServiceImpl extends BaseServiceImpl<Long, FeedBack, FeedBackExample> implements FeedBackService {
    @Autowired
    private FeedBackMapper feedBackMapper;

    @Override
    protected BaseNormalDao<Long, FeedBack, FeedBackExample> getDao() {
        return feedBackMapper;
    }

    @Override
    public List<FeedBackBase> findFeedBackList(Map<String, Object> param) {
        return feedBackMapper.findFeedBackList(param);
    }

    @Override
    public List<FeedBackBase> appFindFeedBackList(Long createUser) {
        return feedBackMapper.appFindFeedBackList(createUser);
    }

    @Override
    public Integer getNotReadCount(Long createUser) {
        return feedBackMapper.getNotReadCount(createUser);
    }
}
