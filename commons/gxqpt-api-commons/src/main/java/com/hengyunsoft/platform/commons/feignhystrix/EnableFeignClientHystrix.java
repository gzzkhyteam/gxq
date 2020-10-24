package com.hengyunsoft.platform.commons.feignhystrix;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 启动feign客户端hystrix，通过配置上下文中的feign去按需加载其对于的hystrix。
 * 
 * 这个需要配置在@EnableFeignClients之后，因为我的实现思路是：
 * 1.获取sping容器中配置所有的feign定义bean。
 * 2.通过feign定义找到其对应的接口，并在接口中找到@FeignClient注解。
 * 3.通过@FeignClient注解找到feign定义需要的fallback，若fallback存在则将其加入到spring容器中
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FeignClientHystrixRegistrar.class)
public @interface EnableFeignClientHystrix {

}
