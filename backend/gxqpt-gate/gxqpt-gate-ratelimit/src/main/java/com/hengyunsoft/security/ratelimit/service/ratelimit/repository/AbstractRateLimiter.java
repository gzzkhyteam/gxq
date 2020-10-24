package com.hengyunsoft.security.ratelimit.service.ratelimit.repository;


import java.util.Date;

import com.hengyunsoft.security.ratelimit.service.Rate;
import com.hengyunsoft.security.ratelimit.service.ratelimit.RateLimiter;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties.Policy;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 *  抽象策略(ConcreteStrategy)角色：包装了相关的算法或行为
 * Abstract implementation for {@link RateLimiter}.
 *
 * @author tangyh
 * @since 2017-08-28
 */
public abstract class AbstractRateLimiter implements RateLimiter {

    /**
     * 根据key查询 Rate
     * @param key
     * @return
     */
    protected abstract Rate getRate(String key);

    /**
     * 保存
     * @param rate
     */
    protected abstract void saveRate(Rate rate);

    @Override
    public synchronized Rate consume(final Policy policy, final String key) {
        Rate rate = this.create(policy, key);
        this.updateRate(rate);
        this.saveRate(rate);
        return rate;
    }

    private Rate create(final Policy policy, final String key) {
        Rate rate = this.getRate(key);
        if (isExpired(rate)) {

            final Long limit = policy.getLimit();
            final Long refreshInterval = SECONDS.toMillis(policy.getRefreshInterval());
            final Date expiration = new Date(System.currentTimeMillis() + refreshInterval);

            rate = new Rate(key, limit, refreshInterval, expiration);
        }
        return rate;
    }

    private void updateRate(final Rate rate) {
        if (rate.getReset() > 0) {
            Long reset = rate.getExpiration().getTime() - System.currentTimeMillis();
            rate.setReset(reset);
        }
        rate.setRemaining(Math.max(-1, rate.getRemaining() - 1));
    }

    private boolean isExpired(final Rate rate) {
        return rate == null || (rate.getExpiration().getTime() < System.currentTimeMillis());
    }
}