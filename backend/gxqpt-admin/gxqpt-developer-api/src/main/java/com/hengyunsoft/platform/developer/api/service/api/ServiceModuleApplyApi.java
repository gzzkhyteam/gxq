package com.hengyunsoft.platform.developer.api.service.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.ServiceModuleApplyApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：我的功能申请管理Api
 * 修改人：sunxiaoya
 * 修改时间：2018/4/2
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.admin.feign.server:gxqpt-gate-server}",
        path = "/api/admin", fallback = ServiceModuleApplyApiHystrix.class)
public interface ServiceModuleApplyApi {

    /**
     * 描述：新增我的功能申请Api
     * 参数：[ServiceModuleApplyRetDTO：我的功能申请实体]
     * 返回值：ServiceModuleApplyRetDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/save", method = RequestMethod.POST)
    Result<ServiceModuleApplyRetDTO> save(@RequestBody ServiceModuleApplySaveDTO dto);

    /**
     * 描述：修改我的功能申请Api
     * 参数：ServiceModuleUpdateDTO
     * 返回值：String
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/update", method = RequestMethod.POST)
    Result<String> update(@RequestBody ServiceModuleUpdateDTO dto);


    /**
     * 描述：我的功能申请审核Api
     * 参数：[ServiceModuleApplyAuditDTO：我的功能申请审核实体]
     * 返回值：ServiceModuleApplyAuditDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/3
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/audit", method = RequestMethod.POST)
    Result<Boolean> audit(@RequestBody ServiceModuleApplyAuditDTO dto);


    /**
     * 描述：删除我的应用的功能申请Api
     * 参数：id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/delete", method = RequestMethod.GET)
    Result<Boolean> delete(@RequestParam("id") Long id);


    /**
     * 描述：我的功能申请禁用Api
     * 参数：id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/forbidUse", method = RequestMethod.POST)
    Result<Boolean> forbidUse(@RequestBody ServiceModuleForbidUseDTO dto);

    /**
     * 描述：我的功能混合逻辑操作Api
     * 参数：id
     * 返回值：String
     * 修改人：sunxiaoya
     * 修改时间：2018/8/29
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/moduleMixHandle", method = RequestMethod.POST)
    Result<String> updateModuleMixHandle(@RequestBody ServiceModuleMixHandleDTO dto);


    /**
     * 描述：根据userId查询我的功能申请Api
     * 参数：id
     * 返回值：ServiceModuleApplyDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/detail", method = RequestMethod.GET)
    Result<ServiceModuleDTO> getById(@RequestParam("id") Long id);


    /**
     * 描述：根据appId查询我的功能列表Api
     * 参数：appId
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/12
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/getModuleList", method = RequestMethod.GET)
    Result<List<ServiceModuleDTO>> getByAppId(@RequestParam("appId") String appId);

    /**
     * 描述：查询我的功能申请Api
     * 参数：
     * 返回值：ServiceModuleApplyDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/getList", method = RequestMethod.GET)
    Result<List<ServiceModuleDTO>> findList();


    /**
     * 描述：查询我的功能分页列表Api
     * 参数：pageNo,pageSize
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    @RequestMapping(value = "/serviceModuleApply/page", method = RequestMethod.POST)
    Result<PageInfo<ServiceModuleDTO>> page(@RequestBody OpenApiReq<ServiceModulePageDTO> openApiReq);
}
