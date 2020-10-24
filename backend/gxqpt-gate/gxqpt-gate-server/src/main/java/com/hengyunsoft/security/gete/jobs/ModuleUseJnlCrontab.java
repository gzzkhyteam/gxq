package com.hengyunsoft.security.gete.jobs;

import com.hengyunsoft.platform.developer.api.service.api.ModuleUseJnlApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.ModuleUseJnlSaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定时获取缓存中功能调用信息,并将信息定时五分钟轮训一次取出来
 * 记录到数据库，处理后清除缓存中的东西。
 * @author sxy
 * @createTime 2018-6-13
 *
 */
@RestController
@Slf4j
public class ModuleUseJnlCrontab {

    @Autowired
    private ModuleUseJnlApi moduleUseJnlApi;

    @SuppressWarnings("rawtypes")
    @Resource(name = "redisJdkTemplate")
    private  RedisTemplate redisTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 功能使用缓存标识
     */
    public final static String MODULE_USE_JNL_CACHE = "module_use_jnl_cache";

    /**
     * 定时获取缓存中功能调用信息上报到数据库中,5分钟上报一次
     * @throws Exception
     */
    //@Scheduled(cron = "0/3 * * * * ?")//每30秒执行一次
    @Scheduled(cron = "0 0/5 * * * ?")//每5分钟执行一次
    public void send() {
        log.info("定时获取缓存中功能调用信息上报到数据库开始");
        try {
            //redis不存在
            if(redisTemplate == null){
                log.info("定时获取缓存中功能调用信息开始,redis服务不存在!!");
                return;
            }
            ConcurrentHashMap<String,Object> map = (ConcurrentHashMap<String,Object>)
                    redisTemplate.opsForValue().get(keyPrefix + ":" + MODULE_USE_JNL_CACHE);

            //无缓存数据
            if(map==null){
                log.info("定时获取缓存中功能调用信息开始,暂无缓存数据!!");
                return;
            }
            Set<String> set = map.keySet();
            for(String key:set){
                ModuleUseJnlSaveDTO dto = (ModuleUseJnlSaveDTO)map.get(key);
                if(dto!=null){
                    moduleUseJnlApi.save(dto);//上报缓存数据
                }
                log.info("定时获取缓存中功能调用信息上报到数据库结束,key,[{}]",key);
            }
            redisTemplate.delete(keyPrefix + ":" + MODULE_USE_JNL_CACHE);//删除缓存
        } catch (Exception e) {
            log.info("定时获取缓存中功能调用信息上报到数据库失败!!",e);
        }
    }
}
