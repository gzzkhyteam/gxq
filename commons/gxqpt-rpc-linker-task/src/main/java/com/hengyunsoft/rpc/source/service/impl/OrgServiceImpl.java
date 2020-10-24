package com.hengyunsoft.rpc.source.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.rpc.data.po.OrgPO;
import com.hengyunsoft.rpc.source.service.OrgService;
import com.hengyunsoft.sync.source.dao.BaseMapper;
import com.hengyunsoft.sync.source.service.impl.BaseServiceImpl;

@Service
public class OrgServiceImpl extends BaseServiceImpl<OrgPO,String> implements OrgService {

	@Autowired
	private BaseMapper<OrgPO> OrgMapper;

	@Override
	public BaseMapper<OrgPO> getBaseMapper() {
		return OrgMapper;
	}
}
