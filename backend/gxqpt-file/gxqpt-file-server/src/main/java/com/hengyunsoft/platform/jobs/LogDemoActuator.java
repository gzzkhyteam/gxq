package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.logs.repository.logs.dao.LogFileInterfaceMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 日志系统造"数据"专用，为了"解决"日志系统的解析bug。
 *
 * @author tangyh
 * @date 2019-07-08 10:28
 */
@Component
@Slf4j
public class LogDemoActuator {

    @Autowired
    private LogFileInterfaceMapper logFileInterfaceMapper;


    @Scheduled(cron = "0 0/59 * * * ?")
    public void updateParsedSattus() {
        try {
            long start = System.currentTimeMillis();
            logFileInterfaceMapper.updateParsedSattus();
            log.info("强制修改状态耗时:{}", (System.currentTimeMillis() - start));
        } catch (Exception e) {
            log.error("强制修改状态失败", e);
        }
    }
}
