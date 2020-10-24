package com.hengyunsoft.platform.developer.impl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.ServiceModuleDocApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocQueryDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocRetDTO;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModuleDoc;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleDocExample;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceModuleDocService;
import com.hengyunsoft.platform.search.queue.SearchQueueProducer;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
import com.hengyunsoft.platform.search.queue.dto.IndexItemDTO;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:帮助文档实现类
 * @author chb
 * @date 2018/4/2 11:05
 * @return
 */
@Api(value = "API - ServiceModuleDocImpl", description = "帮助文档实现类")
@RestController
@RequestMapping("serviceModuleDoc")
@Slf4j
public class ServiceModuleDocImpl implements ServiceModuleDocApi {

    @Autowired
    private ServiceModuleDocService serviceModuleDocService;
    /**
     *DozerUtils
     */
    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    SearchQueueProducer searchQueueProducer;

    @Value("http://${gxqpt.hostname.nginx:127.0.0.1}:${gxqpt.port.gate:10003}/module/provideDocManage?id=")
    String apiUrl;

    /**
     * 新增帮助文档
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "新建帮助文档", notes = "新建帮助文档")
    @ApiResponses({
            @ApiResponse(code = 75000, message = "帮助文档不能为空"),
            @ApiResponse(code = 75001, message = "帮助文档模块ID不能为空"),
            @ApiResponse(code = 75003, message = "帮助文档模块名称不能为空"),
            @ApiResponse(code = 75004, message = "帮助文档内容不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<ServiceModuleDocDTO> save(@RequestBody ServiceModuleDocDTO serviceModuleDocDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_MODULE_DOC,serviceModuleDocDTO);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_ID,String.valueOf(serviceModuleDocDTO.getModuleId()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_TITLE,serviceModuleDocDTO.getTitle());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_CONTENT,serviceModuleDocDTO.getContent());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_TITLE,serviceModuleDocDTO.getSearchTitle());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_CONTENT,serviceModuleDocDTO.getSearchContent());

        //2.数据处理
        ServiceModuleDoc serviceModuleDoc = dozerUtils.map(serviceModuleDocDTO,ServiceModuleDoc.class);
        serviceModuleDoc.setCreateUser(BaseContextHandler.getAdminId());
        serviceModuleDoc.setUpdateUser(BaseContextHandler.getAdminId());
        serviceModuleDoc.setUpdateTime(new Date());
        serviceModuleDoc.setCreateTime(new Date());
        Map<String,String> map = new HashMap<>();
        map.put("searchTitle",serviceModuleDocDTO.getSearchTitle());
        map.put("searchContent",serviceModuleDocDTO.getSearchContent());
        serviceModuleDoc.setJsonContent(JSONUtils.toJsonString(map));
        //3.保存数据
        ServiceModuleDoc result = serviceModuleDocService.save(serviceModuleDoc);

        //帮助文档新增索引
        IndexItemDTO dto = new IndexItemDTO();
        dto.setAppId(BaseContextHandler.getAppId());
        dto.setBizId(String.valueOf(result.getId()));
        dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
        dto.setContent(serviceModuleDocDTO.getSearchContent());
        dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC+"_"+result.getId());
        dto.setTitle(serviceModuleDocDTO.getSearchTitle());
        dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC);
        dto.setUrl("/module/helpDoc"+"?moduleId="+serviceModuleDocDTO.getModuleId()+"&id="+result.getId());
        //dto.setUrl("/module/helpDoc"+"?id="+result.getId());
        searchQueueProducer.addOrUpdateIndex(dto);
        log.info("帮助文档新增索引dto[{}]",dto);
        return Result.success(dozerUtils.map(result,ServiceModuleDocDTO.class));
    }

    /**
     * 根据id帮助文档
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "根据id获取帮助文档", notes = "根据id获取帮助文档")
    @ApiResponses({
            @ApiResponse(code = 75002, message = "帮助文档ID不能为空")
    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Result<ServiceModuleDocRetDTO> getById(@RequestParam(value = "id") String id) {
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_DOC_ID,id);
        //2.查询数据
        ServiceModuleDoc doc =  serviceModuleDocService.getById(Long.valueOf(id));
        ServiceModuleDocRetDTO retDTO = dozerUtils.map(doc,ServiceModuleDocRetDTO.class);
        return Result.success(retDTO);
    }

    /**
     * 删除帮助文档
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "删除帮助文档", notes = "删除帮助文档")
    @ApiResponses({
            @ApiResponse(code = 75002, message = "帮助文档ID不能为空")
    })
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public Result<String> deleteById(@RequestParam(value = "id") String id) {
        //1.校验
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_DOC_ID,id);
        //2.查询数据
        int result =  serviceModuleDocService.deleteById(Long.valueOf(id));

        //删除帮助文档索引
        DeleteIndexDTO dto = new DeleteIndexDTO();
        dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
        dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC+"_"+id);
        searchQueueProducer.deleteIndex(dto);

        if(result>0){
            return Result.success("删除成功！");
        }
        return Result.fail("删除失败！");
    }

    /**
     * 根据id修改帮助文档
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "修改帮助文档", notes = "修改帮助文档")
    @ApiResponses({
            @ApiResponse(code = 75000, message = "帮助文档不能为空"),
            @ApiResponse(code = 75001, message = "帮助文档模块ID不能为空"),
            @ApiResponse(code = 75003, message = "帮助文档模块名称不能为空"),
            @ApiResponse(code = 75004, message = "帮助文档内容不能为空")
    })
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public Result<ServiceModuleDocDTO> updateById(@RequestBody ServiceModuleDocDTO serviceModuleDocDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_MODULE_DOC,serviceModuleDocDTO);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_ID,String.valueOf(serviceModuleDocDTO.getModuleId()));
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_TITLE,serviceModuleDocDTO.getTitle());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_CONTENT,serviceModuleDocDTO.getContent());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_TITLE,serviceModuleDocDTO.getSearchTitle());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_CONTENT,serviceModuleDocDTO.getSearchContent());
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_MODULE_DOC_ID,serviceModuleDocDTO.getId());

        //2.数据处理
        ServiceModuleDoc serviceModuleDoc = dozerUtils.map(serviceModuleDocDTO,ServiceModuleDoc.class);
        serviceModuleDoc.setUpdateUser(BaseContextHandler.getAdminId());
        serviceModuleDoc.setUpdateTime(new Date());
        Map<String,String> map = new HashMap<>();
        map.put("searchTitle",serviceModuleDocDTO.getSearchTitle());
        map.put("searchContent",serviceModuleDocDTO.getSearchContent());
        serviceModuleDoc.setJsonContent(JSONUtils.toJsonString(map));

        //3.保存数据
        int result =  serviceModuleDocService.updateByIdSelective(serviceModuleDoc);

        //帮助文档更新索引
        IndexItemDTO dto = new IndexItemDTO();
        dto.setAppId(BaseContextHandler.getAppId());
        dto.setBizId(String.valueOf(serviceModuleDocDTO.getId()));
        dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
        dto.setContent(serviceModuleDocDTO.getSearchContent());
        dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC+"_"+serviceModuleDocDTO.getId());
        dto.setTitle(serviceModuleDocDTO.getSearchTitle());
        dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC);
        dto.setUrl("/module/helpDoc"+"?moduleId="+serviceModuleDocDTO.getModuleId()+"&id="+serviceModuleDocDTO.getId());
        searchQueueProducer.addOrUpdateIndex(dto);
        log.info("帮助文档更新索引dto[{}]",dto);

        if(result>0){
            return Result.success(serviceModuleDocDTO);
        }
        return Result.fail("修改失败！");
    }

    /**
     * 获取帮助文档分页
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "获取帮助文档分页", notes = "获取帮助文档分页")
    @ApiResponses({
            @ApiResponse(code = 75000, message = "帮助文档不能为空"),
            @ApiResponse(code = 75001, message = "帮助文档模块ID不能为空"),
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ServiceModuleDocRetDTO>> page( @RequestBody OpenApiReq<ServiceModuleDocQueryDTO> req) {
        ServiceModuleDocQueryDTO serviceModuleDocQueryDTO = req.getData();
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_MODULE_DOC,serviceModuleDocQueryDTO);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_ID,String.valueOf(serviceModuleDocQueryDTO.getModuleId()));

        //2.数据处理
        ServiceModuleDocExample example = new ServiceModuleDocExample();
        example.createCriteria().andModuleIdEqualTo(serviceModuleDocQueryDTO.getModuleId())
                .andPublicIsEqualTo(serviceModuleDocQueryDTO.getPublicIs())
                .andPublishStatusEqualTo(serviceModuleDocQueryDTO.getPublishStatus())
                .andTitleLike(ServiceModuleDocExample.fullLike(serviceModuleDocQueryDTO.getTitle()));

        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        example.setOrderByClause(" order_ asc , update_time desc ");
        //3.查询
        List<ServiceModuleDoc> list = serviceModuleDocService.find(example);

        List<ServiceModuleDocRetDTO> retList = dozerUtils.mapList(list,ServiceModuleDocRetDTO.class);
        return Result.success((new PageInfo<>(retList)));
    }


    @Override
    @ApiOperation(value = "获取帮助文档无分页", notes = "获取帮助文档无分页")
    @ApiResponses({
            @ApiResponse(code = 75000, message = "帮助文档不能为空"),
            @ApiResponse(code = 75001, message = "帮助文档模块ID不能为空"),
    })
    @RequestMapping(value = "/findMoudleDoc", method = RequestMethod.GET)
    @AppToken
    public Result<List<ServiceModuleDocRetDTO>> findMoudleDoc(ServiceModuleDocQueryDTO req) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.SERVICE_MODULE_DOC,req);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.SERVICE_MODULE_ID,String.valueOf(req.getModuleId()));

        //2.数据处理
        ServiceModuleDocExample example = new ServiceModuleDocExample();
        example.createCriteria().andModuleIdEqualTo(req.getModuleId())
                .andPublicIsEqualTo(req.getPublicIs())
                .andPublishStatusEqualTo(req.getPublishStatus())
                .andTitleLike(ServiceModuleDocExample.fullLike(req.getTitle()));
        example.setOrderByClause(" order_ asc , update_time desc ");
        //3.查询
        List<ServiceModuleDoc> list = serviceModuleDocService.find(example);

        List<ServiceModuleDocRetDTO> retList = dozerUtils.mapList(list,ServiceModuleDocRetDTO.class);
        return Result.success(retList);
    }
}
