package com.hengyunsoft.platform.developer.api.screen.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.hystrix.ReducedCostScreenApiHystrix;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisListDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.ReducedCostDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author farglory
 * @create 2018-04-30 10:27
 * @desc 降本提质Api
 **/
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer", fallback = ReducedCostScreenApiHystrix.class)
public interface ReducedCostScreenApi {

    /**
     * 组件预估价值
     * @return
     */
    @RequestMapping(value = "/reducedCost/componentEstimatedValue", method = RequestMethod.GET)
    Result<ReducedCostDTO> componentEstimatedValue();

    /**
     * 已有降本案例
     * @return
     */
    @RequestMapping(value = "/reducedCost/reducedExample", method = RequestMethod.GET)
    Result<ApplicationReduceAnalysisListDTO> reducedExample();
}
