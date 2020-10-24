package com.hengyunsoft.security.auth.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 内部api接口，忽略token，就是不做token校验。
 * 此类接口需要满足如下条件：
 * 仅仅供给内部程序调用，基本都是为了内部的定时任务为开发的，此类接口不允许公布给外界使用，
 * 就是说在网关层做过滤，不允许此类接口被外部程序访问，除非外部程序带有token参数。
 * 其作用与{@link IgnoreToken} 相同的效果，都是不用token即可访问，不同之处在于语义不同，这里更加强调此api为内部api，
 * 仅仅允许服务间的调用。不对外开放。而{@link IgnoreToken} 表示对外开放的
 * @author 潘定遥
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface InsideApiIgnoreToken {

}
