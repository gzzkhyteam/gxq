package com.hengyunsoft.security.auth.client.interceptor;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthExceptionCode;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.security.auth.client.annotation.InsideApiIgnoreToken;
import com.hengyunsoft.security.auth.client.annotation.UserAppToken;
import com.hengyunsoft.security.auth.client.config.ServiceAuthConfig;
import com.hengyunsoft.security.auth.client.jwt.ServiceAuthUtil;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * 验证第三方外部请求
 * Created by tangyh on 2017/9/10.
 *
 * @author tyh
 */
public class AppAuthRestInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(AppAuthRestInterceptor.class);
    //@Autowired
    //private AppAuthUtil appAuthUtil;
    //
    //@Autowired
    //private AppAuthConfig appAuthConfig;

    @Autowired
    private ServiceAuthUtil serviceAuthUtil;

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    
    @Autowired
    private IUserToken userToken;
    /**
     * 忽略token的注解集合
     */
    private final static Class[] ignoreTokenAnnotations = {IgnoreAppToken.class,IgnoreToken.class,InsideApiIgnoreToken.class};
    /**
     * 不忽略token的注解集合
     */
    private final static Class[] mustTokenAnnotations = {AppToken.class,UserAppToken.class};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        ApiOperation apiOperation = handlerMethod.getMethod().getAnnotation(ApiOperation.class);

        //设置api名称到报文头中
        if(apiOperation!=null){
            response.setHeader(CommonConstants.CALL_RECORD_API_NAME,URLEncoder.encode(apiOperation.value(),"utf-8"));
        }
        if(isIgnoreToken(handlerMethod)) {
        	return true;
        }
        String clazzName = handlerMethod.getBeanType().getName();
        log.info("clazzName = {}" , clazzName );
        try {
            
            List<Object> userInfo = null;
            String appToken = null;
            IJWTInfo infoFromToken = null;
            try {
            	//默认都使用用户级token进行访问
            	userInfo = getUserToken(request);
            	if(userInfo != null) {
            		//传入用户级token
            		appToken = userToken.getAppToken(userInfo);
                    BaseContextHandler.setName(userToken.getUserName(userInfo));
                    BaseContextHandler.setAdminId(Long.valueOf(userToken.getUserId(userInfo)));
                    BaseContextHandler.setUserTokenExtInfo(userToken.getUserTokenExtInfo(userInfo));
                    
            	} else if(onlyNeedAppToken(clazzName,handlerMethod)) {
            		//只需要应用级token
            		// 项目中约定open包中的controller都是可以对外的，对外就代表可以通过应用级token来进行访问。有时候也希望不再open包中的有些controller 方法也可以被应用级token访问，所以这类操作
            		// 需要在方法级别上面增加 @AppToken注解            只要满足这两个条件中的一个，就可以以应用级token进行访问
            		appToken = getTokenFromRequest(request);
            	} else {
            		//需要用户级token，但是无法得到，故抛出用户级token错误异常
            		throw new BizException(AuthExceptionCode.ERROR_USER_TOKEN.getCode(),AuthExceptionCode.ERROR_USER_TOKEN.getMsg());
            	}
            	infoFromToken = serviceAuthUtil.getInfoFromToken(appToken);
            } catch (BizException e) {
                log.error("url = {}" ,request.getRequestURI());
                log.error("biz e", e);
            	throw e;
            } catch (Exception e) {
                log.error("url = {}" ,request.getRequestURI());
                log.error(" e", e);
            	throw e;
            }


            BaseContextHandler.setAppId(infoFromToken.getAppId());
            BaseContextHandler.setAppName(infoFromToken.getAppName());

            BaseContextHandler.setToken(getTokenFromRequest(request));
        } catch (Exception e) { log.error("url = {}" ,request.getRequestURI());
            log.error("拦截器异常:{}", e);
            //return false;
            if (e instanceof BizException) {
                throw (BizException) e;
            }
            throw new BizException(-1, e.getMessage());
        }
        return super.preHandle(request, response, handler);
    }
    
    private boolean isUserAppTokenAnnotation(HandlerMethod handlerMethod) {
    	Annotation annotation = handlerMethod.getBeanType().getAnnotation(UserAppToken.class);
        if (annotation == null) {
        	annotation = handlerMethod.getMethodAnnotation(UserAppToken.class);
        }
		return annotation != null;
	}

    /**
     * 判断是否只需要应用级token
     * @param clazzName
     * @param handlerMethod
     * @return
     */
    private boolean onlyNeedAppToken(String clazzName,HandlerMethod handlerMethod) {
    	if(isUserAppTokenAnnotation(handlerMethod)) {
    		return false ;
    	}
    	return  clazzName.indexOf(".open.") >= 0 || isAppTokenAnnotation(handlerMethod);
    }
    
	private boolean isAppTokenAnnotation(HandlerMethod handlerMethod) {
    	Annotation annotation = handlerMethod.getBeanType().getAnnotation(AppToken.class);
        if (annotation == null) {
        	annotation = handlerMethod.getMethodAnnotation(AppToken.class);
        }
		return annotation != null;
	}

	/**
	 * 是否忽略token参数
	 * @param handlerMethod
	 * @return
	 */
    private boolean isIgnoreToken(HandlerMethod handlerMethod) {
    	
    	for (int i = 0; i < ignoreTokenAnnotations.length; i++) {
    		
    		if(handlerMethod.hasMethodAnnotation(ignoreTokenAnnotations[i])) {
    			//方法上面明确说明忽略token
    			return true;
    		}
		}
    	for (int i = 0; i < mustTokenAnnotations.length; i++) {
    		if(handlerMethod.hasMethodAnnotation(mustTokenAnnotations[i])) {
    			//方法上面明确说明不忽略token
    			return false;
    		}
    	}
    	for (int i = 0; i < ignoreTokenAnnotations.length; i++) {
    		
    		if(handlerMethod.getBeanType().getAnnotation(ignoreTokenAnnotations[i]) != null) {
    			//类级别上面明确说明忽略token
    			return true;
    		}
    	}
    	return false ;
	}

	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
    
	private List<Object> getUserToken(HttpServletRequest request) throws UnsupportedEncodingException {

		String authToken = getTokenFromRequest(request);
		authToken = URLDecoder.decode(authToken, "utf-8");
		try {
			return userToken.uncoder(authToken);
		} catch (Exception e) {
			//不是标准的userToken   说明是appToken
			e.printStackTrace();
		}
		return null;
	}
	
	private String getTokenFromRequest(HttpServletRequest request) {

		String token = request.getHeader(serviceAuthConfig.getTokenHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(serviceAuthConfig.getTokenHeader());
        }
        return token;
	}
}
