package com.hengyunsoft.platform.admin.repository.base.dao;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.platform.admin.entity.base.po.Area;
import com.hengyunsoft.platform.admin.repository.base.example.AreaExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AreaMapper extends BaseNormalDao<Long, Area, AreaExample> {

    /**
     * 查询区域及子区域ID,名称列表
     * @param parentId  上级区域ID
     */
    List<Area> findByParentId(@Param("parentId") Long parentId);

    int deleteAllById(@Param("id") Long id);

    List findAreaForExcel();
}