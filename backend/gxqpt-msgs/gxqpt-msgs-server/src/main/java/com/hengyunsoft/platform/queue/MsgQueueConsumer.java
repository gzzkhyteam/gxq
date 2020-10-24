package com.hengyunsoft.platform.queue;

import com.hengyunsoft.platform.msgs.biz.BlogMessageService;
import com.hengyunsoft.platform.msgs.biz.SmsMessageService;
import com.hengyunsoft.platform.msgs.biz.WeChatMessageService;
import com.hengyunsoft.platform.msgs.constant.MessageConstant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author dxz
 */
@Component
@Slf4j
public class MsgQueueConsumer {
    @Autowired
    private BlogMessageService blogMessageService;
    @Autowired
    private WeChatMessageService weChatMessageService;
    @Autowired
    private SmsMessageService smsMessageService;
    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 创建微信渠道
     *
     * @return
     */
    @Bean
    public Queue weChatQueue() {
        return new Queue(keyPrefix + MessageConstant.WECHAT_MESSAGE_CHANNEL);
    }

    /**
     * 创建短信渠道
     *
     * @return
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(keyPrefix + MessageConstant.SMS_MESSAGE_CHANNEL);
    }

    /**
     * 创建微博渠道
     *
     * @return
     */
    @Bean
    public Queue blogQueue() {
        return new Queue(keyPrefix + MessageConstant.BLOG_MESSAGE_CHANNEL);
    }

    /**
     * 从管道获取微信消息
     *
     * @return
     */
    @RabbitListener(queues = "${spring.redis.key-prefix}" + MessageConstant.WECHAT_MESSAGE_CHANNEL)
    @RabbitHandler
    public void weChatQueue(String msg) {
        try {
            log.info("微信消息为：{}==={}",keyPrefix, msg);
            weChatMessageService.saveWechatMessage(msg);
        } catch (Exception e) {
            log.error("从管道获取微信消息数据出错", e);
        }
    }

    /**
     * 从管道获取短信消息
     *
     * @return
     */
    @RabbitListener(queues = "${spring.redis.key-prefix}" + MessageConstant.SMS_MESSAGE_CHANNEL)
    @RabbitHandler
    public void smsQueue(String msg) {
        try {
            log.info("短信消息为：", msg);
            smsMessageService.saveMsg(msg);
        } catch (Exception e) {
            log.error("从管道获取短信消息数据出错", e);
        }
    }

    /**
     * 从管道获取微博消息
     *
     * @return
     */
    @RabbitListener(queues = "${spring.redis.key-prefix}" + MessageConstant.BLOG_MESSAGE_CHANNEL)
    @RabbitHandler
    public void blogQueue(String msg) {
        try {
            log.info("微博消息为：", msg);
            blogMessageService.saveBlogMessage(msg);
        } catch (Exception e) {
            log.error("从管道获取微博消息数据出错", e);
        }
    }
}
