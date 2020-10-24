package com.hengyunsoft.platform.warn.repository.service.impl;

import java.util.List;

import com.hengyunsoft.platform.warn.entity.domain.WarnScaleCountDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnScaleCountDTO;
import com.hengyunsoft.platform.warn.entity.po.WarnScaleStatistical;
import com.hengyunsoft.platform.warn.repository.dao.WarnScaleStatisticalMapper;
import com.hengyunsoft.platform.warn.repository.example.WarnScaleStatisticalExample;
import com.hengyunsoft.platform.warn.repository.service.WarnScaleStatisticalService;

@Service
public class WarnScaleStatisticalServiceImpl extends BaseAllServiceImpl<Long, WarnScaleStatistical, WarnScaleStatisticalExample> implements WarnScaleStatisticalService{

	@Autowired
	private WarnScaleStatisticalMapper warnScaleStatisticalMapper;

	@Override
	protected BaseNormalDao<Long, WarnScaleStatistical, WarnScaleStatisticalExample> getDao() {
		return warnScaleStatisticalMapper;
	}
	/**
	 * 单位预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	@Override
	public List<WarnScaleCountDTO> getScaleByOrgId(ScaleReqDTO scaleReqDTO) {
		return warnScaleStatisticalMapper.getScaleByOrgId(scaleReqDTO);
	}
	/**
	 * 部门预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	@Override
	public List<WarnScaleCountDTO> getScaleByDepId(ScaleReqDTO scaleReqDTO) {
		return warnScaleStatisticalMapper.getScaleByDepId(scaleReqDTO);
	}
	/**
	 * 人员预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	@Override
	public List<WarnScaleCountDTO> getScaleByEmpId(ScaleReqDTO scaleReqDTO) {
		return warnScaleStatisticalMapper.getScaleByEmpId(scaleReqDTO);
	}

	/**
	 * 人员预警产生、处理情况(预警)
	 * @param scaleReqDTO
	 * @return
	 */
	@Override
	public List<WarnScaleCountDO> getScaleByUserId(Long userId) {
		return warnScaleStatisticalMapper.getScaleByUserId(userId);
	}
}
