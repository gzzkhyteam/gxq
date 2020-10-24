package com.hengyunsoft.security.ratelimit.service.ratelimit.repository;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hengyunsoft.security.ratelimit.service.Rate;

/**
 * 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为
 *
 *
 * 基于内存的限流器具体实现
 * In memory rate limiter configuration for dev environment.
 *
 * @author tangyh
 * @since 2017-06-23
 */
public class InMemoryRateLimiter extends AbstractRateLimiter {

    private Map<String, Rate> repository = new ConcurrentHashMap<>();

    @Override
    protected Rate getRate(String key) {
        return this.repository.get(key);
    }

    @Override
    protected void saveRate(Rate rate) {
        this.repository.put(rate.getKey(), rate);
    }

}