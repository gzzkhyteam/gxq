package com.hengyunsoft.platform.warn.repository.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.warn.entity.domain.FairWarnTimeSlotCountDO;

@Repository
public interface WarnTimeSlotMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.warn.entity.po.WarnTimeSlot, com.hengyunsoft.platform.warn.repository.example.WarnTimeSlotExample> {
    /**
     * 数博会统各月份预警数量
     * @return
     */
	List<FairWarnTimeSlotCountDO> getTimeSlotByAppId(@Param(value = "appid")String appid);
	/**
	 * 应用预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<FairWarnTimeSlotCountDO> getScaleByAppId(@Param(value = "scaleReqDTO")ScaleReqDTO scaleReqDTO);
}