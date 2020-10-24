package com.hengyunsoft.platform.search.impl;

import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.platform.search.dto.IndexItemDTO;
import com.hengyunsoft.platform.search.entity.core.po.ShareDataDirectory;
import com.hengyunsoft.platform.search.manager.SearchBizCommon;
import com.hengyunsoft.platform.search.repository.exchange.dao.ShareDataDirectoryMapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.search.impl
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：搜索
 * 创建人：tianai
 * 创建时间：2018/11/19
 *
 */
@Api(value = "API - DirectorySearchImpl.java", description = "共享交换数据目录搜索接口")
@RestController
@Slf4j
public class DirectorySearchImpl{

    @Autowired
    SearchBizCommon searchBizCommon;
    @Autowired
    ShareDataDirectoryMapper shareDataDirectoryMapper;

    @Value("${gxqpt.server.exchange.appid:35kj6100}")
    private String exchangeAppId;

    /**
     * 构建共享交换数据目录索引
     * @return
     */
    public List<IndexItemDTO> buildDirectoryIndexItemDTO(){
        List<IndexItemDTO> dtoList = new ArrayList<>();
        List<ShareDataDirectory> list = shareDataDirectoryMapper.getAllList();
        if(list.isEmpty()){
            return null;
        }
        list.forEach((li) ->{
            IndexItemDTO dto = new IndexItemDTO();
            dto.setAppId(exchangeAppId);
            dto.setBizId(String.valueOf(li.getId()));
            dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
            dto.setContent(StringUtils.isEmpty(li.getDesc())?li.getDirName():li.getDesc());
            Date date = li.getUpdateTime()==null?new Date():li.getUpdateTime();
            dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE+"_"+li.getId());
            dto.setTitle(li.getDirName());
            dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE);
            dto.setUrl("/module/index?promUrl=/gxqpt-exchange/module/generalView?id="+li.getId().toString());
            dtoList.add(dto);
        });
        return dtoList;
    }

    /**
     * 批量增加或者更新索引
     * @param
     * @return
     */
    public void addOrUpdateBatchIndex() {
        List<IndexItemDTO> dtoList = new ArrayList<>();
        List<IndexItemDTO> directoryList = buildDirectoryIndexItemDTO();
        if(directoryList!=null){
            dtoList.addAll(directoryList);
        }
        searchBizCommon.addOrUpdateBatchIndex(dtoList);
        return;
    }
}
