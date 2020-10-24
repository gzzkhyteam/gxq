//package com.hengyunsoft.platform.msgs.api.msg;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.api.msg.hystrix.MsgsChannelGroupApiHystrix;
//import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupDetailBackDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelChildTreeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelGroupQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelGroupSelectDTO;
//
///**
// * 渠道API接口
// * fallback: 实现服务降级处理逻辑。
//        * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
//        */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/msgs",
//        fallback = MsgsChannelGroupApiHystrix.class)
//public interface MsgsChannelGroupApi {
//    /**
//     * 获取渠道群组分页列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/channelgroup/query", method = RequestMethod.POST)
//    Result<PageInfo<ChannelGroupDTO>> pageQuery(@RequestBody OpenApiReq<MsgsChannelGroupQueryDTO> openApiReq);
//    /**
//     * 查询所有渠道组
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/channelgroup/all", method = RequestMethod.GET)
//    Result<List<MsgsChannelGroupSelectDTO>> allQuery(@RequestParam(value = "name") String name);
//    /**
//     * 删除渠道群组
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/channelgroup/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//    /**
//     * 新增渠道群组
//     * @param
//     */
//    @RequestMapping(value = "/channelgroup/save", method = RequestMethod.POST)
//    Result<String> save(@RequestBody ChannelGroupSaveDTO channelGroupSaveDTO);
//    /**
//     * 更新渠道群组
//     * @param
//     */
//    @RequestMapping(value = "/channelgroup/update", method = RequestMethod.POST)
//    Result<String> update(@RequestBody ChannelGroupSaveDTO channelGroupSaveDTO);
//    /**
//     * 获取群组包含子渠道
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/channelgroup/detail", method = RequestMethod.GET)
//    Result<List<MsgChannelChildTreeDTO>> getGroupDetail(@RequestParam(value = "id") Long id);
//    /**
//     * 获取群组详情
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/channelgroup/get", method = RequestMethod.GET)
//    Result<ChannelGroupDetailBackDTO> selectGroupDetail(@RequestParam(value = "id") Long id);
//    /**
//     * 获取渠道关系
//     * @return
//     */
//    @RequestMapping(value = "/channel/relation", method = RequestMethod.GET)
//    Result<List<Long>> queryGroupRelation(@RequestParam(value = "id") Long id);
//}
