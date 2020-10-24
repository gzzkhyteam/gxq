//package com.hengyunsoft.platform.modular.api;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.modular.api.hystrix.ModularApiHystrix;
//import com.hengyunsoft.platform.modular.dto.ModularDTO;
//import com.hengyunsoft.platform.modular.dto.ModularDiscardedPageDTO;
//import com.hengyunsoft.platform.modular.dto.ModularQueryDTO;
//import com.hengyunsoft.platform.modular.dto.ModularUpdateDTO;
//
///**
// * @author zhoukx
// * @createTime 2018-4-5
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}",
//        configuration = FeignConfiguration.class,
//        path = "/api/modular", fallback = ModularApiHystrix.class)
//public interface ModularApi {
//
//    /**
//     * 通过id查询模块对象信息
//     *
//     * @param id 模块id
//     * @return ModularDTO
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/modular/get", method = RequestMethod.GET)
//    Result<ModularDTO> getModularById(@RequestParam(value = "id") Long id);
//
//    /**
//     * 分页查询模块列表
//     *
//     * @param openApiReq 分页信息
//     * @return PageInfo<ModularDTO>
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/modular/page", method = RequestMethod.POST)
//    Result<PageInfo<ModularDTO>> page(@RequestBody OpenApiReq<ModularQueryDTO> openApiReq);
//
//    /**
//     * 模块更新
//     *
//     * @param modularUpdateDTO 要更新的模块对象
//     * @return Boolean
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/modular/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody ModularUpdateDTO modularUpdateDTO);
//
//    /**
//     * 根据id删除模块
//     * 如果模块下存在jar包则不可删除。
//     *
//     * @param id 模块id
//     * @return Boolean
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/modular/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam Long id);
//
//    /**
//     * 根据仓库名和groupId和artifactId查询模块对象信息
//     *
//     * @param modularDTO 仓库名和groupId和artifactId
//     * @return ModularDTO
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/modular/getModularByRepNameAndGidAndAid", method = RequestMethod.POST)
//    Result<ModularDTO> getModularByRepNameAndGidAndAid(@RequestBody ModularDTO modularDTO);
//
//    /**
//     * 废弃模块分页列表
//     *
//     * @param openApiReq 分页信息
//     * @return PageInfo<ModularDTO>
//     */
//    @RequestMapping(value = "/discarded/page", method = RequestMethod.POST)
//    Result<PageInfo<ModularDTO>> pageDiscarded(@RequestBody OpenApiReq<ModularDiscardedPageDTO> openApiReq);
//
//}
