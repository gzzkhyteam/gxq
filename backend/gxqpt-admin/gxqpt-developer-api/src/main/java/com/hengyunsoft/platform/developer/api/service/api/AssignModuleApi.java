package com.hengyunsoft.platform.developer.api.service.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.AssignModuleApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述:消费模块接口
 * @author chb
 * @date 2018/4/3 11:05 
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = AssignModuleApiHystrix.class)
public interface AssignModuleApi {

    /**
     * 描述:新增模块
     * @param assignModuleSaveDTO
     * @return
     */
    @RequestMapping(value = "/assignModule/save", method = RequestMethod.POST)
    Result<AssignModuleRetDTO> save(@RequestBody AssignModuleSaveDTO assignModuleSaveDTO);

    /**
     * 根据id删除模块信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/assignModule/deleteById", method = RequestMethod.GET)
    Result<Boolean> deleteById(@RequestParam(value="id")String id);

    /**
     * 根据id修改模块信息
     * @param assignModuleUpdateDTO
     * @return
     */
    @RequestMapping(value = "/assignModule/updateById", method = RequestMethod.POST)
    Result<AssignModuleRetDTO> updateById(@RequestBody AssignModuleUpdateDTO assignModuleUpdateDTO);

    /**
     * 根据id获取消费模块信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/assignModule/getById", method = RequestMethod.GET)
    Result<QueryConsumAssignModuleInfoDTO> getById(@RequestParam(value="id") Long id);

    /**
     *查看我某个应用所消费的所有功能
     * @param req
     * @return
     */
    @RequestMapping(value = "/assignModule/pageMy", method = RequestMethod.POST)
    Result<PageInfo<AssignServiceModuleRetDTO>> pageMy(@RequestBody OpenApiReq<AssignModuleQueryMyDTO> req);

    /**
     * 获取所有模块
     * @param assignModuleQueryDTO
     * @return
     */
    @RequestMapping(value = "/assignModule/page", method = RequestMethod.POST)
    Result<PageInfo<AssignServiceModuleRetDTO>> page(@RequestBody OpenApiReq<AssignModuleQueryMYAppDTO> req);

    /**
     * 获取所有模块不分页
     * @param moduleType
     * @param status
     * @return
     */
    @RequestMapping(value = "/assignModule/findNoPage", method = RequestMethod.GET)
    Result<List<AssignModuleNopageRetDTO>> findNoPage(@RequestParam(value = "moduleType",required = false) String moduleType, @RequestParam(value = "status",required = false)Boolean status);

    /**
     * 描述:查看功能列表（应用不限，所有应用。）
     * @author chb
     * @date 2018/4/4 13:57
     * @param req
     * @return 
     */
    @RequestMapping(value = "/assignModule/findAllMoudles", method = RequestMethod.POST)
    Result<PageInfo<AssignServiceModuleRetDTO>> findAllMoudles(@RequestBody OpenApiReq<AssignModuleQueryMoudlesDTO> req);

    /**
     * 描述:查看功能列表 无分页（应用不限，所有应用。）
     * @author chb
     * @date 2018/4/4 13:57
     * @param req
     * @return
     */
    @RequestMapping(value = "/assignModule/findAllMoudlesNoPage", method = RequestMethod.GET)
    Result<List<AssignServiceModuleRetDTO>> findAllMoudlesNoPage(AssignModuleQueryMoudlesDTO req);

    /**
     * 描述:在未登陆下查看所有的功能列表（有些功能不允许登陆查看）
     * @author chb
     * @date 2018/4/4 13:57
     * @param req
     * @return
     */
    @RequestMapping(value = "/assignModule/findNoLoginMoudles", method = RequestMethod.POST)
    Result<PageInfo<AssignServiceModuleRetDTO>> findNoLoginMoudles(@RequestBody OpenApiReq<AssignModuleQueryMoudlesDTO> req);

    /**
     * 2018-5-2查询热门功能
     * @param top
     * @return
     */
    @RequestMapping(value = "/assignModule/hotModule", method = RequestMethod.GET)
    Result<List<ServiceModuleDTO>> hotModule(@RequestParam(value = "top",required = false)Integer top);
}
