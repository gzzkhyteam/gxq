package com.hengyunsoft.platform.search.impl;

import com.alibaba.fastjson.JSON;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SearchException;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationResDTO;
import com.hengyunsoft.platform.search.api.SearchApi;
import com.hengyunsoft.platform.search.dto.*;
import com.hengyunsoft.platform.search.entity.core.po.*;
import com.hengyunsoft.platform.search.manager.SearchBizCommon;
import com.hengyunsoft.platform.search.manager.SearchManager;
import com.hengyunsoft.platform.search.repository.core.service.AppOptcollectionService;
import com.hengyunsoft.platform.search.repository.core.service.CollectionService;
import com.hengyunsoft.platform.search.repository.developer.dao.ServiceModuleDocMapper;
import com.hengyunsoft.platform.search.repository.developer.dao.ServiceResourceMapper;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.response.AnalysisResponseBase;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.search.impl
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：搜索
 * 修改人：gbl
 * 修改时间：2018/4/8
 * 修改内容：新增基础接口
 */
@Api(value = "API - SearchApiImpl.java", description = "搜索接口")
@RestController
@RequestMapping("searchModule")
@Slf4j
public class SearchApiImpl implements SearchApi {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private SearchManager searchManager;
    @Autowired
    ServiceModuleDocMapper serviceModuleDocMapper;
    @Autowired
    ServiceResourceMapper serviceResourceMapper;
    @Autowired
    SearchBizCommon searchBizCommon;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private AppOptcollectionService appOptcollectionService;

    @Value("${gxqpt.server.admin.appid:45kj6310}")
    private String adminAppId;

    /**
     * 描述： 创建集合
     * 参数：collectionDTO
     * 返回值：返回创建的集合
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @ApiResponses({
            @ApiResponse(code = 80009, message = "创建集合数据不能为空"),
            @ApiResponse(code = 80001, message = "appid不能为空"),
            @ApiResponse(code = 80010, message = "集合编码不能为空"),
            @ApiResponse(code = 80011, message = "集合名称不能为空"),
            @ApiResponse(code = 80012, message = "集合编码重合了"),
            @ApiResponse(code = 80013, message = "没有为该app创建集合的权限")
    })
    @RequestMapping(value = "createCollection", method = RequestMethod.POST)
    @Override
    public Result<CollectionDTO> createCollection(@RequestBody CollectionDTO collectionDTO) {
        //校验
        BizAssert.assertNotNull(SearchException.SEARCH_CREATE_CLOOECTION_DATA, collectionDTO);
        BizAssert.assertNotNull(SearchException.SEARCH_CREATE_APPID, collectionDTO.getAppId());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_CLOOECTION_CODE, collectionDTO.getCollectionCode());
        BizAssert.assertNotEmpty(SearchException.SEARCH_CREATE_CLOOECTION_NAME, collectionDTO.getCollectionName());

        Long adminId = BaseContextHandler.getAdminId();
        Result<List<ApplicationResDTO>> listResult = applicationApi.find();
        List<ApplicationResDTO> allApp = listResult.getData();
        boolean isOK = false;
        for (ApplicationResDTO app : allApp) {
            if (app.getAppId().equals(collectionDTO.getAppId())) {
                isOK = true;
                break;
            }
        }
        if (!isOK) {
            BizAssert.fail(SearchException.SEARCH_CREATE_CLOOECTION_HSA_NOT_OPT);
        }
        List<Collection> colls = collectionService.getByCode(collectionDTO.getCollectionCode());
        if (colls.size() > 0) {
            BizAssert.fail(SearchException.SEARCH_CREATE_CLOOECTION_NAME_DUB);
        }
        Collection coll = new Collection();
        try {
            coll.setAppId(collectionDTO.getAppId());
            coll.setCollectionCode(collectionDTO.getCollectionCode());
            coll.setCollectionName(collectionDTO.getCollectionName());
            coll.setCreateUserId(adminId);
            coll = collectionService.saveCollection(coll);
            collectionDTO.setId(coll.getId());
            searchManager.createCollection(collectionDTO.getCollectionCode());

            AppOptCollection appOpt = new AppOptCollection();
            appOpt.setAppId(collectionDTO.getAppId());
            appOpt.setCollectionId(coll.getId());
            appOpt.setOpt(3);//读写权限
            appOpt.setUpdateTime(new Date());
            appOptcollectionService.saveOrUpdate(appOpt);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_SOLR_OFFLINE);
        }
        return Result.success(collectionDTO);
    }

    /**
     * 描述：增加或者更新索引
     * 参数：indexItemDTO
     * 返回值：是否成功
     * 修改人：gbl
     * 修改时间：2018/4/8
     * 修改内容：
     */
    @RequestMapping(value = "addOrUpdateIndex", method = RequestMethod.POST)
    @Override
    @ApiResponses({
            @ApiResponse(code = 80000, message = "创建索引数据不能为空"),
            @ApiResponse(code = 80002, message = "索引id不能为空"),
            @ApiResponse(code = 80003, message = "索引标题不能为空"),
            @ApiResponse(code = 80004, message = "索引内容不能为空"),
            @ApiResponse(code = 80005, message = "索引URL不能为空"),
            @ApiResponse(code = 80006, message = "操作集合不能为空"),
            @ApiResponse(code = 80007, message = "操作包含没有写权限的集合"),
            @ApiResponse(code = 80008, message = "SOLR不可用"),
    })
    public Result<Boolean> addOrUpdateIndex(@RequestBody IndexItemDTO indexItemDTO) {
        return searchBizCommon.addOrUpdateIndexCommon(indexItemDTO);
    }

