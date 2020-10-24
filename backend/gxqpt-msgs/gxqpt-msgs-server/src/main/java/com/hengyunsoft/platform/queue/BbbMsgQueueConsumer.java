package com.hengyunsoft.platform.queue;

import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgSaveReqDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.manager.BbsBizCommon;
import com.hengyunsoft.utils.JSONUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 站内消息发送消费者
 *
 * @auth sxy
 * @date 2018/08/09
 */
@Component
@Slf4j
public class BbbMsgQueueConsumer {
    /**
     * 站内消息发送
     */
    private final static String MSGS_INTERFACE_BBS_SEND = "msgs.interface.bbs.send";

    /**
     * 站内消息更新
     */
    private final static String MSGS_INTERFACE_BBS_UPDATE = "msgs.interface.bbs.update";

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 创建bean 的作用和 init 方法中的一样。
     * 没有这个，启动会报错
     *
     * @return
     */
    @Bean
    public Queue sendQueue() {
        return new Queue(keyPrefix + MSGS_INTERFACE_BBS_SEND);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(keyPrefix + MSGS_INTERFACE_BBS_UPDATE);
    }

    @Autowired
    private BbsBizCommon bbsBizCommon;

    @RabbitListener(queues = "${spring.redis.key-prefix}" + MSGS_INTERFACE_BBS_SEND)
    @RabbitHandler
    public void sendQueue(String dto) {
        try {

            log.info("从管道[{}]处理发送消息数据开始dto[{}] ", keyPrefix + MSGS_INTERFACE_BBS_SEND, dto);
            BbsAllMainMsgSaveReqDTO record = JSONUtils.parse(dto, BbsAllMainMsgSaveReqDTO.class);
            if (record == null) {
                return;
            }
            bbsBizCommon.saveMsgCommon(record);//处理数据
        } catch (Exception e) {
            log.error("从管道处理消息发送数据失败", e);
        }
    }

    @RabbitListener(queues = "${spring.redis.key-prefix}" + MSGS_INTERFACE_BBS_UPDATE)
    @RabbitHandler
    public void updateQueue(String dto) {
        try {

            log.info("从管道[{}]处理更新消息状态数据开始dto[{}] ", keyPrefix + MSGS_INTERFACE_BBS_UPDATE, dto);
            UpdateBacklogReqDTO record = JSONUtils.parse(dto, UpdateBacklogReqDTO.class);
            if (record == null) {
                return;
            }
            bbsBizCommon.updateBacklogCommon(record);//处理数据
        } catch (Exception e) {
            log.error("从管道处理消息更新状态数据失败", e);
        }
    }
}
