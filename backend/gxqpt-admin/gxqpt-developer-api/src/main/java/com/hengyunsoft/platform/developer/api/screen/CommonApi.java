package com.hengyunsoft.platform.developer.api.screen;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengyunsoft.base.Result;

/**
 * 大屏里面通用api
 * 很多api无法归类，都放在这里。方便维护
 * @author Administrator
 *
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
path = "/api/admin")
public interface CommonApi {

	/**
	 * 概览屏的组件个数
	 */
	
	@RequestMapping("/screen/common/getDiscretenessCount")
	public Result<Integer> getDiscretenessCount();
}
