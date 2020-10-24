package com.hengyunsoft.validator.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpServletRequestValidatorWrapper extends HttpServletRequestWrapper {

	private String fromUri = null;
	public HttpServletRequestValidatorWrapper(HttpServletRequest request,String uri) {
		
		super(request);
		this.fromUri = uri;
	}

	@Override
	public String getRequestURI() {
		return this.fromUri;
	}
	
	@Override
	public String getServletPath() {
		return this.fromUri;
	}
}
