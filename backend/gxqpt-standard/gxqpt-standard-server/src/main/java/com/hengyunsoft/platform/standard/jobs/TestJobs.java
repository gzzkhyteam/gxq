package com.hengyunsoft.platform.standard.jobs;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.open.FileOpenJobsApi;
import com.hengyunsoft.security.auth.cache.TokenCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class TestJobs {

    @Autowired
    private FileOpenJobsApi fileOpenJobsApi;

    //根据业务，决定这里配置的appid是那个系统的， 这里配置标准系统的appId和AppSecret
    @Value("${gxqpt.standard-web.app-id:25kj6354}")
    private String appId;
    @Value("${gxqpt.standard-web.app-secret:standar25kj6354}")
    private String appSecret;

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void test() {
        log.info("" + new Date());

        //查询你们的数据库，获取文件id
        Long[] fileId = new Long[]{1593655165377L};

        Optional<String> tokenOption = TokenCache.of(appId, appSecret).get();
        if (tokenOption.isPresent()) {
            String token = tokenOption.get();
            log.info("token={}", tokenOption.get());
            Result<List<FileDownWaterDTO>> result = fileOpenJobsApi.findDownWater(token, fileId, null, null);
            if (result.isSuccess()) {

                log.info("list.size()={}", result.getData().size());
            }
        }

    }
}
