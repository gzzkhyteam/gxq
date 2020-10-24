package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiSubscription;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiSubscriptionExample;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请消息订阅通知Service
 * 修改人：zhaopengfei
 * 修改时间：2018/9/17
 * 修改内容：
 */

public interface ShareDataApiSubscriptionService extends BaseAllService<Long, ShareDataApiSubscription, ShareDataApiSubscriptionExample> {
    /**
     * 描述：API数据更新定时通知已订阅的用户
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/9/17
     * 修改内容：
     */
    void updateSendNotice() throws Exception;
    /**
     * 描述：用于数据集非结构化目录修改文件后发送订阅更新消息
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/9/17
     * 修改内容：
     */
    void saveUnStructNotice(Long setId);

}
