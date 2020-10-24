package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptDutiesHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.duties.GxqptDutiesDTO;
import com.hengyunsoft.platform.admin.api.core.dto.duties.SimpDutiesDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述:高新区一体化平台职务管理
 * @author chb
 * @date 2018/3/7 13:44
 * @return
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/admin",  fallback = GxqptDutiesHystrix.class)
public interface GxqptDutiesApi {

    /**
     * 新增职务
     * @param gxqptEmpDTO
     * @return
     */
    @RequestMapping(value = "/duties/save", method = RequestMethod.POST)
    Result<GxqptDutiesDTO> save(@RequestBody GxqptDutiesDTO gxqptDutiesDTO);

    /**
     * 根据ID修改职务信息
     * @param gxqptDutiesDTO
     * @return
     */
    @RequestMapping(value = "/duties/updateById", method = RequestMethod.POST)
    Result<GxqptDutiesDTO> updateById(@RequestBody GxqptDutiesDTO gxqptDutiesDTO);

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/duties/getDutiesById", method = RequestMethod.GET)
    Result<GxqptDutiesDTO> getDutiesById(@RequestParam(value="id")String id,@RequestParam(value="systemCode")String systemCode);

    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/duties/removeById", method = RequestMethod.GET)
    Result<String> removeById(@RequestParam(value="id") String id);

    /**
     * 职务信息列表分页查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/duties/findDutiesList", method = RequestMethod.POST)
    Result<PageInfo<GxqptDutiesDTO>>  findDutiesList(@RequestBody OpenApiReq<GxqptDutiesDTO> openApiReq);

    /**
     * 描述：查询gxqpt所有职务的信息
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/27
     * 修改内容：
     */
    @RequestMapping(value = "findSimpDutiesGxqpt", method = RequestMethod.GET)
    Result<List<SimpDutiesDTO>> findSimpDutiesGxqpt(@RequestParam("orgid") String orgid);
}
