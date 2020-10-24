package com.hengyunsoft.platform.security.api.interfaces;

import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.security.api.interfaces.hystrix.InterfacesSettingsApiHystrix;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */

@FeignClient(name = "${gxqpt.feign.pt-server:gxqpt-pt-server}",fallback = InterfacesSettingsApiHystrix.class)
public interface InterfacesSettingsApi {

    @RequestMapping(value = "/interfaces/findNeedFilter", method = RequestMethod.GET)
    Result<List<Long>> findNeedFilter();

    @RequestMapping(value = "/interfaces/get", method = RequestMethod.GET)
    Result<InterfaceConfigDTO> getById(@RequestParam(value = "id", required = false) Long id);
}
