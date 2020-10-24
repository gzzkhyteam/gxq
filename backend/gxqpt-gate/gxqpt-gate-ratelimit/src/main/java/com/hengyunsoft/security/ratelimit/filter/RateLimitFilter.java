package com.hengyunsoft.security.ratelimit.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;
import com.hengyunsoft.security.ratelimit.queue.InterfaceWarnSms;
import com.hengyunsoft.security.ratelimit.queue.SecurityQueueSender;
import com.hengyunsoft.security.ratelimit.service.Rate;
import com.hengyunsoft.security.ratelimit.service.ratelimit.RateLimiter;
import com.hengyunsoft.utils.JSONUtils;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;

/**
 * 接口调用阀值限制 过滤器
 * <p>
 * 环境(Context)角色：持有一个Strategy（RateLimiter）的引用。
 *
 * @auth tangyh
 * @date 2018/07/03
 */
@Slf4j
public class RateLimitFilter extends AbstractZuulFilter {

    private static final String KEY_UPPER_PERFIX = "upper";
    private static final String LIMIT_HEADER = "x-ratelimit-limit";
    private static final String REMAINING_HEADER = "x-ratelimit-remaining";
    private static final String RESET_HEADER = "x-ratelimit-reset";

    private final RateLimiter rateLimiter;


    public RateLimitFilter(RateLimiter rateLimiter, RateLimitProperties properties,
                           RouteLocator routeLocator, SecurityQueueSender securityQueueSender) {
        super(properties, routeLocator, securityQueueSender);
        this.rateLimiter = rateLimiter;
    }

