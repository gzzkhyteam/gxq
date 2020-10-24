package com.hengyunsoft.platform.msgs.api.bbs;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.api.bbs.hystrix.BbsMessageApiHystrix;
import com.hengyunsoft.platform.msgs.dto.bbs.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 站内信息API
 * @author sxy
 * @date 2018-07-24
 *
 */
@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-msgs-server}",fallback = BbsMessageApiHystrix.class)
public interface BbsMessageApi {

    /**
     * 查询全部消息
     * 查询当前系统全量消息
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/msg/getAllMsg", method = RequestMethod.POST)
    Result<PageInfo<BbsAllMsgResDTO>> getAllMsg(@RequestBody OpenApiReq<BbsAllMsgReqDTO> openApiReq);
    
    /**
     * 查看指定的信息（就是获取消息的处理地址）
     * 伴随着查看业务（意味着标记此消息为已读）
     * @param 
     * @return
     */
    @RequestMapping(value = "/msg/flagReadedAndGetUrl", method = RequestMethod.GET)
    Result<String> updateToReadedAndGetUrl(Long recvMsgId);

    /**
     * 查询已读消息
     * 查询当前系统已读消息
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/msg/getReadMsg", method = RequestMethod.POST)
    Result<PageInfo<BbsAllMsgResDTO>> getReadMsg(@RequestBody OpenApiReq<BbsAllMsgReqDTO> openApiReq);

    /**
     * 根据消息ID获取消息详情
     * @param msgId
     * @return
     */
    @RequestMapping(value = "/getDetailById", method = RequestMethod.GET)
    Result<BbsMsgDetailResDTO> getDetailById(@RequestParam(value = "msgId") Long msgId);

    /**
     * 根据用户ID获取最近消息及未读数量
     * @param userId
     * @return
     */
    @RequestMapping(value = "/bbs/msg/getRecentMsgAndNotReadNum", method = RequestMethod.GET)
    Result<BbsMsgDetailResDTO> getRecentMsgAndNotReadNum(@RequestParam(value = "userId") Long userId);

    /**
     * 查询未读消息
     * 查询当前系统未读消息
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/msg/getNotReadMsg", method = RequestMethod.POST)
    Result<PageInfo<BbsNotReadMsgResDTO>> getNotReadMsg(@RequestBody OpenApiReq<BbsNotReadMsgReqDTO> openApiReq);

    /**
     * 读消息
     * 读取一个或多个消息，如果最后一个接收人的消息已读，将删除数据，进入历史库，并更新状态
     * @param ids id为接收表的主键
     * @return
     */
    @RequestMapping(value = "/msg/updateMsgsReaded", method = RequestMethod.POST)
    Result<Boolean> updateMsgsReaded(@RequestParam(value = "ids[]") Long[] ids);

    /**
     * 删除消息
     * 支持删除一条或者多条
     * @param ids id为接收表的主键
     * @return
     */
    @RequestMapping(value = "/msg/deleteById", method = RequestMethod.POST)
    Result<Boolean> deleteById(@RequestParam(value = "ids[]") Long[] ids);

    /**
     * 待办更新状态
     * 待办事项处理完成之后返回，处理结果。更新状态。
     * @param updateBacklogReqDTO
     * @return
     */
    @RequestMapping(value = "/msg/updateBacklog", method = RequestMethod.POST)
    Result<Boolean> updateBacklog(@RequestBody UpdateBacklogReqDTO updateBacklogReqDTO);

    /**
     * 保存消息
     * @param bbsAllMainMsgSaveReqDTO
     * @return
     */
    @RequestMapping(value = "/msg/saveMsg", method = RequestMethod.POST)
    Result<BbsAllMainMsgSaveResDTO> saveMsg(@RequestBody BbsAllMainMsgSaveReqDTO bbsAllMainMsgSaveReqDTO);
}
