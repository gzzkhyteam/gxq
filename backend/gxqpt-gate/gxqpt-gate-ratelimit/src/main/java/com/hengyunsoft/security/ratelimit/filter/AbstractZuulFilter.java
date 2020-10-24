package com.hengyunsoft.security.ratelimit.filter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsBeanCache;
import com.hengyunsoft.platform.security.api.interfaces.InterfacesSettingsIdListCache;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;
import com.hengyunsoft.security.ratelimit.config.properties.GateIgnore2Properties;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;
import com.hengyunsoft.security.ratelimit.queue.SecurityQueueSender;
import com.hengyunsoft.utils.JSONUtils;
import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.util.UrlPathHelper;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Slf4j
public abstract class AbstractZuulFilter extends ZuulFilter {

    protected static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Autowired
    protected GateIgnore2Properties gateIgnoreProperties;
    protected final RouteLocator routeLocator;
    protected final RateLimitProperties properties;
    protected final SecurityQueueSender securityQueueSender;

    private static final String ANONYMOUS_APP = "anonymous_app";
    public final static String CONSUMER_APP_ID_KEY = "csm_app_id";
    public static final String PRODUCER_APP_ID_KEY = "pdr_app_id";
    /**
     * 操作人id   登录人
     */
    public static final String OPERATOR_USER_ID_KEY = "op_us_id";
    /**
     * 操作人名称   登录人
     */
    public static final String OPERATOR_USER_NAME_KEY = "op_us_ne";
    public static final String OPERATOR_USER_ACCOUNT_KEY = "os_us_act";
    private static final UrlPathHelper URL_PATH_HELPER = new UrlPathHelper();
	
    /**
     * 为zuul设置一个公共的前缀
     */
    @Value("${server.context-path}")
    protected String zuulPrefix;


    protected AbstractZuulFilter(RateLimitProperties properties, RouteLocator routeLocator, SecurityQueueSender securityQueueSender) {
        this.properties = properties;
        this.routeLocator = routeLocator;
        this.securityQueueSender = securityQueueSender;
    }

    /**
     * 设置错误响应头
     *
     * @param errMsg         错误信息
     * @param errCode        错误编码
     * @param httpStatusCode 响应状态码
     */
    protected void errorResponse(String errMsg, int errCode, int httpStatusCode) {
        Result tokenError = Result.fail(errCode, errMsg);
        setFailedRequest(JSONUtils.toJsonString(tokenError), httpStatusCode);
    }

    /**
     * 网关抛异常
     *
     * @param body 响应体
     * @param code 响应码
     */
    protected void setFailedRequest(String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        // 返回错误码
        ctx.setResponseStatusCode(code);
        ctx.addZuulResponseHeader("Content-Type", "application/json;charset=UTF-8");
//        if (ctx.getResponseBody() == null) {
        // 返回错误内容
        ctx.setResponseBody(body);
        // 过滤该请求，不对其进行路由
        ctx.setSendZuulResponse(false);
        log.info("setSendZuulResponse ====== false 禁止访问");
//        }
    }


    protected List<InterfaceConfigDTO> getList() {
        InterfacesSettingsIdListCache idListCache = InterfacesSettingsIdListCache.of();
        Optional<List<Long>> idListOptional = idListCache.get();

        if (!idListOptional.isPresent()) {
            return Collections.emptyList();
        }

        List<InterfaceConfigDTO> list = idListOptional.get().stream().map((id) -> {
            InterfacesSettingsBeanCache beanCache = InterfacesSettingsBeanCache.of(id);
            if (beanCache.get().isPresent()) {
                InterfaceConfigDTO interfaceConfigDTO = beanCache.get().get();
                return interfaceConfigDTO;
            }
            return null;
        }).collect(Collectors.toList());
        return list;
    }


