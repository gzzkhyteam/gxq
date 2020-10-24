package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.msgs.biz.BlogMessageService;
import com.hengyunsoft.platform.msgs.biz.MobileMessageService;
import com.hengyunsoft.platform.msgs.biz.SmsMessageService;
import com.hengyunsoft.platform.msgs.biz.WeChatMessageService;
import com.hengyunsoft.platform.msgs.constant.MessageConstant;
import com.hengyunsoft.platform.msgs.constant.MsgConstant;
import com.hengyunsoft.platform.msgs.dto.ChannelMsgDTO;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.utils.HttpClientEx;
import com.hengyunsoft.platform.msgs.utils.RedisUtils;
import com.hengyunsoft.platform.msgs.utils.TockenResult;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MsgsSendActuator {
	@Autowired
	private BlogMessageService blogMessageService;
	@Autowired
	private WeChatMessageService weChatMessageService;
	@Autowired
	private SmsMessageService smsMessageService;
	@Autowired
	private MobileMessageService mobileMessageService;
	@Autowired
    private MsgsChannelService msgsChannelService;
	@Autowired
	private RedisUtils redisUtil;
	
	/**
	 * 定时获取微信AccessToken
	 */
    @Scheduled(fixedRate=7000*1000)
	public void getAccessTokenByScheduled(){
		log.info("-----------------定时获取微信AccessToken调度开始------------------");
		try {
			getAccessToken();
		} catch (Exception e) {
			log.error("定时获取微信AccessToken出错",e);
		}
	}	
	/**
	 * 微博定时发送
	 */
	@Scheduled(cron = "0/30 * *  * * ?")
	public void blogSend(){
		log.info("-----------------微博发送调度开始-------------------");
		try {
			//从数据库中查询待发送信息，把待发送信息发送出去，并修改状态
			blogMessageService.sendToBlog();
		} catch (Exception e) {
			log.error("微博发送出错",e);
		}
	}
	/**
	 * 微信定时发送
	 */
	@Scheduled(cron = "0/30 * *  * * ?")
	public void wechatSend(){
		log.info("-----------------微信发送调度开始------------------");
		try {
			//从数据库中查询待发送信息，把待发送信息发送出去，并修改状态
			weChatMessageService.sendToWeChat();
		} catch (Exception e) {
			log.error("微信发送出错",e);
		}
	}
	/**
	 * 短信定时发送
	 */
	@Scheduled(cron = "0/30 * *  * * ?")
	public void smsSend(){
		log.info("-----------------短信发送调度开始------------------");
		try {
			//从数据库中查询待发送信息，把待发送信息发送出去，并修改状态
			smsMessageService.sendToSMS();
		} catch (Exception e) {
			log.error("短信发送出错",e);
		}
	}
	/**
	 * 移动终端定时发送
	 */
	@Scheduled(cron = "0/30 * *  * * ?")
	public void mobileSend(){
		log.info("-----------------移动终端发送调度开始-------------------");
		try {
			//从数据库中查询待发送信息，把待发送信息发送出去，并修改状态
			mobileMessageService.updateMobileMessage();
		} catch (Exception e) {
			log.error("移动终端定时发送出错",e);
		}
	}
	/**
	 * 每7000秒获取一次AccessToken
	 */
	private void getAccessToken(){
		//获取所有公众号的appid、appSecret
		List<ChannelMsgDTO> channelList = msgsChannelService.getByChannelType(MsgConstant.WECHAT_CHANNEL_TYPE);
		if(!Util.isEmpty(channelList)){
			for(int i=0;i<channelList.size();i++){
				ChannelMsgDTO weChatChannelDTO = channelList.get(i);
				String appid = weChatChannelDTO.getAppId();
				String appSecret = weChatChannelDTO.getAppSecret();
				if(Util.isEmptyString(appid)||Util.isEmptyString(appSecret)){
					continue;
				}
				String url = MessageConstant.wechat_tokenGetUrl.replace("%s", appid).replace("%t", appSecret);
				HttpClientEx ex = new HttpClientEx(url, "utf-8");
				log.info("appid是："+appid);
				TockenResult tres = getTokean(ex, 5);
				if(tres == null || Util.isEmptyString(tres.getAccess_token())){
					continue;
				}
				//把access_token缓存到redis、缓存key用appid
				redisUtil.set(appid, tres.getAccess_token(), tres.getExpires_in());
			}
		}
	}
	/**
	 * 获取微信access_token
	 * @param ex
	 * @param reryCount
	 * @return
	 */
	private TockenResult getTokean(HttpClientEx ex,int reryCount) {
		if(reryCount < 0){
			return null;
		}
		String result = ex.doGet();
		log.info("AAAAAAAAAAAAAA"+"   "+result+"   "+"AAAAAAAAAAAAA");
		TockenResult tres = JSONUtils.parse(result,TockenResult.class);
		if(Util.isEmptyString(tres.getAccess_token())){
			return getTokean(ex, reryCount-1);
		}
		return tres;
	}
}
