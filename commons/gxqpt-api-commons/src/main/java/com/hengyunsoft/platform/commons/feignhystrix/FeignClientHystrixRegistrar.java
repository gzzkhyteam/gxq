package com.hengyunsoft.platform.commons.feignhystrix;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class FeignClientHystrixRegistrar implements ImportBeanDefinitionRegistrar{

	private static final String feignClientBean = "org.springframework.cloud.netflix.feign.FeignClientFactoryBean";
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//1.获取所有已经定义了的bean
		String [] beans = registry.getBeanDefinitionNames();
		BeanDefinition beanDef = null;
		for (int i = 0; i < beans.length; i++) {
			beanDef = registry.getBeanDefinition(beans[i]);
			if(feignClientBean.equals(beanDef.getBeanClassName())) {
				//只是寻找FeignClientFactoryBean的bean，此bean就是我们找寻的feign客户端
				try {
					Class<?> clzz = Class.forName(beans[i]);
					FeignClient cli = clzz.getAnnotation(FeignClient.class);
					if(cli == null || cli.fallback() == null) {
						continue ;
					} else {
						//通过@FeignClient中定义的cli.fallback()得出其依赖的Hystrix
						Class<?> hystrixClass = cli.fallback();
						String beanName = getBeanName(hystrixClass);
						if(!registry.containsBeanDefinition(beanName)) {
							builderBeanDefinition(cli.fallback(),registry,beanName);
						}
					}
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	private void builderBeanDefinition(Class<?> clazz, BeanDefinitionRegistry registry,String beanName) {
		
		
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(clazz);

		registry.registerBeanDefinition(beanName, beanDefinition);
	}

	public String getBeanName(Class<?> clazz) {
		StringBuilder beanName = new StringBuilder(clazz.getSimpleName());
		char c = beanName.charAt(0);
		c += 32;
		beanName.setCharAt(0,c);
		return beanName.toString();
	}
}
