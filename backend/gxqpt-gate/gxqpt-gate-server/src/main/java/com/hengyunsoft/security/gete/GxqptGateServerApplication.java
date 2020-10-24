package com.hengyunsoft.security.gete;

import com.hengyunsoft.platform.commons.feignhystrix.EnableFeignClientHystrix;
import com.hengyunsoft.security.auth.client.EnableGxqptAuthClient;
import com.hengyunsoft.security.ratelimit.EnableAceGateRateLimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * @author tyh
 * @createTime 2017-12-13 15:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.hengyunsoft.security.gete.feign",  //获取资源
        "com.hengyunsoft.platform.developer.api.service.api",  // 接口拦截
        "com.hengyunsoft.platform.security.api.interfaces",  //预警阀值接口
})
@EnableFeignClientHystrix
@EnableZuulProxy
@EnableGxqptAuthClient
@EnableAceGateRateLimit
public class GxqptGateServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(GxqptGateServerApplication.class, args);
    }
    
//    @Autowired
//    private AuthInfoApiHystrix authInfoApiHystrix ;
//    @Autowired
//    private AuthInfoApi authInfoApi;
//    
//    @PostConstruct
//    public void init() {
//    	
//    	for (int i = 0; i < 10; i++) {
//			System.out.println("---------------------");
//		}
//    	System.out.println(authInfoApiHystrix.getAllUseableJryy(""));
//    	System.out.println(authInfoApi);
//    }
}
