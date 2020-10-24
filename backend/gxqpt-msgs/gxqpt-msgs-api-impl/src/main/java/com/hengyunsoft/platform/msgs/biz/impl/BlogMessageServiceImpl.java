package com.hengyunsoft.platform.msgs.biz.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.biz.BlogMessageService;
import com.hengyunsoft.platform.msgs.constant.MessageConstant;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogMessageCursor;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BlogSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogMessageCursorService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsBlacklistService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;
import com.hengyunsoft.platform.msgs.utils.HttpClientEx;
import com.hengyunsoft.platform.msgs.utils.JSONUtils;
import com.hengyunsoft.platform.msgs.utils.Util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
/**
 * 微博服务实现类
 * @author dxz
 */
@Slf4j
@Component
public class BlogMessageServiceImpl implements BlogMessageService{
	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
    private MsgsChannelService msgsChannelService;
	@Autowired
    private BlogSendStatusService blogSendStatusService;
	@Autowired
    private BlogMessageRecordService blogMessageRecordService;
	@Autowired
    private BlogMessageCursorService blogMessageCursorService;
	@Autowired
    private MsgsMessageService msgsMessageService;
	@Autowired
	private MsgsBlacklistService msgsBlacklistService;
	/**
	 * 保存微博记录
	 */
	@Override
	public String saveBlogMessage(String msg) {
		MessageDTO messageDTO = JSONUtils.parseObject(msg, MessageDTO.class);
		BlogMessageRecord blogMessageRecord = dozerUtils.map(messageDTO, BlogMessageRecord.class);
		BlogMessageCursor blogMessageCursor = dozerUtils.map(messageDTO, BlogMessageCursor.class);
		Long id = Util.random();
		String channelId = blogMessageRecord.getChannelId();
		//保存发送状态
	    BlogSendStatus blogSendStatus = new BlogSendStatus();
        blogSendStatus.setId(id);
        blogSendStatus.setMsgId(blogMessageCursor.getMsgId());
        blogSendStatus.setCreateTime(new Date());
	    blogSendStatus.setSendStatus(2);
		//验证黑名单
		String appId = messageDTO.getAppId();
		MsgsBlacklistExample msgsBlacklistExample = new MsgsBlacklistExample();
		msgsBlacklistExample.createCriteria().andAppIdEqualTo(appId).andChannelIdEqualTo(Long.valueOf(channelId));		
		List<MsgsBlacklist> list = msgsBlacklistService.find(msgsBlacklistExample);
		if(!Util.isEmpty(list)){
			blogSendStatus.setResult("您已被加入黑名单，请联系账号管理员");
			blogSendStatusService.save(blogSendStatus);
			return "blacklist";
		}	
		try { 			  
			  if(StringUtils.isEmpty(channelId)||StringUtils.isEmpty(blogMessageRecord.getImgText())){
				  blogSendStatus.setResult("信息参数错误");
				  blogSendStatusService.save(blogSendStatus);
				  return "dataError";
			  }
			  MsgsChannel msgsChannel = msgsChannelService.getById(Long.valueOf(channelId));
			  if(msgsChannel==null){
				  blogSendStatus.setResult("渠道错误");
				  blogSendStatusService.save(blogSendStatus);
				  return "dataError";
			  }
			  blogSendStatus.setChannelId(channelId);
			  blogSendStatus.setChannelName(msgsChannel.getName());
			  blogMessageRecord.setCreateTime(new Date());
			  if(messageDTO.getDraft()==0){
				  Boolean containURL = Util.containURL(messageDTO.getImgText());
				  if(!containURL){
					  blogSendStatus.setResult("信息内容错误");
					  blogSendStatusService.save(blogSendStatus);
					  return "contextError";
				  }
				  //正常发送
				  blogMessageRecord.setId(id);
				  blogMessageCursor.setId(id);
				  BlogMessageCursor insertResult = blogMessageCursorService.save(blogMessageCursor);
				  if(insertResult == null){
					  blogSendStatus.setResult("发送失败，请稍后重试");
					  blogSendStatusService.save(blogSendStatus);
					  return "sendError";
				  }				  				  
				  if(!Util.isEmptyString(blogMessageRecord.getStartTime())){
					  blogMessageRecord.setDraft(1);
				  }
				  BlogMessageRecord insertResult1 = blogMessageRecordService.save(blogMessageRecord);
				  if(insertResult1 == null){
					  blogSendStatus.setResult("保存微博记录失败");
					  blogSendStatusService.save(blogSendStatus);
					  return "saveError";
				  }
			  }else if(messageDTO.getDraft()==2){
				  Boolean containURL = Util.containURL(messageDTO.getImgText());
				  if(!containURL){
					  blogSendStatus.setResult("信息内容错误");
					  blogSendStatusService.save(blogSendStatus);
					  return "contextError";
				  }
				  //草稿编辑发送
				  blogMessageRecord.setDraft(0);
				  Long recordId = blogMessageRecordService.getIdByMsgId(blogMessageRecord.getMsgId());
				  if(recordId==null||recordId==0){
					  blogSendStatus.setResult("草稿不存在");
					  blogSendStatusService.save(blogSendStatus);
					  return "draftError";
				  }
				  blogMessageRecordService.updateByMsgId(blogMessageRecord);
				  blogMessageCursor.setId(recordId);
				  BlogMessageCursor insertResult = blogMessageCursorService.save(blogMessageCursor);
				  if(insertResult == null){
					  blogSendStatus.setResult("草稿发送失败");
					  blogSendStatusService.save(blogSendStatus);
					  return "sendError";
				  }
			  }else if(messageDTO.getDraft()==1){
				  //存草稿
				  blogMessageRecord.setId(id);
				  BlogMessageRecord insertResult = blogMessageRecordService.save(blogMessageRecord);
				  if(insertResult == null){
					  blogSendStatus.setResult("保存草稿失败");
					  blogSendStatusService.save(blogSendStatus);
					  return "saveDraftError";
				  }
			  }	
		} catch (Exception e) {
			 log.error("保存微博记录失败:"+e);
			 e.printStackTrace();
			 blogSendStatus.setResult("发送微博异常");
			 blogSendStatusService.save(blogSendStatus);
			 return "exception";
		}			
		return "success";
	}

