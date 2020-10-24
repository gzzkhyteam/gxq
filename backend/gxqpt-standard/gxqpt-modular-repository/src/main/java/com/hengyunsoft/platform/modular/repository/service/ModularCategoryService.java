package com.hengyunsoft.platform.modular.repository.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularCategory;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularCategoryExample;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
public interface ModularCategoryService extends BaseAllService<Long, ModularCategory, ModularCategoryExample> {
    /**
     * 根据模块id删除该模块的所有分类信息
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author wangs
     */
    void deleteCategorysByModularId(Long id);
}
