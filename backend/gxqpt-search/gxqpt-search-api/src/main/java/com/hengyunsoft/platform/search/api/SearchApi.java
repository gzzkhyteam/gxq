package com.hengyunsoft.platform.search.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.search.api.hystrix.SearchApiHystrix;
import com.hengyunsoft.platform.search.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：
 *
 * @author gbl
 * @date 2018/4/8
 */
@FeignClient(name = "${gxqpt.feign.search-server:gxqpt-search-server}", fallback = SearchApiHystrix.class)
public interface SearchApi {

    /**
     * 描述：创建集合
     * 参数：集合信息
     * 返回值：创建成功的集合
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "/searchModule/createCollection", method = RequestMethod.POST)
    Result<CollectionDTO> createCollection(@RequestBody CollectionDTO collectionDTO);

    /**
     * 描述：增加索引或者更新索引
     * 参数：要创建索引的内容
     * 返回值：true 成功，false失败
     * 修改人：gbl
     * 修改时间：2018/4/8
     * 修改内容：
     */
    @RequestMapping(value = "/searchModule/addOrUpdateIndex", method = RequestMethod.POST)
    Result<Boolean> addOrUpdateIndex(@RequestBody IndexItemDTO indexItemDTO);


    @RequestMapping(value = "/searchModule/remove", method = RequestMethod.POST)
    Result<Boolean> remove(@RequestParam(value = "collection") String collection, @RequestParam(value = "id") String id);

    /**
     * 描述：搜索
     * 参数：搜索参数
     * 返回值：找到的内容
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "/searchModule/search", method = RequestMethod.POST)
    Result<SearchResDTO> search(@RequestBody SeacherParamDTO param);

    /**
     * 描述：搜索
     * 参数：搜索参数
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "/searchModule/searchNoVerify", method = RequestMethod.POST)
    Result<SearchResDTO> searchNoVerify(@RequestBody SeacherParamDTO seacherParamDTO);

    /**
     * 描述：关键字分析
     * 参数：keyWord索引分词  queryWord:查询词 collection:集合  field:字段，title(标题)，content(内容) ,
     * 返回值：返回分析结果
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "/searchModule/analysisField", method = RequestMethod.GET)
    Result<AnalysisResDTO> analysisField(@RequestParam("keyWord") String keyWord, @RequestParam("queryWord") String queryWord, @RequestParam("collection") String collection, @RequestParam("field") String field);
}
