//package com.hengyunsoft.platform.warn.jobs;
//
//import com.hengyunsoft.platform.warn.biz.WarnMessageService;
//import com.hengyunsoft.platform.warn.constant.MessageConstant;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.ReceiveAndReplyCallback;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Component
//@Slf4j
//public class ConsumerMsgActuator {
//
//
//	@Autowired
//	private WarnMessageService warnMessageService;
////	@Autowired
////	private RabbitTemplate rabbitTemplate;
////	private ExecutorService executorService;
////
////	public ConsumerMsgActuator() {}
////
////	/**
////	 *
////	 */
////	public void saveData(){
////		while(true){
////			//不断地从队列里抽取预警信息并保存到数据库
////			rabbitTemplate.receiveAndReply(MessageConstant.WARN_MESSAGE_CHANNEL, new ReceiveAndReplyCallback<String, String>() {
////				public String handle(String warn) {
////					System.out.println(warnMessageDto);
////					warnMessageService.saveWarnMessage(warn);
////					return "success";
////				}
////			});
////		}
////	}
////
////	@PostConstruct
////	public void init(){
////		executorService = Executors.newSingleThreadExecutor();
////		executorService.execute(this);
////	}
////
////	@Override
////	public void run() {
////		try {
////			Thread.sleep(3000);
////			while(true){
////				saveData();
////			}
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
////	}
//
//	@Bean
//	public Queue warnSmsQueue() {
//		return new Queue(MessageConstant.WARN_MESSAGE_CHANNEL);
//	}
//
//	@RabbitListener(queues = MessageConstant.WARN_MESSAGE_CHANNEL)
//	@RabbitHandler
//	public void saveData(String warn){
//		warnMessageService.saveWarnMessage(warn);
//	}
//}
