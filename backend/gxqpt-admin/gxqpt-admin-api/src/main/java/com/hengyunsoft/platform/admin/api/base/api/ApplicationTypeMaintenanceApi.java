package com.hengyunsoft.platform.admin.api.base.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.hystrix.ApplicationTypeMaintenanceHystrix;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import com.hengyunsoft.base.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author zhangbiao
 * @createTime 2018-04-10
 */

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}" , path = "/api/admin" , fallback = ApplicationTypeMaintenanceHystrix.class)
public interface ApplicationTypeMaintenanceApi {

    /**
     * 应用类型维护 查询列表
     * @param openApiReq
     * @return DictionaryMaintainPageDTO
     * @createTime 2018/4/10
     * @author zhangbiao
     *
    */
    @RequestMapping(value = "/maintenance/findList" , method = RequestMethod.POST)
    Result<PageInfo<DictionaryMaintainPageDTO>> findList(@RequestBody OpenApiReq openApiReq);

    /**
     * 应用类型维护 详情
     * @param id
     * @return DictionaryMaintainDetailsDTO
     * @createTime 2018/4/10
     * @author zhangbiao
     *
     */
    @RequestMapping(value = "/maintenance/get" , method = RequestMethod.GET)
    Result<DictionaryMaintainDetailsDTO> get(@RequestParam(value = "id") Long id);

    /**
     * 应用类型维护 修改
     * @param maintainUpdateDTO
     * @return boolean
     * @createTime 2018/4/10
     * @author zhangbiao
     *
     */
    @RequestMapping(value = "/maintenance/update" , method = RequestMethod.POST)
    Result<String> update(@RequestBody DictionaryMaintainUpdateDTO maintainUpdateDTO);

    /**
     * 应用类型维护 删除 (逻辑删除)
     * @param id
     * @return boolean
     * @createTime 2018/4/10
     * @author zhangbiao
     *
     */
    @RequestMapping(value = "/maintenance/delete" , method = RequestMethod.POST)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 应用类型维护 保存
     * @param maintainSaveDTO
     * @return DictionaryDTO
     * @createTime 2018/4/10
     * @author zhangbiao
     *
     */
    @RequestMapping(value = "/maintenance/save" , method = RequestMethod.POST)
    Result<String> save(@RequestBody DictionaryMaintainSaveDTO maintainSaveDTO);
}
