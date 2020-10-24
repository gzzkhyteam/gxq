package com.hengyunsoft.security.auth.jobs;

import java.util.List;

import javax.annotation.PostConstruct;

import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.repository.apply.dao.ApplicationMapper;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.service.AuthService;
import com.hengyunsoft.utils.JSONUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TokenRefreshActuator {

    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private AuthService authService;

    /**
     * 每1个小时刷新一次token
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void batchAppTokenRefresh() {
        log.info("-------定时刷新token-----");

        ApplicationExample appExample = new ApplicationExample();
        appExample.createCriteria().andStatusEqualTo(EnableStatus.ENABLE.getVal());
        List<Application> applicationList = applicationMapper.selectByExample(appExample);

        log.info("applicationList.size={}", applicationList.size());
        applicationList.forEach((app) -> {
            TokenVo tokenVo = authService.token(app.getAppId(), app.getAppSecret());
            log.info("刷新token：appId={}, tokenVo----{}", app.getAppId(), JSONUtils.toJsonString(tokenVo));

            TokenCache token = TokenCache.of(app.getAppId(), app.getAppSecret());
            token.set(tokenVo.getToken());
            token.expire(tokenVo.getExpire());
        });

    }

    //启动时执行一次,不需要启动执行的请不要盲目复制
    @PostConstruct
    public void init() {
        try {
            log.info("-------启动时刷新token-----");
            batchAppTokenRefresh();
        } catch (Exception e) {
            log.error("定时报错：", e);
        }
    }
}
