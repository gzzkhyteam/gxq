//package com.hengyunsoft.platform.file.interceptor;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//@Component
//public class FeignFileAddHeaderRequestInterceptor implements RequestInterceptor {
//
//
//    @Override
//    public void apply(RequestTemplate template) {
//        String token = (String) RequestContextHolder.getRequestAttributes().getAttribute("token", RequestAttributes.SCOPE_SESSION);
//        if (token == null || "".equals(token.trim())) {
//            token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("token");
//        }
//        System.out.println("---------file-interceptor--------------");
//        //String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxIiwiYXBwSWQiOiIxMDAwMCIsImV4cCI6MTUyMTAzODE3MH0.ZEyKIFcg973WEHtXcX_MqCZSB49wgTtz1nDzu2Zk5tT4D5jonQrmr7YvQdrtDagi0ZnmKy38j8eK5NS-wHYEvWkFQjDcfzqCvIUiWpkMiPXVCJINukrXp0x3tb_6KJemA44OsZn8Nk5XCPMCIE24g5_pHGa993ncUg2d9mw8YVM";
//        template.header("token", token);
//    }
//}
