package com.hengyunsoft.platform.configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengyunsoft.platform.annotation.DisableXxsFilter;
import com.hengyunsoft.platform.security.StringParamSecurityUtil;

@Aspect
@Component
public class XxsControllerAopConfig {

	@Pointcut("execution(public * com.hengyunsoft.platform.controller.*.*(..))")  
    public void xxsFilter(){
		
	}  
	
	 @Before("xxsFilter()")
     public void doBefore(JoinPoint joinPoint) throws Exception{

         //获取目标方法的参数信息
		 
         Signature signature = joinPoint.getSignature();
         if(! (joinPoint instanceof MethodInvocationProceedingJoinPoint)) {
        	 return ;
         }
         MethodSignature methodSignature = (MethodSignature) signature;
         
         Method method = methodSignature.getMethod();
         
         if(method.getParameterCount() < 1) {
        	 return ;
         }
         if(!(hasAnnotation(method,RequestMapping.class) || hasAnnotation(method,GetMapping.class) 
        		 || hasAnnotation(method,PostMapping.class) || hasAnnotation(method,DeleteMapping.class)
        		 || hasAnnotation(method,PutMapping.class))) {
        	 return ;
         }
         
         Field field = MethodInvocationProceedingJoinPoint.class.getDeclaredField("methodInvocation");
         field.setAccessible(true);
         ProxyMethodInvocation methodInvocation = (ProxyMethodInvocation) field.get(joinPoint);
         
         Object[] params = methodInvocation.getArguments();
         
         filterXxsString(method.getParameters(),params);
	 }

	private  <T extends Annotation>  boolean hasAnnotation(Method method, Class<T> annotationClass) {

		return method.getAnnotation(annotationClass) != null;
	}

	private void filterXxsString(Parameter[] parameter, Object[] params) {
		
		for (int i = 0; i < params.length; i++) {
			if(params[i] != null && params[i] instanceof String) {
				if(parameter[i].getAnnotation(DisableXxsFilter.class) != null) {
					continue ;
				}
				params[i] = StringParamSecurityUtil.filterSpecialCharacter((String)params[i]);
				System.out.println(params[i]);
			}
		}
	}
	 
}
