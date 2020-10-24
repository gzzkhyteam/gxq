package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularTag;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularTagMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularTagExample;
import com.hengyunsoft.platform.modular.repository.service.ModularTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Service
public class ModularTagServiceImpl extends BaseAllServiceImpl<Long, ModularTag, ModularTagExample> implements ModularTagService {

    @Autowired
    private ModularTagMapper modularTagMapper;

    @Override
    protected BaseNormalDao<Long, ModularTag, ModularTagExample> getDao() {
        return modularTagMapper;
    }

    /**
     * 根据模块id删除该模块的所有标签
     *
     * @param id 模块id
     * @createTime 2018-4-5
     * @author wangs
     */
    @Override
    public void deleteTagsByModularId(Long id) {
        modularTagMapper.deleteTagsByModularId(id);
    }
}
