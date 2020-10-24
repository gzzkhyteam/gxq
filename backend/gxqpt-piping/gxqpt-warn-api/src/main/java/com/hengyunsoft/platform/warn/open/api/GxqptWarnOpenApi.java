package com.hengyunsoft.platform.warn.open.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.warn.open.api.hystrix.GxqptWarnOpenApiHystrix;
import com.hengyunsoft.platform.warn.open.dto.UpdateGxqptWarnOpenDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述：预警管理系统对外接口
 * @author zjr
 * @date 2018/06/26
 * @return
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        fallback = GxqptWarnOpenApiHystrix.class)
public interface GxqptWarnOpenApi {

    /**
     * 预警信息更新对外接口
     * @param updateGxqptWarnOpenDTO
     * @return
     */
    @RequestMapping(value = "/p/warn/updateByIdAndUserId", method = RequestMethod.POST)
    Result<Boolean> updateByIdAndUserId(@RequestBody UpdateGxqptWarnOpenDTO updateGxqptWarnOpenDTO);
}
