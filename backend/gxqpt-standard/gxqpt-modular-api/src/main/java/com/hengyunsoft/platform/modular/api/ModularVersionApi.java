//package com.hengyunsoft.platform.modular.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.modular.api.hystrix.ModularApiHystrix;
//import com.hengyunsoft.platform.modular.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * @author zhoukx
// * @createTime 2018-4-5
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}",
//        configuration = FeignConfiguration.class,
//        path = "/api/modular", fallback = ModularApiHystrix.class)
//public interface ModularVersionApi {
//
//    /**
//     * 根据id 查看版本详情
//     *
//     * @param id 模块版本id
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/get", method = RequestMethod.GET)
//    Result<ModularVersionDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 版本列表查询
//     * 分页查询指定模块的jar包
//     *
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/pageModularJar", method = RequestMethod.POST)
//    Result<PageInfo<ModularVersionDTO>> pageModularJar(@RequestBody OpenApiReq<ModularVersionQueryDTO> openApiReq);
//
//    /**
//     * 版本列表查询
//     * 分页查询jar包
//     *
//     * @param openApiReq
//     * @createTime 2018-4-16
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/pageJar", method = RequestMethod.POST)
//    Result<PageInfo<ModularVersionDTO>> pageJar(@RequestBody OpenApiReq<ModularVersionPageDTO> openApiReq);
//
//    /**
//     * 获取登录人的单位信息
//     *
//     * @param
//     */
//    @RequestMapping(value = "/version/findPoly", method = RequestMethod.GET)
//    Result<List<CompanyInfoDTO>> findPolyByUser();
//
//    /**
//     * 发布版本
//     *
//     * @param file    上传的文件，单文件上传
//     * @param request
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/upload", method = RequestMethod.POST)
//    Result<ModularDTO> upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request);
//
//    /**
//     * 发布版本
//     *
//     * @param files   上传的文件，支持多文件上传
//     * @param request
//     * @createTime 2018-5-16
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/uploads", method = RequestMethod.POST)
//    Result<List<ModularDTO>> uploads(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request);
//
//    /**
//     * 更新jar包版本
//     *
//     * @param file    上传的文件
//     * @param request
//     * @createTime 2018-4-18
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/updateVersion", method = RequestMethod.POST)
//    Result<ModularDTO> updateVersion(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request);
//
//    /**
//     * 根据id 删除版本（同时删除nexus仓库对应的版本文件）
//     *
//     * @param id 模块版本id
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @RequestMapping(value = "/version/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//
//}
