package com.hengyunsoft.platform.queue;

import com.hengyunsoft.platform.warn.biz.WarnMessageService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hengyunsoft.platform.piping.constant.MessageConstant;

/**
 * 创建渠道队列
 * @author dxz
 */
@Component
@Slf4j
public class WarnQueueCreater {

	@Value("${spring.redis.key-prefix:dev}")
	private String keyPrefix;
    @Autowired
    private WarnMessageService warnMessageService;

	/**
	 * 创建微信渠道
	 * @return
	 */
    @Bean
    public Queue weChatQueue() {
        return new Queue(keyPrefix + MessageConstant.WECHAT_MESSAGE_CHANNEL);
    }
	/**
	 * 创建短信渠道
	 * @return
	 */
    @Bean
    public Queue smsQueue() {
        return new Queue(keyPrefix + MessageConstant.SMS_MESSAGE_CHANNEL);
    }
	/**
	 * 创建微博渠道
	 * @return
	 */
    @Bean
    public Queue blogQueue() {
        return new Queue(keyPrefix + MessageConstant.BLOG_MESSAGE_CHANNEL);
    }
	/**
	 * 创建预警渠道
	 * @return
	 */
    @Bean
    public Queue warnQueue() {
        return new Queue(keyPrefix + MessageConstant.WARN_MESSAGE_CHANNEL);
    }

    /**
     * 预警信息队列
     * @param warn
     */
    @RabbitListener(queues = "${spring.redis.key-prefix:dev}" + MessageConstant.WARN_MESSAGE_CHANNEL)
    @RabbitHandler
    public void saveData(String warn){
        log.info("预警消费预警信息 saveData---》 warn：{}", warn);
        warnMessageService.saveWarnMessage(warn);
    }
}
