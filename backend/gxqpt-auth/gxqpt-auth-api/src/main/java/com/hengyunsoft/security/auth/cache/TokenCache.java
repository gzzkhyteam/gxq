package com.hengyunsoft.security.auth.cache;

import java.util.StringJoiner;
import java.util.function.Supplier;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.cache.KeyGenerator;
import com.hengyunsoft.cache.RedisHashCache;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.utils.SpringUtil;

import org.springframework.data.redis.core.RedisTemplate;

@Deprecated
public class TokenCache extends RedisHashCache<String, String, String> {
    /**
     * 业务key
     */
    private static final String CACHE_RESOURCE_COLLECTION = "app:token";
    private static final RedisTemplate<String, String> REDIS_TEMPLATE = SpringUtil.getBean("redisTemplate", RedisTemplate.class);

    private final AuthTokenApi authTokenApi = SpringUtil.getBean(AuthTokenApi.class);
    private final String appId;
    private final String appSecret;

    private TokenCache(String appId, String appSecret) {
        super(() -> REDIS_TEMPLATE);
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    protected String key() {
        return keyGenerator(CACHE_RESOURCE_COLLECTION, appId);
    }

    @Override
    protected String field() {
        return appId;
    }

    protected String keyGenerator(CharSequence... values) {
        KeyGenerator bean = SpringUtil.getBean(KeyGenerator.class);
        if (bean != null) {
            return new StringJoiner(":")
                    .add(bean.keyPrefix())
                    .add("gxqpt-auth-server")
                    .add(String.join(":", values))
                    .toString();
        } else {
            return String.join(":", values);
        }
    }

    @Override
    protected Supplier<String> getDefaultSupplier() {
    	
        return () -> {
        				Result<TokenVo> token = authTokenApi.token(appId, appSecret);
        				if(token.isSuccess()) {
        					return token.getData().getToken();
        				} else {
        					throw new BizException(token.getErrcode(), token.getErrmsg());
        				} 
        			};
    }

    public static TokenCache of(String appId, String appSecret ) {
        return new TokenCache(appId, appSecret);
    }
}
