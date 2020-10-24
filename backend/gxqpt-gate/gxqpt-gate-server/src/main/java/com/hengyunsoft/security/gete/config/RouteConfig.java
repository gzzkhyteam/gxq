package com.hengyunsoft.security.gete.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;


public class RouteConfig {


	public ServiceRouteMapper  serviceRouteMapper() {
		
		return new ServiceRouteMapper() {
			
			@Override
			public String apply(String serviceId) {
				
				String[] str = serviceId.split("-");
				if(str.length < 4) {
					
					return str[1];
				} else {
					return str[3] + "/" +str[1];
				}
			}
		};
	} 
}
