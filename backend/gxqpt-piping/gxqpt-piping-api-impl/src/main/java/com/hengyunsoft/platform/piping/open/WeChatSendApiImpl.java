package com.hengyunsoft.platform.piping.open;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.servicemodule.annotation.WeixinSendModule;
import com.hengyunsoft.platform.piping.api.msgs.dto.WeChatSendDTO;
import com.hengyunsoft.platform.piping.api.msgs.dto.WeChatSendToPipingDTO;
import com.hengyunsoft.platform.piping.constant.MessageConstant;
import com.hengyunsoft.platform.piping.utils.JSONUtils;
import com.hengyunsoft.platform.piping.utils.LongUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "微信消息发送服务", description = "微信消息发送服务")
@WeixinSendModule
public class WeChatSendApiImpl implements WeChatSendApi {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    @ApiOperation(value = "微信消息发送服务", notes = "微信消息发送服务")
    @ApiResponses({
            @ApiResponse(code = 2, message = "应用程序id不能为空"),
            @ApiResponse(code = 3, message = "应用程序名称不能为空"),
            @ApiResponse(code = 4, message = "发送渠道不能为空"),
            @ApiResponse(code = 5, message = "发布内容不能为空"),
            @ApiResponse(code = 8, message = "发送失败"),
            @ApiResponse(code = 12, message = "信息主题不能为空"),
            @ApiResponse(code = 13, message = "发送时间格式不正确")
    })
    public Result<String> send(WeChatSendDTO weChatSendDTO) {
        try {
            String appid = weChatSendDTO.getAppId();
            String appName = weChatSendDTO.getAppName();
            String channelid = weChatSendDTO.getChannelId();
            String imgText = weChatSendDTO.getImgText();
            String topic = weChatSendDTO.getTopic();
            if (StringUtils.isEmpty(appid)) {
                return Result.fail(2, "应用程序id不能为空");
            }
            if (StringUtils.isEmpty(appName)) {
                return Result.fail(3, "应用程序名称不能为空");
            }
            if (StringUtils.isEmpty(channelid)) {
                return Result.fail(4, "发送渠道不能为空");
            }
            if (StringUtils.isEmpty(imgText)) {
                return Result.fail(5, "发布内容不能为空");
            }
            if (StringUtils.isEmpty(topic)) {
                return Result.fail(12, "信息主题不能为空");
            }
            if (!StringUtils.isEmpty(weChatSendDTO.getStartTime())) {
                String reg = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|"
                        + "((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|"
                        + "((0[48]|[2468][048]|[3579][26])00))-02-29))\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
                boolean isMatch = Pattern.matches(reg, weChatSendDTO.getStartTime());
                if (!isMatch) {
                    return Result.fail(13, "发送时间格式不正确");
                }
            }
            long num = LongUtil.random();
            String msgid = String.valueOf(num);
            WeChatSendToPipingDTO weChatSendToPipingDTO = new WeChatSendToPipingDTO();
            weChatSendToPipingDTO.setAppId(appid);
            weChatSendToPipingDTO.setAppName(appName);
            weChatSendToPipingDTO.setChannelId(channelid);
            weChatSendToPipingDTO.setDigest(weChatSendDTO.getDigest());
            weChatSendToPipingDTO.setDraft(0);
            weChatSendToPipingDTO.setFilepath(weChatSendDTO.getFilepath());
            weChatSendToPipingDTO.setImgText(imgText);
            weChatSendToPipingDTO.setMsgId(msgid);
            weChatSendToPipingDTO.setSender("123456");
            weChatSendToPipingDTO.setSenderName("其他系统");
            weChatSendToPipingDTO.setStartTime(weChatSendDTO.getStartTime());
            weChatSendToPipingDTO.setTopic(topic);
            String message = JSONUtils.toJSON(weChatSendToPipingDTO);
            rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.WECHAT_MESSAGE_CHANNEL, message);
            return Result.success(msgid);
        } catch (Exception e) {
            return Result.fail(8, "发送失败");
        }
    }
}
