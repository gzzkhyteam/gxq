package com.hengyunsoft.platform.controller.sso;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.loginlog.LoginStatistics;
import com.hengyunsoft.platform.security.CasFilterExt;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.api.ApplicationApi;
import com.hengyunsoft.security.auth.dto.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.IShareCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("slogin")
@Api(value = "API - SSOLoginController", description = "统一门户中心登录")
public class SSOLoginController {

	@Value("${gxqpt.index-url:}")
	private String indexUrl ;
    @Autowired
    IShareCache shareCache;
    
    @Value("${gxqpt.hostname.nginx}")
    private String localIp ;
    
    @Value("${gxqpt.port.nginx}")
    private String localPort ;
    
    @Autowired
    private ApplicationApi applicationApi;
    
    private volatile List<String> applicationIndexUrlIpPort = null;
    private AtomicLong nextLoadTime = new AtomicLong(0);
    private final static long LOAD_TIME_INTERVAL_MILLISECOND = 20*60*1000;
    private final String  applySsoTips = "error/applySsoTips";
    
    
    @Autowired
    CasFilterExt casFilterExt;
    private long token_timeout = 30 * 60 * 1000L;
    private final String service_in_session = "service_";

    public SSOLoginController() {

    }

    @ApiResponses({
        @ApiResponse(code = 106008, message = "service不正确")
	})
	@ApiOperation(value = "登录", notes = "统一门户中心登录")
	@RequestMapping(method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, String service) throws ServletException, IOException {


    	if(!checkWhiteList(service)) {
    		//检查白名单，只有是申请了单点登录功能的应用才可以进行单点登录集成。
    		return applySsoTips;
    	};
        HttpSession session = request.getSession();

        session.setAttribute(service_in_session, service);

        if (LoginInfoUtil.loginInfo() == null) {
            log.info(" 登录信息为空 ");
            if(!StringUtils.isEmpty(indexUrl)) {
            	return "redirect:"+indexUrl;
            }
            return "redirect:/gxqpt-center/admin/index";
        } else {
            String serviceUrl = getServiceUrl(request, response);
            log.info(" serviceUrl= {} ", serviceUrl);
            return "redirect:" + serviceUrl;
        }
    }

    private boolean checkWhiteList(String service) {
    	//这里的service url必须包含在application中的indexUrl
    	if(isLocalService(service)) {
    		return true;
    	}
    	long currentTime = System.currentTimeMillis();
    	
    	if(nextLoadTime.get() < currentTime) {
    		Result<List<String>> ssoApplicationIndexUrl = applicationApi.findRatifySsoAppList();
    		if(ssoApplicationIndexUrl.isSuccess()) {
    			applicationIndexUrlIpPort = convertToProtocolIpPort(ssoApplicationIndexUrl.getData());
    			nextLoadTime.set(currentTime+LOAD_TIME_INTERVAL_MILLISECOND);
    		} else {
    			throw new BizException(-1, ssoApplicationIndexUrl.getErrmsg());
    		}
    	}
    	List<String> currApplicationIndexUrlIpPort = applicationIndexUrlIpPort;
    	for (String currApplicationIndexUrl : currApplicationIndexUrlIpPort) {
			if(service.startsWith(currApplicationIndexUrl)) {
				return true;
			}
		}
    	return false;
	}

	private List<String> convertToProtocolIpPort(List<String> urls) {
		
		return urls.stream().map(url->{
			int portAfterFirst = url.indexOf('/',10);
			if(portAfterFirst == -1) {
				return url;
			} else {
				return url.substring(0, portAfterFirst);
			}}).collect(Collectors.toList());
	}

	private boolean isLocalService(String service) {
			
		//由于大数据分析平台是我们自己的应用，而且和我们部署到一个ip下面，仅仅端口不同而已，故此只验证ip而不验证端口
		boolean isLocal = service.startsWith("http://"+localIp) || service.startsWith("https://"+localIp) ;
		//方便前端使用这个单点登录  特意加入此判断：
		boolean isTestUrl = service.startsWith("http://192.168");
		return isLocal || isTestUrl;
	}

	public boolean issueSuccessRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String service = getServiceUrl(request, response);
        if (service == null) {
            return false;
        }
        response.sendRedirect(service);
        return true;
    }

    private String getServiceUrl(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String service = (String) session.getAttribute(service_in_session);

        if (service == null) {
            return null;
        }
        session.removeAttribute(service_in_session);
        String token = RandomStringUtils.randomAlphanumeric(64);

        String upToken = (String) session.getAttribute("token");
        shareCache.delete(upToken);
        SSOLoginInfo loginInfo = new SSOLoginInfo();
        loginInfo.account = LoginInfoUtil.loginInfo();
        loginInfo.loginCycleFlag = (int) request.getSession().getAttribute(CasFilterExt.loginCycleFlag_in_service);
        loginInfo.clientFlag = casFilterExt.getClientUnique(request, response);
        
        loginInfo.setAdminAppIds(LoginInfoUtil.getLoginUserAdminAppIds());
        loginInfo.setMasterLoginLogId(LoginStatistics.getMasterLoginLogId(session));
        shareCache.putFixedTimeout(token, loginInfo, token_timeout);
        session.setAttribute("token", token);
        return builderServiceUrl(service, token);
    }

    private String builderServiceUrl(String service, String token) {

        StringBuilder url = new StringBuilder(service.length() + 8 + token.length());
        url.append(service);
        if (service.indexOf('?') < 0) {
            url.append('?');
        } else {
            url.append('&');
        }
        url.append("ticket=");
        url.append(token);
        return url.toString();
    }


    public static class SSOLoginInfo {

        private String clientFlag;
        private UserDTO account;
        private int loginCycleFlag;
        private Long adminAppIds;
        private Long masterLoginLogId;

        public String getClientFlag() {
            return clientFlag;
        }

        public UserDTO getAdmin() {
            return account;
        }

		public int getLoginCycleFlag() {
			return loginCycleFlag;
		}

		public Long getAdminAppIds() {
			return adminAppIds;
		}

		public void setAdminAppIds(Long adminAppIds) {
			this.adminAppIds = adminAppIds;
		}

		public Long getMasterLoginLogId() {
			return masterLoginLogId;
		}

		public void setMasterLoginLogId(Long masterLoginLogId) {
			this.masterLoginLogId = masterLoginLogId;
		}
    }
}
