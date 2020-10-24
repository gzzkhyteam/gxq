package com.hengyunsoft.security.ratelimit.service.ratelimit.repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.security.ratelimit.service.Rate;
import com.hengyunsoft.security.ratelimit.service.ratelimit.RateLimiter;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *  具体策略(ConcreteStrategy)角色：包装了相关的算法或行为
 *
 * 基于Redis的限流器具体实现 *(推荐)
 *
 * @author tangyh
 */
@Slf4j
@RequiredArgsConstructor
public class RedisRateLimiter implements RateLimiter {
    private final RedisTemplate<String, Long> template;

    @Override
    @SuppressWarnings("unchecked")
    public Rate consume(final RateLimitProperties.Policy policy, final String key) {
        int cycleType = policy.getCycleType();
        final Long limit = policy.getLimit();  //限制次数

        Date expiration = null;
        //开始时间还没到时， 直接返回
        if (RateLimitProperties.Policy.DATE_BETWEEN == cycleType) {
            if (policy.getStart() == null || policy.getEnd() == null) {
                return null;
            }

            //时间还没到
            if (new Date().before(policy.getStart())) {  //
                Duration duration = Duration.between(LocalDateTime.now(), DateUtils.date2LocalDateTime(policy.getEnd()));

                return new Rate(key, limit, duration.getSeconds(), policy.getEnd());
            }
            //时间已过
            if (new Date().after(policy.getEnd())) {  //
                return new Rate(key, limit, 0L, policy.getEnd());
            }
        }

        //curent = 4
        // limit = 4
        // 5
        // 次数 + 1
        final Long current = this.template.boundValueOps(key).increment(1L); //次数增加1
        if(current > limit){
            log.info("超过调用次数了={}", current, limit);
            this.template.boundValueOps(key).set(limit);
        }
        Long expire = this.template.getExpire(key);
        LocalDateTime now = LocalDateTime.now();  //当前时间

        switch (cycleType) {
            case RateLimitProperties.Policy.REFRESH_INTERVAL:  //1

                final Long refreshInterval = policy.getRefreshInterval();  //刷新周期（秒）
                if (expire == null || expire == -1) {
                    this.template.expire(key, refreshInterval, SECONDS);
                    expire = refreshInterval;
                }

                LocalDateTime expirationDateTime = now.plusSeconds(expire);
                expiration = DateUtils.localDateTime2Date(expirationDateTime);

                break;
            case RateLimitProperties.Policy.DATE_BETWEEN: //3

                if (expire == null || expire == -1) { //第一次访问时，需要设置过期时间
                    //计算当前时间和结束时间的差值
                    Duration duration = Duration.between(LocalDateTime.now(), DateUtils.date2LocalDateTime(policy.getEnd()));

                    expire = duration.getSeconds();
                    this.template.expire(key, expire, SECONDS);
                }

                expiration = policy.getEnd();
                break;

            case RateLimitProperties.Policy.DAY_INTERVAL://2
            default:
                int day = policy.getDay();
                day = day <= 0 ? 1 : day;

                //day-1 天之后的23:59:59
                LocalDateTime daysAfter = now.plusDays(day - 1).withHour(23).withMinute(59).withSecond(59);
                expiration = DateUtils.localDateTime2Date(daysAfter);

                if (expire == null || expire == -1) { //第一次访问时，需要设置过期时间

                    //计算差值
                    Duration duration = Duration.between(now, daysAfter);

                    log.info("getSeconds={}", duration.getSeconds());
                    this.template.expire(key, duration.getSeconds(), SECONDS);
                    expire = duration.getSeconds();

                }
                break;
        }


//        return new Rate(key, Math.max(-1, limit - current), SECONDS.toSeconds(expire), expiration);
        return new Rate(key, Math.max(-1, limit - current), expire, expiration);
    }


}