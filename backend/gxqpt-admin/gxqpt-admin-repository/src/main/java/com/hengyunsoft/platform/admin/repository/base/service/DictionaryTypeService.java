package com.hengyunsoft.platform.admin.repository.base.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.admin.entity.base.po.DictionaryType;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryTypeExample;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-01-24
 */
public interface DictionaryTypeService extends BaseAllService<Long, DictionaryType, DictionaryTypeExample>{

    /**
     * 根据应用ID-appId、字典編碼檢查数据字典是否已存在
     *
     * @param appId 应用id 、code字典编码
     */
    boolean check( String code);

    /**
     * 根据应用ID-appId查詢数据字典類型列表
     *
     * @param appId 应用id
     */
    List<DictionaryType> find(String appId);

    /**
     * 查询数据字典類型列表
     * @param appId,parentId  上级区域ID
     */
    List<DictionaryType> findByParentId(String appId,Long parentId);


    /**
     * 查询数据字典類型及子类型
     * @param id 主键id
     */
    List<DictionaryType> getSubDictionaryList(String appId,Long id);

}
