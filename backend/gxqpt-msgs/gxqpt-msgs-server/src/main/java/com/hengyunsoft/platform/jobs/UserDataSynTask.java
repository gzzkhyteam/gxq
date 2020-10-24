package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.mail.repository.service.user.UserRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 定时同步用户表数据到邮件用户表中
 * @author wt
 * @createTime 2018-8-17
 *
 */
@RestController
@Slf4j
public class UserDataSynTask {
    @Resource
    private UserRegisterService userRegisterService;

    /**
     * 定时同步copy_core_c_user表数据到邮件用户表，凌晨1点半跑前一天年数据
     * update 2019年4月26日 由于测试提出用户同步周期影响发送邮件，调整为每半个小时执行一次
     * @throws Exception
     */

    @Scheduled(cron = "0 0/30 * * * ? ")
    public void saveSend() {
        log.info("定时获取缓存中功能调用信息上报到数据库开始");
        try {
            log.info("开始执行定时任务");
            userRegisterService.synUserData();
            log.info("结束执行定时任务");
        } catch (Exception e) {
            log.error("定时获取缓存中功能调用信息上报到数据库失败!!",e);
        }
    }
}
