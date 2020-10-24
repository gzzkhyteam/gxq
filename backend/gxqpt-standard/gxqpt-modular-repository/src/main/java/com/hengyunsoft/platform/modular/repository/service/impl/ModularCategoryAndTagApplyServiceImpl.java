package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularApply;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularApplyMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularApplyExample;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryAndTagApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
@Service
public class ModularCategoryAndTagApplyServiceImpl extends BaseAllServiceImpl<Long, ModularApply, ModularApplyExample> implements ModularCategoryAndTagApplyService {
    @Autowired
    private ModularApplyMapper modularApplyMapper;

    @Override
    protected BaseNormalDao<Long, ModularApply, ModularApplyExample> getDao() {
        return modularApplyMapper;
    }

	@Override
	public int saveModularApply(ModularApply modularApply) {
		
		return modularApplyMapper.insertSelective(modularApply);
	}

}
