package com.hengyunsoft.platform.admin.config;

import org.aopalliance.aop.Advice;
import org.springframework.aop.*;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * Xss配置，只拦截对数据库进行操作的事务方法
 * 对其参赛进行Xss过滤
 */
@Configuration
public class XssConfig {
    private static final List<Class<? extends Annotation>> AOP_POINTCUT_ANNOTATIONS = new ArrayList<>(2);
    private static final String TX_BASE_PACKAGE = "com.hengyunsoft.platform";

    static {
        //事务在controller层开启。
        AOP_POINTCUT_ANNOTATIONS.add(RestController.class);
        AOP_POINTCUT_ANNOTATIONS.add(Controller.class);
    }

    private ClassFilter builderClassFilter() {

        return clazz -> {

            if (!clazz.getName().startsWith(TX_BASE_PACKAGE)) {
                return false;
            }
            for (Class<? extends Annotation> aop : AOP_POINTCUT_ANNOTATIONS) {
                if (clazz.getAnnotation(aop) != null) {
                    return true;
                }
            }
            return false;
        };
    }

    @Bean
    public Advisor xssAdviceAdvisor(PlatformTransactionManager transactionManager) {

        return new DefaultPointcutAdvisor(new Pointcut() {

            private final ClassFilter filter = builderClassFilter();

            @Override
            public MethodMatcher getMethodMatcher() {

                return MethodMatcher.TRUE;
            }

            @Override
            public ClassFilter getClassFilter() {
                return filter;
            }
        }, dealXssBeforeAdvice());
    }

    private Advice dealXssBeforeAdvice() {

        BeforeAdvice beforeAdvice = (MethodBeforeAdvice) (method, args, target) -> {
            TransactionStatus transactionStatus;
            try {
                transactionStatus = TransactionInterceptor.currentTransactionStatus();
            } catch (NoTransactionException e) {
                return;
            }
            if (transactionStatus instanceof DefaultTransactionStatus) {
                DefaultTransactionStatus def = (DefaultTransactionStatus) transactionStatus;
                if (def.isReadOnly()) {
                    return;
                }
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == null) {
                        continue;
                    }
                    if (args[i].getClass().getName().contains("com.hengyunsoft") || args[i] instanceof String) {
                        args[i] = XssUtil.cleanArg(args[i]);
                    }
                }
            }
        };
        return beforeAdvice;
    }
}