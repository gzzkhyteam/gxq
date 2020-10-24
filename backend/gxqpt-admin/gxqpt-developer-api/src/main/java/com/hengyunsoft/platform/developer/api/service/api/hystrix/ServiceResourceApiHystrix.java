package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.service.api.ServiceResourceApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDocDTO;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务资源管理Api熔断
 * 修改人：sunxiaoya
 * 修改时间：2018/4/4
 * 修改内容：新增基础接口
 */
@Component
public class ServiceResourceApiHystrix implements ServiceResourceApi {
    @Override
    public Result<List<ServiceResourceDTO>> getByModuleId(Long moduleId) {
        return Result.timeout();
    }

    @Override
    public Result<ServiceResourceDocDTO> getById(Long moduleId) {
        return Result.timeout();
    }

	@Override
	public Result<List<ServiceResourceDTO>> getServiceAllPublicUrlsUsableByAppId(String appId) {
		return Result.timeout();
	}

	@Override
	public Result<List<ServiceResourceDTO>> getServiceResourceOfAppPrivateUsable(String appId) {
		return Result.timeout();
	}


	@Override
	public Result<List<ServiceResourceDTO>> getServiceResourceOfUserAppConsumer(String likeResourceName) {
		return Result.timeout();
	}
}
