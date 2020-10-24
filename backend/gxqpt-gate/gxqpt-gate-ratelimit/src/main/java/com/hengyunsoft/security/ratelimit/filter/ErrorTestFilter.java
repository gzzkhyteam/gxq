//package com.hengyunsoft.security.ratelimit.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//
//import org.springframework.stereotype.Component;
//
///**
// * This is a Description
// *
// * @auth tangyh
// * @date 2018/07/09
// */
//
//@Component
//public class ErrorTestFilter extends ZuulFilter {
//
//    @Override
//    public String filterType() {
//        return "error";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 10;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() {
//
//
//        RequestContext ctx = RequestContext.getCurrentContext();
//        int responseSatusCode = ctx.getResponseStatusCode();
//
//        String body = ctx.getResponseBody();
//
//        Throwable throwable = ctx.getThrowable();
//
//
//        return null;
//    }
//}
