package com.hengyunsoft.platform.warn.repository.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.warn.entity.domain.FairWarnTimeSlotCountDO;
import com.hengyunsoft.platform.warn.entity.po.WarnTimeSlot;
import com.hengyunsoft.platform.warn.repository.example.WarnTimeSlotExample;

public interface WarnTimeSlotService extends BaseService<Long, WarnTimeSlot, WarnTimeSlotExample>{
    /**
     * 数博会统各月份预警数量
     * @return
     */
	List<FairWarnTimeSlotCountDO> getTimeSlotByAppId(String appid);
	/**
	 * 应用预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	List<FairWarnTimeSlotCountDO> getScaleByAppId(ScaleReqDTO scaleReqDTO);
}
