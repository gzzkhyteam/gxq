package com.hengyunsoft.platform.developer.repository.fast.dao;

import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FastMenuMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.developer.entity.fast.po.FastMenu, com.hengyunsoft.platform.developer.repository.fast.example.FastMenuExample> {

    List<FastMenu> getMenu(@Param("parentId")Long parentId, @Param("appId")String appId);

    void deleteByAppId(String appId);
}