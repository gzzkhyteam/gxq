package com.hengyunsoft.platform.security.api.interfaces;

import java.util.function.Supplier;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.cache.RedisStringCache;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;
import com.hengyunsoft.utils.SpringUtil;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
public class InterfacesSettingsBeanCache extends RedisStringCache<String, InterfaceConfigDTO> {
    /**
     * 业务key
     */
    private static final String CACHE_RESOURCE_COLLECTION = "pt:interfaces";
    private static final RedisTemplate<String, InterfaceConfigDTO> REDIS_TEMPLATE = SpringUtil.getBean("redisTemplate", RedisTemplate.class);

    private final InterfacesSettingsApi interfacesSettingsApi = SpringUtil.getBean(InterfacesSettingsApi.class);

    private Long id;

    private InterfacesSettingsBeanCache(Long id) {
        super(() -> REDIS_TEMPLATE);
        this.id = id;
    }

    @Override
    protected String key() {
        return keyGenerator(CACHE_RESOURCE_COLLECTION, String.valueOf(id));
    }

    @Override
    protected Supplier<InterfaceConfigDTO> getDefaultSupplier() {
        Result<InterfaceConfigDTO> dtoResult = interfacesSettingsApi.getById(this.id);
        if (dtoResult.isSuccess()) {
            return () -> dtoResult.getData();
        }
        return () -> null;
    }

    public static InterfacesSettingsBeanCache of(Long id) {
        return new InterfacesSettingsBeanCache(id);
    }
}
