package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpIdentityApi;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityQueryDTO;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentitySaveDTO;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityUpdateDTO;

/**
 * 描述:人员身份设置熔断
 * @author chb
 * @date 2018/4/10 11:10 
 */
public class GxqptEmpIdentityApiHystrix implements GxqptEmpIdentityApi {

    @Override
    public Result<GxqptEmpIdentityRetDTO> save(GxqptEmpIdentitySaveDTO saveDTO) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptEmpIdentityRetDTO> getById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<String> removeById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptEmpIdentityRetDTO> updateById(GxqptEmpIdentityUpdateDTO updateDTO) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptEmpIdentityRetDTO>> page(OpenApiReq<GxqptEmpIdentityQueryDTO> openApiReq) {
        return Result.timeout();
    }
}
