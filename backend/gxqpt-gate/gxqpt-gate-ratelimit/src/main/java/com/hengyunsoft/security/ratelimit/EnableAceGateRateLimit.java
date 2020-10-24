package com.hengyunsoft.security.ratelimit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

/**
 * 标注这个注解后，会自动import RateLimitAutoConfiguration这个配置类。
 *
 * Documented: 表明这个注解应该被javadoc 工具记录， 默认情况下，javadoc 是不包括注解的。
 *
 * Inherited： 表明被注解的类会自动继承，更具体地说，如果定义注解使用类@Inherited标记，
 * 然后用定义的注解来标注另一个父类， 父类又有一个子类， 则父类的所有属性将被继承到它的子类中。
 * @auth tangyh
 * @date 2018/07/02
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RateLimitAutoConfiguration.class)
@Documented
@Inherited
public @interface EnableAceGateRateLimit {
}
