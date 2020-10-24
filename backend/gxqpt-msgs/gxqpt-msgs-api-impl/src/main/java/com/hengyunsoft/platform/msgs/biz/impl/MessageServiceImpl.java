package com.hengyunsoft.platform.msgs.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.msgs.biz.BlogMessageService;
import com.hengyunsoft.platform.msgs.biz.MessageService;
import com.hengyunsoft.platform.msgs.biz.MobileMessageService;
import com.hengyunsoft.platform.msgs.biz.SmsMessageService;
import com.hengyunsoft.platform.msgs.biz.WeChatMessageService;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelThreeDTO;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WechatSendStatus;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WechatSendStatusService;
import com.hengyunsoft.platform.msgs.utils.JSONUtils;
import com.hengyunsoft.platform.msgs.utils.Util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
/**
 * 内部使用信息发布接口
 * @author dxz
 */
@Slf4j
@Component
public class MessageServiceImpl implements MessageService{
	@Autowired
	private SmsMessageService smsMessageService;
	@Autowired
	private BlogMessageService blogMessageService;
	@Autowired
	private WeChatMessageService weChatMessageService;
	@Autowired
	private BlogSendStatusService blogSendStatusService;
	@Autowired
	private SmsSendStatusService smsSendStatusService;
	@Autowired
	private WechatSendStatusService wechatSendStatusService;
	@Autowired
	private MobileMessageService mobileMessageService;
	@Autowired
	private MobileSendStatusService mobileSendStatusService;

