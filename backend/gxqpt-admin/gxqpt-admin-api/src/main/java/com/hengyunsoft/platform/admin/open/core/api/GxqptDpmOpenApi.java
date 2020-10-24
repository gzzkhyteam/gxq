package com.hengyunsoft.platform.admin.open.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgAndSysDTO;
import com.hengyunsoft.platform.admin.open.core.api.hystrix.GxqptDpmOpenHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 部门管理-open
 *
 * @author wangzhen
 * @createTime 2018-03-26
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/admin", fallback = GxqptDpmOpenHystrix.class)
public interface GxqptDpmOpenApi {

    /**
     * 通过单位id+体系编码获得所有部门
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/dpm/pageByOrgSys", method = RequestMethod.POST)
    Result<PageInfo<GxqptDpmResDTO>> pageByOrgAndSys(@RequestBody OpenApiReq<GxqptOrgAndSysDTO> openApiReq);
}
