package com.hengyunsoft.platform.developer.repository.fast.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.fast.po.FastBizConfig;
import com.hengyunsoft.platform.developer.repository.fast.example.FastBizConfigExample;

import java.util.List;

public interface FastBizConfigService extends BaseService<Long, FastBizConfig, FastBizConfigExample> {

    /**
     * 描述：根据id查询快速应用业务场景配置Api
     * 参数：parentId
     * 返回值：FastMenuDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    List<FastBizConfig> getBizConfig(Long parentId);

}
