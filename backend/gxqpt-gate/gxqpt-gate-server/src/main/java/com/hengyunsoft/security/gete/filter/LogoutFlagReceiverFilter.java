package com.hengyunsoft.security.gete.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.hengyunsoft.security.gete.controller.LogoutFlagReceiverController;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * 
 * 因为zuul:
 *       servlet-path: /         # 默认是/zuul , 上传文件需要加/zuul前缀才不会出现乱码，这个改成/ 即可不加前缀
 * 遗留的问题，导致我们进入不了控制器，就是访问不了spring mvc的dispatchServlet。只能够通过过滤器的形式去间接访问。
 * 
 * 凡是请求路径中带有logoutflag的请求，都将认为是来传输请求退出标记的
 * @author 潘定遥
 *
 */
@Component
public class LogoutFlagReceiverFilter extends ZuulFilter {

	@Autowired
	private LogoutFlagReceiverController logoutFlagReceiverFilter;
	@Override
	public boolean shouldFilter() {
		
		String uri = RequestContext.getCurrentContext().getRequest().getRequestURI();
		return uri == null ? false : uri.toString().contains("logoutflag");
	}

	@Override
	public Object run() {
		
		String result = null;
		try {
			result = logoutFlagReceiverFilter.receiver(RequestContext.getCurrentContext().getRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setResponse(result);
		return null;
	}

	public void setResponse(String txt) {
		RequestContext context = RequestContext.getCurrentContext();
		context.setResponseStatusCode(200);
		context.setResponseBody(txt);
	}
	
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return Integer.MIN_VALUE;
	}
}
