//package com.hengyunsoft.platform.piping.job;
//
//import java.io.IOException;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.hengyunsoft.platform.piping.constant.MessageConstant;
//
//@Component
//public class WechatMessageChannelActuator{
//	@Autowired
//	private CachingConnectionFactory cachingConnectionFactory;
//	
//	@PostConstruct
//	public void init(){
//		//创建通讯渠道
//		try {
//			//微信渠道
//			cachingConnectionFactory.createConnection().createChannel(false).queueDeclare(MessageConstant.WECHAT_MESSAGE_CHANNEL, true, false, false, null);
//			//短信
//			cachingConnectionFactory.createConnection().createChannel(false).queueDeclare(MessageConstant.SMS_MESSAGE_CHANNEL, true, false, false, null);
//			//微博
//			cachingConnectionFactory.createConnection().createChannel(false).queueDeclare(MessageConstant.BLOG_MESSAGE_CHANNEL, true, false, false, null);
//			//预警发布渠道
//			cachingConnectionFactory.createConnection().createChannel(false).queueDeclare(MessageConstant.WARN_MESSAGE_CHANNEL, true, false, false, null);
//		} catch (AmqpException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		
//	}
//	
//}
