//package com.hengyunsoft.platform.exchange.api.dataapi.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix.ShareDataDemandApiHystrix;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * com.hengyunsoft.platform.exchange.api.dataapi.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：角色管理Api
// * 修改人：zhaopengfei
// * 修改时间：2018/4/21
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//        path = "api/exchange", fallback = ShareDataDemandApiHystrix.class)
//public interface ShareDataDemandApi {
//    /**
//     * 描述：新增需求
//     * 参数：DemandSaveDTO 需求新增dto
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/demand/save", method = RequestMethod.POST)
//    Result<Boolean> save(@RequestBody DemandSaveDTO dto);
//
//    /**
//     * 描述：查询api分页数据
//     * 参数：openApiReq 分页信息；appId：应用Id
//     * 返回值：PageInfo<RoleDto>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/demand/find", method = RequestMethod.POST)
//    Result<PageInfo<DemandListDTO>> page(@RequestBody OpenApiReq<DemandQueryDTO> openApiReq);
//
//    /**
//     * 描述：根据需求Id查询需求处理详细信息
//     * 参数：id：需求Id
//     * 返回值：DemandHandleDetailDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/demand/hddetail", method = RequestMethod.POST)
//    Result<DemandHandleDetailDTO> getHandleDetail(@RequestParam("id") Long id);
//
//    /**
//     * 描述：获取需求新增时公共信息
//     * 参数：unitId：单位Id
//     * 返回值：DemandHandleDetailDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/demand/getaddinfo", method = RequestMethod.GET)
//     Result<DemandAddRequestDTO> getUnitName();
//}