    /**
     * 构建帮助文档索引
     * @return
     */
   public List<IndexItemDTO> buildServiceModuleDocIndexItemDTO(){
       List<IndexItemDTO> dtoList = new ArrayList<IndexItemDTO>();
       List<ServiceModuleDoc> list = serviceModuleDocMapper.selectAll();
       if(list.isEmpty()){
           return null;
       }
       list.forEach((li) ->{
           IndexItemDTO dto = new IndexItemDTO();
           dto.setAppId(adminAppId);
           dto.setBizId(String.valueOf(li.getId()));
           dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
           Map<String,String> map = (Map<String,String>)JSON.parse(li.getJsonContent());
           if(map !=null){
               dto.setContent(StringUtils.isEmpty(map.get("searchContent"))?li.getTitle():map.get("searchContent"));
           }
           Date date = li.getUpdateTime()==null?new Date():li.getUpdateTime();
           dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
           dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC+"_"+li.getId());
           dto.setTitle(li.getTitle());
           dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC);
           dto.setUrl("/module/helpDoc"+"?moduleId="+li.getModuleId()+"&id="+li.getId());
           dtoList.add(dto);
       });
       return dtoList;
   }

    /**
     * 构建api索引
     * @return
     */
    public List<IndexItemDTO> buildServiceResourceIndexItemDTO(){
        List<IndexItemDTO> dtoList = new ArrayList<IndexItemDTO>();
        List<ServiceResource> list = serviceResourceMapper.selectAll();
        if(list.isEmpty()){
            return null;
        }
        list.forEach((li) ->{
            IndexItemDTO dto = new IndexItemDTO();
            dto.setAppId(adminAppId);
            dto.setBizId(String.valueOf(li.getId()));
            dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
            dto.setContent(StringUtils.isEmpty(li.getDesc())?li.getName():li.getDesc());
            Date date = li.getUpdateTime()==null?new Date():li.getUpdateTime();
            dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_FWJK_API+"_"+li.getId());
            dto.setTitle(li.getName());
            dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_FWJK_API);
            dto.setUrl("/module/apiDoc"+"?moduleId="+li.getModuleId());
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
        List<IndexItemDTO> dtoList = new ArrayList<IndexItemDTO>();
        //服务监控索引
        List<IndexItemDTO> smList = buildServiceModuleDocIndexItemDTO();
        List<IndexItemDTO> srList = buildServiceResourceIndexItemDTO();
        if(smList!=null){
            dtoList.addAll(smList);
        }
        if(srList!=null){
            dtoList.addAll(srList);
        }
        searchBizCommon.addOrUpdateBatchIndex(dtoList);
        return;
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 80031, message = "索引删除失败"),
    })
    public Result<Boolean> remove(@RequestParam(value = "collection") String collection,
                                  @RequestParam(value = "id") String id) {
        searchManager.remove(collection, id);
        return Result.success(true);
    }

    /**
     * 描述：搜索
     * 参数：搜索参数
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    @AppToken
    @Override
    @ApiResponses({
            @ApiResponse(code = 80014, message = "搜索数据不能为空"),
            @ApiResponse(code = 80015, message = "搜索数据集合不能为空"),
            @ApiResponse(code = 80016, message = "搜索数据关键字不能为空"),
            @ApiResponse(code = 80017, message = "搜索数据当前页不能为空"),
            @ApiResponse(code = 80018, message = "搜索数据每页大小不能为空"),
            @ApiResponse(code = 80019, message = "搜索数据包括没有读权限的集合"),
            @ApiResponse(code = 80020, message = "搜索数据是否高亮不能为空"),
    })
    public Result<SearchResDTO> search(@RequestBody SeacherParamDTO seacherParamDTO) {

        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_DATA, seacherParamDTO);
        BizAssert.assertNotEmpty(SearchException.SEARCH_SEARCH_COLL_HAS_EMPTY, seacherParamDTO.getCollections());
        BizAssert.assertNotEmpty(SearchException.SEARCH_SEARCH_KEY_WORLDS_HAS_EMPTY, seacherParamDTO.getKeyWords());
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_PAGE_NOW_HAS_EMPTY, seacherParamDTO.getPageNo());
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_PAGE_SIZE_HAS_EMPTY, seacherParamDTO.getPageSize());
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_IS_HIG_HAS_EMPTY, seacherParamDTO.isHighlighter());

        //检测集合读权限
        String appId = BaseContextHandler.getAppId();
        log.info("搜索功能入参输出,dto:[{}],appId:[{}]", JSONUtils.toJsonString(seacherParamDTO),appId);
        List<OptClollection> allCanWrite = collectionService.getAllCanRead(appId);
        log.info("查询集合返回：[{}]", JSONUtils.toJsonString(allCanWrite));
        String[] ids = seacherParamDTO.getCollections().split(",");
        boolean isOK = false;
        for (String cod : ids) {
            for (OptClollection col : allCanWrite) {
                if (col.getCollectionCode().equals(cod)) {
                    isOK = true;
                    break;
                }
            }
        }
        if (!isOK) {
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_HAS_NOT_WRITE);
        }
        SearchResDTO search = null;
        try {
            search = searchManager.addSearch(seacherParamDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_SOLR_OFFLINE);
        }
        return Result.success(search);
    }

    /**
     * 描述：搜索,不验证集合权限
     * 参数：搜索参数
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "searchNoVerify", method = RequestMethod.POST)
    @Override
    @ApiResponses({
            @ApiResponse(code = 80014, message = "搜索数据不能为空"),
            @ApiResponse(code = 80015, message = "搜索数据集合不能为空"),
            @ApiResponse(code = 80016, message = "搜索数据关键字不能为空"),
            @ApiResponse(code = 80017, message = "搜索数据当前页不能为空"),
            @ApiResponse(code = 80018, message = "搜索数据每页大小不能为空"),
            @ApiResponse(code = 80019, message = "搜索数据包括没有读权限的集合"),
            @ApiResponse(code = 80020, message = "搜索数据是否高亮不能为空"),
    })
    public Result<SearchResDTO> searchNoVerify(@RequestBody SeacherParamDTO seacherParamDTO) {
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_DATA, seacherParamDTO);
        BizAssert.assertNotEmpty(SearchException.SEARCH_SEARCH_COLL_HAS_EMPTY, seacherParamDTO.getCollections());
        BizAssert.assertNotEmpty(SearchException.SEARCH_SEARCH_KEY_WORLDS_HAS_EMPTY, seacherParamDTO.getKeyWords());
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_PAGE_NOW_HAS_EMPTY, seacherParamDTO.getPageNo());
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_PAGE_SIZE_HAS_EMPTY, seacherParamDTO.getPageSize());
        BizAssert.assertNotNull(SearchException.SEARCH_SEARCH_IS_HIG_HAS_EMPTY, seacherParamDTO.isHighlighter());

        SearchResDTO search = null;
        try {
            search = searchManager.addSearch(seacherParamDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_SOLR_OFFLINE);
        }
        return Result.success(search);
    }

    /**
     * 描述：关键字分析
     * 参数：keyWord关键字 collection:集合  field:字段，title(标题)，content(内容)
     * 返回值：返回分析结果
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @ApiResponses({
            @ApiResponse(code = 80028, message = "关键字分析关键字不能为空"),
            @ApiResponse(code = 80029, message = "关键字分析集合不能为空"),
            @ApiResponse(code = 80030, message = "关键字分析选择字段不能为空"),
    })
    @RequestMapping(value = "analysisField", method = RequestMethod.GET)
    @Override
    public Result<AnalysisResDTO> analysisField(@RequestParam("keyWord") String keyWord, @RequestParam("queryWord") String queryWord, @RequestParam("collection") String collection, @RequestParam("field") String field) {
        BizAssert.assertNotEmpty(SearchException.SEARCH_ANALYSIS_KEYWORLD_NULL, keyWord);
        BizAssert.assertNotEmpty(SearchException.SEARCH_ANALYSIS_COLLECTION_NULL, collection);
        BizAssert.assertNotEmpty(SearchException.SEARCH_ANALYSIS_FIELD_NULL, field);

        if (StringUtils.isEmpty(queryWord)) {
            queryWord = "";
        }

        AnalysisResDTO res = new AnalysisResDTO();
        try {
            FieldAnalysisResponse process = searchManager.analysisField(keyWord, queryWord, collection, field);
            FieldAnalysisResponse.Analysis titleAna = process.getFieldNameAnalysis(field);
            Iterable<AnalysisResponseBase.AnalysisPhase> queryPhases = titleAna.getQueryPhases();
            Iterable<AnalysisResponseBase.AnalysisPhase> indexPhases = titleAna.getIndexPhases();
            Object queryPhasesObj = JSON.toJSON(queryPhases);
            Object indexPhasesObj = JSON.toJSON(indexPhases);
            String queryStr = queryPhasesObj.toString();
            String indexStr = indexPhasesObj.toString();
            res.setIndexStr(indexStr);
            res.setQueryStr(queryStr);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            BizAssert.fail(SearchException.SEARCH_CREATE_INDEX_SOLR_OFFLINE);
        }
        return Result.success(res);
    }
}
