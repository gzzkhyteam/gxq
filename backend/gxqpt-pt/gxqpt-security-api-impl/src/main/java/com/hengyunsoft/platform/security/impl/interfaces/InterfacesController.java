package com.hengyunsoft.platform.security.impl.interfaces;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.SecurityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.ServiceResourceApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource.ServiceResourceDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiCallDto;
import com.hengyunsoft.platform.exchange.api.dataapi.open.ShareDataApiOpen;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsBeanCache;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsIdListCache;
import com.hengyunsoft.platform.security.dto.interfaces.*;
import com.hengyunsoft.platform.security.entity.interfaces.domain.ServiceResource;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceAccessStat;
import com.hengyunsoft.platform.security.entity.interfaces.po.InterfaceConfig;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceAccessStatService;
import com.hengyunsoft.platform.security.repository.interfaces.service.InterfaceConfigService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;
import java.util.stream.Collectors;

/**
 * com.hengyunsoft.platform.admin.controller.authority
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：接口阀值设置Api
 * 修改人：yxl
 * 修改时间：2018/6/29
 * 修改内容：新增基础接口
 */
@Api(value = "API - InterfaceController.java", description = "接口阀值设置")
@RestController
@RequestMapping("interfaces")
@Slf4j
public class InterfacesController {
    @Autowired
    private InterfaceAccessStatService interfaceAccessStatService;
    @Autowired
    private InterfaceConfigService interfaceConfigService;

    @Autowired
    private ShareDataApiOpen shareDataApiOpen;

    @Autowired
    private ServiceResourceApi serviceResourceApi;

    @Autowired
    private DozerUtils dozerUtils;

