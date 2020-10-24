package com.hengyunsoft.platform.developer.impl.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModuleDoc;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResource;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResourceDoc;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleApplyService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceResourceDocService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceResourceService;
import com.hengyunsoft.platform.developer.repository.service.service.ServiceModuleDocService;
import com.hengyunsoft.platform.search.queue.SearchQueueProducer;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
import com.hengyunsoft.platform.search.queue.dto.IndexItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * com.hengyunsoft.platform.developer.utils
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：基础公共类
 * 修改人：sunxiaoya
 * 修改时间：2018/8/24
 * 修改内容：
 */
@Slf4j
@Component
public class ServiceModuleCommon {

    @Autowired
    ServiceModuleApplyService serviceModuleApplyService;

    @Autowired
    ServiceModuleService serviceModuleService;

    @Autowired
    ServiceResourceService serviceResourceService;

    @Autowired
    ServiceResourceDocService serviceResourceDocService;

    @Autowired
    ServiceModuleDocService serviceModuleDocService;

    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    SearchQueueProducer searchQueueProducer;

    /**
     * 使用RestTemplate获取返回值
     * @param url
     * @return
     */
    public String getSwaggerJsonStr(String url){
        //复杂构造函数的使用
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000);// 设置超时
        requestFactory.setReadTimeout(1000);

        RestTemplate client = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();

        //请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();

