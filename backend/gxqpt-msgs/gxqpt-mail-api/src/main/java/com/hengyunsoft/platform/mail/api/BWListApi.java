//package com.hengyunsoft.platform.mail.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mail.api.hystrix.BWListApiHystrix;
//import com.hengyunsoft.platform.mail.dto.bwlist.BWListDTO;
//import com.hengyunsoft.platform.mail.dto.bwlist.BWPagingDTO;
//import com.hengyunsoft.platform.mail.dto.bwlist.QueryBWDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author zjr
// * @date 2018/08/08
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", fallback = BWListApiHystrix.class,
//        path = "/api/mail")
//public interface BWListApi {
//    /**
//     * 新增黑名单
//     * @param bwListDto
//     * @return
//     */
//    @RequestMapping(value = "/mail/save", method = RequestMethod.POST)
//    Result<Boolean> save(@RequestBody BWListDTO bwListDto);
//
//    /**
//     * 查询黑名单分页列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/mail/findBWList", method = RequestMethod.POST)
//    Result<PageInfo<BWPagingDTO>> findBWList(@RequestBody OpenApiReq<QueryBWDTO> openApiReq);
//
//    /**
//     * 根据id删除黑名单
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/mail/deleteById", method = RequestMethod.GET)
//    Result<String> deleteById(@RequestParam(value = "id") Long id);
//
//    /**
//     * 新增白名单
//     * @param bwListDto
//     * @return
//     */
//    @RequestMapping(value = "/mail/saveWhite", method = RequestMethod.POST)
//    Result<Boolean> saveWhite(@RequestBody BWListDTO bwListDto);
//
//    /**
//     * 根据id删除白名单
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/mail/deleteWhiteById", method = RequestMethod.GET)
//    Result<String> deleteWhiteById(@RequestParam(value = "id") Long id);
//}
