package com.hengyunsoft.platform.warn.entity.domain;

import lombok.Data;

/**
 * 预警统计
 * @author sxy
 */
@Data
public class FairWarnCountDO {
	private String type;
	private String appName;
	private String appId;
	private Integer countNum;
}
