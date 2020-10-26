package com.hengyunsoft.sso.webflow.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.web.support.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

@Component("remoteLoginAction")
public final class RemoteLoginAction extends AbstractAction {
	
    private final transient Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected Event doExecute(final RequestContext context) throws Exception {
        final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
        
        // 若参数包含_eventId=submit则进行提交，否则进行验证
        String eventId = request.getParameter("_eventId");
        if (StringUtils.equals("submit", eventId)) {
        	
        	// 解决远程登陆时不能从flow上下文中获取ticket的问题
            String loginTicket = WebUtils.getLoginTicketFromRequest(context);
            if(StringUtils.isBlank(loginTicket)) {
            	return error();
            }
            
            WebUtils.putLoginTicket(context, loginTicket);
            
            // 获取用户名和密码
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            UsernamePasswordCredential credential = new UsernamePasswordCredential();
            credential.setUsername(username);
            credential.setPassword(password);
            
            context.getFlowScope().put("credential", credential);
        	
            return result("submit");
            
        } else {
        	
        	// 客户端必须传递loginUrl参数过来，否则无法确定登陆目标页面
            String loginUrl = request.getParameter("loginUrl");
            context.getFlowScope().put("remoteLoginUrl", loginUrl);
        }
        
        return result("check");
    }

}
