package com.hengyunsoft.security.ratelimit.filter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.platform.security.dto.interfaces.InterfaceConfigDTO;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;
import com.hengyunsoft.security.ratelimit.queue.InterfaceWarnSms;
import com.hengyunsoft.security.ratelimit.queue.SecurityQueueSender;
import com.hengyunsoft.security.ratelimit.service.Rate;
import com.hengyunsoft.security.ratelimit.service.ratelimit.RateLimiter;
import com.hengyunsoft.utils.JSONUtils;
import com.netflix.util.Pair;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StreamUtils;

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
public class WarnLimitFilter extends AbstractZuulFilter {

    private static final String KEY_WAIT_PERFIX = "warn";

    private static final String WARN_LIMIT_HEADER = "x-warn-limit";
    private static final String WARN_REMAINING_HEADER = "x-warn-remaining";
    private static final String WARN_RESET_HEADER = "x-warn-reset";

    private final RateLimiter warnLimiter;


    public WarnLimitFilter(RateLimiter warnLimiter, RateLimitProperties properties,
                           RouteLocator routeLocator, SecurityQueueSender securityQueueSender) {
        super(properties, routeLocator, securityQueueSender);
        this.warnLimiter = warnLimiter;
    }


    /**
     * 前置过滤器
     */
    @Override
    public String filterType() {
        return "post";
    }

    /**
     * 一定要在
     * {@link com.hengyunsoft.security.gete.filter.AdminAccessFilter }
     * 过滤器之后执行，因为这个过滤器解析了token ，
     * 而我们需要取 appId 等信息就必须在它之后
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 3;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        InputStream responseDataStream = ctx.getResponseDataStream();
        String body = null;
        try {
            final String requestURI = ctx.getRequest().getRequestURI().substring(zuulPrefix.length());

            // 不进行拦截的地址
            if (isStartWith(requestURI)) {
                log.info("warn filter not execute = {}", requestURI);
                return false;
            }

            Optional<Pair<String, String>> pairOptional = getPairByHeader(ctx, "Content-Type");
            if (pairOptional.isPresent()) {
                Pair<String, String> pair = pairOptional.get();
                if ("application/force-download; charset=UTF-8".equalsIgnoreCase(pair.second())
                        || StringUtils.contains(pair.second().toLowerCase(), "application/force-download")
                        || StringUtils.contains(pair.second().toLowerCase(), "application/octet-stream")
                        ) {
                    return false;
                }
            }

            body = StreamUtils.copyToString(responseDataStream, Charset.forName("UTF-8"));
//            ctx.setResponseBody(body);//方法2
            if (StringUtils.isNotBlank(body)) {
                Result result = JSONUtils.parse(body, Result.class);
                if (result != null && (result.getErrcode() == ExceptionCode.SYSTEM_BUSY.getCode()
                        || result.getErrcode() == ExceptionCode.SYSTEM_TIMEOUT.getCode()
                        || result.getErrcode() == ExceptionCode.NOT_FOUND.getCode()
                        || result.getErrcode() == ExceptionCode.BAD_GATEWAY.getCode()
                        || result.getErrcode() == ExceptionCode.GATEWAY_TIMEOUT.getCode())
                        ) {
                    //共享交换有特殊需求，需要拦截:/exchange/p/api/sharedataapiopen
                    if (properties.isEnabled() && requestURI.startsWith("/exchange/p/api/sharedataapiopen")) {
                        return true;
                    }

                    return properties.isEnabled()
                            &&  ctx.getBoolean("app_jryy")
//                            && ctx.get(CONSUMER_APP_ID_KEY) != null
                            && ctx.get(PRODUCER_APP_ID_KEY) != null;
                }
            }


        } catch (Exception e) {
            log.error("预警拦截器发生异常", e);
        } finally {
            try {
                if (StringUtils.isNotEmpty(body)) {
                    // responseDataStream为IO流,仅能读取一次,需要重新将数据写入
                    ctx.setResponseDataStream(new ByteArrayInputStream(body.getBytes(Charset.forName("UTF-8"))));
                }
            } catch (Exception e) {
                log.error("重置响应数据发生异常", e);
            }
        }

//        ctx.setResponseDataStream(responseDataStream);
        return false;
    }

    @Override
    public Object run(final RequestContext ctx, final HttpServletRequest request, final HttpServletResponse response) {

        log.info("warn filter current uri={}, url={}", request.getRequestURI(), request.getRequestURL());
        List<InterfaceConfigDTO> list = getList();

        //查询 预警阀值 策略
        Optional<RateLimitProperties.Policy> errorPo = errorCountMinutePolicy(list, request);

        //接口调用次数计数， 并响应响应的状态值
        errorPo.ifPresent(policy -> {
            String key = key(KEY_WAIT_PERFIX, ctx, policy);
            log.info("warn filter key={}, policy={}", key, JSONUtils.toJsonString(policy));

            final Rate rate = warnLimiter.consume(policy, key);
            response.setHeader(WARN_LIMIT_HEADER, policy.getLimit().toString());  //限制次数
            response.setHeader(WARN_REMAINING_HEADER, String.valueOf(rate.getRemaining())); //限制次数内，剩下可调用次数
            response.setHeader(WARN_RESET_HEADER, rate.getReset().toString()); //重置时间

            //超出阀值
            if (rate.getRemaining() < 0) {
                //发送短信通知
                InterfaceWarnSms warnSms = new InterfaceWarnSms();
                warnSms.setId(policy.getId());
                warnSms.setStatus(InterfaceWarnSms.WARN);
                securityQueueSender.sendWarnSms(warnSms);

                // 只有 pre 类型的过滤器才能终止转发。  详情查看 ZuulServletFilter（76行） 源码
                errorResponse("请求超过预警次数", TOO_MANY_REQUESTS.value(), TOO_MANY_REQUESTS.value());
            }
        });

        return null;
    }


    /**
     * 获取 预警阀值 策略
     *
     * @param request
     * @return
     */
    private Optional<RateLimitProperties.Policy> errorCountMinutePolicy(List<InterfaceConfigDTO> list, final HttpServletRequest request) {
        for (InterfaceConfigDTO ic : list) {
            if (ic == null || ic.getUpperLimitCountByDay() == null || ic.getUpperLimitCountByDay() <= 0) {
                continue;
            }
            RequestContext ctx = RequestContext.getCurrentContext();
            //相对路径
            String uri = ctx.get(FilterConstants.REQUEST_URI_KEY) != null ? (String) ctx.get(FilterConstants.REQUEST_URI_KEY) : null;
            //被调用方appid
            String pdrAppId = ctx.get(PRODUCER_APP_ID_KEY) != null ? (String) ctx.get(PRODUCER_APP_ID_KEY) : null;

            log.info("apiURL={}, uri={}, pdrAppId={}, URL={}", ic.getApiUrl(), uri, pdrAppId, request.getRequestURL());

            //判断appid 和 具体相对路径是否一致  // pdrAppId 获取时有问题，不校验了
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
                policy.setCycleType(RateLimitProperties.Policy.REFRESH_INTERVAL);

                policy.setLimit(Long.valueOf(ic.getErrorCountMinute()));
                policy.setRefreshInterval(5 * 60L); //业务需求是5分钟
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

    }


}
