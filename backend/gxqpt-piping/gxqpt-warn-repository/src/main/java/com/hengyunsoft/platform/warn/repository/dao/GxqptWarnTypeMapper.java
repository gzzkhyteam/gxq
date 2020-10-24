package com.hengyunsoft.platform.warn.repository.dao;

import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GxqptWarnTypeMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.warn.entity.po.GxqptWarnType, com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample> {
    /**
     * 查询预警类型
     * @return
     */
    List<Map<String,Object>> getWarnType();

    /**
     * 查询预警类型编码
     * @return
     */
    List<String> getCode(@Param("code")String code);

    /**
     * 根据父id查询id
     * @param parentId
     * @return
     */
    Long getIdByParentId(@Param("parentId")Long parentId);

    /**
     * 查询所有的id，父id，类型名称
     * @param isEnable
     * @return
     */
    List<Map<String,Object>> getTypeAll(@Param("isEnable") Boolean isEnable);

    /**
     * 查询预警所有类型,非一级菜单
     * @return
     */
    List<Map<String,Object>> getWarnTypeList();
}