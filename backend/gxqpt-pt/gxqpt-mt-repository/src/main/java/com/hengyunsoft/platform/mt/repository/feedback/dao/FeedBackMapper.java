package com.hengyunsoft.platform.mt.repository.feedback.dao;

import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBackBase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FeedBackMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.feedback.po.FeedBack, com.hengyunsoft.platform.mt.repository.feedback.example.FeedBackExample> {
    /***
     * 查询意见反馈列表
     * @param param
     * @return
     */
    List<FeedBackBase> findFeedBackList(Map<String, Object> param);

    /***
     * 查询我的意见反馈
     * @param createUser
     * @return
     */
    List<FeedBackBase> appFindFeedBackList(@Param("createUser") Long createUser);

    /***
     * 查询未读消息条数
     * @param createUser
     * @return
     */
    Integer getNotReadCount(@Param("createUser") Long createUser);
}