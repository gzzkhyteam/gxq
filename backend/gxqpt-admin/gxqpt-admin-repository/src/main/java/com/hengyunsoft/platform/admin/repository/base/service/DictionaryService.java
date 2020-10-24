package com.hengyunsoft.platform.admin.repository.base.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-01-24
 */
public interface DictionaryService extends BaseAllService<Long, Dictionary, DictionaryExample> {

    /**
     * 根据应用ID-appId、字典类型ID-typeId查询数据字典列表
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    List<Dictionary> findByTypeId(String appId, Long typeId);

    /**
     * 根据应用ID-appId、字典类型ID-typeId删除数据字典表信息
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    int deleteByAppIdAndTypeId(String appId, Long typeId);

    /**
     * 根据应用ID-appId、字典类型ID-typeIds查询数据字典列表
     *
     * @param appId 应用id、typeId数据字典类型id
     */
    List<List<Dictionary>> findByTypeId(String appId, Long typeIds[]);

    /**
     * 根据应用ID-appId、字典类型ID-typeCodes查询数据字典列表
     *
     * @param appId 应用id、typeCodes数据字典类型code
     */
    List<List<Dictionary>> findByTypeCode(String typeIds[]);

    /**
     * 查询唯一code
     *
     * @param code
     * @return
     */
    Dictionary findByCode(String code);

    /**
     * 根据名字查询
     *
     * @param name
     * @return
     * @modify: madb
     * @Time:2018/4/10
     */
    Dictionary findByName(String name);

    /**
     * 根据名字查询
     *
     * @param dictionary
     * @return
     * @modify: madb
     * @Time:2018/4/10
     */
    int delById(Dictionary dictionary);

    /**
     * 根据code查询数据字典(默认加appId)
     *
     * @param code,appId
     * @return
     */
    List<Dictionary> findByCodeList(String appId, String code);

    /**
     * 应用类型维护 修改
     *
     * @param dictionary
     * @return
     */
    int updateDictionaryById(Dictionary dictionary);

    /**
     * 应用类型维护 保存
     *
     * @param dictionary
     * @return
     */
    int saveDictionaryById(Dictionary dictionary);

    /**
     * 根据应用ID-appId、字典类型ID-typeCodes查询数据字典列表
     *
     * @param appId 应用id、typeCodes数据字典类型code
     */
    List<Dictionary> findByTypeCode(String typeCode);

    /**
     * 查询单位的所有字典
     *
     * @return
     */
    List findOrgDictionary();

    /**
     * 应用类型维护查询
     *
     * @return
     */
    List findAppMaintainPage(String typeCode, String appId);

    /**
     * 功能类型维护查询
     *
     * @param typeCode
     * @param
     * @return
     */
    List findModMaintainPage(String typeCode, String appId);

    /**
     * 判断字典code是否存在
     * @param appId
     * @param code
     * @return
     */
    boolean check( String code,String typeCode);
}
