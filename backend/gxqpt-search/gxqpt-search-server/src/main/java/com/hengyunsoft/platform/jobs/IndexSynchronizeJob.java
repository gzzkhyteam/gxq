package com.hengyunsoft.platform.jobs;


import com.hengyunsoft.platform.search.impl.ApiSearchImpl;
import com.hengyunsoft.platform.search.impl.DirectorySearchImpl;
import com.hengyunsoft.platform.search.impl.SearchApiImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 索引同步定时
 * 存在索引数据不一致问题，需要定时增量同步保持一致性。
 *
 */
@Component
@Slf4j
public class IndexSynchronizeJob {

    @Autowired
    SearchApiImpl api;
    @Autowired
    DirectorySearchImpl directorySearch;
    @Autowired
    ApiSearchImpl apiSearch;

    /**
     * 服务监控系统索引同步定时
     */
    @Scheduled(cron = "0 0 1 * * ?")//每天晚上1点执行
    //@Scheduled(cron = "0 0/5 * * * ?")//每5分钟执行一次
    public void addOrUpdateBatchIndex() {
        log.info("服务监控系统-API及帮助文档索引同步定时开始----------->");
        api.addOrUpdateBatchIndex();
    }

    /**
     * 共享交换系统索引同步定时
     */
    @Scheduled(cron = "0 0 2 * * ?")//每天晚上2点执行
    public void addOrUpdateBatchIndexDirectory() {
        log.info("共享交换系统-数据目录索引同步定时开始------------------>");
        directorySearch.addOrUpdateBatchIndex();
    }


    /**
     * 共享交换系统索引同步定时
     */
    @Scheduled(cron = "0 0 3 * * ?")//每天晚上3点执行
    public void addOrUpdateBatchIndexApi() {
        log.info("共享交换系统-API索引同步定时开始---------------------->");
        apiSearch.addOrUpdateBatchIndex();
    }
}
