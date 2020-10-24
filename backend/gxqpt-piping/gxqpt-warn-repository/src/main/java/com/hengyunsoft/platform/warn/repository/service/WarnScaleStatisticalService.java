package com.hengyunsoft.platform.warn.repository.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnScaleCountDTO;
import com.hengyunsoft.platform.warn.entity.domain.WarnScaleCountDO;
import com.hengyunsoft.platform.warn.entity.po.WarnScaleStatistical;
import com.hengyunsoft.platform.warn.repository.example.WarnScaleStatisticalExample;

public interface WarnScaleStatisticalService extends BaseService<Long, WarnScaleStatistical, WarnScaleStatisticalExample>{

	/**
	 * 单位预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<WarnScaleCountDTO> getScaleByOrgId(ScaleReqDTO scaleReqDTO);
	/**
	 * 部门预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<WarnScaleCountDTO> getScaleByDepId(ScaleReqDTO scaleReqDTO);
	/**
	 * 人员预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<WarnScaleCountDTO> getScaleByEmpId(ScaleReqDTO scaleReqDTO);

	/**
	 * 人员预警产生、处理情况(预警)
	 * @param userId
	 * @return
	 */
	List<WarnScaleCountDO> getScaleByUserId(Long userId);
}
