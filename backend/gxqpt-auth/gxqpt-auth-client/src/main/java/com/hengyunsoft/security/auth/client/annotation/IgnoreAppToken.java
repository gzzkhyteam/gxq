package com.hengyunsoft.security.auth.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 潘定遥
 * 因为token开始分为用户级token与应用级token了，故此注解的语义有所变化，因为一开始我们期望的这个注解的语义是不需要传输任何的token信息。
 * 故推荐使用这个注解 {@link IgnoreToken}。他们的功能一模一样，仅仅是字面表表达的意思让人觉得这个注解不合理。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
@Deprecated 
public @interface IgnoreAppToken {
}
