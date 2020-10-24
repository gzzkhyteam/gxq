package com.hengyunsoft.platform.admin.open.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgAndSysDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptDpmOpenApi;
import org.springframework.stereotype.Component;

@Component
public class GxqptDpmOpenHystrix implements GxqptDpmOpenApi {
    @Override
    public Result<PageInfo<GxqptDpmResDTO>> pageByOrgAndSys(OpenApiReq<GxqptOrgAndSysDTO> openApiReq) {
        return Result.timeout();
    }
}
