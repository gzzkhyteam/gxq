package com.hengyunsoft.platform.warn.repository.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.warn.entity.domain.FairWarnTimeSlotCountDO;
import com.hengyunsoft.platform.warn.entity.po.WarnTimeSlot;
import com.hengyunsoft.platform.warn.repository.dao.WarnTimeSlotMapper;
import com.hengyunsoft.platform.warn.repository.example.WarnTimeSlotExample;
import com.hengyunsoft.platform.warn.repository.service.WarnTimeSlotService;

@Service
public class WarnTimeSlotServiceImpl extends BaseAllServiceImpl<Long, WarnTimeSlot, WarnTimeSlotExample> implements WarnTimeSlotService{
	@Autowired
	private WarnTimeSlotMapper warnTimeSlotMapper;
	@Override
	protected BaseNormalDao<Long, WarnTimeSlot, WarnTimeSlotExample> getDao() {		
		return warnTimeSlotMapper;
	}
    /**
     * 数博会统各月份预警数量
     * @return
     */
	@Override
	public List<FairWarnTimeSlotCountDO> getTimeSlotByAppId(String appid) {
		return warnTimeSlotMapper.getTimeSlotByAppId(appid);
	}
	/**
	 * 应用预警产生、处理情况
	 * @param scaleReqDTO
	 * @return
	 */
	@Override
	public List<FairWarnTimeSlotCountDO> getScaleByAppId(ScaleReqDTO scaleReqDTO) {
		return warnTimeSlotMapper.getScaleByAppId(scaleReqDTO);
	}

}