	@Override
	public String saveMessage(MessageDTO messageDTO) {
		List<MsgsChannelThreeDTO> channelIds = messageDTO.getChannelIds();
		String msgid = messageDTO.getMsgId();
		int draft = messageDTO.getDraft();
		String ding = messageDTO.getStartTime();
		if(Util.isEmptyString(msgid)&&messageDTO.getDraft()!=2){
			messageDTO.setMsgId(String.valueOf(blogSendStatusService.genId()));
		}
		if(channelIds==null||channelIds.size()==0){
			return "渠道不能为空";
		}
		messageDTO.setAppId(BaseContextHandler.getAppId());
		messageDTO.setAppName(BaseContextHandler.getAppName());
		messageDTO.setSender(BaseContextHandler.getAdminId()+"");
		messageDTO.setSenderName(BaseContextHandler.getName());
		String sendWeChatResult = "";
		String sendBlogResult = "";
		String sendMobileResult = "";
		try {				
			for(MsgsChannelThreeDTO msgsChannelThreeDTO:channelIds){
				String type = msgsChannelThreeDTO.getChannelType();
				String result = null;
				messageDTO.setChannelId(String.valueOf(msgsChannelThreeDTO.getId()));
				if("1".equals(type)){
					//微信
					String imgText = messageDTO.getImgText();
					if(StringUtils.isEmpty(imgText)){
						return "发布内容不能为空";
					}					
					String message = JSONUtils.toJSON(messageDTO);
					result = weChatMessageService.saveWechatMessage(message);
					if("dataNull".equals(result)){
						sendWeChatResult = "发送微信数据参数不能为空";
					}else if("topicError".equals(result)){
						sendWeChatResult = "请填写信息主题";
					}else if("channelError".equals(result)){
						sendWeChatResult = "微信渠道无效";
					}else if("sendError".equals(result)){
						sendWeChatResult = "发送微信失败";
					}else if("saveError".equals(result)){
						sendWeChatResult = "发送微信记录保存失败";
					}else if("draftError".equals(result)){
						sendWeChatResult = "微信草稿查询失败";
					}else if("saveDraftError".equals(result)){
						sendWeChatResult = "保存微信草稿失败";
					}else if("exception".equals(result)){
						sendWeChatResult = "发送微信异常";
					}else if("blacklist".equals(result)){
						sendWeChatResult = "您已被加入黑名单，请联系管理员";
					}
					if(draft == 1&&!"success".equals(result)){
						sendWeChatResult =  "保存草稿失败";
					}
					if(!StringUtils.isEmpty(ding)&&!"success".equals(result)){
						sendWeChatResult =  "发送失败";
					}
				}
				if("2".equals(type)){
					//微博
					String imgText = messageDTO.getImgText();
					if(StringUtils.isEmpty(imgText)){
						return "发布内容不能为空";
					}
					String message = JSONUtils.toJSON(messageDTO);
					result = blogMessageService.saveBlogMessage(message);
					if("dataError".equals(result)){
						sendBlogResult = "发送微博参数错误";
					}else if("sendError".equals(result)){
						sendBlogResult = "发送微博失败";
					}else if("contextError".equals(result)){
						sendBlogResult = "内容必须含有一个网址";
					}else if("saveError".equals(result)){
						sendBlogResult = "发送微博记录保存失败";
					}else if("draftError".equals(result)){
						sendBlogResult = "微博草稿查询失败";
					}else if("saveDraftError".equals(result)){
						sendBlogResult = "保存微博草稿失败";
					}else if("exception".equals(result)){
						sendBlogResult = "发送微博异常";
					}else if("blacklist".equals(result)){
						sendBlogResult = "您已被加入黑名单，请联系管理员";
					}
					if(draft == 1&&!"success".equals(result)){
						sendBlogResult = "保存草稿失败";
					}
					if(!StringUtils.isEmpty(ding)&&!"success".equals(result)){
						sendBlogResult = "发送失败";
					}
				}
				if("3".equals(type)){
					//短信
					String templateId = messageDTO.getTemplateId();
					String templateParams = messageDTO.getTemplateParams();
					if(StringUtils.isEmpty(templateId)){
						return "短信模板不能为空";
					}
					if(StringUtils.isEmpty(templateParams)){
						return "短信模板参数不能为空";
					}
					String message = JSONUtils.toJSON(messageDTO);
					result = smsMessageService.saveMsg(message);
					if("sendError".equals(result)){
						return "发送短信失败";
					}else if("reciverTooLong".equals(result)){
						return "接收人数量超限";
					}else if("dataError".equals(result)){
						return "发送短信参数错误";
					}else if("saveError".equals(result)){
						return "保存短信记录失败";
					}else if("draftError".equals(result)){
						return "短信草稿查询失败";
					}else if("saveDraftError".equals(result)){
						return "保存短信草稿失败";
					}else if("dataTooLong".equals(result)){
						return "短信字数超限";
					}else if("exception".equals(result)){
						return "发送短信异常";
					}else if("blacklist".equals(result)){
						return "您已被加入黑名单，请联系管理员";
					}
					if(draft == 1&&!"success".equals(result)){
						return "保存草稿失败";
					}
					if(!StringUtils.isEmpty(ding)&&!"success".equals(result)){
						return "发送失败";
					}
				}	
				if("5".equals(type)){
					//移动终端
					String imgText = messageDTO.getImgText();
					if(StringUtils.isEmpty(imgText)){
						return "发布内容不能为空";
					}
					String message = JSONUtils.toJSON(messageDTO);
					result = mobileMessageService.saveMobileMessage(message);	
					if("exception".equals(result)){
						sendMobileResult = "发送移动终端消息出错";
					}else if("channelError".equals(result)){
						sendMobileResult = "发送渠道不存在";
					}else if("blacklist".equals(result)){
						sendMobileResult = "您已被加入黑名单，请联系管理员";
					}
				}
			}		
		}catch (Exception e) {
			log.error("发布信息异常"+e);
			if(draft == 1){
				return "保存草稿异常";
			}
			return "发布信息异常";
		}
		if(!Util.isEmptyString(sendWeChatResult)){
			return sendWeChatResult;			
		}
		if(!Util.isEmptyString(sendBlogResult)){
			return sendBlogResult;			
		}
		if(!Util.isEmptyString(sendMobileResult)){
			return sendMobileResult;			
		}
		if(draft == 1){
			return "保存草稿成功";
		}
		return "发送成功";
	}

