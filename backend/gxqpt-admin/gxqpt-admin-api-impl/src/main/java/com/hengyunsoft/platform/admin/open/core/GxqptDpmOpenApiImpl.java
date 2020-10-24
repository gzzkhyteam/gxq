package com.hengyunsoft.platform.admin.open.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.OrgSystemModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgAndSysDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptDpmOpenApi;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDpmService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "API - GxqptDpmApiImpl", description = "部门管理对外接口")
@RestController
@RequestMapping("/p/dpm")
@Slf4j
@OrgSystemModule
public class GxqptDpmOpenApiImpl implements GxqptDpmOpenApi {
    @Autowired
    private GxqptDpmService dpmService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptSystemService systemService;

    /**
     * 通过单位id+体系编码获得所有部门
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @ApiOperation(value = "获得所有部门", notes = "通过单位id+体系编码获得所有未删除启用部门")
    @RequestMapping(value = "/pageByOrgAndSys", method = RequestMethod.POST)
    public Result<PageInfo<GxqptDpmResDTO>> pageByOrgAndSys(@RequestBody OpenApiReq<GxqptOrgAndSysDTO> openApiReq) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, openApiReq.getData().getSystemCode());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, openApiReq.getData().getOrgId());
        if (!systemService.isExistSystem(openApiReq.getData().getSystemCode())) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.获取并返回列表
        List list = dpmService.pageByOrgAndSys(openApiReq.getData().getOrgId(), openApiReq.getData().getSystemCode());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, GxqptDpmResDTO.class)));
    }
}