        //params.add("username", "用户名");
        //params.add("password", "123456");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return  response.getBody();
    }

    /**
     * 校验swagger地址的有效性
     * @param swaggerUrl
     * @return
     */
    public String validateSwaggerUrl(String swaggerUrl){
        String result = null;
        String jsonStr = null;
        try {
            jsonStr = getSwaggerJsonStr(swaggerUrl);
            JSON.parse(jsonStr);
        } catch (Exception e) {
            log.error("通过swagger地址获取json字符串[{}]异常,{}",jsonStr,e);
            result = "swagger地址填写有误!!";
        }
        if(jsonStr==null){
            return result;
        }
        if(!jsonStr.contains("tags")&&!jsonStr.contains("paths")&&!jsonStr.contains("definitions")){
            result = "入参swagger地址（"+jsonStr+"）错误，请检查swagger地址的正确性！！";
        }
        return result;
    }

    /**
     * 删除服务监控API索引
     */
    public void deleteServiceResource(Long moduleId){
        List<ServiceResource>  srList = serviceResourceService.getByModuleId(moduleId);
        if(srList!=null&&srList.size()>0){
            for(ServiceResource li:srList){
                //删除服务监控API索引
                DeleteIndexDTO dto = new DeleteIndexDTO();
                dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_FWJK_API+"_"+li.getId());
                searchQueueProducer.deleteIndex(dto);
                log.info("删除服务监控API索引,dto[{}]",dto);
                serviceResourceService.deleteById(li.getId());
            }
        }
    }

    /**
     * 删除帮助文档索引
     */
    public void deleteServerModuleDocIndex(Long moduleId){
        List<ServiceModuleDoc> list = serviceModuleDocService.getByModuleId(moduleId);
        if(list!=null&&list.size()>0){
            for(ServiceModuleDoc li:list){
                DeleteIndexDTO dto = new DeleteIndexDTO();
                dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC+"_"+li.getId());
                log.info("删除帮助文档索引,dto[{}]",dto);
                searchQueueProducer.deleteIndex(dto);
            }
        }
    }

    /**
     * 新增帮助文档索引
     */
    public void addServerModuleDocIndex(Long moduleId){
        List<ServiceModuleDoc> list = serviceModuleDocService.getByModuleId(moduleId);
        if(list!=null&&list.size()>0){
            for(ServiceModuleDoc li:list){
                if(li!=null){
                    Map<String,String> map = (Map<String,String>)JSON.parse(li.getJsonContent());
                    if(map!=null){
                        IndexItemDTO dto = new IndexItemDTO();
                        dto.setAppId(BaseContextHandler.getAppId());
                        dto.setBizId(String.valueOf(li.getId()));
                        dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                        dto.setContent(map.get("searchContent"));
                        dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC+"_"+li.getId());
                        dto.setTitle(map.get("searchTitle"));
                        dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_HELP_DOC);
                        dto.setUrl("/module/helpDoc"+"?moduleId="+li.getModuleId()+"&id="+li.getId());
                        log.info("帮助文档新增索引,dto[{}]",dto);
                        searchQueueProducer.addOrUpdateIndex(dto);
                    }
                }
            }
        }
    }



    /**
     * 处理swagger字符串
     * @param swaggerUrl
     * @param moduleId
     * @param appId
     * @param
     * @return
     */
    public void updateSwaggerJsonStr(String swaggerUrl, Long moduleId, String appId){
        String jsonStr = getSwaggerJsonStr(swaggerUrl);
        try {
            //将json字符串转为map
            Map<String, Object> maps = (Map<String, Object>) JSON.parse(jsonStr);

            //处理paths
            JSONObject pathsJsonObj =  (JSONObject)maps.get("paths");

            //方法value集合
            List<JSONObject> methodList = new ArrayList<JSONObject>();

            //方法key集合
            List<String> methodKeyList = new ArrayList<String>();

            //地址集合
            List<String> urlList = new ArrayList<String>();
            List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

            List<Map<String, Object>> msgList = new ArrayList<Map<String, Object>>();

            //处理paths key 过滤非code数据
            Set<String> sIterator = pathsJsonObj.keySet();
            for (String key:sIterator){
                //urlList.add(key);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(key,pathsJsonObj.get(key));
                mapList.add(map);
                JSONObject methodJsonObj = (JSONObject)pathsJsonObj.get(key);

                //处理方法key 封装所需要的key
                Set<String> method = methodJsonObj.keySet();
                for (String methodKey:method){
                    urlList.add(key);
                    methodKeyList.add(methodKey);
                    methodList.add((JSONObject)methodJsonObj.get(methodKey));
                }
            }

            //更新swagger情况，需要查询API信息并删除
            deleteServiceResource(moduleId);

            //更新swagger情况，需要先删除服务资源文档信息
            ServiceResourceDoc srd = serviceResourceDocService.getByModuleId(moduleId);
            if(srd!=null){
                serviceResourceDocService.deleteById(srd.getId());
            }

            for(int i=0;i<methodList.size();i++){
                String name = methodList.get(i).get("summary") == null? null : methodList.get(i).get("summary").toString();
                String desc = methodList.get(i).get("description") == null ? null : methodList.get(i).get("description").toString();
                String url = urlList.get(i);
                String method = methodKeyList.get(i);
                ServiceResource serviceResource = new ServiceResource();
                serviceResource.setAppId(appId);
                serviceResource.setModuleId(moduleId);
                serviceResource.setUrl(url);
                serviceResource.setDesc(desc);
                serviceResource.setName(name);
                serviceResource.setHttpMethod(method);
                serviceResource.setCreateUser(BaseContextHandler.getAdminId());
                serviceResource.setCreateTime(new Date());

                //组装url,method集合
                Map<String, Object> urlAndMethodMap = new HashMap<String, Object>();
                urlAndMethodMap.put("url",urlList.get(i));
                urlAndMethodMap.put("method",methodKeyList.get(i));
                msgList.add(urlAndMethodMap);

                //保存服务资源信息
                ServiceResource sr = serviceResourceService.save(serviceResource);

                //服务监控系统API新增索引
                IndexItemDTO dto = new IndexItemDTO();
                dto.setAppId(BaseContextHandler.getAppId());
                dto.setBizId(String.valueOf(sr.getId()));
                dto.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                dto.setContent(sr.getDesc());
                dto.setExt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                dto.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_FWJK_API+"_"+sr.getId());
                dto.setTitle(sr.getName());
                dto.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_FWJK_API);
                dto.setUrl("/module/apiDoc"+"?moduleId="+moduleId);
                searchQueueProducer.addOrUpdateIndex(dto);
            }

            ServiceResourceDoc serviceResourceDoc = new ServiceResourceDoc();
            serviceResourceDoc.setModuleId(moduleId);
            serviceResourceDoc.setCreateTime(new Date());
            serviceResourceDoc.setCreateUser(BaseContextHandler.getAdminId());
            serviceResourceDoc.setJsonContent(jsonStr);
            serviceResourceDoc.setJsonMsg(null);

            //保存服务资源文档信息
            serviceResourceDocService.save(serviceResourceDoc);
        } catch (Exception e) {
            log.error("处理swagger地址异常[{}]",e);
        }
    }
}
