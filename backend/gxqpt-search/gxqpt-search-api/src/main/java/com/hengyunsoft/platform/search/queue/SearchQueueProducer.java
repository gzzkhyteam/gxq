package com.hengyunsoft.platform.search.queue;

import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
import com.hengyunsoft.platform.search.queue.dto.IndexItemDTO;
import com.hengyunsoft.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 门户索引生产者
 * @auth sxy
 * @date 2018/08/09
 */
@Slf4j
@Component
public class SearchQueueProducer {
    /**
     * 门户搜索索引创建
     */
    private final static String SEARCH_INTERFACE_GATEWAY_ADD_INDEX = "search.interface.gateway.add.index";

    /**
     * 门户搜索索引删除
     */
    private final static String SEARCH_INTERFACE_GATEWAY_DELETE_INDEX = "search.interface.gateway.delete.index";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;
    public String addOrUpdateIndex(IndexItemDTO dto) {

        String msg = null;
        try {
            msg = validateAdd(dto);
            String bean = JSONUtils.toJsonString(dto);
            log.info("接口调用消息队列新增索引[{}]", bean);
            if(msg!=null){
                log.info("接口调用消息队列新增索引,必输项校验失败,msg:[{}]", msg);
                return msg;
            }
            this.rabbitTemplate.convertAndSend(keyPrefix + SEARCH_INTERFACE_GATEWAY_ADD_INDEX, bean);
        } catch (AmqpException e) {
            log.error("接口调用消息队列新增索引异常！！",e);
        }
        return msg;
    }

    public String deleteIndex(DeleteIndexDTO dto) {

        String msg = null;
        try {
            msg = validateDel(dto);
            String bean = JSONUtils.toJsonString(dto);
            log.info("接口调用消息队列删除索引[{}]", bean);
            if(msg!=null){
                log.info("接口调用消息队列删除索引,必输项校验失败,msg:[{}]", msg);
                return msg;
            }
            this.rabbitTemplate.convertAndSend(keyPrefix + SEARCH_INTERFACE_GATEWAY_DELETE_INDEX, bean);
        } catch (AmqpException e) {
            log.error("接口调用消息队列删除索引异常！！",e);
        }
        return msg;
    }

    /**
     * 校验入参
     * @param dto
     * @return
     */
    public String validateDel(DeleteIndexDTO dto){
        String msg = null;
        if(dto==null){
            msg =  "入参实体DTO不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getId())){
            msg =  "索引id不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getCollection())){
            msg =  "索引集合不能为空！！";
        }
        return msg;
    }

    /**
     * 校验入参
     * @param dto
     * @return
     */
    public String validateAdd(IndexItemDTO dto){
        String msg = null;
        if(dto==null){
            msg =  "入参实体DTO不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getId())){
            msg =  "索引主键ID不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getCollection())){
            msg =  "索引集合不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getTitle())){
            msg =  "索引标题不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getContent())){
            msg =  "索引内容不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getExt())){
            msg =  "索引更新时间不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getUrl())){
            msg =  "索引地址不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getType())){
            msg =  "索引类型不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getBizId())){
            msg =  "索引业务ID不能为空！！";
        }
        if(StringUtil.isEmpty(dto.getAppId())){
            msg =  "索引应用ID不能为空！！";
        }
        log.info("索引dto[{}],msg[{}]",JSONUtils.toJsonString(dto),msg);
        return msg;
    }
}
