//package com.hengyunsoft.platform.mt.api.application.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.application.api.hystrix.ApplicationApiHystrix;
//import com.hengyunsoft.platform.mt.api.application.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 描述：
// *
// * @author gbl
// * @date 2018/5/27
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/appmanager", fallback = ApplicationApiHystrix.class)
//public interface ApplicationApi {
//
//    /**
//     * 描述：创建应用第一步,基本信息
//     * 参数：dto
//     * 返回值：数据集ID
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "createAppFirst", method = RequestMethod.POST)
//    Result<Long> createAppFirst(@RequestBody CreateAppFirstReqDTO dto);
//
//    /**
//     * 描述：查询应用列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "find", method = RequestMethod.POST)
//    Result<PageInfo<ApplicationDTO>> find(@RequestBody OpenApiReq<QueryApplicationParamDTO> openApiReq);
//
//    /**
//     * 描述：查找所有的应用
//     * 参数：
//     * 返回值：返回应用的id和名称
//     * 修改人：gbl
//     * 修改时间：2018/7/11
//     * 修改内容：
//     */
//    @RequestMapping(value = "findAllApp", method = RequestMethod.POST)
//    Result<List<AppIdAndNameDTO>> findAllApp();
//
//    /**
//     * 描述：根据id查询应用详情
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "getAppBaseInfo", method = RequestMethod.POST)
//    Result<ApplicationDTO> getAppBaseInfo(@RequestParam("id") Long id);
//
//    /**
//     * 描述：审核应用
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "auditApp", method = RequestMethod.POST)
//    Result<Boolean> auditApp(@RequestBody AuditAppReqDTO dto);
//
//
//    /**
//     * 描述：创建功能
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "createFunction", method = RequestMethod.POST)
//    Result<Boolean> createFunction(@RequestBody CreateFunctionReqDTO dto);
//
//    /**
//     * 描述：查询应用的功能
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "findFunctionListByAppId", method = RequestMethod.POST)
//    Result<List<FunctionDTO>> findFunctionListByAppId(@RequestParam("appId") Long appId);
//
//    /**
//     * 描述：查询所有的功能列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "findAllFunctionList", method = RequestMethod.POST)
//    Result<List<FunctionDTO>> findAllFunctionList();
//
//    /**
//     * 描述：查询功能详情
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "getFunctionInfo", method = RequestMethod.POST)
//    Result<FunctionDTO> getFunctionInfo(@RequestParam("funcId") Long funcId);
//}
