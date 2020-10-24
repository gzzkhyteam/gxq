package com.hengyunsoft.platform.supervise.repository.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSuperviseTypeMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseType, com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTypeExample> {

    /**
     * 根据父id查询id
     * @param parentId
     * @return
     */
    Long getIdByParentId(@Param("parentId")Long parentId);

    /**
     * 查询全责类型编码
     * @return
     */
    List<String> getCode(@Param("code")String code);
}