    /**
     * 前置过滤器
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 一定要在 {@link com.hengyunsoft.security.gete.filter.AdminAccessFilter } 过滤器之后执行，因为这个过滤器解析了token ，
     * 而我们需要取 appId 等信息就必须在它之后
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        final HttpServletRequest request = ctx.getRequest();
        String requestUri = request.getRequestURI().substring(zuulPrefix.length());

        //共享交换有特殊需求，需要拦截:/exchange/p/api/sharedataapiopen
        if (properties.isEnabled() && requestUri.startsWith("/exchange/p/api/sharedataapiopen")) {
            return true;
        }
        return properties.isEnabled()
                && ctx.getBoolean("app_jryy") //只限制外网关
//                && ctx.get(CONSUMER_APP_ID_KEY) != null
//                && ctx.get(PRODUCER_APP_ID_KEY) != null
                ;
    }

    @Override
    public Object run(final RequestContext ctx, final HttpServletRequest request, final HttpServletResponse response) {

        log.info("current uri={}, url={}", request.getRequestURI(), request.getRequestURL());
        List<InterfaceConfigDTO> list = getList();
        log.info("list.size={}", list.size());
        //查询 每日上限拦截策略
        Optional<RateLimitProperties.Policy> po = upperLimitCountByDayPolicy(list, request);

        //接口调用次数计数， 并响应响应的状态值
        po.ifPresent(policy -> {
            //gate_rate:KEY:securiry:/client/testGetUser:APP_ID
            String key = key(KEY_UPPER_PERFIX, ctx, policy);
            log.info("ratelimit key={}, policy={}", key, JSONUtils.toJsonString(policy));

            final Rate rate = rateLimiter.consume(policy, key);
            response.setHeader(LIMIT_HEADER, policy.getLimit().toString());  //限制次数
            response.setHeader(REMAINING_HEADER, String.valueOf(rate.getRemaining())); //限制次数内，剩下可调用次数
            response.setHeader(RESET_HEADER, rate.getReset().toString()); //重置时间

            //超出阀值
            if (rate.getRemaining() < 0) {
                //发送短信通知
                InterfaceWarnSms warnSms = new InterfaceWarnSms();
                warnSms.setId(policy.getId());
                warnSms.setStatus(InterfaceWarnSms.UPPER_DAY);
                securityQueueSender.sendWarnSms(warnSms);

                errorResponse("请求超过限制次数", TOO_MANY_REQUESTS.value(), TOO_MANY_REQUESTS.value());
                //请求频繁报错 这里不能报错。 否则client 接受不到响应体
                //throw new ZuulRuntimeException(new ZuulException(TOO_MANY_REQUESTS.toString(), TOO_MANY_REQUESTS.value(), null));
            }
        });

        return null;
    }


    /**
     * 获取 接口阀值 每日上限 策略
     *
     * @return
     */
    private Optional<RateLimitProperties.Policy> upperLimitCountByDayPolicy(List<InterfaceConfigDTO> list, final HttpServletRequest request) {
//        Route route = route();
//        if (route != null) {
//            return properties.getPolicy(route.getId());
//        }
//        return Optional.ofNullable(properties.getDefaultPolicy());


        for (InterfaceConfigDTO ic : list) {
            if (ic == null || ic.getUpperLimitCountByDay() == null || ic.getUpperLimitCountByDay() <= 0) {
                continue;
            }
            if (ic.getStatus() == null || ic.getStatus() == 0) {  //未设置的， 不统计
                continue;
            }
//apiURL=\/p\/org\/getOrgInfoByUserId, uri=\/p\/org\/getOrgInfoByUserId
            RequestContext ctx = RequestContext.getCurrentContext();
            //相对路径
            String uri = ctx.get(FilterConstants.REQUEST_URI_KEY) != null ? (String) ctx.get(FilterConstants.REQUEST_URI_KEY) : null;
            //被调用方appid
            String pdrAppId = ctx.get(PRODUCER_APP_ID_KEY) != null ? (String) ctx.get(PRODUCER_APP_ID_KEY) : null;

            log.info("apiURL={}, uri={}, pdrAppId={}, URL={}", ic.getApiUrl(), uri, pdrAppId, request.getRequestURL());

            boolean judgeAppIdAndUri = false;
            //判断appid 和 具体相对路径是否一致  // pdrAppId 获取时有问题，不校验了
            if (StringUtils.isNotEmpty(pdrAppId)) {
                judgeAppIdAndUri = StringUtils.equals(pdrAppId, ic.getAppId()) && StringUtils.equals(uri, ic.getApiUrl());
            } else {
                judgeAppIdAndUri = StringUtils.equals(uri, ic.getApiUrl());
            }

            //判断绝对路径是否一致
            boolean judgeUri = StringUtils.equals(request.getRequestURI(), ic.getApiUrl());
            //判断 网关相对路径是否一致
            boolean judgeUrl = StringUtils.equals(request.getRequestURL().toString(), ic.getApiUrl());
            //判断 接口类型是否一致
            boolean judgeMethod = StringUtils.equalsIgnoreCase(request.getMethod(), ic.getMethod()); //POST/GET/DELETE...

            // 满足 url中任意一个符合 并且 方法类型一致
            if ((judgeAppIdAndUri || judgeUri || judgeUrl) && judgeMethod) {

                RateLimitProperties.Policy policy = new RateLimitProperties.Policy();
                policy.setCycleType(RateLimitProperties.Policy.DAY_INTERVAL);

                policy.setLimit(Long.valueOf(ic.getUpperLimitCountByDay()));
                policy.setDay(1);
                List<RateLimitProperties.Policy.Type> type = new ArrayList<>();
                type.add(RateLimitProperties.Policy.Type.URL);
                type.add(RateLimitProperties.Policy.Type.APP);
                policy.setType(type);

                //接口所属的应用id 区分应用下相同的url
                policy.setAppId(ic.getAppId());
                policy.setMethod(ic.getMethod());
                policy.setId(ic.getId());
                return Optional.ofNullable(policy);
            }
        }
        return Optional.empty();

//        RateLimitProperties.Policy policy = new RateLimitProperties.Policy();
//        policy.setCycleType(RateLimitProperties.Policy.DAY_INTERVAL);
//        policy.setLimit(10L);
//        policy.setDay(1);
//        List<RateLimitProperties.Policy.Type> type = new ArrayList<>();
//        type.add(RateLimitProperties.Policy.Type.URL);
//        type.add(RateLimitProperties.Policy.Type.APP);
//        policy.setType(type);
//        return Optional.ofNullable(policy);
    }


}
