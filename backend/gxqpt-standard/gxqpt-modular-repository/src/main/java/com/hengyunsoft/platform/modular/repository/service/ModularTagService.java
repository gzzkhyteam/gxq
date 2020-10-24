package com.hengyunsoft.platform.modular.repository.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularTag;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularTagExample;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
public interface ModularTagService extends BaseAllService<Long, ModularTag, ModularTagExample> {
    /**
     * 根据模块id删除该模块的所有标签
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author wangs
     */
    void deleteTagsByModularId(Long id);
}
