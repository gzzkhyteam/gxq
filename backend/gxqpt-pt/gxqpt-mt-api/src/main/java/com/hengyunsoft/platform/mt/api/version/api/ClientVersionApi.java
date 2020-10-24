//package com.hengyunsoft.platform.mt.api.version.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.version.api.hystrix.ClientVersionApiHystrix;
//import com.hengyunsoft.platform.mt.api.version.dto.ClientVersionDTO;
//import com.hengyunsoft.platform.mt.api.version.dto.CreateVersionParamDTO;
//import com.hengyunsoft.platform.mt.api.version.dto.QueryClientVersionParamDTO;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * 描述：客户端版本api
// *
// * @author gbl
// * @date 2018/5/27
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/clientVersion", fallback = ClientVersionApiHystrix.class)
//public interface ClientVersionApi {
//
//    /**
//     * 描述：创建版本
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "createVersion", method = RequestMethod.POST)
//    Result<Boolean> createVersion(@RequestBody CreateVersionParamDTO dto);
//
//    /**
//     * 描述：查询版本列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "find", method = RequestMethod.POST)
//    Result<PageInfo<ClientVersionDTO>> find(@RequestBody OpenApiReq<QueryClientVersionParamDTO> openApiReq);
//
//    /**
//     * 描述：发布版本
//     * 参数：版本id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "publishVersion", method = RequestMethod.POST)
//    Result<Boolean> publishVersion(@RequestParam("id") Long id) throws Exception;
//
//    /**
//     * 描述：查询已经发布的版本
//     * 参数：版本id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "findPubishVersion", method = RequestMethod.POST)
//    Result<PageInfo<ClientVersionDTO>> findPubishVersion(@RequestBody OpenApiReq<QueryClientVersionParamDTO> openApiReq);
//
//    /**
//     * 描述：根据版本id查询版本详情
//     * 参数：版本id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "getBaseInfo", method = RequestMethod.POST)
//    Result<ClientVersionDTO> getBaseInfo(@RequestParam("id") Long id);
//
//    /**
//     * 描述：得到最新的版本信息
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "getLastVersionInfo", method = RequestMethod.GET)
//    @ApiOperation(value = "得到最新的版本信息", notes = "得到最新的版本信息")
//    Result<ClientVersionDTO> getLastVersionInfo();
//
//    /**
//     * 描述：更新版本数量加1
//     * 参数：版本id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/13
//     * 修改内容：
//     */
//    @RequestMapping(value = "addUpdataOne", method = RequestMethod.POST)
//    Result<Boolean> addUpdataOne(@RequestParam("id") Long id);
//}
