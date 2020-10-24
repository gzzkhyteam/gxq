package com.hengyunsoft.platform.controller.sso;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hengyunsoft.cas.sso.ext.UserLogoutListener;
import com.hengyunsoft.platform.security.CasFilterExt;

import lombok.extern.slf4j.Slf4j;
import util.IShareCache;

@Component
@Slf4j
public class SSOUserLogoutListener implements UserLogoutListener {

	
	RestTemplate restTemplate;
	
	@Value("${gxqpt.variable.gate-url}")
	private String getwayUrl ;
	
	public SSOUserLogoutListener() {
		this.restTemplate = new RestTemplate();
	}
	
	@Autowired
	private IShareCache shareCache;
	
	@Override
	public void logout(HttpServletRequest req, HttpServletResponse res, HttpSession httpSession) {
		
		
		try {
			String loginCycleFlag = req.getParameter(CasFilterExt.loginCycleFlag_in_service);
			log.error("退出时的退出标记为：" + loginCycleFlag);
			if(loginCycleFlag != null) {
				toInvalidToken(Integer.valueOf(loginCycleFlag));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String unique = req.getParameter(CasFilterExt.clientUniqueId_in_Cookies);
		if(unique == null)
			return ;
		List<String> logoutCallbakUrls = (List<String>) shareCache.delete(unique);
		
		if(CollectionUtils.isEmpty(logoutCallbakUrls)) {
			return ;
		}
		for (String url : logoutCallbakUrls) {
			
			try {
//				TransportLayerFactory.getTransportLayer().transportStream(url, null);
				URI uri = new URI(url);
				this.restTemplate.getRequestFactory().createRequest(uri, HttpMethod.GET).execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void toInvalidToken(Integer flag) {
		
		try {
			
			String logoutGatewayUrl = getwayUrl + "/api/logoutflag?logoutFlag="+flag;
			
			log.error("退出网关地址："+logoutGatewayUrl);
			
			String result = this.restTemplate.getForObject(logoutGatewayUrl, String.class);
			
			log.error("退出网关地址响应是："+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
