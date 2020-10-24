//package com.hengyunsoft.platform.modular.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.modular.api.ModularVersionApi;
//import com.hengyunsoft.platform.modular.dto.*;
//import org.springframework.stereotype.Component;
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
//@Component
//public class ModularVersionApiHystrix implements ModularVersionApi {
//
//    /**
//     * 根据id 查看版本详情
//     *
//     * @param id 模块版本id
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<ModularVersionDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 版本列表查询
//     * 分页查询指定模块的jar包
//     *
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<PageInfo<ModularVersionDTO>> pageModularJar(OpenApiReq<ModularVersionQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 版本列表查询
//     * 分页查询jar包
//     *
//     * @param openApiReq
//     * @createTime 2018-4-16
//     * @author zhoukx
//     */
//    @Override
//    public Result<PageInfo<ModularVersionDTO>> pageJar(OpenApiReq<ModularVersionPageDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 获取登录人的单位信息
//     */
//    @Override
//    public Result<List<CompanyInfoDTO>> findPolyByUser() {
//        return Result.timeout();
//    }
//
//    /**
//     * 发布版本
//     *
//     * @param file    上传的文件，单文件上传
//     * @param request
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<ModularDTO> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        return Result.timeout();
//    }
//
//    /**
//     * 发布版本
//     *
//     * @param files   上传的文件，支持多文件上传
//     * @param request
//     * @createTime 2018-5-16
//     * @author zhoukx
//     */
//    @Override
//    public Result<List<ModularDTO>> uploads(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
//        return Result.timeout();
//    }
//
//    /**
//     * 更新jar包版本
//     *
//     * @param file    上传的文件
//     * @param request
//     * @createTime 2018-4-18
//     * @author zhoukx
//     */
//    @Override
//    public Result<ModularDTO> updateVersion(MultipartFile file, HttpServletRequest request) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据id 删除版本（同时删除nexus仓库对应的版本文件）
//     *
//     * @param id 模块版本id
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return null;
//    }
//}
