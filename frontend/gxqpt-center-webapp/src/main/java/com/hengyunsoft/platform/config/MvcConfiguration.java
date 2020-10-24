package com.hengyunsoft.platform.config;

import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.util.IntrospectorCleanupListener;

import com.hengyunsoft.platform.listener.SessionDestroyUserLogoutListener;
import com.hengyunsoft.platform.loginlog.LoginStatistics;

/**
 * SpringBoot提供了三种BeanFilterRegistrationBean、ServletRegistrationBean、ServletListenerRegistrationBean
 * 分别对应配置原生的Filter、Servlet、Listener,
 *
 * @author tyh
 * @createTime 2017-11-06 11:26
 */
@Configuration
public class MvcConfiguration {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
            ErrorPage error405Page = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
            ErrorPage error504Page = new ErrorPage(HttpStatus.GATEWAY_TIMEOUT, "/error/504");
            container.addErrorPages(error400Page, error404Page, error405Page, error500Page, error504Page);
        });
    }

    /**
     * cas sso 注销
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationServletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new SingleSignOutHttpSessionListener());
        //servletListenerRegistrationBean.setOrder(1);
        return servletListenerRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationCharacterEncodingFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("characterEncodingFilter"));
        //filterRegistration.addUrlPatterns("*.do");
        filterRegistration.addUrlPatterns("/*");
        //filterRegistration.setOrder(2);
        return filterRegistration;
    }

//    /**
//     * 该过滤器用于实现单点登出功能，单点退出配置，一定要放在其他filter之前
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean filterRegistrationSingleSignOutFilter() {
//        //FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        //filterRegistration.setFilter(new DelegatingFilterProxy("SSO Single Sign Out Filter"));
//        //filterRegistration.addInitParameter("casServerUrlPrefix", "http://casserver.gxqpt.com:9525/gxqpt-sso-webapp/");
//        //filterRegistration.addUrlPatterns("/*");
//        //return filterRegistration;
//
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new SingleSignOutFilter());
//
//        //if(autoconfig.getSignOutFilters().size()>0)
//        //    filterRegistration.setUrlPatterns(autoconfig.getSignOutFilters());
//        //else
//        filterRegistration.addUrlPatterns("/*");
//        filterRegistration.addInitParameter("casServerUrlPrefix", "http://casserver.gxqpt.com:9525/gxqpt-sso-webapp/");
//
//        filterRegistration.setOrder(1);
//        return filterRegistration;
//    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationRequestContextListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new RequestContextListener());
        //servletListenerRegistrationBean.setOrder(5);
        return servletListenerRegistrationBean;
    }
    
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationSessionDestroyUserLogoutListener(LoginStatistics statistics ) {
    	ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
    	servletListenerRegistrationBean.setListener(new SessionDestroyUserLogoutListener(statistics));
    	//servletListenerRegistrationBean.setOrder(5);
    	return servletListenerRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationIntrospectorCleanupListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new IntrospectorCleanupListener());
        //servletListenerRegistrationBean.setOrder(6);
        return servletListenerRegistrationBean;
    }

    //@Bean
    //public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
    //    ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
    //    //registration.getUrlMappings().clear();
    //    //registration.addUrlMappings("*.do");
    //    registration.addUrlMappings("/*");
    //    registration.setOrder(3);
    //    return registration;
    //}

    @Bean("characterEncodingFilter")
    @Order(0)
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter ceFilter = new CharacterEncodingFilter();
        ceFilter.setEncoding("UTF-8");
        ceFilter.setForceEncoding(true);
        return ceFilter;
    }

    //@Bean("SSO Single Sign Out Filter")
    //public SingleSignOutFilter getSingleSignOutFilter() {
    //    SingleSignOutFilter sso = new SingleSignOutFilter();
    //    sso.setCasServerUrlPrefix("http://casserver.gxqpt.com:9525/gxqpt-sso-webapp/");
    //    return sso;
    //}


}
