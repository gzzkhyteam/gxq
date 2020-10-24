package com.hengyunsoft.platform.file;

import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

/**
 * 主类
 * @author tyh
 * @createTime 2018-01-25 10:13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHystrix
@ComponentScan({
        "com.hengyunsoft.platform",
        "com.hengyunsoft.commons.utils.context",
})
@EnableFeignClients(value = {
        "com.hengyunsoft.security.auth.api",
        "com.hengyunsoft.platform.developer.api.core.api",
})
@EnableScheduling
@EnableTransactionManagement
@EnableGxqptAuthClient
public class GxqptFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptFileApplication.class, args);
    }

//    @Bean
//    public CommonsMultipartResolver commonsMultipartResolver() {
//        final CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//        resolver.setMaxInMemorySize(40960);
//        resolver.setMaxUploadSize(15*1024*1024);//上传文件大小 50M 50*1024*1024
//        resolver.setResolveLazily(true);
//        return resolver;
//    }
//
//    @Bean
//    public FilterRegistrationBean multipartFilterRegistrationBean() {
//        final MultipartFilter multipartFilter = new MultipartFilter();
//        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(multipartFilter);
//        filterRegistrationBean.addInitParameter("multipartResolverBeanName", "commonsMultipartResolver");
//        return filterRegistrationBean;
//    }
}
