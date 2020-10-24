package com.hengyunsoft.platform.ops.repository.application.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.application.po.ApplicationUpdate;
import com.hengyunsoft.platform.ops.repository.application.example.ApplicationUpdateExample;

import java.util.List;
import java.util.Map;

public interface ApplicationUpdateService extends BaseService<Long,ApplicationUpdate,ApplicationUpdateExample> {
    /**
     * 查询应用升级分页信息
     * @param
     */
    List<ApplicationUpdate> getPageList(Map map);
}
