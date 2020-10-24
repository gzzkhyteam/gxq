package com.hengyunsoft.platform.exchange.util;

import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.search.queue.SearchQueueProducer;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
import com.hengyunsoft.platform.search.queue.dto.IndexItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.utils
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/11/15
 * 修改内容：
 */
@Slf4j
@Component
public class SearchQueueUtil {
    @Autowired
    private SearchQueueProducer searchQueueProducer;
    @Value("${app.id}")
    private String appId;

    public void saveOrUpdateIndex(IndexItemDTO dto){
        searchQueueProducer.addOrUpdateIndex(dto);
    }

    public IndexItemDTO covertIndexItemDto(String bizId, String content, String title, String url, String type){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        IndexItemDTO indexItemDTO = new IndexItemDTO();
        indexItemDTO.setAppId(appId);
        indexItemDTO.setBizId(bizId);
        indexItemDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
        indexItemDTO.setContent(content);
        indexItemDTO.setExt(simpleDateFormat.format(new Date()));
        indexItemDTO.setId(type + "_" + bizId);
        indexItemDTO.setTitle(title);
        indexItemDTO.setType(type);
        indexItemDTO.setUrl(url + bizId);
        return indexItemDTO;
    }

    public void deleteIndex(DeleteIndexDTO indexDTO) {
        searchQueueProducer.deleteIndex(indexDTO);
    }
}
