package com.hengyunsoft.sso.webflow.action;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.web.support.WebUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class ProviderLoginTicketAction extends AbstractAction {

	@Override
	protected Event doExecute(RequestContext context) throws Exception {
		final HttpServletRequest request = WebUtils.getHttpServletRequest(context);  
		  
        if (request.getParameter("get-lt") != null && request.getParameter("get-lt").equalsIgnoreCase("true")) {  
            return result("loginTicketRequested");  
        }  
        return result("continue"); 
	}


}
