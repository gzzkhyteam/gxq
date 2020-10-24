//package com.hengyunsoft.platform.file.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.file.api.hystrix.FileRecycleApiHystrix;
//import com.hengyunsoft.platform.file.dto.FileRecycleDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 回收站
// */
//@FeignClient(name = "${gxqpt.feign.file-server:gxqpt-file-server}", fallback = FileRecycleApiHystrix.class)
//public interface FileRecycleApi {
//    @RequestMapping(value = "/filerecycle/page", method = RequestMethod.POST)
//    Result<PageInfo<FileRecycleDTO>> page(@RequestBody OpenApiReq<FileRecycleDTO> openApiReq);
//
//    /**
//     * 删除文件
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/filerecycle/remove", method = RequestMethod.POST)
//    Result<Boolean> remove(@RequestParam(value = "ids[]") Long[] ids);
//
//    /**
//     * 还原回收站
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/filerecycle/recycle", method = RequestMethod.POST)
//    Result<Boolean> recycleFile(@RequestParam(value = "ids []") Long[] ids);
//
//    /**
//     * 获取永久回收数据
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/filerecycle/getForeverRecycle", method = RequestMethod.GET)
//    List<FileRecycleDTO> getForeverRecycle();
//
//    /**
//     * 永久回收数据
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/filerecycle/foreverRecycle", method = RequestMethod.POST)
//    void foreverRecycle(Long id);
//}
