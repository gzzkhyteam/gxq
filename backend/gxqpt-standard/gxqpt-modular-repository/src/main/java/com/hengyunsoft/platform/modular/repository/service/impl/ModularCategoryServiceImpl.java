package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularCategory;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularCategoryMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularCategoryExample;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Service
public class ModularCategoryServiceImpl extends BaseAllServiceImpl<Long, ModularCategory, ModularCategoryExample> implements ModularCategoryService {
    @Autowired
    private ModularCategoryMapper modularCategoryMapper;

    @Override
    protected BaseNormalDao<Long, ModularCategory, ModularCategoryExample> getDao() {
        return modularCategoryMapper;
    }

    /**
     * 根据模块id删除该模块的所有分类信息
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author wangs
     */
    @Override
    public void deleteCategorysByModularId(Long id) {
        modularCategoryMapper.deleteCategorysByModularId(id);
    }
}
