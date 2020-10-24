package com.hengyunsoft.platform.developer.repository.core.service.impl;


import com.hengyunsoft.platform.developer.entity.apply.po.domain.DependRelationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.core.domain.DependRelationStatisticsDO;
import com.hengyunsoft.platform.developer.entity.core.po.DependRelation;
import com.hengyunsoft.platform.developer.repository.core.dao.DependRelationMapper;
import com.hengyunsoft.platform.developer.repository.core.example.DependRelationExample;
import com.hengyunsoft.platform.developer.repository.core.service.DependRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

@Service
public class DependRelationServiceImpl extends BaseServiceImpl<Long, DependRelation, DependRelationExample> implements DependRelationService {

	@Autowired
	private DependRelationMapper dependRelationMapper;
	
	@Override
	protected BaseNormalDao<Long, DependRelation, DependRelationExample> getDao() {
		return dependRelationMapper;
	}


    @Override
    public List<DependRelationDO> getUseInfo(String strDate) {
        return dependRelationMapper.getUseInfo(strDate);
    }
	/**
	 * 总降本率查询
	 * @return
	 */
	@Override
	public String getReduced() {
		return dependRelationMapper.getReduced();
	}
	/**
	 * farglory
	 * 降本提质-成本统计
	 * @return
	 */
	@Override
	public List<DependRelationStatisticsDO> findApplicationReduceCost() {
		return dependRelationMapper.findApplicationReduceCost();
	}
	/**
	 * farglory
	 * 降本提质-工期统计
	 * @return
	 */
	@Override
	public List<DependRelationStatisticsDO>  findApplicationReduceTime() {
		return dependRelationMapper.findApplicationReduceTime();
	}
}
