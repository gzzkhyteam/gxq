//package com.hengyunsoft.platform.exchange.api.screen.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.exchange.api.flow.api.hystrix.ShareFlowTaskApiHystrix;
//import com.hengyunsoft.platform.exchange.api.screen.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * @author wgj
// * @TODO: 数博会数据交换共享屏
// * 查询各类图表
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// * @createTime 2018-05-01 10:42
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-exchange-server}",
//        path = "/api/exchange",
//        fallback = ShareFlowTaskApiHystrix.class)
//public interface ShareDataScreenApi {
//    /**
//     *查询首页统计数据
//     * 包含接入部门，数据目录，数据集，API,访问量，调用次数
//     * @return
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getShareDataCount", method = RequestMethod.POST)
//    public Result<ScreenDataCountDTO>  getShareDataCount();
//
//
//    /**
//     *按月查询平台数据情况
//     * 数据目录，数据集，API
//     * @return
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getShareDataView", method = RequestMethod.POST)
//    public Result<ScreenDataViewDTO>  getShareDataView();
//
//    /**
//     *部门使用情况
//     * api数目与调用次数
//     * @return
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getOrgUseView", method = RequestMethod.POST)
//    public Result<OrgApiViewDTO>  getOrgUseView();
//
//    /**
//     *API调用TOP10
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getApiCallTopList", method = RequestMethod.POST)
//    public Result<OrgApiViewDTO>  getApiCallTopList();
//
//    /**
//     *数据趋势
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getDataTrend", method = RequestMethod.POST)
//    public Result<DataTrendDTO>  getDataTrend();
//
//    /**
//     *api实时调用
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getApiRealTimeCall", method = RequestMethod.GET)
//    public Result<List<ScreenApiRealDTO>>  getApiRealTimeCall();
//
//
//    /**
//     *共享交换调用关系
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getCallRelationship", method = RequestMethod.GET)
//    public Result<List<RelationshipDTO>>  getCallRelationship();
//
//
//    /**
//     *整体概览
//     * @return 数据目录，数据量
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getDirDataCount", method = RequestMethod.GET)
//    public Result<DirDataCount>  getDirDataCount(String unitId);
//
//    /**
//     *整体概览(部门统计)
//     * @return 数据目录，数据量,api数量
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/screen/getOrgDataCount", method = RequestMethod.GET)
//    public Result<OrgDataDTO>  getOrgDataCount();
//
//}
