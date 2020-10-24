package com.hengyunsoft.platform.queue;

import com.hengyunsoft.platform.search.dto.IndexItemDTO;
import com.hengyunsoft.platform.search.manager.SearchBizCommon;
import com.hengyunsoft.platform.search.manager.SearchManager;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
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
 * 门户索引消费者
 *
 * @auth sxy
 * @date 2018/08/09
 */
@Component
@Slf4j
public class SearchQueueConsumer {

    /**
     * 门户搜索索引创建
     */
    private final static String SEARCH_INTERFACE_GATEWAY_ADD_INDEX = "search.interface.gateway.add.index";

    /**
     * 门户搜索索引删除
     */
    private final static String SEARCH_INTERFACE_GATEWAY_DELETE_INDEX = "search.interface.gateway.delete.index";

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 创建bean 的作用和 init 方法中的一样。
     * 没有这个，启动会报错
     *
     * @return
     */
    @Bean
    public Queue addSearchIndex() {
        return new Queue(keyPrefix + SEARCH_INTERFACE_GATEWAY_ADD_INDEX);
    }

    @Bean
    public Queue deleteSearchIndex() {
        return new Queue(keyPrefix + SEARCH_INTERFACE_GATEWAY_DELETE_INDEX);
    }

    @Autowired
    private SearchManager searchManager;

    @Autowired
    SearchBizCommon searchBizCommon;

    @RabbitListener(queues = "${spring.redis.key-prefix}" + SEARCH_INTERFACE_GATEWAY_ADD_INDEX)
    @RabbitHandler
    public void addSearchIndex(String dto) {
        try {

            log.info("从管道[{}]处理新增索引数据开始dto[{}] ", SEARCH_INTERFACE_GATEWAY_ADD_INDEX, dto);
            IndexItemDTO indexItemDTO = JSONUtils.parse(dto, IndexItemDTO.class);
            if (indexItemDTO == null) {
                return;
            }
            searchBizCommon.addOrUpdateIndexCommon(indexItemDTO);
        } catch (Exception e) {
            log.error("从管道处理新增索引数据失败", e);
        }
    }

    @RabbitListener(queues = "${spring.redis.key-prefix}" + SEARCH_INTERFACE_GATEWAY_DELETE_INDEX)
    @RabbitHandler
    public void deleteSearchIndex(String dto) {
        try {

            DeleteIndexDTO record = JSONUtils.parse(dto, DeleteIndexDTO.class);
            if (record == null) {
                return;
            }
            log.info("从管道[{}]处理删除索引数据开始dto[{}] ", SEARCH_INTERFACE_GATEWAY_DELETE_INDEX, record);
            searchManager.remove(record.getCollection(), record.getId());
        } catch (Exception e) {
            log.error("从管道处理删除索引数据失败", e);
        }
    }

}
