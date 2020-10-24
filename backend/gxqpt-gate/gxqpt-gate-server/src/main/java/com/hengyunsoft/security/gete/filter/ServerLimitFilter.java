package com.hengyunsoft.security.gete.filter;

import com.hengyunsoft.commons.context.CommonConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务调用阀值记录过滤器
 * 将平台每个服务调用次数做统计，并放入缓存中，每调用一次加一
 * 缓存策略：取出网关路由id，对应应用表里code作为每个服务缓存key
 * 用于统一监管平台 监管服务调用阀值预警
 * @author sxy
 * @createTime 2018-9-18
 */
@Component
@Slf4j
public class ServerLimitFilter extends ZuulFilter {

    private static final UrlPathHelper URL_PATH_HELPER = new UrlPathHelper();

    @Autowired
    RouteLocator routeLocator;

    @SuppressWarnings("rawtypes")
    @Resource(name = "redisJdkTemplate")
    private  RedisTemplate redisTemplate;

    /**
     * 给 userService 接口添加拦截器，每次调用userService 接口的方法，都自动在请求头中添加
     * auth-client-token 和 auth-user-token
     */
    @PostConstruct
    public void init() {
    }

    /**
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        // 前置过滤器
        return "post";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        // 优先级为1，数字越大，优先级越低
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 5;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //开关
        return true;
        //return false;
    }

    /**
     * 接口路由信息
     * @return
     */
    public Route route() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String requestURI = URL_PATH_HELPER.getPathWithinApplication(request);
        return routeLocator.getMatchingRoute(requestURI);
    }

    /**
     * 过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
     * 不对其进行路由，然后通过ctx.setResponseStatusCode(200)设置了其返回的错误码
     *
     * @return
     */
    @Override
    public Object run() {

        //获取接口路由信息
        try {
            Route route = route();
            if(route==null){
                return null;
            }
            //routeName-网关yml文件中的路由名称，需要在应用表code字段中配置方可使用。
            String routeName = route.getId();
            Object mapObj  = redisTemplate.opsForValue().get(CommonConstants.SERVER_LIMIT_CODE_CACHE_LIST);

            /*redisTemplate.opsForHash().increment(SERVER_LIMIT_CODE_CACHE_LIST, serverCode, 1);
            redisTemplate.opsForHash().keys(SERVER_LIMIT_CODE_CACHE_LIST);

            redisTemplate.opsForHash().get()*/

            ConcurrentHashMap<String,Object> cacheMap  = (ConcurrentHashMap<String,Object>)mapObj;

            //设置缓存
            if(cacheMap != null){
                Object obj = cacheMap.get(routeName);
                if(obj == null){
                    cacheMap.put(routeName,1);
                }else {
                    Object tempObj = cacheMap.get(routeName);
                    cacheMap.put(routeName, Integer.parseInt(tempObj.toString())+1);
                }
            }else {
                cacheMap = new ConcurrentHashMap<String,Object>();
                cacheMap.put(routeName,1);
            }
            redisTemplate.opsForValue().set(CommonConstants.SERVER_LIMIT_CODE_CACHE_LIST,cacheMap);
        } catch (NumberFormatException e) {
            log.info("服务调用阀值记录过滤器异常,[{}]",e);
        }
        return null;
    }
}

