package com.hengyunsoft.platform.file.config;

/**
 * 解决跨域问题
 * @author tyh
 * @createTime 2017-12-29 14:16
 */
//@Configuration
public class FileCorsConfiguration {
    /**
     * 在这里加上后，通过gate网关访问会出现跨域问题.
     *
     */
    //@Bean
    //public CorsFilter corsFilter() {
    //    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //    final org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
    //    // 允许cookies跨域
    //    config.setAllowCredentials(true);
    //    // #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
    //    config.addAllowedOrigin("*");
    //    // #允许访问的头信息,*表示全部
    //    config.addAllowedHeader("*");
    //    // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
    //    config.setMaxAge(18000L);
    //    // 允许提交请求的方法，*表示全部允许
    //    config.addAllowedMethod("*");
    //    config.addAllowedMethod("OPTIONS");
    //    config.addAllowedMethod("HEAD");
    //    // 允许Get的请求方法
    //    config.addAllowedMethod("GET");
    //    config.addAllowedMethod("PUT");
    //    config.addAllowedMethod("POST");
    //    config.addAllowedMethod("DELETE");
    //    config.addAllowedMethod("PATCH");
    //    source.registerCorsConfiguration("/**", config);
    //    return new CorsFilter(source);
    //}
}
