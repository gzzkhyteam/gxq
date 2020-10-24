package com.hengyunsoft.platform.developer.api.service.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.ServiceModuleApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.FindModuleNameDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author luchanghong
 * @create 2018-04-30 21:09
 * @desc 功能模块api层
 **/
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        path = "/api/serviceModule",   fallback = ServiceModuleApiHystrix.class)
public interface ServiceModuleApi {
    Result<List<FindModuleNameDTO>> findModuleName(Integer pageSize);

	/**
	 * 获取指定消费者可用消费的所有模块id
	 * @param consumerAppId
	 * @param token
	 * @return
	 */
    @RequestMapping(value = "/getConsumerModuleIdsUsable", method = RequestMethod.GET)
	Result<List<Long>> getConsumerModuleIdsUsable(@RequestParam("consumerAppId") String consumerAppId);

	/**
	 * 获取近12月统一认证接入情况
	 *
	 * @return
	 */
	@RequestMapping(value = "/findTyrzJoinLastYear", method = RequestMethod.GET)
	Result<Map> findTyrzJoinLastYear();
}