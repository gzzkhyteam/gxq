package com.hengyunsoft.platform.mail.queue;


import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.platform.mail.dto.MqMessageDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 站内消息生产者
 *
 * @auth wt
 * @date 2018/08/14
 */
@Slf4j
@Component
public class MailQueueProducer {

    /**
     * 发送邮件
     */
    private final static String MAIL_INTERFACE_SEND = "mail.interface.send";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 发送消息
     *
     * @param dto
     */
    public void saveSendBbsMsg(MqMessageDTO dto) {
        try {
            String bean = JSONObject.toJSONString(dto);
            log.info("接口调用消息队列发送，dto[{}]", bean);

            this.rabbitTemplate.convertAndSend(keyPrefix + MAIL_INTERFACE_SEND, bean);
        } catch (AmqpException e) {
            log.error("发送消息异常！！", e);
        }
    }
}
