package com.hengyunsoft.platform.admin.api.base.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.DictionaryApi;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


/**
 * feign 熔断机制的实现， 默认返回超时响应
 * @author tianai
 * @createTime 2018-01-24
 */
@Component
public class DictionaryApiHystrix implements DictionaryApi{


    /**
     * 根据类型id查询数据字典信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<DictionaryDTO>> getList(Long typeId) {
        return Result.timeout();
    }

    /**
     * 根据字典编码-code查询数据字典列表
     * @return  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<DictionaryDTO>> getCodeList(String code) {
        return Result.timeout();
    }

    /**
     * 根据主键id查询数据字典信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<DictionaryDTO> get(Long id) {
        return Result.timeout();
    }
    /**
     * 查询数据字典分页信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<PageInfo<DictionaryDTO>> page(@RequestBody OpenApiReq<DictionaryPageReqDTO> openApiReq) {
        return Result.timeout();
    }
    /**
     * 保存数据字典信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<DictionaryDTO> save(DictionarySaveDTO dictionarySaveDto) {
        return Result.timeout();
    }
    /**
     * 修改数据字典信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> update(DictionaryUpdateDTO dictionaryUpdateDto) {
        return Result.timeout();
    }

    /**
     * 删除数据字典信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> delete(Long id) {
        return Result.timeout();
    }
    /**
     * 更新数据字典类型信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> updateType(DictionaryTypeUpdateDTO dictionaryTypeUpdateDto) {
        return Result.timeout();
    }

    /**
     * 根据id查询数据字典类型信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<DictionaryTypeDTO> getType(Long id) {
        return Result.timeout();
    }
    /**
     * 查询数据字典类型list信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<DictionaryTypeDTO>> listType() {
        return Result.timeout();
    }
    /**
     * 查询数据字典类型分页信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<PageInfo<DictionaryTypeDTO>> pageType(@RequestBody  OpenApiReq<DictionaryTypePageReqDTO> openApiReq) {
        return Result.timeout();
    }
    /**
     *保存数据字典类型分页信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<DictionaryTypeDTO> saveType(DictionaryTypeSaveDTO dictionaryTypeSaveDto) {
        return Result.timeout();
    }
    /**
     *删除数据字典类型分页信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> deleteType(Long id,String appId) {
        return Result.timeout();
    }

    @Override
    public Result<Map<String, Map<String, String>>> findDictionary(String[] typeCode) { return Result.timeout(); }

    @Override
    public Result<List<DictionaryTreeDTO>> dictionaryTree(String appId,Long parentId) {
        return Result.timeout();
    }

    @Override
    public Result<List<DictionaryDTO>> getCodeListNoAppId(String code) {
        return Result.timeout();
    }
}
