package com.hengyunsoft.security.auth.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  因为我们的token分为： 用户级toekn  和应用级token ；
 *  而有些请求需要放弃验证，就是说不需要传输任何的token。 
 *  
 *  但是注意：   我们的数据在获取的时候，基本都是通过应用去做限制，各个应用加载自己的数据。
 *  故这个注解慎用
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface IgnoreToken {

}
