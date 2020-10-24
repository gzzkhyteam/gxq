package com.hengyunsoft.platform.admin.api.base.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.hystrix.ModuleTypeMaintenanceApiHystrix;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 应用服务部署管理
 *
 * @author madb
 * @createTime 2018/4/10
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/admin",fallback = ModuleTypeMaintenanceApiHystrix.class)
public interface ModuleTypeMaintenanceApi {
    /**
     * 分页查询功能类型
     * @param
     * @return
     */
    @RequestMapping(value = "/dictionary/pageModuleType", method = RequestMethod.POST)
    Result<PageInfo<ModuleDictionaryDTO>> pageModuleType(@RequestBody OpenApiReq<ModuleDictionaryViewDTO> openApiReq);

    /**
     * 新增功能类型
     * */
    @RequestMapping(value = "/dictionary/addModuleType", method = RequestMethod.POST)
    Result<String> addModuleType(@RequestBody ModuleTypeAddDTO moduleTypeAddDTO);

    /**
     * 删除功能类型
     * */
    @RequestMapping(value = "/dictionary/deleteModuleType", method = RequestMethod.GET)
    Result<String> deleteModuleType(@RequestParam(value = "id") Long id);

    /**
     * 更改应用类型
     * */
    @RequestMapping(value = "/dictionary/updateModuleType", method = RequestMethod.GET)
    Result<String> updateModuleType(@RequestParam ModuleDictionaryModifyDTO moduleDictionaryModifyDTO);

    /**
     * 根据Id获取功能详情信息
     * */
    @RequestMapping(value = "/dictionary/getDetailModuleTypeById", method = RequestMethod.GET)
    Result<ModuleDictionaryDTO> getDetailModuleTypeById(@RequestParam(value = "id") Long id);

    /**
    *根据typeCode获取类型列表
    * */
    @RequestMapping(value = "/dictionary/getListByTypeCode", method = RequestMethod.GET)
    Result<List<AppAndModuleDTO>> getListByTypeCode(@RequestParam(value = "typeCode") String typeCode);
}
