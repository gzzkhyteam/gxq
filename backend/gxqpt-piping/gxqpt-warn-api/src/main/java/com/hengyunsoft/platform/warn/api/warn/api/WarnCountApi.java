//package com.hengyunsoft.platform.warn.api.warn.api;
//
//import java.util.List;
//
//import com.hengyunsoft.platform.warn.api.warn.dto.*;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warn.api.hystrix.WarnCountApiHystrix;
//
///**
// * 预警统计接口
// * @author dxz
// *
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//fallback = WarnCountApiHystrix.class,path = "/api/warn")
//public interface WarnCountApi {
//
//    /**
//     * 根据部门统计个人发布预警情况
//     * @return
//     */
//    @RequestMapping(value = "/warncount/personal", method = RequestMethod.POST)
//    Result<PageInfo<WarnPersonalCountDTO>> getPersonalByDepartment(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 根据单位统计部门发布预警情况
//     * @return
//     */
//    @RequestMapping(value = "/warncount/department", method = RequestMethod.POST)
//    Result<PageInfo<WarnDepartmentCountDTO>> getDepartmentByCompany(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 根据应用程序统计发布预警情况
//     * @return
//     */
//    @RequestMapping(value = "/warncount/app", method = RequestMethod.POST)
//    Result<PageInfo<WarnAppCountDTO>> getByApp(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 个人预警状态统计
//     * @return
//     */
//    @RequestMapping(value = "/warnstatus/personal", method = RequestMethod.POST)
//    Result<PageInfo<WarnStatusCountDTO>> getStatusByPersonal(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 单位预警状态统计
//     * @return
//     */
//    @RequestMapping(value = "/warnstatus/company", method = RequestMethod.POST)
//    Result<PageInfo<WarnStatusCountDTO>> getStatusByCompany(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 应用预警状态统计
//     * @return
//     */
//    @RequestMapping(value = "/warnstatus/app", method = RequestMethod.POST)
//    Result<PageInfo<WarnStatusCountDTO>> getStatusByApp(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 个人预警处理效率统计
//     * @return
//     */
//    @RequestMapping(value = "/warnhandle/personal", method = RequestMethod.POST)
//    Result<PageInfo<WarnPersonalCountDTO>> getHandleByPersonal(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 部门预警处理效率统计
//     * @return
//     */
//    @RequestMapping(value = "/warnhandle/company", method = RequestMethod.POST)
//    Result<PageInfo<WarnDepartmentCountDTO>> getHandleByCompany(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 应用预警处理效率统计
//     * @return
//     */
//    @RequestMapping(value = "/warnhandle/app", method = RequestMethod.POST)
//    Result<PageInfo<WarnAppCountDTO>> getHandleByApp(@RequestBody OpenApiReq<WarnParamDTO> openApiReq);
//    /**
//     * 数博会统计各状态预警数量
//     * @return
//     */
//    @RequestMapping(value = "/fairwarn/status", method = RequestMethod.GET)
//    Result<List<FairWarnStatusCountDTO>> getNumberByAppId(@RequestParam(value="appid")String appid);
//    /**
//     * 数博会统计各级别预警数量
//     * @return
//     */
//    @RequestMapping(value = "/fairwarn/level", method = RequestMethod.GET)
//    Result<List<FairWarnLevelCountDTO>> getLevelByAppId(@RequestParam(value="appid")String appid);
//    /**
//     * 数博会统计各类型预警数量
//     * @return
//     */
//    @RequestMapping(value = "/fairwarn/type", method = RequestMethod.GET)
//    Result<FairWarnTypeReturnDTO> getTypeByAppId(@RequestParam(value="appid")String appid);
//    /**
//     * 数博会统计各应用预警数量
//     * @return
//     */
//    @RequestMapping(value = "/fairwarn/apps", method = RequestMethod.GET)
//    Result<FairWarnAppCountDTO> getAppsNumber();
//    /**
//     * 数博会统计各月份预警数量
//     * @return
//     */
//    @RequestMapping(value = "/fairwarn/months", method = RequestMethod.GET)
//    Result<List<FairWarnTimeSlotCountDTO>> getTimeSlotByAppId(@RequestParam(value="appid")String appid);
//    /**
//     * 部门-应用-预警情况分析
//     * @return
//     */
//    @RequestMapping(value = "/fairwarn/relationship", method = RequestMethod.GET)
//    Result<List<FairRelationshipDTO>> getRelationship();
//
//    /**
//     * 获取个人预警混合状态数量,确认,处理
//     * @return
//     */
//    @RequestMapping(value = "/count/getWarnMixStatusNum", method = RequestMethod.GET)
//    Result<WarnMixStatusNumDTO> getWarnMixStatusNum(@RequestParam(value = "userId") Long userId);
//
//}
