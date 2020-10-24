package com.hengyunsoft.platform.security.api.interfaces;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.cache.RedisListCache;
import com.hengyunsoft.utils.SpringUtil;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/06
 */
public class InterfacesSettingsIdListCache extends RedisListCache<String, Long> {
    /**
     * 业务key
     */
    private static final String CACHE_RESOURCE_COLLECTION = "pt:interfaceslist";
    private static final RedisTemplate<String, Long> REDIS_TEMPLATE = SpringUtil.getBean("redisLongTemplate", RedisTemplate.class);

    private final InterfacesSettingsApi interfacesSettingsApi = SpringUtil.getBean(InterfacesSettingsApi.class);

    private InterfacesSettingsIdListCache() {
        super(() -> REDIS_TEMPLATE);

    }

    @Override
    protected String key() {
        return keyGenerator(CACHE_RESOURCE_COLLECTION);
    }

    @Override
    protected Supplier<List<Long>> getDefaultSupplier() {
//        Result<List<Long>> resultList = interfacesSettingsApi.findNeedFilter();
//        if(resultList.isSuccess()){
//            return ()-> resultList.getData();
//        }
//        return () -> Collections.emptyList();

        return () -> {
            Result<List<Long>> resultList = interfacesSettingsApi.findNeedFilter();
            if (resultList.isSuccess()) {
                return resultList.getData();
            }
            return Collections.emptyList();
        };
    }

    public static InterfacesSettingsIdListCache of() {
        return new InterfacesSettingsIdListCache();
    }
}
