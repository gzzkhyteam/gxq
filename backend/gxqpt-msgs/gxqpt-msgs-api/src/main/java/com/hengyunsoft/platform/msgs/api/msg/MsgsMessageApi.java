package com.hengyunsoft.platform.msgs.api.msg;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.msg.MessageSendDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MobileMsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MobileNewReadDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgDetailDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageMobileDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageQueryDTO;

/**
 * 消息API接口
 * fallback: 实现服务降级处理逻辑。
        * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
        */
@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-msgs-server}")
public interface MsgsMessageApi {
    /**
     * 保存消息
     *
     * @param
     */
    @RequestMapping(value = "/message/save", method = RequestMethod.POST)
    Result<String> save(@RequestBody MessageSendDTO messageSendDTO);
    /**
     * 更新消息
     *
     * @param
     */
    @RequestMapping(value = "/message/update", method = RequestMethod.POST)
    Result<String> update(@RequestBody MessageSendDTO messageSendDTO);
    /**
     * 根据id信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/message/delete", method = RequestMethod.GET)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);
    /**
     * 获取消息列表
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/message/query", method = RequestMethod.POST)
    Result<PageInfo<MsgsListBackDTO>> query(@RequestBody OpenApiReq<MsgsMessageQueryDTO> openApiReq);
    /**
     * 根据id获取信息详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/message/detail", method = RequestMethod.GET)
    Result<MsgDetailDTO> getMsgDetail(@RequestParam(value = "msgId") Long msgId);
    /**
     * 根据id获取草稿箱信息详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/drafts/detail", method = RequestMethod.GET)
    Result<MsgDetailDTO> getDraftsDetail(@RequestParam(value = "msgId") Long msgId);
    /**
     * 获取移动终端消息列表
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/message/mobile", method = RequestMethod.POST)
    Result<PageInfo<MobileMsgsListBackDTO>> queryMobile(@RequestBody OpenApiReq<MsgsMessageMobileDTO> openApiReq);
    /**
     * 获取移动终端消息未读数量
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/mobile/readnum", method = RequestMethod.GET)
    Result<MobileNewReadDTO> queryMobileIsRead(@RequestParam(value = "userId") Long userId);
    /**
     * 移动终端消息未读转已读
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/mobile/isread", method = RequestMethod.POST)
    Result<Boolean> saveMobileIsRead(@RequestParam(value = "userId") Long userId,@RequestParam(value = "msgId") Long msgId);
}
