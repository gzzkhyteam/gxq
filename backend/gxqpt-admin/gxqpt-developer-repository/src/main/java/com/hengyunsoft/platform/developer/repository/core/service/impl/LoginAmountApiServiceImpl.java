package com.hengyunsoft.platform.developer.repository.core.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.core.po.LoginAmount;
import com.hengyunsoft.platform.developer.repository.core.dao.LoginAmountMapper;
import com.hengyunsoft.platform.developer.repository.core.example.LoginAmountExample;
import com.hengyunsoft.platform.developer.repository.core.service.LoginAmountApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAmountApiServiceImpl extends BaseServiceImpl<Long, LoginAmount, LoginAmountExample> implements LoginAmountApiService {

	@Autowired
	private LoginAmountMapper loginAmountMapper;
	
	@Override
	protected BaseNormalDao<Long, LoginAmount, LoginAmountExample> getDao() {
		return loginAmountMapper;
	}
}
