package com.hengyunsoft.security.auth.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hengyunsoft.commons.context.BaseContextHandler;

/**
 * 仅仅只需要有应用级的token即可。可以不需要有用户级token，但是也会先解析用户级token，若解析错误，在解析应用级token。意味着你也可以使用用户级token
 * 注意： 使用此注解后，你不应该使用上下文中的获取用户的方法
 * {@link BaseContextHandler#getAdminId()}和
 * {@link BaseContextHandler#getName()}； 但是可以使用
 * 
 * {@link BaseContextHandler#getAppId()}和
 * {@link BaseContextHandler#getAppName()}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface AppToken {

}
