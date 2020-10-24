package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularCategoryDef;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularCategoryDefMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularCategoryDefExample;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Service
public class ModularCategoryDefServiceImpl extends BaseAllServiceImpl<Long, ModularCategoryDef, ModularCategoryDefExample> implements ModularCategoryDefService {
    @Autowired
    private ModularCategoryDefMapper modularCategoryDefMapper;

    @Override
    protected BaseNormalDao<Long, ModularCategoryDef, ModularCategoryDefExample> getDao() {
        return modularCategoryDefMapper;
    }

}
