package com.hengyunsoft.security.gete.feign.hystrix;

import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.security.gete.feign.AuthInfoApi;

import org.springframework.stereotype.Component;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/11
 */
@Component
public class AuthInfoApiHystrix implements AuthInfoApi {
    @Override
    public Result<List<ResourceDTO>> findResByAppIdAndUserId(String appId, Long userId, String group, String token) {
        return Result.timeout();
    }

    @Override
    public Result<List<ResourceDTO>> getAppAllNotpublicResourceOfExistAuthUrls(String appId, String token) {
        return Result.timeout();
    }

    @Override
    public Result<List<ServiceResourceDTO>> getServiceAllPublicUrlsUsable(String appId, String token) {
        return Result.timeout();
    }

    @Override
    public Result<List<ServiceResourceDTO>> getServiceResourceOfAppPrivateUsable(String appId, String token) {
        return Result.timeout();
    }

    @Override
    public Result<List<Long>> getConsumerModuleIdsUsable(String consumerAppId, String token) {
        return Result.timeout();
    }

    @Override
    public Result<List<String>> getAllUseableJryy(String token) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationAllDTO>> findAllList(String token) {
        return Result.timeout();
    }
}
