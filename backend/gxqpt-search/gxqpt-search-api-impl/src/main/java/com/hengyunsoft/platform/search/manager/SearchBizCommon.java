package com.hengyunsoft.platform.search.manager;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.SearchException;
import com.hengyunsoft.platform.search.dto.IndexItemDTO;
import com.hengyunsoft.platform.search.entity.core.po.OptClollection;
import com.hengyunsoft.platform.search.repository.core.service.CollectionService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 搜索相关公共业务处理类
 * @author sxy
 * @date 20180814
 */
@Component
@Slf4j
public class SearchBizCommon {

    @Autowired
    SearchManager searchManager;

    @Autowired
    CollectionService collectionService;

    /**
     * 批量增加或者更新索引
     * @param
     * @return
     */
    public void addOrUpdateBatchIndex(List<IndexItemDTO> list) {
        if(!list.isEmpty()){
            list.forEach((dto) ->{
                addOrUpdateIndexCommon(dto);
            });
        }
        return;
    }

    /**
     * 新增索引公共方法处理
     * @param indexItemDTO
     * @return
     */
    public Result<Boolean> addOrUpdateIndexCommon(IndexItemDTO indexItemDTO) {
        //校验
        BizAssert.assertNotNull(SearchException.SEARCH_CREATE_INDEX_DATA, indexItemDTO);
        BizAssert.assertNotNull(SearchException.SEARCH_CREATE_INDEX_ID, indexItemDTO.getId());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_INDEX_TITLE, indexItemDTO.getTitle());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_INDEX_CONTENT, indexItemDTO.getContent());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_INDEX_URL, indexItemDTO.getUrl());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_INDEX_COLLS, indexItemDTO.getCollection());
        String appId = indexItemDTO.getAppId();
        
        //检测集合写权限
        List<OptClollection> allCanWrite = collectionService.getAllCanWrite(appId);
        String code = indexItemDTO.getCollection();
        boolean isOK = false;
        for (OptClollection col : allCanWrite) {
            if (col.getCollectionCode().equals(code)) {
                isOK = true;
                break;
            }
        }
        if (!isOK) {
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_HAS_NOT_WRITE);
        }
        try {
            //写索引
            searchManager.addOrUpdateIndex(code, indexItemDTO);
        } catch (Exception e) {
            log.error("新增搜索索引异常", e);
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_SOLR_OFFLINE);
        }
        return Result.success(true);
    }
}


