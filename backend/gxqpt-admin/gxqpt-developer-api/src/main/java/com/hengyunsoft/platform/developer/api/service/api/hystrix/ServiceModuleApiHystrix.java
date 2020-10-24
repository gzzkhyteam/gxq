package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.service.api.ServiceModuleApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.FindModuleNameDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author luchanghong
 * @create 2018-04-30 21:11
 * @desc 功能模块熔断层
 **/
@Component
public class ServiceModuleApiHystrix implements ServiceModuleApi{
    @Override
    public Result<List<FindModuleNameDTO>> findModuleName(Integer pageSize) {
        return Result.timeout();
    }

	@Override
	public Result<List<Long>> getConsumerModuleIdsUsable(String consumerAppId) {
		return Result.timeout();
	}

    @Override
    public Result<Map> findTyrzJoinLastYear() {
        return Result.timeout();
    }
}