	/**
	 * 发布信息到微博
	 */
	@Override
	public String sendToBlog() {
		List<BlogMessageCursor> recordList = blogMessageCursorService.getAll();
		if(Util.isEmpty(recordList)){
			 return null;
		}
		for(BlogMessageCursor blogMessageCursor:recordList){
			//定时任务判断
			String date = blogMessageCursor.getStartTime();
			if(!Util.isEmptyString(date)){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date date0 = df.parse(date);
					long time = date0.getTime();
					long now = System.currentTimeMillis();
					if(now<time){
						continue;
					}
					//回写定时发送状态为 ‘发送’
					if(!Util.isEmptyString(blogMessageCursor.getMsgId())){
						MsgsMessage msgsMessage = new MsgsMessage();
						msgsMessage.setId(Long.valueOf(blogMessageCursor.getMsgId()));
						msgsMessage.setSendJobTime(new Date());
						msgsMessage.setMsgStatus(0L);
						msgsMessageService.updateByIdSelective(msgsMessage);
					}
					 //修改定时发送状态为“发送”
					 BlogMessageRecord blogMessageRecord = new BlogMessageRecord();
					 blogMessageRecord.setDraft(0);
					 blogMessageRecord.setId(blogMessageCursor.getId());
					 blogMessageRecordService.updateByIdSelective(blogMessageRecord);					
				} catch (ParseException e) {
					e.printStackTrace();
			    	BlogSendStatus blogSendStatus = new BlogSendStatus();
			    	blogSendStatus.setId(Util.random());
			    	blogSendStatus.setMsgId(blogMessageCursor.getMsgId());
			    	blogSendStatus.setCreateTime(new Date());
					blogSendStatus.setSendStatus(2);
					blogSendStatus.setResult("发送时间格式错误");
					blogSendStatusService.save(blogSendStatus);
					blogMessageCursorService.deleteById(blogMessageCursor.getId());
					continue;
				}
			}
			//发送消息
			String context = blogMessageCursor.getImgText();
			String filePath = blogMessageCursor.getFileUrl();
			String channelId = blogMessageCursor.getChannelId();
	    	List<String> channels = Arrays.asList(channelId.split(","));
	    	for(String channel:channels){
		    	BlogSendStatus blogSendStatus = new BlogSendStatus();
		    	blogSendStatus.setId(Util.random());
		    	blogSendStatus.setMsgId(blogMessageCursor.getMsgId());
		    	blogSendStatus.setChannelId(channel);		    	
		    	blogSendStatus.setCreateTime(new Date());
			    MsgsChannel msgsChannel = msgsChannelService.getById(Long.parseLong(channel));
			    if(msgsChannel==null){
			    	blogSendStatus.setChannelName("");
			    	blogSendStatus.setSendStatus(2);
					blogSendStatus.setResult("请求微博异常");
					blogSendStatusService.save(blogSendStatus);
					blogMessageCursorService.deleteById(blogMessageCursor.getId());
			    	return "channelIsNull";
			    }
			    blogSendStatus.setChannelName(msgsChannel.getName());
		    	String accessToken = msgsChannel.getAccessToken();
		    	String url = MessageConstant.sendToBlog;
		    	Map<String,String> param = new HashMap<String, String>();
		    	Map<String,String> fileParam = new HashMap<String, String>();
		    	if(Util.isEmptyString(filePath)){
		    		param.put("access_token", accessToken);
		    		param.put("status", context);
		    	}else{
		    		param.put("access_token", accessToken);
		    		param.put("status", context);
		    		fileParam.put("pic", filePath);
		    	}
		    	try {
		    		//发送到微博
					String result = "";
					if(StringUtils.isEmpty(filePath)){
						result = HttpClientEx.doPost(url,param);
					}else{
						result = HttpClientEx.formUpload(url,param,fileParam);
					}						
					if(Util.isEmptyString(result)){
						blogSendStatus.setSendStatus(2);
						blogSendStatus.setResult("请求微博异常");
						blogSendStatusService.save(blogSendStatus);
						blogMessageCursorService.deleteById(blogMessageCursor.getId());
						return "sendError";
					}
					JSONObject json = JSONObject.fromObject(result);
					Long sendid = (Long) json.get("id");
					if(sendid!=null){
						blogSendStatus.setSendStatus(1);
						blogSendStatus.setResult("发布信息成功");
						blogSendStatusService.save(blogSendStatus);
						blogMessageCursorService.deleteById(blogMessageCursor.getId());
					}else{
						blogSendStatus.setSendStatus(2);
						blogSendStatus.setResult((String)json.get("error"));
						blogSendStatusService.save(blogSendStatus);
						blogMessageCursorService.deleteById(blogMessageCursor.getId());
					}
				} catch (Exception e) {
					blogSendStatus.setSendStatus(2);
					blogSendStatus.setResult("发布信息异常");
					blogSendStatusService.save(blogSendStatus);
					blogMessageCursorService.deleteById(blogMessageCursor.getId());
					log.error("发布微博信息异常"+e);
				}finally {
					blogMessageCursorService.deleteById(blogMessageCursor.getId());
				}
	    	}	    	
		}
		return "success";
	}
}
