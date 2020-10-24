package com.hengyunsoft.platform.supervise.repository.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.entity.po.ServerSupervise;
import com.hengyunsoft.platform.supervise.repository.example.ServerSuperviseExample;

import java.util.List;

public interface ServerSuperviseService extends BaseService<Long,ServerSupervise,ServerSuperviseExample> {

    /**
     * 查询符合当前时间，并且为启用状态
     * @return
     */
    List<ServerSupervise> getUsableConfig();
}