    /**
     * 获取route
     *
     * @return
     */
    public Route route() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String requestURI = URL_PATH_HELPER.getPathWithinApplication(request);
        return routeLocator.getMatchingRoute(requestURI);
    }

    /**
     * 计算用于控制 接口阀值的 key
     * key 的规则为: 前缀:ROUTE_ID:URL:APP_ID
     *
     * @param ctx
     * @param policy
     * @return
     */
    protected String key(final String modularPrefix, final RequestContext ctx, final RateLimitProperties.Policy policy) {
        final Route route = route();
        final StringJoiner joiner = new StringJoiner(":");
        joiner.add(properties.getKeyPrefix());
        joiner.add(modularPrefix);
        joiner.add(route.getId());
        joiner.add(policy.getAppId());//接口的appId 为了区分不同应用的相同url
        joiner.add(policy.getMethod());//接口的方法 为了区分不同应用的相同url 不同的方法类型 (GET/POST/...)
        List<RateLimitProperties.Policy.Type> types = policy.getType();

        if (types != null && !types.isEmpty()) {
            if (types.contains(RateLimitProperties.Policy.Type.URL)) {
                joiner.add(ctx.getRequest().getRequestURI());
            }
            //调用者应用id 针对每个调用者，进行限制
            if (types.contains(RateLimitProperties.Policy.Type.APP)) {
                String appId = (String) ctx.get(CONSUMER_APP_ID_KEY);
                joiner.add(StringUtils.isNotEmpty(appId) ? appId : ANONYMOUS_APP);
            }
//            if (types.contains(RateLimitProperties.Policy.Type.ORIGIN)) {
//                joiner.add(getRemoteAddr(request));
//            }
//            if (types.contains(RateLimitProperties.Policy.Type.USER)) {
//                String name = userPrincipal.getName(request);
//                joiner.add(name != null ? name : ANONYMOUS_USER);
//            }
        }
        log.info("key={}", joiner.toString());
        return joiner.toString();
    }

    /**
     * 获取 调用方IP
     *
     * @param request
     * @return
     */
    protected String getRemoteAddr(final HttpServletRequest request) {
        String ip = request.getHeader(com.google.common.net.HttpHeaders.X_FORWARDED_FOR);
        if (properties.isBehindProxy() && ip != null) {
            return ip;
        }
        return request.getRemoteAddr();
    }


    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    protected boolean isStartWith(String requestUri) {
        if (gateIgnoreProperties == null || gateIgnoreProperties.getStartWithList().isEmpty()) {
            return false;
        }
        //共享交换有特殊需求，需要拦截:/exchange/p/api/sharedataapiopen
        if (requestUri.startsWith("/exchange/p/api/sharedataapiopen")) {
            return false;
        }
        for (String s : gateIgnoreProperties.getStartWithList()) {
            if (requestUri.startsWith(s) || PATH_MATCHER.match(s, requestUri)) {
                return true;
            }
        }
        return false;
    }

    protected Optional<Pair<String, String>> getPairByHeader(RequestContext ctx, String header) {
        List<Pair<String, String>> zuulResponseHeaders = ctx.getZuulResponseHeaders();
        List<Pair<String, String>> pairList = zuulResponseHeaders.stream().filter((pair) -> pair.first().equalsIgnoreCase(header))
                .collect(Collectors.toList());
        if (pairList != null && !pairList.isEmpty()) {
            Pair<String, String> pair = pairList.get(0);

            return Optional.ofNullable(pair);
        }
        return Optional.empty();
    }

    @Override
    public Object run() {
        final RequestContext ctx = RequestContext.getCurrentContext();
        final HttpServletRequest request = ctx.getRequest();
        final HttpServletResponse response = ctx.getResponse();

        final String requestURI = request.getRequestURI().substring(zuulPrefix.length());

        // 不进行拦截的地址
        if (isStartWith(requestURI)) {
            log.info("{} filter not execute = {}", this.getClass().getName(), requestURI);
            return null;
        }

        return this.run(ctx, request, response);
    }

    protected abstract Object run(final RequestContext ctx, final HttpServletRequest request, final HttpServletResponse response);
}
