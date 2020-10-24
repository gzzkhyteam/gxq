package com.hengyunsoft.platform.admin.repository.org.gxqpt.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptSystemMapper extends com.hengyunsoft.base.dao.BaseNormalDao<String, GxqptSystem, GxqptSystemExample> {

    /**
     * 删除体系信息
     * @param id
     * @return
     */
    int deleteSystem(@Param("id")String id);

    /**
     * 根据来源查询体系信息
     * @return
     */
    List<String> getBySource();
}