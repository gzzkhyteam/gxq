package com.hengyunsoft.sso.authentication;

import com.hengyunsoft.sso.exception.CaptchaException;
import com.hengyunsoft.sso.exception.LoginAuthFailException;
import com.hengyunsoft.sso.exception.LoginDisableException;
import com.hengyunsoft.sso.webflow.action.CaptchaAction;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.web.support.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/**
 * 单点登录用户认证处理器
 * <p>
 * 查询数据库验证用户名和密码有效性
 * </p>
 * 
 * @author loujingying@hengyunsoft.com
 * @version 1.0.0, 2016-06-01
 * @since HENGYUN1.1.7
 */
@Component("queryDatabaseAuthenticationAndLogHandler")
public class QueryDatabaseAuthenticationAndLogHandler extends AbstractUsernamePasswordAuthenticationHandler{
    
    /** Logger instance. */
    protected final transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonAttributeDao personAttributeDao;

    private final static String LOGIN_RANDOM_SALT_IN_SESSION = "l_r_s";
    public static String generatorLoginRandomSalt(HttpServletRequest request) {
    	
    	HttpSession session = request.getSession(true);
    	String salt = RandomStringUtils.randomAlphanumeric(32);
    	session.setAttribute(LOGIN_RANDOM_SALT_IN_SESSION, salt);
    	return salt;
    }
    
    private static String deleteLoginRandomSalt() {
    	
    	HttpSession session = WebUtils.getHttpServletRequest().getSession(true);
    	String salt = (String) session.getAttribute(LOGIN_RANDOM_SALT_IN_SESSION);
    	session.removeAttribute(LOGIN_RANDOM_SALT_IN_SESSION);
    	return salt;
    }
    
    @Override
    protected final HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential credential)
            throws GeneralSecurityException, PreventedException {

        //获取seesion中的值
		final String username = credential.getUsername();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String sessionKey = CaptchaAction.LOGIN_QRCODE_SESSION_KEY+request.getSession().getId();
		String qrCode = (String)RequestContextHolder.getRequestAttributes().getAttribute(sessionKey, RequestAttributes.SCOPE_SESSION);

//		//获取表单数据
//		String fromQrCode = request.getParameter("qrcode");
//		if(StringUtils.isEmpty(fromQrCode) || !fromQrCode.equalsIgnoreCase(qrCode)){
//
//			throw new CaptchaException("验证码错误!!");
//		}
		String salt = deleteLoginRandomSalt();
		if(salt == null) {
			throw new CaptchaException("不安全的登录!!");
		}
        try {
			 UserDTO userDTO = personAttributeDao.getPerson(username,credential.getPassword(),salt);
			 if(userDTO != null) {
				 Map<String,Object> attrs = toAttrs(userDTO);
				 Principal p = this.principalFactory.createPrincipal(username,attrs);
				 return createHandlerResult(credential, p,null);
			}
        		 throw new LoginAuthFailException("远程调用服务异常，请联系管理员！.");
        } catch (LoginDisableException e){
             throw e;
        }catch (final LoginAuthFailException e) {
        	 throw e;
        } catch (final Exception e) {
       	 	 throw new LoginAuthFailException("服务异常，请稍后再试");
       } 
    }

	private Map<String, Object> toAttrs(UserDTO userDTO) {
		Map<String, Object> attr = new HashMap<>(8);
		attr.put("id", userDTO.getId());
		return attr;
	}
}