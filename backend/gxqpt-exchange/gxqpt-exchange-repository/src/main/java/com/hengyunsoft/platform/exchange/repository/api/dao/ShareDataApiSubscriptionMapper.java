package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.ApiUseSubscriptionDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDataApiSubscriptionMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiSubscription, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiSubscriptionExample> {
    /**
     * 描述：根据数据集Id和数据类型查询该申请api的通知相关信息
     * 参数：param : setId 数据集Id，可为空, dateType ： 数据集类型：1、结构化目录，2、非结构化目录
     * 返回值： List<ApiUseSubscriptionDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/9/17
     * 修改内容：
     */
    List<ApiUseSubscriptionDO> selectSubcriptionInfoList(Map<String,Object> param);
}