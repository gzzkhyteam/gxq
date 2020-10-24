package com.hengyunsoft.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * SBA 监控中心
 * @author tyh
 * @createTime 2018-01-04 15:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableTurbineStream
public class GxqptMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(GxqptMonitorApplication.class, args);
    }
}
