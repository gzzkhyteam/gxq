//package com.hengyunsoft.platform.modular.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.modular.api.hystrix.ModularApiHystrix;
//import com.hengyunsoft.platform.modular.dto.HotSupportDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.text.ParseException;
//import java.util.List;
//
///**
// * 标准文档分析API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}",
//        configuration = FeignConfiguration.class,
//        path = "/api/modular", fallback = ModularApiHystrix.class)
//
//public interface ModularUseAnalysisApi {
//
//    /**
//     * 活跃提供商榜
//     *
//    */
//    @RequestMapping(value = "/analysis/hotsupport/top10", method = RequestMethod.POST)
//   Result<List<HotSupportDTO>>  hotSupport() throws ParseException;
//
//    /**
//     * 模块热度榜
//     *
//
//     */
//    @RequestMapping(value = "/analysis/hotmodular/top10", method = RequestMethod.POST)
//    Result<List<HotSupportDTO>> hotModularTop10() throws ParseException;
//
//    /**
//     * 模块活跃度榜
//     *
//     *
//     */
//    @RequestMapping(value = "/analysis/hotmodularjar/top10", method = RequestMethod.POST)
//    Result<List<HotSupportDTO>> hotModularjar() throws ParseException;
//
//
//
//
//    /**
//     * 新模块榜
//     *
//     *
//     */
//    @RequestMapping(value = "/analysis/newmodular/top10", method = RequestMethod.POST)
//    Result<List<HotSupportDTO>> newModular() throws ParseException;
//
//}
