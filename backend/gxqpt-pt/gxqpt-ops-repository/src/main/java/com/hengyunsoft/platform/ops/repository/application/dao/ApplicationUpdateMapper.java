package com.hengyunsoft.platform.ops.repository.application.dao;

import com.hengyunsoft.platform.ops.entity.application.po.ApplicationUpdate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApplicationUpdateMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, ApplicationUpdate, com.hengyunsoft.platform.ops.repository.application.example.ApplicationUpdateExample> {

    /**
     * 查询应用升级分页信息
     * @param
     */
    List<ApplicationUpdate> getPageList(Map map);
}