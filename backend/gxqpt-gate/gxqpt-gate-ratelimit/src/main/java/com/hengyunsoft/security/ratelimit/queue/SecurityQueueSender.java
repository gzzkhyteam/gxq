package com.hengyunsoft.security.ratelimit.queue;

import com.hengyunsoft.utils.JSONUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Slf4j
public class SecurityQueueSender {

    private final static String INTERFACE_CALL_RECORD_QUEUE = "security.interface.call.record";
    private final static String INTERFACE_WARN_SMS = "security.interface.warn.sms";
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;
    public void send(InterfaceCallRecordDTO dto) {
        String bean = JSONUtils.toJsonString(dto);
        //log.info("接口调用消息队列发送{}", bean);

        this.rabbitTemplate.convertAndSend(keyPrefix + INTERFACE_CALL_RECORD_QUEUE, bean);
    }

    public void sendWarnSms(InterfaceWarnSms dto) {
        String bean = JSONUtils.toJsonString(dto);
        log.info("预警短信通知消息队列发送{}", bean);

        this.rabbitTemplate.convertAndSend(keyPrefix + INTERFACE_WARN_SMS, bean);
    }
}