	/**
	 * 获得信息详情错误信息情况
	 */
	@Override
	public JSONObject getErrorInfo(String msgId) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<SmsSendStatus> smsList = smsSendStatusService.getByMsgId(msgId);
			List<BlogSendStatus> blogList = blogSendStatusService.getByMsgId(msgId);
			List<WechatSendStatus> wechatList = wechatSendStatusService.getByMsgId(msgId);
			List<MobileSendStatus> mobileList = mobileSendStatusService.getByMsgId(msgId);
			int success = 0;
			int error = 0;			
			if(!Util.isEmpty(smsList)){
				Map<String,List<String>> smsMap = new HashMap<String, List<String>>();
				List<String> channelSuccessList = new ArrayList<String>();
				List<String> channelErrorList = new ArrayList<String>();
				for(SmsSendStatus smsSendStatus:smsList){					
					String receiver = smsSendStatus.getReceiver();
					Integer sendStatus = smsSendStatus.getSendStatus();
					if(sendStatus==1){
						channelSuccessList.add(receiver);
						success += 1;
					}else if(sendStatus==2){
						channelErrorList.add(receiver);
						error += 1;
					}
				}
				smsMap.put("success",channelSuccessList);
				smsMap.put("error",channelErrorList);
				map.put("Sms", smsMap);
			}
			if(!Util.isEmpty(blogList)){
				Map<String,List<String>> blogMap = new HashMap<String, List<String>>();
				List<String> channelSuccessList = new ArrayList<String>();
				List<String> channelErrorList = new ArrayList<String>();
				for(BlogSendStatus blogSendStatus:blogList){					
					String channelName = blogSendStatus.getChannelName();
					Integer sendStatus = blogSendStatus.getSendStatus();
					if(sendStatus==1){
						channelSuccessList.add(channelName);
						success += 1;
					}else if(sendStatus==2){
						channelErrorList.add(channelName);
						error += 1;
					}
				}
				blogMap.put("success",channelSuccessList);
				blogMap.put("error",channelErrorList);
				map.put("Blog", blogMap);
			}
			if(!Util.isEmpty(wechatList)){
				Map<String,List<String>> wechatMap = new HashMap<String, List<String>>();
				List<String> channelSuccessList = new ArrayList<String>();
				List<String> channelErrorList = new ArrayList<String>();
				for(WechatSendStatus wechatSendStatus:wechatList){					
					String channelName = wechatSendStatus.getChannelName();
					Integer sendStatus = wechatSendStatus.getSendStatus();
					if(sendStatus==1){
						channelSuccessList.add(channelName);
						success += 1;
					}else if(sendStatus==2){
						channelErrorList.add(channelName);
						error += 1;
					}
				}
				wechatMap.put("success",channelSuccessList);
				wechatMap.put("error",channelErrorList);
				map.put("Wechat", wechatMap);
			}
			if(!Util.isEmpty(mobileList)){
				Map<String,List<String>> mobileMap = new HashMap<String, List<String>>();
				List<String> channelSuccessList = new ArrayList<String>();
				List<String> channelErrorList = new ArrayList<String>();
				for(MobileSendStatus mobileSendStatus:mobileList){					
					String channelName = mobileSendStatus.getChannelName();
					Integer sendStatus = mobileSendStatus.getSendStatus();
					if(sendStatus==1){
						channelSuccessList.add(channelName);
						success += 1;
					}else if(sendStatus==2){
						channelErrorList.add(channelName);
						error += 1;
					}
				}
				mobileMap.put("success",channelSuccessList);
				mobileMap.put("error",channelErrorList);
				map.put("Mobile", mobileMap);
			}
			map.put("success", success);
			map.put("error", error);
		} catch (Exception e) {
			log.error("获取信息详情错误信息情况异常"+e);
			String error = "{code:40000,msg:\"获得信息详情错误信息情况异常\",data:null}";
			return JSONObject.fromObject(error);
		}
		return JSONObject.fromObject(map);
	}
}
