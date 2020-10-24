package com.hengyunsoft.platform.admin.repository.base.dao;

import com.hengyunsoft.platform.admin.entity.base.po.DictionaryType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryTypeMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.admin.entity.base.po.DictionaryType, com.hengyunsoft.platform.admin.repository.base.example.DictionaryTypeExample> {
    /**
     * 查询数据字段类型列表
     * @param parentId  上级区域ID
     */
    List<DictionaryType> findByParentId(@Param("appId") String appId,@Param("parentId") Long parentId);
}