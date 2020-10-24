package com.hengyunsoft.platform.developer.api.screen.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.hystrix.OrgScreenApiHystrix;
import com.hengyunsoft.platform.developer.api.screen.dto.org.OrgMonthNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.org.OrgTitleDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author wz
 * @create 2018-04-30 21:37
 * @desc 单位大屏Api
 **/
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer", fallback = OrgScreenApiHystrix.class)
public interface OrgScreenApi {

    /**
     * 查询接入横幅
     * @return
     */
    @RequestMapping(value = "/org/findTitle", method = RequestMethod.GET)
    Result<OrgTitleDTO> findTitle();

    /**
     * 查询前7个月中每个月应用被调用的的次数
     * */
    @RequestMapping(value = "/org/findAppUseNum", method = RequestMethod.GET)
    Result<List<OrgMonthNumDTO>> findAppUseNum();
}
