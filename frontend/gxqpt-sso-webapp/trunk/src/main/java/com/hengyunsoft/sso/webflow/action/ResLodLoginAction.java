package com.hengyunsoft.sso.webflow.action;

import org.springframework.stereotype.Component;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

@Component("resLodLoginAction")
public class ResLodLoginAction extends AbstractAction{
	@Override
	protected Event doExecute(RequestContext context) throws Exception {
	
		return success();
	}
	
	
	
	
	
	
	
	
}
