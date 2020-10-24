package com.hengyunsoft.platform.controller.sso;

import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.minlog.Log;
import com.hengyunsoft.commons.exception.core.CenterExceptionCode;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.controller.sso.SSOLoginController.SSOLoginInfo;
import com.hengyunsoft.platform.loginlog.LoginStatistics;
import com.hengyunsoft.security.auth.api.AuthTokenApi;
import com.hengyunsoft.security.auth.client.jwt.ServiceAuthUtil;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.IShareCache;

@RestController
@RequestMapping("svalidate")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value = "API - SSOValidateController", description = "统一门户中心验证")
public class SSOValidateController {
	
	private long logoutCallbakUrl_timeout = 24*60*60*1000L;
	@Autowired
	IShareCache shareCache ;
	@Autowired
	private IUserToken userToken;
    @Autowired
    private ServiceAuthUtil serviceAuthUtil;
	@Autowired
	private LoginStatistics loginStatistics;
	
	/**
	 * appToken 与 appKey 必须填写一个
	 * @param ticket
	 * @param logoutCallbakUrl
	 * @param appToken 
	 * @param appKey
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "验证", notes = "统一门户中心验证")
	@RequestMapping(method = RequestMethod.GET)
	public SSOLoginUser validate(String ticket,String logoutCallbakUrl,String appToken,String appKey) throws Exception {
	
		SSOLoginInfo loginInfo = (SSOLoginInfo) shareCache.delete(ticket);
		Log.info("检验传入参数是：logoutCallbakUrl=" + logoutCallbakUrl + " appToken=" + appToken + " appKey=" + appKey);
		if(loginInfo == null) {
			return SSOLoginUser.unLogin;
		}
		joinNotifyLogoutList(loginInfo.getClientFlag(),logoutCallbakUrl);
		Long userid = loginInfo.getAdmin().getId();
		int loginCycleFlag = loginInfo.getLoginCycleFlag();
		
		if(StringUtils.isEmpty(appToken)) {
			//appToken 与 appKey 二选一
			appToken = getAppTokenByAppKey(appKey);
			BizAssert.assertNotEmpty(CenterExceptionCode.MUST_APP_INFO,appToken);
		}
		
		String userToken = getUserToken(appToken,loginInfo,loginCycleFlag);
		IJWTInfo infor = parseToken(appToken);
		//记录登录日志
		loginStatistics.writeLoginLog(loginInfo.getAdmin(),loginInfo.getMasterLoginLogId(),infor.getAppId(),infor.getAppName());

		return SSOLoginUser.loginOk(userid.toString(),userToken,loginInfo.getAdmin().getAccount(),loginInfo.getAdmin().getName(),loginInfo.getAdminAppIds(),loginCycleFlag,loginInfo.getAdmin().getPhoto());
	}

    @Autowired
    private AuthTokenApi authTokenApi;
	private String getAppTokenByAppKey(String appKey) {
		  if(appKey == null) {
			  return null;
		  } 
		  String[] appId2AppSecret = AppInfoEncoder.uncoder(appKey);
//		  Optional<String> optional = TokenCache.of(AppInfoEncoder.getAppId(appId2AppSecret),
//      				AppInfoEncoder.getAppSecret(appId2AppSecret)).get();
//	      if (optional.isPresent()) {
//	    	  return optional.get();
//	      }

        return authTokenApi.token(AppInfoEncoder.getAppId(appId2AppSecret),
                AppInfoEncoder.getAppSecret(appId2AppSecret)).getData().getToken();
	}

	private IJWTInfo parseToken(String appToken) {
		
		if(appToken != null) {
			return serviceAuthUtil.getInfoFromToken(appToken);
		} else {
			return null;
		}
	}

	private String getUserToken(String appToken, SSOLoginInfo loginInfo, int loginCycleFlag) throws Exception {
		
		

    	  UserTokenExtInfo extInfo = new UserTokenExtInfo();
    	  extInfo.setLogoutFlag(loginCycleFlag);
    	  extInfo.setAccount(loginInfo.getAdmin().getAccount());
    	  extInfo.setRoles(loginInfo.getAdminAppIds());
    	  return userToken.encoder(appToken, loginInfo.getAdmin().getId().toString(), loginInfo.getAdmin().getName(), extInfo);
	}

	private void joinNotifyLogoutList(String clientFlag, String logoutCallbakUrl) {
		if(StringUtils.isEmpty(logoutCallbakUrl)) {
			return ;
		}
		List<String> logoutCallbakUrls = (List<String>) shareCache.get(clientFlag);
		
		if(logoutCallbakUrls == null) {
			logoutCallbakUrls = new ArrayList<>();
		} 
		logoutCallbakUrls.add(logoutCallbakUrl);
		
		shareCache.putFixedTimeout(clientFlag, logoutCallbakUrls, logoutCallbakUrl_timeout);
	}
}
