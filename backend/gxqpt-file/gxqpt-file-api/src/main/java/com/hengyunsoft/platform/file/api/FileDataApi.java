//package com.hengyunsoft.platform.file.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.file.api.hystrix.FileDataApiHystrix;
//import com.hengyunsoft.platform.file.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 云盘首页
// * */
//@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-file-server}",
//        configuration = FeignConfiguration.class,
//        fallback = FileDataApiHystrix.class)
//public interface FileDataApi {
//
//    /**
//     * 云盘首页数据概览
//     * */
//    @RequestMapping(value = "/file/getMyFileDataView", method = RequestMethod.GET)
//    Result<FileDataViewDTO> getMyFileDataView();
//
//    /**
//     * 文件类型情况
//     * */
//    @RequestMapping(value = "/file/getMyFileTypeView", method = RequestMethod.GET)
//    Result<FileTypeViewDTO> getMyFileTypeView();
//
//    /**
//     * 文件分享占比
//     * */
//    @RequestMapping(value = "/file/getFileShareData", method = RequestMethod.GET)
//    Result<FileShareViewDTO> getFileShareData();
//
//    /**
//     *全部文件发展情况（统计数量）
//     * */
//    @RequestMapping(value = "/file/getFileDev", method = RequestMethod.GET)
//    Result<List<FileDevViewDTO>> getFileDev(@RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime);
//
//    /**
//     * 个人各种类型文件近六月发展状况分析
//    * */
//    @RequestMapping(value = "/file/getFileDataTypeDev", method = RequestMethod.GET)
//    Result<List<FileDataTypeDevViewDTO>> getFileDataTypeDev(@RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime);
//
//}
