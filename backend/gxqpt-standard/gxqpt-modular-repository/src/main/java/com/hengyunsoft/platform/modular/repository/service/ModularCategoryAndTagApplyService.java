package com.hengyunsoft.platform.modular.repository.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularApply;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularApplyExample;

/**
 * @author wangs
 * @createTime 2018-4-5
 */
public interface ModularCategoryAndTagApplyService extends BaseAllService<Long, ModularApply, ModularApplyExample> {

	int saveModularApply(ModularApply modularApply);

}
