package com.hengyunsoft.platform.msgs.biz.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.biz.MobileMessageService;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageCursor;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageRecord;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageCursorService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsBlacklistService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;
import com.hengyunsoft.platform.msgs.utils.JSONUtils;
import com.hengyunsoft.platform.msgs.utils.Util;

import lombok.extern.slf4j.Slf4j;
/**
 * 移动终端消息服务实现类
 * @author dxz
 */
@Slf4j
@Component
public class MobileMessageServiceImpl implements MobileMessageService{

	 @Autowired
     private DozerUtils dozerUtils;
	 @Autowired
	 private MobileSendStatusService mobileSendStatusService;
	 @Autowired
	 private MobileMessageCursorService mobileMessageCursorService;
	 @Autowired
     private MsgsMessageService msgsMessageService;
	 @Autowired
     private MobileMessageRecordService mobileMessageRecordService;
	 @Autowired
     private MsgsChannelService msgsChannelService;
	 @Autowired
	 private MsgsBlacklistService msgsBlacklistService;
	/**
	 * 保存移动终端消息
	 */
	@Override
	
	public String saveMobileMessage(String msg) {
		 MessageDTO messageDTO = JSONUtils.parseObject(msg, MessageDTO.class);
		 String channelId = messageDTO.getChannelId();
		 if(Util.isEmptyString(channelId)){
			 return "channelError";
		 }
		 MsgsChannel msgsChannel = msgsChannelService.getById(Long.valueOf(channelId));
		 if(msgsChannel==null){
			 return "channelError";
		 }
		 try {
			 MobileSendStatus mobileSendStatus = new MobileSendStatus();
			 mobileSendStatus.setId(Util.random());
			 mobileSendStatus.setMsgId(messageDTO.getMsgId());
			 mobileSendStatus.setCreateTime(new Date());
			 mobileSendStatus.setChannelId(channelId);
			 mobileSendStatus.setChannelName(msgsChannel.getName());
			 //验证黑名单
			 String appId = messageDTO.getAppId();
			 MsgsBlacklistExample msgsBlacklistExample = new MsgsBlacklistExample();
			 msgsBlacklistExample.createCriteria().andAppIdEqualTo(appId).andChannelIdEqualTo(Long.valueOf(channelId));		
			 List<MsgsBlacklist> list = msgsBlacklistService.find(msgsBlacklistExample);
			 if(!Util.isEmpty(list)){
				 mobileSendStatus.setResult("您已被加入黑名单，请联系账号管理员");
				 mobileSendStatus.setSendStatus(2);
				 mobileSendStatusService.save(mobileSendStatus);
				 return "blacklist";
			 }
			 //定时发送保存			 
			 String startTime = messageDTO.getStartTime();
			 if(!Util.isEmptyString(startTime)){
				 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 try {
					 Date date = df.parse(startTime);
					 long time = date.getTime();
					 long now = System.currentTimeMillis();
					 if(now<time){
						 MobileMessageCursor mobileMessageCursor = dozerUtils.map(messageDTO, MobileMessageCursor.class);
						 mobileMessageCursorService.save(mobileMessageCursor);
						 return null;
					 }
				 } catch (Exception e) {
					 log.error("时间格式不正确"+e);
					 mobileSendStatus.setSendStatus(2);
					 mobileSendStatus.setResult("时间格式不正确");
					 mobileSendStatusService.save(mobileSendStatus);
					 return "exception";
				 }				 
			 }
			 //开始发送
			 MobileMessageRecord mobileMessageRecord = dozerUtils.map(messageDTO, MobileMessageRecord.class);
			 mobileMessageRecord.setCreateTime(new Date());
			 mobileMessageRecord.setDraft(0);
			 mobileMessageRecordService.save(mobileMessageRecord);
			 //保存发送状态
			 mobileSendStatus.setSendStatus(1);
			 mobileSendStatus.setResult("发送成功");
			 mobileSendStatusService.save(mobileSendStatus);
			 return null;
		 } catch (Exception e) {
				log.error("保存移动终端消息出错"+e);
				MobileSendStatus mobileSendStatus = new MobileSendStatus();
				mobileSendStatus.setId(Util.random());
				mobileSendStatus.setMsgId(messageDTO.getMsgId());
				mobileSendStatus.setCreateTime(new Date());
				mobileSendStatus.setChannelId(channelId);
				mobileSendStatus.setChannelName(msgsChannel.getName());
				mobileSendStatus.setSendStatus(2);
				mobileSendStatus.setResult("移动终端发送消息出错");
				mobileSendStatusService.save(mobileSendStatus);
				return "exception";
		 }		
	}
	/**
	 * 定时发送
	 * @return
	 */
	@Override
	public String updateMobileMessage() {
		List<MobileMessageCursor> list = mobileMessageCursorService.getAll();
		try {
			if(!Util.isEmpty(list)){
				MobileSendStatus mobileSendStatus = new MobileSendStatus();
				mobileSendStatus.setId(Util.random());				
				mobileSendStatus.setCreateTime(new Date());
				mobileSendStatus.setChannelName("移动终端");
				mobileSendStatus.setSendStatus(1);
				mobileSendStatus.setResult("发送成功");
				Set<Long> ids = new HashSet<Long>();
				List<MobileSendStatus> statusList = new ArrayList<MobileSendStatus>();
				List<MobileMessageRecord> recordList = new ArrayList<MobileMessageRecord>();
				for(MobileMessageCursor mobileMessageCursor:list){					
					 //开始发送
					 MobileMessageRecord mobileMessageRecord = dozerUtils.map(mobileMessageCursor, MobileMessageRecord.class);
					 mobileMessageRecord.setCreateTime(new Date());
					 recordList.add(mobileMessageRecord);
					 ids.add(mobileMessageCursor.getId());
					 //记录发送状态
					 mobileSendStatus.setMsgId(mobileMessageCursor.getMsgId());
					 mobileSendStatus.setChannelId(mobileMessageCursor.getChannelId());
					 statusList.add(mobileSendStatus);
					 //回写定时发送状态为 ‘发送’
					 if(!Util.isEmptyString(mobileMessageCursor.getMsgId())){
						  MsgsMessage msgsMessage = new MsgsMessage();
						  msgsMessage.setId(Long.valueOf(mobileMessageCursor.getMsgId()));
						  msgsMessage.setMsgStatus(0L);
						  msgsMessageService.updateByIdSelective(msgsMessage);
					 }
				}
				//保存记录
				mobileMessageRecordService.save(recordList);
				//删除已发送信息
				mobileMessageCursorService.deleteByIds(ids);
				//保存发送状态
				mobileSendStatusService.save(statusList);
			}
			return null;
		} catch (Exception e) {
			log.error("定时发送出错"+e);
			if(!Util.isEmpty(list)){
				MobileSendStatus mobileSendStatus = new MobileSendStatus();
				mobileSendStatus.setId(Util.random());				
				mobileSendStatus.setCreateTime(new Date());
				mobileSendStatus.setChannelName("移动终端");
				mobileSendStatus.setSendStatus(2);
				mobileSendStatus.setResult("发送失败");
				Set<Long> ids = new HashSet<Long>();
				List<MobileSendStatus> statusList = new ArrayList<MobileSendStatus>();
				for(MobileMessageCursor mobileMessageCursor:list){
					 ids.add(mobileMessageCursor.getId());
					 //记录发送状态
					 mobileSendStatus.setMsgId(mobileMessageCursor.getMsgId());
					 mobileSendStatus.setChannelId(mobileMessageCursor.getChannelId());
					 statusList.add(mobileSendStatus);
				}
				//删除已发送信息
				mobileMessageCursorService.deleteByIds(ids);
				//保存发送状态
				mobileSendStatusService.save(statusList);
			}
			return "exception";
		}
	}
}
