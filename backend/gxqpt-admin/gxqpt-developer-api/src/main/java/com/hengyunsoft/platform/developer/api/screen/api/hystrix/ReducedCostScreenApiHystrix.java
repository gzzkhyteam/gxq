package com.hengyunsoft.platform.developer.api.screen.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.ReducedCostScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisListDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.ReducedCostDTO;
import org.springframework.stereotype.Component;

/**
 * farglory
 * 降本提质  模块熔断器
 */
@Component
public class ReducedCostScreenApiHystrix implements ReducedCostScreenApi {

	/**
	 * 组件预估价值
	 */
	@Override
	public Result<ReducedCostDTO> componentEstimatedValue() {
		
		return Result.timeout();
	}

	/**
	 * 已有降本案例
	 * @return
	 */
	@Override
	public Result<ApplicationReduceAnalysisListDTO> reducedExample() {

		return Result.timeout();
	}
}
