package com.hengyunsoft.platform.mt.repository.feedback.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBack;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBackBase;
import com.hengyunsoft.platform.mt.repository.feedback.example.FeedBackExample;

import java.util.List;
import java.util.Map;

public interface FeedBackService extends BaseService<Long, FeedBack, FeedBackExample> {
    /***
     * 查询意见反馈列表
     * @param param
     * @return
     */
    List<FeedBackBase> findFeedBackList(Map<String, Object> param);

    /***
     * 查询我的意见反馈
     * @param adminId
     * @return
     */
    List<FeedBackBase> appFindFeedBackList(Long createUser);

    /***
     * 得到用户的未读消息数量
     * @param createUser
     * @return
     */
    Integer getNotReadCount(Long createUser);
}
