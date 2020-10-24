package com.hengyunsoft.platform.msgs.biz.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.biz.SmsMessageService;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsSmsBlacklist;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageCursor;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsSendStatus;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.SmsTemplate;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.dao.SmsMessageRecordMapper;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsSmsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsSmsBlacklistService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsMessageCursorService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsSendStatusService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.SmsTemplatesService;
import com.hengyunsoft.platform.msgs.utils.JSONUtils;
import com.hengyunsoft.platform.msgs.utils.SMSSendUtil;
import com.hengyunsoft.platform.msgs.utils.SmsResult;
import com.hengyunsoft.platform.msgs.utils.Util;

import lombok.extern.slf4j.Slf4j;
/**
 * 短信服务实现类
 * @author dxz
 */
@Slf4j
@Component
public class SmsMessageServiceImpl implements SmsMessageService{

	@Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private SmsMessageRecordMapper smsMessageRecordMapper;
    @Autowired
    private SmsTemplatesService smsTemplatesService;
    @Autowired
    private SmsMessageCursorService smsMessageCursorService;
    @Autowired
    private SmsSendStatusService smsSendStatusService;
	@Autowired
    private MsgsChannelService msgsChannelService;
	@Autowired
    private MsgsSmsBlacklistService msgsSmsBlacklistService;
	@Autowired
	private ApplicationApi applicationApi;
	/**
	 * 将短信发送到接收人
	 */
	@Override
	public String sendToSMS() {
		 //从数据库查询所有待发送短信信息
		 List<SmsMessageCursor> smsMsgRecordList = smsMessageCursorService.getAll();
		 if(Util.isEmpty(smsMsgRecordList)){
			 return null;
		 }

		 for(SmsMessageCursor smsMessageCursor:smsMsgRecordList){
			 //定时任务判断
			 String date = smsMessageCursor.getStartTime();
			 if(!Util.isEmptyString(date)){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					 Date date0 = df.parse(date);
					 long time = date0.getTime();
					 long now = System.currentTimeMillis();
					 if(now<time){
						 continue;
					 }
					 //修改定时发送状态为“发送”
					 SmsMessageRecord smsMessageRecord = new SmsMessageRecord();
					 smsMessageRecord.setDraft(0);
					 smsMessageRecord.setId(smsMessageCursor.getId());
					 smsMessageRecordMapper.updateByPrimaryKeySelective(smsMessageRecord);
				 } catch (ParseException e) {
					 e.printStackTrace();
					 SmsSendStatus smsSendStatus = new SmsSendStatus();
					 smsSendStatus.setId(Util.random());
					 smsSendStatus.setSender(smsMessageCursor.getSender());
					 smsSendStatus.setMsgId(smsMessageCursor.getMsgId());
					 smsSendStatus.setAppId(smsMessageCursor.getAppId());
					 smsSendStatus.setCreateTime(new Date());
					 smsSendStatus.setSendStatus(2);
					 smsSendStatus.setResult("发送时间格式不正确");
					 smsSendStatusService.save(smsSendStatus);
					 smsMessageCursorService.deleteById(smsMessageCursor.getId());
					 continue;
				 }
			 }
			 //开始发送
			 String channelid = smsMessageCursor.getChannelId();
			 List<String> channels = Arrays.asList(channelid.split(","));
			 for(String channel:channels){
				 //根据渠道id获得渠道信息
				 SmsSendStatus smsSendStatus = new SmsSendStatus();
				 smsSendStatus.setSender(smsMessageCursor.getSender());
				 smsSendStatus.setMsgId(smsMessageCursor.getMsgId());
				 smsSendStatus.setAppId(smsMessageCursor.getAppId());
				 smsSendStatus.setCreateTime(new Date());
				 MsgsChannel msgsChannel = msgsChannelService.getById(Long.parseLong(channel));
				 if(msgsChannel==null){
					 //状态改为发送失败
					 smsSendStatus.setId(Util.random());
					 smsSendStatus.setSendStatus(2);
					 smsSendStatus.setResult("您所选的渠道不存在，或已经停用，请重新选择渠道");
					 smsSendStatusService.save(smsSendStatus);
					 smsMessageCursorService.deleteById(smsMessageCursor.getId());
					 continue;
				 }
				 String channelServer = msgsChannel.getChannelServer();
				 String mobiles = smsMessageCursor.getReceiver();
				 try {
					//模板校验
					String appId = msgsChannel.getAppId();
					String appSecret = msgsChannel.getAppSecret();
					Long templeteId = smsMessageCursor.getTemplateId();
					if(templeteId==null||templeteId==0){
						smsSendStatus.setId(Util.random());
						smsSendStatus.setSendStatus(2);
						smsSendStatus.setResult("您所选的模板编码不存在");
						smsSendStatusService.save(smsSendStatus);
						smsMessageCursorService.deleteById(smsMessageCursor.getId());
						continue;
					}
					SmsTemplate smsTemplate = smsTemplatesService.getById(templeteId);
					if(smsTemplate==null){
						smsSendStatus.setId(Util.random());
						smsSendStatus.setSendStatus(2);
						smsSendStatus.setResult("您所选的模板不存在或已经失效，请重新选择模板");
						smsSendStatusService.save(smsSendStatus);
						smsMessageCursorService.deleteById(smsMessageCursor.getId());
						continue;
					}
					String signName = smsTemplate.getSignName();
					String templateCode = smsTemplate.getTemplateCode();
					String templateParam = smsMessageCursor.getTemplateParams();
					//阿里云短信
					if("Alibaba".equals(channelServer)){
						List<String> mlist = Arrays.asList(mobiles.split(","));
						for(String mobile:mlist){
							if(mobile.indexOf("<")>=0){
								mobile = mobile.substring(mobile.indexOf("<")+1, mobile.indexOf(">"));
							}
							SendSmsResponse sendSmsResponse = SMSSendUtil.sendAliYunSms(mobile, appId, appSecret, signName, templateCode, templateParam);
							if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")){
								smsSendStatus.setId(Util.random());
								smsSendStatus.setSendStatus(1);
								smsSendStatus.setReceiver(mobile);
								smsSendStatus.setResult("发送成功");
								smsSendStatusService.save(smsSendStatus);
								smsMessageCursorService.deleteById(smsMessageCursor.getId());
								Long existing = msgsChannel.getExisting();
								Long used = msgsChannel.getUsed();
								if(existing==null){
									existing = -1L;
								}else{
									existing -= 1;
								}
								if(used==null){
									used = 1L;
								}else{
									used += 1;
								}
								msgsChannel.setExisting(existing);
								msgsChannel.setUsed(used);
								msgsChannelService.updateById(msgsChannel);
							}else{
								smsSendStatus.setId(Util.random());
								smsSendStatus.setSendStatus(2);
								smsSendStatus.setReceiver(mobile);
								smsSendStatus.setResult(sendSmsResponse.getMessage());
								smsSendStatusService.save(smsSendStatus);
								smsMessageCursorService.deleteById(smsMessageCursor.getId());
							}
						}
					//百度云短信
					}else if("Baidu".equals(channelServer)){
						List<String> mlist = Arrays.asList(mobiles.split(","));
						for(String mobile:mlist){
							if(mobile.indexOf("<")>=0){
								mobile = mobile.substring(mobile.indexOf("<")+1, mobile.indexOf(">"));
							}
							SmsResult smsResult = SMSSendUtil.sendBaiduSms(mobile, appId, appSecret, templateCode, signName, templateParam);
							if(SmsResult.SUCCESS_BAIDU.equals(smsResult.getCode())){
								smsSendStatus.setId(Util.random());
								smsSendStatus.setSendStatus(1);
								smsSendStatus.setReceiver(mobile);
								smsSendStatus.setResult("发送成功");
								smsSendStatusService.save(smsSendStatus);
								smsMessageCursorService.deleteById(smsMessageCursor.getId());
								Long existing = msgsChannel.getExisting();
								Long used = msgsChannel.getUsed();
								if(existing==null){
									existing = -1L;
								}else{
									existing -= 1;
								}
								if(used==null){
									used = 1L;
								}else{
									used += 1;
								}
								msgsChannel.setExisting(existing);
								msgsChannel.setUsed(used);
								msgsChannelService.updateById(msgsChannel);
							}else{
								smsSendStatus.setId(Util.random());
								smsSendStatus.setSendStatus(2);
								smsSendStatus.setReceiver(mobile);
								smsSendStatus.setResult(smsResult.getMessage());
								smsSendStatusService.save(smsSendStatus);
								smsMessageCursorService.deleteById(smsMessageCursor.getId());
							}
						}
					//腾讯云短信
					}else if("Tencent".equals(channelServer)){
						List<String> mlist = Arrays.asList(mobiles.split(","));
						for(String mobile:mlist){
							if(mobile.indexOf("<")>=0){
								mobile = mobile.substring(mobile.indexOf("<")+1, mobile.indexOf(">"));
							}
							SmsResult smsResult = SMSSendUtil.sendTencentSms(mobile, appId, appSecret, templateCode, signName, templateParam);
							if(SmsResult.SUCCESS_TENCENT.equals(smsResult.getCode())){
								smsSendStatus.setId(Util.random());
								smsSendStatus.setSendStatus(1);
								smsSendStatus.setReceiver(mobile);
								smsSendStatus.setResult("发送成功");
								smsSendStatusService.save(smsSendStatus);
								smsMessageCursorService.deleteById(smsMessageCursor.getId());
								Long existing = msgsChannel.getExisting();
								Long used = msgsChannel.getUsed();
								if(existing==null){
									existing = -1L;
								}else{
									existing -= 1;
								}
								if(used==null){
									used = 1L;
								}else{
									used += 1;
								}
								msgsChannel.setExisting(existing);
								msgsChannel.setUsed(used);
								msgsChannelService.updateById(msgsChannel);
							}else{
								smsSendStatus.setId(Util.random());
								smsSendStatus.setSendStatus(2);
								smsSendStatus.setReceiver(mobile);
								smsSendStatus.setResult(smsResult.getMessage());
								smsSendStatusService.save(smsSendStatus);
								smsMessageCursorService.deleteById(smsMessageCursor.getId());
							}
						}
					}
				 } catch (ClientException e) {
					smsSendStatus.setId(Util.random());
					smsSendStatus.setSendStatus(2);
					smsSendStatus.setResult("短信发送异常");
					smsSendStatusService.save(smsSendStatus);
					smsMessageCursorService.deleteById(smsMessageCursor.getId());
					log.error("发送短信失败："+e);
					return "aliSendException";
				}catch (Exception e) {
					smsSendStatus.setId(Util.random());
					smsSendStatus.setSendStatus(2);
					smsSendStatus.setResult("短信发送异常");
					smsSendStatusService.save(smsSendStatus);
					smsMessageCursorService.deleteById(smsMessageCursor.getId());
					log.error("发送短信失败："+e);
					return "exception";
				}
			 }
		 }
		 return "success";
	}
	/**
	 * 将短信信息保存到数据库
	 */
	@Override
	public String saveMsg(String msg) {
		MessageDTO messageDTO = JSONUtils.parseObject(msg, MessageDTO.class);
		Long moduleId = messageDTO.getModuleId();
		String moduleName = messageDTO.getModuleName();
		//判断是否是模块
		if (StringUtils.isEmpty(messageDTO.getSourceType())){
			AtomicReference<String> sourceTyp = new AtomicReference<>("");
			if (moduleId != null && !StringUtils.isEmpty(moduleName)){
				sourceTyp.set("MODULAR");//模块
			}else {//判断是服务还是应用
				messageDTO.setModuleId(null);
				Result<List<ApplicationAllDTO>> appListResult = applicationApi.findAllList();
				if (appListResult != null && appListResult.getData() != null){
					appListResult.getData().forEach(val->{
						if (val.getAppId().equals(messageDTO.getAppId())){
							if ("1".equals(val.getAppType())){
								sourceTyp.set("APP");//应用
							}else if ("2".equals(val.getAppType())){
								sourceTyp.set("SERVICE");//服务
							}else if ("3".equals(val.getAppType())){
								sourceTyp.set("APP,SERVICE");//应用,服务
							}else {
								sourceTyp.set("APP");
							}
						}
					});
				}
			}
			if (StringUtils.isEmpty(sourceTyp.get())){
				return "appId不存在";
			}
			messageDTO.setSourceType(sourceTyp.get());
		}

		//解析信息内容
		/*String templateParams = messageDTO.getTemplateParams();
		String templateId = messageDTO.getTemplateId();*/

		SmsMessageRecord smsMessageRecord = dozerUtils.map(messageDTO, SmsMessageRecord.class);
		smsMessageRecord.setDeleteIs(false);//未删除标识
		SmsMessageCursor smsMessageCursor = dozerUtils.map(messageDTO, SmsMessageCursor.class);
		Long id = Util.random();
		//保存发送状态
		SmsSendStatus smsSendStatus = new SmsSendStatus();
		smsSendStatus.setId(id);
		smsSendStatus.setSender(smsMessageCursor.getSender());
		smsSendStatus.setMsgId(smsMessageCursor.getMsgId());
		smsSendStatus.setAppId(smsMessageCursor.getAppId());
		smsSendStatus.setCreateTime(new Date());
		smsSendStatus.setSendStatus(2);
		//验证黑名单
		String channelId = smsMessageRecord.getChannelId();
		MsgsChannel msgsChannel = msgsChannelService.getById(Long.valueOf(channelId));
		Long createUser = msgsChannel.getCreateUser();
		MsgsSmsBlacklistExample smsBlacklistExample = new MsgsSmsBlacklistExample();
		smsBlacklistExample.createCriteria().andAppIdEqualTo(messageDTO.getAppId())
						   .andGxqptEmpIdEqualTo(Long.valueOf(messageDTO.getSender()))
						   .andCreateUserEqualTo(createUser);
		List<MsgsSmsBlacklist> list = msgsSmsBlacklistService.find(smsBlacklistExample);
		if(!Util.isEmpty(list)){
			smsSendStatus.setResult("您已被加入黑名单，无法再发送短信");
			smsSendStatusService.save(smsSendStatus);
			return "blacklist";
		}
		try {
			  if(Util.isEmptyString(smsMessageRecord.getReceiver())||Util.isEmptyString(channelId)){
				  smsSendStatus.setResult("发送短信参数不正确");
				  smsSendStatusService.save(smsSendStatus);
				  return "dataError";
			  }
			  String param = messageDTO.getTemplateParams();
			  String context = messageDTO.getContext();
			  String reciver = messageDTO.getReceiver();
			  if((context!=null&&context.length()>450)||(param!=null&&param.length()>450)){
				  smsSendStatus.setResult("短信字数超限");
				  smsSendStatusService.save(smsSendStatus);
				  return "dataTooLong";
			  }
			  if(reciver!=null&&reciver.length()>3000){
				  smsSendStatus.setResult("接收者数量超限");
				  smsSendStatusService.save(smsSendStatus);
				  return "reciverTooLong";
			  }
			  smsMessageRecord.setCreateTime(new Date());
			  if(messageDTO.getDraft()==0){
				  //正常发送
				  smsMessageRecord.setId(id);
				  if(Util.isEmptyString(smsMessageRecord.getStartTime())){
					  smsMessageRecord.setSendTime(new Date());
				  }else{
					  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					  Date date = df.parse(smsMessageRecord.getStartTime());
					  smsMessageRecord.setSendTime(date);
				  }
				  smsMessageCursor.setId(id);
				  SmsMessageCursor insertResult = smsMessageCursorService.save(smsMessageCursor);
				  if(insertResult == null){
					  smsSendStatus.setResult("发送失败，请稍后重试");
					  smsSendStatusService.save(smsSendStatus);
					  return "sendError";
				  }
				  if(!Util.isEmptyString(smsMessageRecord.getStartTime())){
					  smsMessageRecord.setDraft(1);
				  }
				  int insertResult1 = smsMessageRecordMapper.insert(smsMessageRecord);
				  if(insertResult1<=0){
					  smsSendStatus.setResult("保存短信记录失败");
					  smsSendStatusService.save(smsSendStatus);
					  return "saveError";
				  }
			  }else if(messageDTO.getDraft()==2){
				  //草稿编辑发送
				  smsMessageRecord.setDraft(0);
				  if(Util.isEmptyString(smsMessageRecord.getStartTime())){
					  smsMessageRecord.setSendTime(new Date());
				  }else{
					  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					  Date date = df.parse(smsMessageRecord.getStartTime());
					  smsMessageRecord.setSendTime(date);
				  }
				  Long recordId = smsMessageRecordMapper.getIdByMsgId(smsMessageRecord.getMsgId());
				  if(recordId==null||recordId==0){
					  smsSendStatus.setResult("草稿不存在");
					  smsSendStatusService.save(smsSendStatus);
					  return "draftError";
				  }
				  smsMessageRecordMapper.updateByMsgId(smsMessageRecord);
                  int result = 0;
                  if(smsMessageCursor.getStartTime()!=null && !"".equals(smsMessageCursor.getStartTime())) {
                      smsMessageCursor.setId(recordId);
                      //之前的save 方法是错误的，会重新生成id，导致定时发送是查询记录无复匹配
                      result = smsMessageCursorService.saveHavedId(smsMessageCursor);
                  }
				  if(result == 0){
					  smsSendStatus.setResult("草稿发送失败");
					  smsSendStatusService.save(smsSendStatus);
					  return "sendError";
				  }
			  }else if(messageDTO.getDraft()==1){
				  //存草稿
				  int insertResult = 0;
				  SmsMessageRecord record = smsMessageRecordMapper.getByMsgId(smsMessageRecord.getMsgId());
				  if(record!=null){
					  smsMessageRecordMapper.updateByMsgId(smsMessageRecord);
					  insertResult = 1;
				  }else{
					  smsMessageRecord.setId(id);
					  insertResult = smsMessageRecordMapper.insert(smsMessageRecord);
				  }
				  //保存到定时发送表
                  if(smsMessageCursor.getStartTime()!=null && !"".equals(smsMessageCursor.getStartTime())){
                      smsMessageCursor.setId(smsMessageRecord.getId());
                      smsMessageCursorService.saveHavedId(smsMessageCursor);
                  }
				  if(insertResult<=0){
					  smsSendStatus.setResult("保存草稿失败");
					  smsSendStatusService.save(smsSendStatus);
					  return "saveDraftError";
				  }
			  }
		} catch(DataIntegrityViolationException e){
			 log.error("短信字数超限："+e);
			 smsSendStatus.setResult("短信字数超限");
			 smsSendStatusService.save(smsSendStatus);
			 return "dataTooLong";
		}catch (Exception e) {
			 log.error("保存短信记录失败:"+e);
			 smsSendStatus.setResult("发送短信异常");
			 smsSendStatusService.save(smsSendStatus);
			 return "exception";
		}
		return "success";
	}
}
