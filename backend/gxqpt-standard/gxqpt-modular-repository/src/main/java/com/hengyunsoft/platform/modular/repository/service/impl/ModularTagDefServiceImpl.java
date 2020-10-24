package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularTagDef;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularTagDefMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularTagDefExample;
import com.hengyunsoft.platform.modular.repository.service.ModularTagDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Service
public class ModularTagDefServiceImpl extends BaseAllServiceImpl<Long, ModularTagDef, ModularTagDefExample> implements ModularTagDefService {
    @Autowired
    private ModularTagDefMapper modularTagDefMapper;

    @Override
    protected BaseNormalDao<Long, ModularTagDef, ModularTagDefExample> getDao() {
        return modularTagDefMapper;
    }

}
