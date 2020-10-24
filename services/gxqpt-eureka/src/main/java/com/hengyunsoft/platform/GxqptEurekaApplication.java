package com.hengyunsoft.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务端
 * https://www.cnblogs.com/chry/p/7992885.html
 * @author tyh
 * @createTime 2017-11-24 13:43
 */
@SpringBootApplication
@EnableEurekaServer
public class GxqptEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptEurekaApplication.class, args);
    }
}
