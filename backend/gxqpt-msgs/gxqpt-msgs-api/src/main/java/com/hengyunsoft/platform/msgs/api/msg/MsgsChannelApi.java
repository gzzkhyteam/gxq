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
//import com.hengyunsoft.platform.msgs.api.msg.hystrix.MsgsChannelApiHystrix;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTreeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelByTypeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeSelectDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelUpdateDTO;
//
///**
// * 渠道API接口
// * fallback: 实现服务降级处理逻辑。
//        * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
//        */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/msgs",
//        fallback = MsgsChannelApiHystrix.class)
//public interface MsgsChannelApi {
//
//    /**
//     * 渠道分页查询
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/channel/query", method = RequestMethod.POST)
//    Result<PageInfo<MsgsChannelDTO>> query(@RequestBody OpenApiReq<MsgsChannelQueryDTO> openApiReq);
//
//    /**
//     * 根据类型id查询渠道列表
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/channel/getChannelByType", method = RequestMethod.POST)
//    Result<PageInfo<MsgsChannelByTypeDTO>> getChannelByType(@RequestParam(value = "typeId") Integer typeId);
//
//    /**
//     * 根据id 查看渠道详情
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/channel/get", method = RequestMethod.GET)
//    Result<MsgsChannelDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 保存渠道
//     *
//     * @param
//     */
//    @RequestMapping(value = "/channel/save", method = RequestMethod.POST)
//    Result<String> save(@RequestBody MsgsChannelSaveDTO msgsChannelSaveDTO);
//
//    /**
//     * 更新渠道
//     *
//     * @param
//     */
//    @RequestMapping(value = "/channel/update", method = RequestMethod.POST)
//    Result<String> update(@RequestBody MsgsChannelUpdateDTO msgsChannelUpdateDTO);
//
//    /**
//     * 根据id 删除
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/channel/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//    /**
//     * 获取渠道树
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/channel/tree", method = RequestMethod.GET)
//    Result<List<MsgChannelTreeDTO>> getTree();
//    /**
//     * 根据名称模糊查询渠道树
//     *
//     * @param name
//     * @return
//     */
//    @RequestMapping(value = "/channel/like", method = RequestMethod.GET)
//    Result<List<MsgChannelTreeDTO>> getTreeByNameLike(@RequestParam(value = "name") String name);
//    /**
//     * 根据类型获取渠道
//     *
//     * @param name
//     * @return
//     */
//    @RequestMapping(value = "/channel/type", method = RequestMethod.GET)
//    Result<List<MsgsChannelByTypeDTO>> getByType(@RequestParam(value = "type") Integer type);
//    /**
//     * 获取渠道类型
//     * @return
//     */
//    @RequestMapping(value = "/channeltype/list", method = RequestMethod.GET)
//    Result<List<MsgsChannelTypeSelectDTO>> querySelect();
//}
