//package com.hengyunsoft.platform.msgs.api.msg;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.msgs.api.msg.hystrix.MsgsChannelTypeApiHystrix;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeSelectDTO;
//
///**
// * 渠道类别API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/msgs",
//        fallback = MsgsChannelTypeApiHystrix.class)
//public interface MsgsChannelTypeApi {
//    /**
//     * 渠道类别列表无分页全部查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/channeltype/query", method = RequestMethod.GET)
//    Result<List<MsgsChannelTypeDTO>> query();
//    /**
//     * 渠道类别列表全部查询-(作为下拉框)
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/channeltype/querySelect", method = RequestMethod.POST)
//    Result<PageInfo<MsgsChannelTypeSelectDTO>> querySelect();
//}
