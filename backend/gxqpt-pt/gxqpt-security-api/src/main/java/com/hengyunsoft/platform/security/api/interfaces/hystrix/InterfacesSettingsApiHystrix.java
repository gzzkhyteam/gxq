package com.hengyunsoft.platform.security.api.interfaces.hystrix;

import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsApi;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;

import org.springframework.stereotype.Component;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Component
public class InterfacesSettingsApiHystrix implements InterfacesSettingsApi {
    @Override
    public Result<List<Long>> findNeedFilter() {
        return Result.timeout();
    }

    @Override
    public Result<InterfaceConfigDTO> getById(Long id) {
        return Result.timeout();
    }
}
