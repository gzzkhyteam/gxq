package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptSystemApiHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemPageListDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemSourceDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemUpdateDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述：高新区一体化平台体系管理
 * @author zjr
 * @createTime 2018-03-07
 * @return
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = GxqptSystemApiHystrix.class)
public interface GxqptSystemApi {

    /**
     * 查询体系来源
     * @return
     */
    @RequestMapping(value = "/system/getBySource", method = RequestMethod.GET)
    Result<List<String>> getBySource();

    /**
     * 分页获取条件查询信息
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/system/findSystemList", method = RequestMethod.POST)
    Result<PageInfo<GxqptSystemPageListDTO>> findSystemList(@RequestBody OpenApiReq<GxqptSystemDTO> openApiReq);


    /**
     * 编辑体系信息
     * @param systemUpdateDto
     * @return
     */
    @RequestMapping(value = "/system/update", method = RequestMethod.POST)
    Result<GxqptSystemUpdateDTO> updateById(@RequestBody GxqptSystemUpdateDTO systemUpdateDto);


    /**
     * 删除体系信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/delete", method = RequestMethod.POST)
    Result<Boolean> deleteSystem(@RequestParam(value = "id") String id);

}
