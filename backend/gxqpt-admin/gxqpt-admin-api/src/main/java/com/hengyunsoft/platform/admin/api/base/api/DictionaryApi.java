package com.hengyunsoft.platform.admin.api.base.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hengyunsoft.platform.admin.api.base.api.hystrix.DictionaryApiHystrix;

import java.util.List;
import java.util.Map;


/**
 * @author tianai
 * @createTime 2018-01-24
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = DictionaryApiHystrix.class)
public interface DictionaryApi {

    /**
     * 根据类型ID-typeid查询数据字典列表
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/dictionary/getList", method = RequestMethod.GET)
    Result<List<DictionaryDTO>> getList(@RequestParam(value = "typeId") Long typeId);

    /**
     * 根据字典编码-code查询数据字典列表
     * @param code
     * @return
     */
    @RequestMapping(value = "/dictionary/getCodeList", method = RequestMethod.GET)
    Result<List<DictionaryDTO>> getCodeList(@RequestParam(value = "code") String code);

    /**
     * 根据id + token 查数据字典
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/dictionary/get", method = RequestMethod.GET)
    Result<DictionaryDTO> get(@RequestParam(value = "id") Long id);


    /**
     * 查询数据字典分页信息
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/dictionary/page", method = RequestMethod.POST)
    Result<PageInfo<DictionaryDTO>> page(@RequestBody OpenApiReq<DictionaryPageReqDTO> openApiReq);

    /**
     * 保存数据字典
     *
     * @param dictionarySaveDto
     * @return
     */
    @RequestMapping(value = "/dictionary/save", method = RequestMethod.POST)
    Result<DictionaryDTO> save(@RequestBody DictionarySaveDTO dictionarySaveDto);

    /**
     * 修改数据字典
     *
     * @param dictionaryUpdateDto
     * @return
     */
    @RequestMapping(value = "/dictionary/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody DictionaryUpdateDTO dictionaryUpdateDto);

    /**
     * 删除数据字典
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/dictionary/delete", method = RequestMethod.POST)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 根据id + token 查数据字典类型
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/dictionary/getType", method = RequestMethod.GET)
    Result<DictionaryTypeDTO> getType(@RequestParam(value = "id") Long id);

    /**
     *  查数据字典类型List
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/dictionary/listType", method = RequestMethod.GET)
    Result<List<DictionaryTypeDTO>> listType();

    /**
     * 查询数据字典类型分页信息
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/dictionary/pageType", method = RequestMethod.POST)
    Result<PageInfo<DictionaryTypeDTO>> pageType(@RequestBody  OpenApiReq<DictionaryTypePageReqDTO> openApiReq);

    /**
     * 保存数据字典类型
     *
     * @param dictionaryTypeSaveDto
     * @return
     */
    @RequestMapping(value = "/dictionary/saveType", method = RequestMethod.POST)
    Result<DictionaryTypeDTO> saveType(@RequestBody DictionaryTypeSaveDTO dictionaryTypeSaveDto);

    /**
     * 修改数据字典类型传入的字段， 未传入的字段不修改
     *
     * @param dictionaryTypeUpdateDto
     * @return
     */
    @RequestMapping(value = "/dictionary/updateType", method = RequestMethod.POST)
    Result<Boolean> updateType(@RequestBody DictionaryTypeUpdateDTO dictionaryTypeUpdateDto);

    /**
     * 删除数据字典类型
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/dictionary/deleteType", method = RequestMethod.POST)
    Result<Boolean> deleteType(@RequestParam(value = "id") Long id,@RequestParam(value = "appId") String appId);

    /**
     * 查找下拉字典
     *
     * @param typeCode
     * @return
     */
    @RequestMapping(value = "/api/developer/dictionary/findDictionary", method = RequestMethod.GET)
    Result<Map<String, Map<String, String>>> findDictionary(@RequestParam(value = "typeCode[]") String[] typeCode);
    /**
     * 查询数据字段树列表
     *
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/dictionary/dictionaryTree", method = RequestMethod.GET)
    Result<List<DictionaryTreeDTO>> dictionaryTree(@RequestParam(value = "appId") String  appId,@RequestParam(value = "parentId") Long parentId);

    /**
     * 根据字典编码-code查询数据字典列表(不过滤appid)
     * @param code
     * @return
     */
    @RequestMapping(value = "/dictionary/getCodeListNoAppId", method = RequestMethod.GET)
    Result<List<DictionaryDTO>> getCodeListNoAppId(@RequestParam(value = "code") String code);

}
