package com.hengyunsoft.platform.config;

import com.hengyunsoft.cache.KeyGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * @author tyh
 * @createTime 2017-12-22 17:52
 */


@Configuration
public class RedisConfiguration {
    @Bean("redisSuperviseTemplate")
    public RedisTemplate redisTemplate(final RedisConnectionFactory conn) {
        StringRedisTemplate template = new StringRedisTemplate(conn);
        template.setConnectionFactory(conn);
        JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer(RedisConfiguration.class.getClassLoader());
       
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

    @ConditionalOnMissingBean(KeyGenerator.class)
    @Bean("cacheKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator();
    }

}
