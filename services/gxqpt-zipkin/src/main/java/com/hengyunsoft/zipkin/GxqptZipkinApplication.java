package com.hengyunsoft.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * 1
 * @author tyh
 * @createTime 2018-01-04 16:07
 */
@SpringBootApplication
//注册到eureka
@EnableDiscoveryClient
//使用Stream方式启动ZipkinServer
@EnableZipkinStreamServer
public class GxqptZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptZipkinApplication.class, args);
    }
}
