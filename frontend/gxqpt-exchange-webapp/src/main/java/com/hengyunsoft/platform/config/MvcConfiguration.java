package com.hengyunsoft.platform.config;

import com.hengyunsoft.sso.demo.servlet.SessionStorageSessionDestroyListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.util.IntrospectorCleanupListener;

/**
 * SpringBoot提供了三种BeanFilterRegistrationBean、ServletRegistrationBean、ServletListenerRegistrationBean
 * 分别对应配置原生的Filter、Servlet、Listener,
 *
 * @author tyh
 * @createTime 2017-11-06 11:26
 */
@Configuration
public class MvcConfiguration {
    /**
     * cas sso 注销
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationServletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new SessionStorageSessionDestroyListener());
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

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationRequestContextListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new RequestContextListener());
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

    @Bean("characterEncodingFilter")
    @Order(0)
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter ceFilter = new CharacterEncodingFilter();
        ceFilter.setEncoding("UTF-8");
        ceFilter.setForceEncoding(true);
        return ceFilter;
    }

}
