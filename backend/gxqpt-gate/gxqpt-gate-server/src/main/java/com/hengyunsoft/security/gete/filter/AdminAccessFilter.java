package com.hengyunsoft.security.gete.filter;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.security.auth.client.config.ServiceAuthConfig;
import com.hengyunsoft.security.auth.client.jwt.ServiceAuthUtil;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.gete.auth.ApplicationAuth;
import com.hengyunsoft.security.gete.auth.UserAuth;
import com.hengyunsoft.security.gete.config.GateIgnoreProperties;
import com.hengyunsoft.security.logoutflag.ILogoutFlagStorage;
import com.hengyunsoft.security.ratelimit.filter.AbstractZuulFilter;
import com.hengyunsoft.utils.JSONUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.instrument.web.TraceFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * admin 权限 过滤器
 *
 * @author tyh
 * @createTime 2017-12-13 15:22
 */
@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter {

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Autowired
    private GateIgnoreProperties gateIgnoreProperties;
    /**
     * 为zuul设置一个公共的前缀
     */
    @Value("${server.context-path}")
    //@Value("${server.context-path}${zuul.prefix}")
    private String zuulPrefix;
    @Value("${gxqpt.auth.enabled:true}")
    private Boolean gxqptAuthEnabled;

    public final static int TOKEN_TIMEOUT_ERROR_CODE = -9999;

    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    @Autowired
    private ServiceAuthUtil serviceAuthUtil;
    @Autowired
    private UserAuth userAuth;
    @Autowired
    private ApplicationAuth applicationAuth;
    @Autowired
    private IUserToken userToken;
    @Autowired
    private ILogoutFlagStorage logoutFlagStorage;
    
    /**
     * 消费的模块id 键
     */
    public final static String CONSUMER_MODULE_ID_KEY = "csm_mdl_id";
    /**
     * 调用方，请求发起方的appid
     */
    public final static String CONSUMER_APP_ID_KEY = AbstractZuulFilter.CONSUMER_APP_ID_KEY;

    protected static final String TRACE_REQUEST_ATTR = TraceFilter.class.getName() + ".TRACE";

    public static final String PRODUCER_APP_ID_KEY = AbstractZuulFilter.PRODUCER_APP_ID_KEY;

    /**
     * 给 userService 接口添加拦截器，每次调用userService 接口的方法，都自动在请求头中添加
     * auth-client-token 和 auth-user-token
     */
    @PostConstruct
    public void init() {
        //InstanceInfo prodSvcInfo = discoveryClient.getNextServerFromEureka("GXQPT-ADMIN-SERVER", false);
        //ServiceFeignInterceptor serviceFeignInterceptor = new ServiceFeignInterceptor();
        //serviceFeignInterceptor.setServiceAuthConfig(serviceAuthConfig);
        //serviceFeignInterceptor.setServiceAuthUtil(serviceAuthUtil);
        //serviceFeignInterceptor.setUserAuthConfig(appAuthConfig);
        //this.userService = Feign.builder().encoder(new JacksonEncoder())
        //        .decoder(new JacksonDecoder())
        //        .requestInterceptor(serviceFeignInterceptor)
        //        .target(UserService.class, prodSvcInfo.getHomePageUrl());
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
        return "pre";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        // 数字越大，优先级越低
        /**
         * 一定要在 {@link org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter} 过滤器之后执行，因为这个过滤器做了路由  而我们需要这个路由信息来鉴权
         * 这个过滤器会将很多我们鉴权需要的信息放置在请求上下文中。故一定要在此过滤器之后执行
         */
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        /**
         * 在过滤器中抛出异常后，会被   {@link org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter}重定向到错误界面，然而在重定向的过程中，依然会经过一次
         * 这些过滤器，而我们需要忽略这种情况。故我们不过滤那种错误重定向的请求
         */
        return ctx.getThrowable() == null;
    }

    /**
     * 过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
     * 不对其进行路由，然后通过ctx.setResponseStatusCode(200)设置了其返回的错误码
     *
     * @return
     */
    @Override
    public Object run() {


        RequestContext ctx = RequestContext.getCurrentContext();
        
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        ctx.set(PRODUCER_APP_ID_KEY, serviceId);
        
        HttpServletRequest request = ctx.getRequest();

        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());

        BaseContextHandler.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            log.info("access filter not execute");
            return null;
        }

        List<Object> userInfo = null;
        String appToken = null;
        String token = getTokenFromRequest(request);

        IJWTInfo user = null;
        try {
            userInfo = getUserToken(token);
            if (userInfo != null) {
                checkUserTokenValid(userInfo);
                appToken = userToken.getAppToken(userInfo);
                String userId = userToken.getUserId(userInfo);
                String userName = userToken.getUserName(userInfo);
                UserTokenExtInfo extInfo = userToken.getUserTokenExtInfo(userInfo);
                if(extInfo != null) {
                	ctx.set(AbstractZuulFilter.OPERATOR_USER_ACCOUNT_KEY, extInfo.getAccount());
                }
                
                ctx.set(AbstractZuulFilter.OPERATOR_USER_ID_KEY, Long.valueOf(userId));
                ctx.set(AbstractZuulFilter.OPERATOR_USER_NAME_KEY, userName);
            } else {
                appToken = token;
            }
            user = getJWTUser(appToken);
            
            addSpanConsumerAppIdAndProducerServiceId(request, user.getAppId(),serviceId);
            
        } catch (BizException e) {
            errorResponse(e.getMessage(), e.getCode(), 200);
            return null;
        } catch (Exception e) {
            log.error("all err", e);
            errorResponse("验证token出错", Result.FAIL, 200);
            return null;
        }



        if (gxqptAuthEnabled) {
            //是否启动权限认证
            Long userId = null;
            if (userInfo != null) {
                userId = Long.valueOf(userToken.getUserId(userInfo));
            }

            try {
                if (!authCheck(user.getAppId(), userId, ctx, appToken)) {
                    log.error("无权限访问[{}], [{}], {}", user.getAppId(), userId, appToken);
                    errorResponse("无权限访问", Result.FAIL, 200);
                }

            } catch (BizException be) { //这里报错一般都是 feign 远程调用报错
                errorResponse(be.getMessage(), be.getCode(), 200);
            }
        }

        

        ctx.set(CONSUMER_APP_ID_KEY, user.getAppId());
        BaseContextHandler.setToken(token);
        ctx.addZuulRequestHeader(serviceAuthConfig.getTokenHeader(), token);
        return null;
    }

    private void checkUserTokenValid(List<Object> userInfo) {

        UserTokenExtInfo userTokenExtInfo = userToken.getUserTokenExtInfo(userInfo);
        if (userTokenExtInfo == null || userTokenExtInfo.getLogoutFlag() == null) {
            return;
        }

        Integer logoutFlagInt = userTokenExtInfo.getLogoutFlag();

        if (logoutFlagStorage.existLogutFlag(logoutFlagInt)) {
            throw new BizException(TOKEN_TIMEOUT_ERROR_CODE, "登录超时，请重新登录");
        }
    }

    private List<Object> getUserToken(String token) {

        try {
            token = URLDecoder.decode(token, "utf-8");
            return userToken.uncoder(token);
        } catch (Exception e) {
            //不是标准的userToken   说明是appToken
        }
        return null;
    }

    private void addSpanConsumerAppIdAndProducerServiceId(HttpServletRequest request, String appId,String serviceId) {
        Span spanFromRequest = (Span) request.getAttribute(TRACE_REQUEST_ATTR);
        if (spanFromRequest.getTraceId() == spanFromRequest.getSpanId()) {
            //只有跟节点加入appid   调用端标志
        	String appidServiceId = appId+"@" + serviceId;
            spanFromRequest.tag("app_id", appidServiceId);
            spanFromRequest.setBaggageItem("app_id", appidServiceId);
        }
    }


    private boolean authCheck(String appId, Long userId, RequestContext ctx, String token) {

    	String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
    	String uri = (String) ctx.get(FilterConstants.REQUEST_URI_KEY);
    	List<String> producerAppIds = applicationAuth.getAppIdsByServiceId(serviceId, token);
        if (applicationAuth.isJryy(appId, token)) {
            ctx.set("app_jryy");//表示外网关
            if (CollectionUtils.isEmpty(producerAppIds)) {
                return false;
            }
            Long moduleId = null;
            for (String producerAppIdTemp : producerAppIds) {
                log.info("外网关 producerAppIdTemp={}", producerAppIdTemp);
                moduleId = applicationAuth.moduleIdOfConsumerUseable(appId, producerAppIdTemp, uri, token);
                log.info("外网关 moduleId={}", moduleId);
                if (moduleId != null) {
                    break;
                }
            }
            ctx.set(CONSUMER_MODULE_ID_KEY, moduleId);
            return moduleId != null;
        } else {
            //非接入应用验证的是登录用户信息    走的是内网关验证流程
            boolean pass = userAuth.isPass(appId, userId, uri, token);
            if(pass) {
                if (!CollectionUtils.isEmpty(producerAppIds)) {
                	Long moduleId = null;
                    for (String producerAppIdTemp : producerAppIds) {
   
                        moduleId = applicationAuth.getModuleId(producerAppIdTemp, uri, token);
                        if (moduleId != null) {
                            break;
                        }
                    }
                    ctx.set(CONSUMER_MODULE_ID_KEY, moduleId);
                }
            }
            return pass;
        }
    }

    /**
     * 返回session中的用户信息
     *
     * @param request
     * @param ctx
     * @return
     */
    private IJWTInfo getJWTUser(String appToken) throws BizException {
        return serviceAuthUtil.getInfoFromToken(appToken);

    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String authToken = request.getHeader(serviceAuthConfig.getTokenHeader());
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter(serviceAuthConfig.getTokenHeader());
        }
        return authToken;
    }


    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        if (gateIgnoreProperties == null || gateIgnoreProperties.getStartWithList().isEmpty()) {
            return false;
        }
        for (String s : gateIgnoreProperties.getStartWithList()) {
            if (requestUri.startsWith(s) || PATH_MATCHER.match(s, requestUri)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(String body, int code) {
        log.info("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        // 返回错误码
        ctx.setResponseStatusCode(code);
        ctx.addZuulResponseHeader("Content-Type", "application/json;charset=UTF-8");
        if (ctx.getResponseBody() == null) {
            // 返回错误内容
            ctx.setResponseBody(body);
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
        }
    }

    private void errorResponse(String errMsg, int errCode, int httpStatusCode) {
        Result tokenError = Result.fail(errCode, errMsg);
        setFailedRequest(JSONUtils.toJsonString(tokenError), httpStatusCode);
    }

}

