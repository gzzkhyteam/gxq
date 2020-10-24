package com.hengyunsoft.security.ratelimit.service.ratelimit;

import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;
import com.hengyunsoft.security.ratelimit.service.Rate;

/**
 * 速率 抽象策略(Strategy)角色
 * 这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 *
 * 抽象了消费次数的方法
 *
 * @auth tangyh
 * @date 2018/07/03
 */
public interface RateLimiter {
    /**
     * 消费
     * @param policy - 在没有与键相关的速率限制的情况下，应该为哪个速率创建模板
     * @param key    - 唯一key
     * @return 用户的速率请求限制的视图
     */
    Rate consume(RateLimitProperties.Policy policy, String key);
}
