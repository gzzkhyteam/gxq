package com.hengyunsoft.platform.developer.api.service.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.ServiceModuleDocApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocQueryDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocRetDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述:开发者管理平台帮助文档接口
 * @author chb
 * @date 2018/4/2 11:01
 * @return
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = ServiceModuleDocApiHystrix.class)
public interface ServiceModuleDocApi {
    /**
     * 描述:新增帮助文档
     * @param serviceModuleDocDTO
     * @return
     */
    @RequestMapping(value = "/serviceModuleDoc/save", method = RequestMethod.POST)
    Result<ServiceModuleDocDTO> save(@RequestBody ServiceModuleDocDTO serviceModuleDocDTO);

    /**
     * 根据id获取帮助文档信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/serviceModuleDoc/getById", method = RequestMethod.GET)
    Result<ServiceModuleDocRetDTO> getById(@RequestParam(value="id")String id);

    /**
     * 根据id删除帮助文档信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/serviceModuleDoc/deleteById", method = RequestMethod.GET)
    Result<String> deleteById(@RequestParam(value="id")String id);

    /**
     * 根据id修改帮助文档信息
     * @param serviceModuleDocDTO
     * @return
     */
    @RequestMapping(value = "/serviceModuleDoc/updateById", method = RequestMethod.POST)
    Result<ServiceModuleDocDTO> updateById(@RequestBody ServiceModuleDocDTO serviceModuleDocDTO);


    /**
     * 获取帮助文档分页数据
     * @param ServiceModuleDocDTO
     * @return
     */
    @RequestMapping(value = "/serviceModuleDoc/page", method = RequestMethod.POST)
    Result<PageInfo<ServiceModuleDocRetDTO>> page(@RequestBody OpenApiReq<ServiceModuleDocQueryDTO> req);

    /**
     * 获取帮助文档无分页
     * @param ServiceModuleDocDTO
     * @return
     */
    @RequestMapping(value = "/serviceModuleDoc/findMoudleDoc", method = RequestMethod.GET)
    Result<List<ServiceModuleDocRetDTO>> findMoudleDoc(ServiceModuleDocQueryDTO req);

}
