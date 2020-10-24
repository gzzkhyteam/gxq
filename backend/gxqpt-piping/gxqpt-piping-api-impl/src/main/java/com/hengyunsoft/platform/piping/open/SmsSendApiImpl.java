package com.hengyunsoft.platform.piping.open;

import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.servicemodule.annotation.SMSSendModule;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendToPipingDTO;
import com.hengyunsoft.platform.piping.constant.MessageConstant;
import com.hengyunsoft.platform.piping.utils.JSONUtils;
import com.hengyunsoft.platform.piping.utils.LongUtil;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "短信消息发送服务", description = "短信消息发送服务")
@SMSSendModule
@Slf4j
public class SmsSendApiImpl implements SmsSendApi {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;
    @ApiOperation(value = "短信消息发送服务", notes = "短信消息发送服务")
    @IgnoreToken
    @ApiResponses({
        @ApiResponse(code = 2, message = "应用程序id不能为空"),
        @ApiResponse(code = 3, message = "应用程序名称不能为空"),
        @ApiResponse(code = 4, message = "发送渠道不能为空"),
        @ApiResponse(code = 8, message = "发送失败"),
        @ApiResponse(code = 9, message = "接收者不能为空"),
        @ApiResponse(code = 10, message = "短信模板ID不能为空"),
        @ApiResponse(code = 11, message = "短信模板参数不能为空"),
        @ApiResponse(code = 12, message = "信息主题不能为空"),
        @ApiResponse(code = 13, message = "发送时间格式不正确"),
        @ApiResponse(code = 20, message = "发送人Id不能为空")
    })
    public Result<String> send(@RequestBody SmsSendDTO smsSendDTO) {
        try {
            String appid = smsSendDTO.getAppId();
            String appName = smsSendDTO.getAppName();
            String channelid = smsSendDTO.getChannelId();
            String userId = smsSendDTO.getSender();
            if (StringUtils.isEmpty(userId)) {
                return Result.fail(20, "发送人Id不能为空");
            }
            if (StringUtils.isEmpty(appid)) {
                return Result.fail(2, "应用程序id不能为空");
            }
            if (StringUtils.isEmpty(appName)) {
                return Result.fail(3, "应用程序名称不能为空");
            }
            if (StringUtils.isEmpty(channelid)) {
                return Result.fail(4, "发送渠道不能为空");
            }
            if (StringUtils.isEmpty(smsSendDTO.getReceiver())) {
                return Result.fail(9, "接收者不能为空");
            }
            //验证模板
            String templateId = smsSendDTO.getTemplateId();
            String templateParams = smsSendDTO.getTemplateParams();
            String topic = smsSendDTO.getTopic();
            String context = smsSendDTO.getContext();
            if (StringUtils.isEmpty(templateId)) {
                return Result.fail(10, "短信模板ID不能为空");
            }
            if (StringUtils.isEmpty(templateParams)) {
                return Result.fail(11, "短信模板参数不能为空");
            }
            if (StringUtils.isEmpty(topic)) {
                return Result.fail(11, "短信主题不能为空");
            }
            if (StringUtils.isEmpty(context)) {
                return Result.fail(11, "短信内容不能为空");
            }
            //验证手机号
			if(!StringUtils.isEmpty(smsSendDTO.getStartTime())){
				String reg = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|"
						+"((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|"
						+"((0[48]|[2468][048]|[3579][26])00))-02-29))\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
				boolean isMatch = Pattern.matches(reg, smsSendDTO.getStartTime());
				if(!isMatch){
					return Result.fail(13,"发送时间格式不正确");
				}			
			}
            SmsSendToPipingDTO smsSendToPipingDTO = new SmsSendToPipingDTO();
            long num = LongUtil.random();
            String msgid = String.valueOf(num);
            smsSendToPipingDTO.setMsgId(msgid);
            smsSendToPipingDTO.setSender(userId);
            smsSendToPipingDTO.setSenderName("其他系统");
            smsSendToPipingDTO.setDraft(0);
            smsSendToPipingDTO.setAppId(appid);
            smsSendToPipingDTO.setAppName(appName);
            smsSendToPipingDTO.setChannelId(channelid);
            smsSendToPipingDTO.setReceiver(smsSendDTO.getReceiver());
            smsSendToPipingDTO.setStartTime(smsSendDTO.getStartTime());
            smsSendToPipingDTO.setTemplateId(templateId);
            smsSendToPipingDTO.setTemplateParams(templateParams);
            smsSendToPipingDTO.setTopic(smsSendDTO.getTopic());
            smsSendToPipingDTO.setContext(smsSendDTO.getContext());
            smsSendToPipingDTO.setModuleId(smsSendDTO.getModuleId());
            smsSendToPipingDTO.setModuleName(smsSendDTO.getModuleName());
            //smsSendToPipingDTO.setSourceType("SERVICE");
            String message = JSONUtils.toJSON(smsSendToPipingDTO);
            log.info("发送短信内容,dto[{}]",message);
            rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.SMS_MESSAGE_CHANNEL, message);
            return Result.success(msgid);
        } catch (Exception e) {
            return Result.fail(8, "发送失败");
        }
    }

}
