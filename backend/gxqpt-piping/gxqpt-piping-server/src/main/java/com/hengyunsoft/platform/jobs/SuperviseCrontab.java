package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.supervise.impl.center.AppRunningSuperviseApiImpl;
import com.hengyunsoft.platform.supervise.impl.center.PowerSuperviseTempApiImpl;
import com.hengyunsoft.platform.supervise.impl.center.ServerSuperviseApiImpl;
import com.hengyunsoft.platform.supervise.impl.center.StorageSuperviseApiImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 统一监管配置中心定时任务
 * @author sxy
 * @createTime 2018-9-14
 *
 */
@RestController
@Slf4j
public class SuperviseCrontab {

    @Autowired
    private AppRunningSuperviseApiImpl appRunningSuperviseApiImpl;

    @Autowired
    private StorageSuperviseApiImpl storageSuperviseApi;

    @Autowired
    private PowerSuperviseTempApiImpl powerSuperviseTempApiImpl;

    @Autowired
    private ServerSuperviseApiImpl serverSuperviseApi;

    @SuppressWarnings("rawtypes")
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 定时获取缓存服务调用统计信息,，轮训周期一小时
     * @throws Exception
     */
    //@Scheduled(cron = "0/3 * * * * ?")//每30秒执行一次
    //@Scheduled(cron = "0 0/5 * * * ?")//每5分钟执行一次
    @Scheduled(cron = "0 0 0/1 * * ?") //每个小时整点执行一次
    public void addHandleServerSupervise(){
        log.info("定时获取缓存服务调用统计信息,轮训周期一小时");
        serverSuperviseApi.addHandleServerSupervise();
    }

    /**
     * 处理监管环节
     */
    //@Scheduled(cron = "0/3 * * * * ?")//每30秒执行一次
    //@Scheduled(cron = "0 0 */2 * * ?") //每两小时执行一次
    @Scheduled(cron = "0 0/5 * * * ?")//每5分钟执行一次
    public void addHandleSuperviseLink(){
        log.info(" 处理监管环节");
        powerSuperviseTempApiImpl.addHandleSuperviseLink();
    }

    /**
     * 应用运行最大在线数统计
     */
    @Scheduled(cron = "0 0/5 * * * ?")//每5分钟执行一次
    public void findOnlineMaxNum(){
        log.info(" 应用运行最大在线数统计");
        appRunningSuperviseApiImpl.findOnlineMaxNum();
    }

    /**
     * 数据存储阀值统计
     */
    @Scheduled(cron = "0 0/5 * * * ?")//每5分钟执行一次
    public void findSpaceNum(){
        log.info(" 数据存储阀值统计");
        storageSuperviseApi.findSpaceNum();
    }
}
