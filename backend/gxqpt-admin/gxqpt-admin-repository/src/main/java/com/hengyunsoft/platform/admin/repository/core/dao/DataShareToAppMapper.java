package com.hengyunsoft.platform.admin.repository.core.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptShareAndAppInServiceDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataShareToAppMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.admin.entity.core.po.DataShareToApp, com.hengyunsoft.platform.admin.repository.core.example.DataShareToAppExample> {
    List<GxqptShareAndAppInServiceDO> selectAppByShare(String bizId);

    int deleteShare(@Param("deleteIds") List<String> deleteIds, @Param("id") String id);
}