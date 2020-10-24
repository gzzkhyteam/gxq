package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.LoginLogApi;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogListDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.LoginLogMaxDTO;
import com.hengyunsoft.platform.admin.api.core.dto.loginlog.ResponseLoginLogListDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginLogHystrix implements LoginLogApi {

	@Override
	public Result<Long> addLoginLog(LoginLogDTO loginLogDTO) {
		return Result.timeout();
	}

	@Override
	public void saveLogoutLog(Long logId, long logoutTime) {
		
	}

	@Override
	public Result<List<LoginLogMaxDTO>> findByAppId(String appId, String beginDate) {
		return Result.timeout();
	}

	@Override
	public Result<List<LoginLogMaxDTO>> findByAppIdAndLoginDate(String appId, String beginDate) {
		return Result.timeout();
	}

	@Override
	public Result<PageInfo<ResponseLoginLogListDTO>> page(OpenApiReq<LoginLogListDTO> openApiReq) {
		return Result.timeout();
	}
}