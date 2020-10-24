package com.hengyunsoft.platform.warn.repository.dao;

import java.util.List;

import com.hengyunsoft.platform.warn.entity.domain.WarnScaleCountDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnScaleCountDTO;

@Repository
public interface WarnScaleStatisticalMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.warn.entity.po.WarnScaleStatistical, com.hengyunsoft.platform.warn.repository.example.WarnScaleStatisticalExample> {
	/**
	 * 单位预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<WarnScaleCountDTO> getScaleByOrgId(@Param("scaleReqDTO")ScaleReqDTO scaleReqDTO);
	/**
	 * 部门预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<WarnScaleCountDTO> getScaleByDepId(@Param("scaleReqDTO")ScaleReqDTO scaleReqDTO);
	/**
	 * 人员预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<WarnScaleCountDTO> getScaleByEmpId(@Param("scaleReqDTO")ScaleReqDTO scaleReqDTO);

	/**
	 * 人员预警产生、处理情况(预警)
	 * @param userId
	 * @return
	 */
	List<WarnScaleCountDO> getScaleByUserId(Long userId);
}