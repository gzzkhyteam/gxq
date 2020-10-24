package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptPostHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostQueryDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostSaveDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostUpdateDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:高新区一体化平台岗位管理
 *
 * @author chb
 * @date 2018/3/7 13:44
 * @return
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/admin", fallback = GxqptPostHystrix.class)
public interface GxqptPostApi {

    /**
     * 新增岗位
     *
     * @param gxqptEmpDTO
     * @return
     */
    @RequestMapping(value = "/post/save", method = RequestMethod.POST)
    Result<GxqptPostRetDTO> save(@RequestBody GxqptPostSaveDTO gxqptPostSaveDTO);

    /**
     * 根据ID修改岗位信息
     *
     * @return
     */
    @RequestMapping(value = "/post/updateById", method = RequestMethod.POST)
    Result<GxqptPostUpdateDTO> updateById(@RequestBody GxqptPostUpdateDTO gxqptPostUpdateDTO);

    /**
     * 根据ID获取数据
     *
     * @param Id
     * @return
     */
    @RequestMapping(value = "/post/getPostById", method = RequestMethod.GET)
    Result<GxqptPostRetDTO> getPostById(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode);

    /**
     * 根据ID删除数据
     *
     * @param Id
     * @return
     */
    @RequestMapping(value = "/post/removeById", method = RequestMethod.GET)
    Result<String> removeById(@RequestParam(value = "id") String id);

    /**
     * 岗位信息列表分页查询
     *
     * @return
     */
    @RequestMapping(value = "/post/findPostList", method = RequestMethod.POST)
    Result<PageInfo<GxqptPostRetDTO>> findPostList(@RequestBody OpenApiReq<GxqptPostQueryDTO> openApiReq);

}
