package com.hengyunsoft.platform.search.impl;

import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.platform.search.dto.IndexItemDTO;
import com.hengyunsoft.platform.search.entity.core.po.ShareDataApiIndex;
import com.hengyunsoft.platform.search.manager.SearchBizCommon;
import com.hengyunsoft.platform.search.repository.exchange.dao.ShareDataApiMapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
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
public class ApiSearchImpl {

    @Autowired
    SearchBizCommon searchBizCommon;
    @Autowired
    ShareDataApiMapper shareDataApiMapper;

    @Value("${gxqpt.server.exchange.appid:35kj6100}")
    private String exchangeAppId;

    /**
     * 构建共享交换数据目录索引
     * @return
     */
    public List<IndexItemDTO> buildDirectoryIndexItemDTO(){
        List<IndexItemDTO> dtoList = new ArrayList<>();
        List<ShareDataApiIndex> list = shareDataApiMapper.getAllApiList();
        if(list.isEmpty()){
            return null;
        }
        list.forEach((li) ->{
            IndexItemDTO dto = new IndexItemDTO();
            dto.setAppId(exchangeAppId);
            dto.setBizId(String.valueOf(li.getId()));
            dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
            dto.setContent(StringUtils.isEmpty(li.getApiDesc())?li.getApiName():li.getApiDesc());
            Date date = li.getUpdateTime()==null?new Date():li.getUpdateTime();
            dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API+"_"+li.getId());
            dto.setTitle(li.getApiName());
            dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API);
            dto.setUrl("/module/index?promUrl=/gxqpt-exchange/module/generalApiView?id="+li.getId().toString());
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
        List<IndexItemDTO> apiList = buildDirectoryIndexItemDTO();
        if(apiList!=null){
            dtoList.addAll(apiList);
        }
        searchBizCommon.addOrUpdateBatchIndex(dtoList);
        return;
    }
}
