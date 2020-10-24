package com.hengyunsoft.platform.developer.api.screen.api;

import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.dto.hostruning.HostRuningDTO;

/**
 * 
 * 主机运行时的信息   用于大屏的运维监控
 * @author 潘定遥
 *
 */
public interface HostRuningInfoApi {
	
	/**
	 * 获取主机运行时信息
	 * @return
	 */
	public Result<Map<String,List<Double>>> getHostRuningInfo();
	
	public Result<List<HostRuningDTO>> getHostLoadTop();
}
