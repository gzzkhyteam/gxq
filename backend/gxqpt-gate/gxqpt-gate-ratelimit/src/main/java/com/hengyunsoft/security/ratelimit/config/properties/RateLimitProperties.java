package com.hengyunsoft.security.ratelimit.config.properties;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import static com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties.PREFIX;

/**
 * 速率限制配置
 *
 * @auth tangyh
 * @date 2018/07/02
 */
@Data
@Validated
@NoArgsConstructor
@ConfigurationProperties(PREFIX)
public class RateLimitProperties {
    public static final String PREFIX = "zuul.ratelimit";
    /** 默认的策略 */
    private Policy defaultPolicy;
    /** 策略
     * key：接口服务的id
     * value: 具体的限制政策
     * */
    private Map<String, Policy> policies = new HashMap<>();
    /** 代理 */
    private boolean behindProxy;
    /** 是否启用 */
    private boolean enabled;
    /** key前缀  */
    private String keyPrefix;
    /** 存储方式 */
    private Repository repository = Repository.REDIS;

    public enum Repository {
        /** mybatis(未实现) */
        MYBATIS,
        /** 缓存 */
        REDIS,
        /** 内存 */
        IN_MEMORY;
    }

    public Optional<Policy> getPolicy(String key) {
        return Optional.ofNullable(policies.getOrDefault(key, defaultPolicy));
    }

    @Data
    public static class Policy {
        public final static int REFRESH_INTERVAL = 1;
        public final static int DAY_INTERVAL = 2;
        public final static int DATE_BETWEEN = 3;


        /** 周期限制类型
         * 1：指定的秒数循环 refreshInterval
         * 2: 多少天  的限制次数
         * 3: 某段时间类  start-end
         * */
        private int cycleType = 1;

        //刷新时间：1s
        private Long refreshInterval = TimeUnit.MINUTES.toSeconds(1L);

        /** 多少天内 */
        private int day;

        //开始时间
        private Date start;
        //时间
        private Date end;

        //限制次数
        private Long limit;

        /**
         * 限制类型。 组成限制key的因素
         *
         */
        private List<Type> type = new ArrayList<>();

        //非配置字段
        //应用id 区分应用下相同的url
        private String appId;
        //接口的方法
        private String method;
        //接口id
        private Long id;
        public enum Type {
            /** IP 来源（未实现） */
            ORIGIN,
            /** 用户（未实现） */
            USER,
            /**
             * 应用
             */
            APP,
            /**
             * 链接
             */
            URL,;
        }

    }

}
