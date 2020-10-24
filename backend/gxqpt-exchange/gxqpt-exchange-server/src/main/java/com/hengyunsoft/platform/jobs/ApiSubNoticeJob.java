package com.hengyunsoft.platform.jobs;


import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiSubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：API数据更新定时通知已订阅的用户
 * 修改人：zhaopengfei
 * 修改时间：2018/9/17
 * 修改内容：
 */
@Component
@Slf4j
public class ApiSubNoticeJob {
    @Autowired
    private ShareDataApiSubscriptionService shareDataApiSubscriptionService;

    /**
     * 定时生成告警信息
     */
    @Scheduled(cron = "0 0 2 * * ?")//每天2点执行
//    @Scheduled(cron = "0/60 * * * * ?")//每30秒执行一次
    public void saveAlarmInformation() {
        log.info("API数据更新定时通知已订阅的用户", LocalDateTime.now());
        try {
            shareDataApiSubscriptionService.updateSendNotice();
        } catch (Exception e) {
            log.error("订阅通知出错", e);
        }
    }


}
