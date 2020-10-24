package com.hengyunsoft.platform.piping.impl;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.piping.api.msgs.dto.MessageDTO;
import com.hengyunsoft.platform.piping.constant.MessageConstant;
import com.hengyunsoft.platform.piping.utils.JSONUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "消息发送服务", description = "消息发送服务")
public class MessageSendApiImpl {
	@Autowired 
    private RabbitTemplate rabbitTemplate;
	@Value("${spring.redis.key-prefix}")
	private String keyPrefix;
	@ApiOperation(value = "消息发送服务", notes = "消息发送服务")
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public Result<String> send(@RequestBody MessageDTO messageDTO) {
		if(messageDTO == null){
			return Result.fail("参数错误");
		}
		String appid = messageDTO.getAppId();
		String appName = messageDTO.getAppName();
		String channelid = messageDTO.getChannelId();
		String msgid = messageDTO.getMsgId();
		if(StringUtils.isEmpty(msgid)&&messageDTO.getDraft()!=2){
			msgid = UUID.randomUUID().toString().replace("-", "");
			messageDTO.setMsgId(msgid);
		}
		if(StringUtils.isEmpty(appid)){
			return Result.fail("应用程序ID不能为空");
		}
		if(StringUtils.isEmpty(appName)){
			return Result.fail("应用程序名称不能为空");
		}
		if(channelid==null||"".equals(channelid)){
			return Result.fail("发送渠道不能为空");
		}
		messageDTO.setSender(BaseContextHandler.getAdminId().toString());
		Map<String, Object> map = JSON.parseObject(channelid);
		for(String type:map.keySet()){
			if("WeChat".equals(type)){
				String context = messageDTO.getContext();
				String fileUrl = messageDTO.getFileUrl();
				String imgText = messageDTO.getImgText();
				if(StringUtils.isEmpty(context)&&StringUtils.isEmpty(fileUrl)
						&&StringUtils.isEmpty(imgText)){
					return Result.fail("发布内容不能为空");
				}
				String message = JSONUtils.toJSON(messageDTO);
				rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.WECHAT_MESSAGE_CHANNEL, message);
			}
			if("Blog".equals(type)){
				String context = messageDTO.getContext();
				String fileUrl = messageDTO.getFileUrl();
				String imgText = messageDTO.getImgText();
				if(StringUtils.isEmpty(context)&&StringUtils.isEmpty(fileUrl)
						&&StringUtils.isEmpty(imgText)){
					return Result.fail("发布内容不能为空");
				}
				String message = JSONUtils.toJSON(messageDTO);
				rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.BLOG_MESSAGE_CHANNEL, message);
			}
			if("Sms".equals(type)){
				String templateId = messageDTO.getTemplateId();
				String templateParams = messageDTO.getTemplateParams();
				if(StringUtils.isEmpty(templateId)){
					return Result.fail("短信模板ID不能为空");
				}
				if(StringUtils.isEmpty(templateParams)){
					return Result.fail("短信模板参数不能为空");
				}
				String message = JSONUtils.toJSON(messageDTO);
				rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.SMS_MESSAGE_CHANNEL, message);
			}		
		}		
		return Result.success("发送成功");
	}
}
