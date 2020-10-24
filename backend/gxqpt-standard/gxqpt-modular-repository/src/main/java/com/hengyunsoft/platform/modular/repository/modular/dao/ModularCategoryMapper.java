package com.hengyunsoft.platform.modular.repository.modular.dao;

import org.springframework.stereotype.Repository;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Repository
public interface ModularCategoryMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.modular.entity.modular.po.ModularCategory, com.hengyunsoft.platform.modular.repository.modular.example.ModularCategoryExample> {
    /**
     * 根据模块id删除该模块的所有分类信息
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author wangs
     */
    void deleteCategorysByModularId(Long id);
}