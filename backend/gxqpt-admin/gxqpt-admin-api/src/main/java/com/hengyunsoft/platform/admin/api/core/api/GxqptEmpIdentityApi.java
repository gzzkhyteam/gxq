package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptEmpIdentityApiHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityQueryDTO;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentitySaveDTO;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityUpdateDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:高新区一体化平台人员身份管理
 * @author chb
 * @date 2018/4/10 10:34
 * @return
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = GxqptEmpIdentityApiHystrix.class)
public interface GxqptEmpIdentityApi {

    /**
     * 描述:新增人员身份
     * @author chb
     * @date 2018/3/6 11:20
     * @param saveDTO
     * @return
     */
    @RequestMapping(value = "/empIdentity/save", method = RequestMethod.POST)
    Result<GxqptEmpIdentityRetDTO> save(@RequestBody GxqptEmpIdentitySaveDTO saveDTO);

    /**
     * 根据id获取人员身份信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/empIdentity/getById", method = RequestMethod.GET)
    Result<GxqptEmpIdentityRetDTO> getById(@RequestParam(value = "id") String id);

    /**
     * 根据id删除人员身份信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/empIdentity/removeById", method = RequestMethod.GET)
    Result<String> removeById(@RequestParam(value = "id") String id);

    /**
     * 根据id修改人员身份信息
     * @param updateDTO
     * @return
     */
    @RequestMapping(value = "/empIdentity/updateById", method = RequestMethod.POST)
    Result<GxqptEmpIdentityRetDTO> updateById(@RequestBody GxqptEmpIdentityUpdateDTO updateDTO);


    /**
     * 获取分页列表
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/empIdentity/page", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpIdentityRetDTO>> page(@RequestBody OpenApiReq<GxqptEmpIdentityQueryDTO> openApiReq);

}
