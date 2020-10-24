package com.hengyunsoft.platform.developer.impl.service;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.api.service.api.ServiceResourceApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDocDTO;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplicationDO;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResource;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResourceDoc;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceResourceDocService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceResourceService;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务资源管理Api
 * 修改人：sunxiaoya
 * 修改时间：2018/4/4
 * 修改内容：新增基础接口
 */
@Api(value = "API - ServiceResourceApiImpl.java", description = "服务资源管理")
@RestController
@RequestMapping("serviceResource")
@Slf4j
public class ServiceResourceApiImpl implements ServiceResourceApi {

    @Autowired
    ServiceResourceService serviceResourceService;

    @Autowired
    ServiceResourceDocService serviceResourceDocService;

    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    private ApplicationService applicationService;

    /**
     * 描述：根据模块id查询服务资源列表Api
     * 参数：模块id
     * 返回值：ServiceResourceDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据模块id查询服务资源列表", notes = "根据模块id查询服务资源列表")
    @ApiResponses({
            @ApiResponse(code = 76800, message = "服务资源模块ID不能为空"),
    })
    @RequestMapping(value = "/getByModuleId", method = RequestMethod.GET)
    public Result<List<ServiceResourceDTO>> getByModuleId(@RequestParam("moduleId") Long moduleId) {
        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_RESOURCE_MODULE_ID_NULL, moduleId);

        //2、执行查询
        List<ServiceResourceDTO> dto = dozerUtils.mapList(serviceResourceService.getByModuleId(moduleId), ServiceResourceDTO.class);

        //3、返回结果
        return Result.success(dto);
    }

    /**
     * 描述：根据id查询服务资源文档Api
     * 参数：id
     * 返回值：ServiceResourceDocDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据moduleId查询服务资源文档", notes = "根据moduleId查询服务资源文档")
    @ApiResponses({
            @ApiResponse(code = 76801, message = "服务资源文档ID不能为空"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @AppToken
    public Result<ServiceResourceDocDTO> getById(@RequestParam("moduleId") Long moduleId) {
        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_RESOURCE_MODULE_ID_NULL, moduleId);

        //2、执行查询
        ServiceResourceDoc serviceResourceDoc = serviceResourceDocService.getByModuleId(moduleId);
        if (serviceResourceDoc == null) {
            return Result.success(null);
        }
        ServiceResourceDocDTO dto = dozerUtils.map(serviceResourceDoc, ServiceResourceDocDTO.class);

        //3、返回结果
        return Result.success(dto);
    }

    @Override
    @AppToken
    @ApiOperation(value = "加载指定应用的服务资源中的所有公有（对所有应用开放）可用的资源链接地址", notes = "加载指定应用的服务资源中的所有公有（对所有应用开放）可用的资源链接地址")
    public Result<List<ServiceResourceDTO>> getServiceAllPublicUrlsUsableByAppId(String appId) {


        List<ServiceResource> urls = serviceResourceService.getServiceAllPublicUrlsUsableByAppId(appId);
        if (CollectionUtils.isEmpty(urls)) {
            return Result.success(Collections.EMPTY_LIST);
        }
        List<ServiceResourceDTO> result = dozerUtils.mapList(urls, ServiceResourceDTO.class);
        return Result.success(result);
    }

    @Override
    @AppToken
    @ApiOperation(value = "获取应用非公开的所有可用使用的服务资源", notes = "获取应用非公开的所有可用使用的服务资源")
    public Result<List<ServiceResourceDTO>> getServiceResourceOfAppPrivateUsable(String appId) {

        List<ServiceResource> urls = serviceResourceService.getServiceResourceOfAppPrivateUsable(appId);
        if (CollectionUtils.isEmpty(urls)) {
            return Result.success(Collections.EMPTY_LIST);
        }
        List<ServiceResourceDTO> result = dozerUtils.mapList(urls, ServiceResourceDTO.class);
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "获取指定用户管理下的应用消费服务资源集合", notes = "获取指定用户管理下的应用消费服务资源集合")
    public Result<List<ServiceResourceDTO>> getServiceResourceOfUserAppConsumer(@RequestParam(value = "likeResourceName",required = false) String likeResourceName) {

        Long userId = BaseContextHandler.getAdminId();

        List<ApplicationDO> managerApps = applicationService.findAppByAdmin(userId, null);

        if (managerApps.size() == 0) {
            return Result.success(Collections.EMPTY_LIST);
        }
        List<String> appIds = managerApps.stream().map(app -> app.getAppId()).collect(Collectors.toList());
        managerApps = null;

        List<ServiceResource> resources = serviceResourceService.getServiceResourceOfAppConsumer(appIds, likeResourceName);
        List<ServiceResourceDTO> result = dozerUtils.mapList(resources, ServiceResourceDTO.class);
        return Result.success(result);
    }
}