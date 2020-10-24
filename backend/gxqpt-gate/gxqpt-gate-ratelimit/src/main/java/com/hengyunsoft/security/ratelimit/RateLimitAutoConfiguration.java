package com.hengyunsoft.security.ratelimit;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.cache.KeyGenerator;
import com.hengyunsoft.security.ratelimit.config.properties.GateIgnore2Properties;
import com.hengyunsoft.security.ratelimit.filter.CallRecordFilter;
import com.hengyunsoft.security.ratelimit.filter.WarnLimitFilter;
import com.hengyunsoft.security.ratelimit.queue.SecurityQueueSender;
import com.hengyunsoft.security.ratelimit.service.ratelimit.RateLimiter;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;
import com.hengyunsoft.security.ratelimit.service.ratelimit.repository.InMemoryRateLimiter;
import com.hengyunsoft.security.ratelimit.service.ratelimit.repository.RedisRateLimiter;
import com.hengyunsoft.security.ratelimit.filter.RateLimitFilter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * ConditionalOnProperty
 * 当且仅当application.yml 存在制定的配置项（zuul.ratelimit.enabled = true）,在创建RateLimitAutoConfiguration类和类中bean的实例
 *
 * @auth tangyh
 * @date 2018/07/02
 */
@Configuration
@EnableConfigurationProperties(value = {
        RateLimitProperties.class,
        GateIgnore2Properties.class
})
//@ConditionalOnClass(EnableAceGateRateLimit.class)
@ConditionalOnProperty(prefix = RateLimitProperties.PREFIX, name = "enabled", havingValue = "true")
public class RateLimitAutoConfiguration {

    @Bean
    public SecurityQueueSender securityQueueSender() {
        return new SecurityQueueSender();
    }

    @Bean
    public RateLimitFilter rateLimiterFilter(
            final RateLimiter rateLimiter
            , final RateLimitProperties rateLimitProperties
            , final RouteLocator routeLocator
            , final SecurityQueueSender securityQueueSender
    ) {
//        return new RateLimitFilter(rateLimiter, rateLimitProperties, routeLocator, userPrincipal);
        return new RateLimitFilter(rateLimiter, rateLimitProperties, routeLocator, securityQueueSender);
    }

    @Bean
    public WarnLimitFilter warnLimitFilter(
            final RateLimiter rateLimiter
            , final RateLimitProperties rateLimitProperties
            , final RouteLocator routeLocator
            , final SecurityQueueSender securityQueueSender
    ) {
        return new WarnLimitFilter(rateLimiter, rateLimitProperties, routeLocator, securityQueueSender);
    }

    @Bean
    public CallRecordFilter callRecordFilter(
            final SecurityQueueSender securityQueueSender,
            final RateLimitProperties rateLimitProperties,
            final RouteLocator routeLocator
    ) {
        return new CallRecordFilter(rateLimitProperties, routeLocator, securityQueueSender);
    }

    /**
     * 当存在 RedisTemplate 类, 并且不存在 RateLimiter 类， 并且zuul.ratelimit.repository=REDIS 时，创建RedisConfiguration类和类中当bean
     */
    @ConditionalOnClass(RedisTemplate.class)
    @ConditionalOnMissingBean(RateLimiter.class)
    @ConditionalOnProperty(prefix = RateLimitProperties.PREFIX, name = "repository", havingValue = "REDIS")
    public static class RedisConfiguration {
//        @Bean("rateLimiterRedisTemplate")
//        public StringRedisTemplate redisTemplate(final RedisConnectionFactory connectionFactory) {
//            StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
//            template.setConnectionFactory(connectionFactory);
//            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper om = new ObjectMapper();
//            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            jackson2JsonRedisSerializer.setObjectMapper(om);
//            template.setValueSerializer(jackson2JsonRedisSerializer);
//            template.setHashValueSerializer(jackson2JsonRedisSerializer);
//            template.afterPropertiesSet();
//            return template;
//        }

        @Bean("redisTemplate")
        public RedisTemplate redisTemplate(final RedisConnectionFactory connectionFactory) {
            StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
            template.setConnectionFactory(connectionFactory);
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            template.setValueSerializer(jackson2JsonRedisSerializer);
            template.setHashValueSerializer(jackson2JsonRedisSerializer);
            template.afterPropertiesSet();
            return template;
        }

        @Bean("redisLongTemplate")
        public RedisTemplate redisLongTemplate(final RedisConnectionFactory connectionFactory) {
            StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
            template.setConnectionFactory(connectionFactory);
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Long.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            template.setValueSerializer(jackson2JsonRedisSerializer);
            template.setHashValueSerializer(jackson2JsonRedisSerializer);
            template.afterPropertiesSet();
            return template;
        }


        @Bean
        public RateLimiter redisRateLimiter(@Qualifier(value = "redisLongTemplate") final RedisTemplate<String, Long> redisTemplate) {
            return new RedisRateLimiter(redisTemplate);
        }


        @Bean("cacheKeyGenerator")
        @ConditionalOnMissingBean(KeyGenerator.class)
        public KeyGenerator keyGenerator() {
            return new KeyGenerator();
        }
    }


    @ConditionalOnMissingBean(RateLimiter.class)
    @ConditionalOnProperty(prefix = RateLimitProperties.PREFIX, name = "repository", havingValue = "IN_MEMORY", matchIfMissing = true)
    public static class InMemoryConfiguration {
        @Bean
        public RateLimiter inMemoryRateLimiter() {
            return new InMemoryRateLimiter();
        }
    }

}
