package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.LoginLogHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogListDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogMaxDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.ResponseLoginLogListDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = LoginLogHystrix.class)
public interface LoginLogApi  {
	
	@RequestMapping("loginLog/add")
	public Result<Long> addLoginLog(@RequestBody LoginLogDTO loginLogDTO);
	
	@RequestMapping("loginLog/saveLogoutLog")
	public void saveLogoutLog(@RequestParam("masterLogId") Long masterLogId,@RequestParam("logoutTime")  long logoutTime);

	@RequestMapping(value = "loginLog/findByAppId", method = RequestMethod.GET)
	public Result<List<LoginLogMaxDTO>> findByAppId(@RequestParam("appId") String appId,@RequestParam("beginDate")String beginDate);

	@RequestMapping(value = "loginLog/findByAppIdAndLoginDate", method = RequestMethod.GET)
    Result<List<LoginLogMaxDTO>> findByAppIdAndLoginDate(@RequestParam("appId") String appId,
                                                         @RequestParam("beginDate") String beginDate);

    /**
	 * 获取分页列表
	 * @param openApiReq
	 * @return
	 */
	@RequestMapping(value = "/loginLog/page", method = RequestMethod.POST)
	Result<PageInfo<ResponseLoginLogListDTO>> page(@RequestBody OpenApiReq<LoginLogListDTO> openApiReq);
}