    @RequestMapping(value = "/pageInterfaceConfig", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询接口阀值配置信息", notes = "分页查询接口阀值配置信息(appID不能为空)")
    @ApiResponses({
            @ApiResponse(code = 95001, message = "分页参数,不能为空"),
            @ApiResponse(code = 95011, message = "模块ID不能为空"),
            @ApiResponse(code = 95003, message = "参数ID不能为空")
    })
    public Result<PageInfo<InterfaceConfigPageDTO>> pageApiList(@RequestBody OpenApiReq<InterfaceConfigReqDTO> openApiReq) {
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        Map<String, Object> param = new HashMap<>();
        if (!CommonConstants.SEARCH_ALL_STRING.equals(openApiReq.getData().getAppId())) {
            param.put("appId", openApiReq.getData().getAppId());
        }
        param.put("apiName", BaseExample.fullLike(openApiReq.getData().getApiName()));
        if (null != openApiReq.getData().getStatus() && CommonConstants.SEARCH_ALL_INT != openApiReq.getData().getStatus()) {
            param.put("status", openApiReq.getData().getStatus());
        }
        List<InterfaceConfigPageDTO> interfaceConfigList = interfaceConfigService.pageApiList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(interfaceConfigList, InterfaceConfigPageDTO.class)));
    }

    @RequestMapping(value = "/getInterfaceConfig", method = RequestMethod.GET)
    @ApiOperation(value = "获取单个接口阀值信息", notes = "根据主键获取单个接口阀值信息")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空")
    })
    @IgnoreToken
    public Result<InterfaceConfigPageDTO> get(@RequestParam(value = "id", required = false) Long id) {
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL, id);
        InterfaceConfig interfaceConfig = interfaceConfigService.getById(id);
        if (interfaceConfig == null) {
            return Result.fail(SecurityExceptionCode.ID_NOT_EXIST.getCode(), SecurityExceptionCode.ID_NOT_EXIST.getMsg());
        }
        InterfaceConfigPageDTO interfaceConfigPageDTO = dozerUtils.map(interfaceConfig, InterfaceConfigPageDTO.class);
        return Result.success(interfaceConfigPageDTO);
    }


    @RequestMapping(value = "/updateApiAccessLimitList", method = RequestMethod.POST)
    @ApiOperation(value = "批量更新接口阀值限制信息", notes = "批量更新接口阀值限制信息")
    @ApiResponses({
            @ApiResponse(code = 95002, message = "集合参数不能为空"),
            @ApiResponse(code = 95003, message = "参数不能为空"),
            @ApiResponse(code = 95004, message = "操作失败")
    })
    public Result<Integer> updateApiAccessLimitList(@RequestBody InterfaceConfigUploadDTO interfaceConfigUploadDTO) {
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, interfaceConfigUploadDTO);
        BizAssert.assertNotEmpty(SecurityExceptionCode.PARAM_COLLECTION_EMPTY, interfaceConfigUploadDTO.getIdList());
        Long userId = BaseContextHandler.getAdminId();
        interfaceConfigUploadDTO.setUpdateUser(userId);
        InterfaceConfig interfaceConfig = dozerUtils.map(interfaceConfigUploadDTO, InterfaceConfig.class);
        int size = interfaceConfigService.updateApiAccessLimitList(interfaceConfigUploadDTO.getIdList(), interfaceConfig);
        if (interfaceConfigUploadDTO.getIdList() != null && !interfaceConfigUploadDTO.getIdList().isEmpty()) {
            //淘汰缓存
            interfaceConfigUploadDTO.getIdList().forEach((id) -> InterfacesSettingsBeanCache.of(id).clear());
            InterfacesSettingsIdListCache.of().clear();
        }
        return Result.success(size);
    }

    @RequestMapping(value = "/getApiAccessStat", method = RequestMethod.GET)
    @ApiOperation(value = "获取访问量统计结果", notes = "获取指定接口、指定日期的访问量统计结果")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "日期不能为空"),
            @ApiResponse(code = 95000, message = "主键不能为空"),
            @ApiResponse(code = 95005, message = "主键不存在"),
    })
    public Result<Collection<Integer>> getApiAccessStatisticList(
            @RequestParam(value = "id", required = true) Long interfaceConfigId,
            @RequestParam(value = "date", required = true) String date) {
        BizAssert.assertNotEmpty(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, date);
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL, interfaceConfigId);
        List<InterfaceAccessStat> list = interfaceAccessStatService.getApiAccessStatisticList(interfaceConfigId, date);
        //为保证0到23点均有统计数据返回
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        if (null != list && list.size() > 0) {
            for (InterfaceAccessStat item : list) {
                treeMap.put(item.getStatHour(), item.getStatSum());
            }
        }
        for (int i = 0; i < 24; i++) {
            if (!treeMap.containsKey(i)) {
                treeMap.put(i, 0);
            }
        }
        return Result.success(treeMap.values());
    }

    @RequestMapping(value = "/findNeedFilter", method = RequestMethod.GET)
    @ApiOperation(value = "查询需要过滤的接口", notes = " 查询接口阀值配置表中， 已经设置了上限或预警的接口")
    @IgnoreToken
    public Result<List<Long>> findNeedFilter() {
        return Result.success(interfaceConfigService.findNeedFilter());
    }

    /**
     * 根据id 查询对象
     * 该方法不需要token ！！！
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "获取单个接口阀值信息", notes = "根据主键获取单个接口阀值信息")
    @ApiResponses({
            @ApiResponse(code = 95000, message = "主键不能为空")
    })
    @IgnoreToken
    @ApiIgnore
    public Result<InterfaceConfigDTO> getById(@RequestParam(value = "id", required = false) Long id) {
        BizAssert.assertNotNull(SecurityExceptionCode.ID_IS_NULL, id);
        InterfaceConfig interfaceConfig = interfaceConfigService.getById(id);
        return Result.success(dozerUtils.map(interfaceConfig, InterfaceConfigDTO.class));
    }

    @RequestMapping(value = "/getInterfaceConfigList", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户有权限，获取接口列表", notes = "根据用户有权限，获取接口列表")
    public Result<List<InterfaceConfigPageDTO>> getInterfaceConfigList(@RequestParam(value = "apiName", required = false) String apiName) {
        log.info("apiName = {} ", apiName);
        Long userId = BaseContextHandler.getAdminId();
        Set<Long> apiIdSet = new HashSet<>();
        //获取共享交换平台接口权限
        OpenApiReq openApiReq = new OpenApiReq();
        openApiReq.setPageNo(1);
        openApiReq.setPageSize(Integer.MAX_VALUE);
        ApiCallDto apiCallDto = new ApiCallDto();
        apiCallDto.setUserId(userId);
        apiCallDto.setApiName(apiName);
        openApiReq.setData(apiCallDto);
        Result<PageInfo<Long>> exchangeGetResult = shareDataApiOpen.getApiByUserId(openApiReq);
        log.info("调用共享交换平台：根据用户id获取有访问权限的接口列表，" + exchangeGetResult.toString());

        if (exchangeGetResult != null && exchangeGetResult.isSuccess() && exchangeGetResult.getData() != null && exchangeGetResult.getData().getList() != null) {
            apiIdSet.addAll(exchangeGetResult.getData().getList());
        }
        //获取权限管理平台接口列表

        Result<List<ServiceResourceDTO>> serviceResult = serviceResourceApi.getServiceResourceOfUserAppConsumer(apiName);
        log.info("调用权限管理系统：获取用户有访问权限的接口列表，" + serviceResult.toString());
        if (serviceResult != null && serviceResult.isSuccess()) {
            List<ServiceResourceDTO> serviceData = serviceResult.getData();
            if (null != serviceData && !serviceData.isEmpty()) {
                Set<Long> set = serviceData.stream().map((item)->item.getId()).collect(Collectors.toSet());
                apiIdSet.addAll(set);
            }
        }

        log.info("apiIdSet.size={}", apiIdSet.size());
        if (null != apiIdSet && apiIdSet.size() > 0) {
            return Result.success(interfaceConfigService.getInterfaceConfigList(apiIdSet));
        }
        return Result.success(null);
    }

    @RequestMapping(value = "/pageInterfaceConfigList", method = RequestMethod.POST)
    @ApiOperation(value = "根据用户有权限，获取接口列表 分页", notes = "根据用户有权限，获取接口列表 分页")
    public Result<PageInfo<InterfaceConfigPageDTO>> pageInterfaceConfigList(@RequestBody OpenApiReq<String> pageApiReq) {
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, pageApiReq);
        PageHelper.startPage(pageApiReq.getPageNo(), pageApiReq.getPageSize());
        log.info("apiName = {} ", pageApiReq.toString());
        String apiName = pageApiReq.getData();
        Long userId = BaseContextHandler.getAdminId();
        Set<Long> apiIdSet = new HashSet<>();
        List<Set<Long>> apiIdList = new ArrayList<>();
        //获取共享交换平台接口权限
        OpenApiReq openApiReq = new OpenApiReq();
        openApiReq.setPageNo(1);
        openApiReq.setPageSize(Integer.MAX_VALUE);
        ApiCallDto apiCallDto = new ApiCallDto();
        apiCallDto.setUserId(userId);
        apiCallDto.setApiName(apiName);
        openApiReq.setData(apiCallDto);
        Result<PageInfo<Long>> exchangeGetResult = shareDataApiOpen.getApiByUserId(openApiReq);
        log.info("调用共享交换平台：根据用户id获取有访问权限的接口列表，" + exchangeGetResult.toString());

        if (exchangeGetResult != null && exchangeGetResult.isSuccess() && exchangeGetResult.getData() != null && exchangeGetResult.getData().getList() != null) {
            apiIdSet.addAll(exchangeGetResult.getData().getList());
        }
        //获取权限管理平台接口列表
        Result<List<ServiceResourceDTO>> serviceResult = serviceResourceApi.getServiceResourceOfUserAppConsumer(apiName);
        log.info("调用权限管理系统：获取用户有访问权限的接口列表，" + serviceResult.toString());

        if (serviceResult != null && serviceResult.isSuccess()) {
            List<ServiceResourceDTO> serviceData = serviceResult.getData();
            if (null != serviceData && !serviceData.isEmpty()) {
                Set<Long> set = serviceData.stream().map((item)->item.getId()).collect(Collectors.toSet());
                apiIdSet.addAll(set);
            }
        }
        log.debug("apiIdSet.size={}", apiIdSet.size());
        if (null != apiIdSet && apiIdSet.size() > 0) {
            Object[] arr =  apiIdSet.toArray();
            int index = 0;
            for(;apiIdSet.size() > 0;){
                Set<Long> item = new HashSet<>();
                while(index < arr.length && apiIdSet.size() > 0 && item.size() < 300){
                    Long i = (Long) arr[index++];
                    item.add(i);
                    apiIdSet.remove(i);
                }
                apiIdList.add(item);
            }
            return Result.success(new PageInfo<>(dozerUtils.mapPage(interfaceConfigService.pageInterfaceConfigList(apiIdList), InterfaceConfigPageDTO.class)));
        }
        return Result.success(new PageInfo<>(dozerUtils.mapPage(null, InterfaceConfigPageDTO.class)));
    }

}
