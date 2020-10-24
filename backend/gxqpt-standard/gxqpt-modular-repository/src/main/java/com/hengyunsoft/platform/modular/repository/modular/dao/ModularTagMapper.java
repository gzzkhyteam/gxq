package com.hengyunsoft.platform.modular.repository.modular.dao;

import org.springframework.stereotype.Repository;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Repository
public interface ModularTagMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.modular.entity.modular.po.ModularTag, com.hengyunsoft.platform.modular.repository.modular.example.ModularTagExample> {
    /**
     * 根据模块id删除该模块的所有标签
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author wangs
     */
    void deleteTagsByModularId(Long id);
}