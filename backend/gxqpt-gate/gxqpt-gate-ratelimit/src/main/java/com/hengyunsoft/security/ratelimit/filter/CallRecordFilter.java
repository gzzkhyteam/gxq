package com.hengyunsoft.security.ratelimit.filter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.utils.ClientUtil;
import com.hengyunsoft.security.ratelimit.config.properties.RateLimitProperties;
import com.hengyunsoft.security.ratelimit.queue.InterfaceCallRecordDTO;
import com.hengyunsoft.security.ratelimit.queue.SecurityQueueSender;
import com.hengyunsoft.utils.JSONUtils;
import com.netflix.util.Pair;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StreamUtils;

/**
 * 记录
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Slf4j
public class CallRecordFilter extends AbstractZuulFilter {


    public CallRecordFilter(RateLimitProperties properties, RouteLocator routeLocator, SecurityQueueSender securityQueueSender) {
        super(properties, routeLocator, securityQueueSender);
    }


    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 4;
    }

    @Override
    public boolean shouldFilter() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        return properties.isEnabled() && ctx.get(CONSUMER_APP_ID_KEY) != null;
        return properties.isEnabled();
//        return true;
    }


    @Override
    public Object run(final RequestContext ctx, final HttpServletRequest request, final HttpServletResponse response) {
        InputStream responseDataStream = ctx.getResponseDataStream();
        String body = null;
        try {
            String callerAppId = (String) ctx.get(CONSUMER_APP_ID_KEY);
            String ip = ClientUtil.getClientIp(request);

            //从报文头获取api名称
            List<Pair<String, String>> zuulHeaders = ctx.getZuulResponseHeaders();
            String apiName = null;
            for(Pair li:zuulHeaders){
                if(li.first()!=null){
                    if(CommonConstants.CALL_RECORD_API_NAME.equals(li.first().toString())){
                        if(li.second()!=null){
                            apiName = URLDecoder.decode(li.second().toString(),"utf-8");
                            //这个响应头主要用于告知网关，由网关记录调用信息，不需要给客户端（调用端的）
                            zuulHeaders.remove(li);
                            break ;
                        }
                    }
                }
            }

            //cookies
            Cookie[] cookies = request.getCookies();
            String cookiesJson = JSONObject.toJSONString(cookies);

            //请求头
            Map<String, String> zuulRequestHeaders = ctx.getZuulRequestHeaders();
            String headers = JSONObject.toJSONString(zuulRequestHeaders);

            String queryString = request.getQueryString();

            //参数
            String requestQueryParams = JSONObject.toJSONString(ctx.getRequestQueryParams());

            String contentType = request.getContentType();
            int contentLength = request.getContentLength();

            //请求类型
            String method = request.getMethod();


            int status = 0;
            String errMsg = "";

            Optional<Pair<String, String>> pairOptional = getPairByHeader(ctx, "Content-Type");

            if (pairOptional.isPresent()) {
                Pair<String, String> pair = pairOptional.get();
                if (!("application/force-download; charset=UTF-8".equalsIgnoreCase(pair.second())
                        || StringUtils.contains(pair.second().toLowerCase(), "application/force-download")
                        || StringUtils.contains(pair.second().toLowerCase(), "application/octet-stream")
                )) {  //下载类 接口不能
                    body = StreamUtils.copyToString(responseDataStream, Charset.forName("UTF-8"));
                }
            } else {
                body = StreamUtils.copyToString(responseDataStream, Charset.forName("UTF-8"));
            }

            log.info("ctx.getResponseStatusCode()={} ", ctx.getResponseStatusCode());
            log.info("ctx.getResponseBody()={} ", ctx.getResponseBody());
            if (StringUtils.isEmpty(body)) {
                body = ctx.getResponseBody();
            }
            if (StringUtils.isNotBlank(body)) {
                Result result = JSONUtils.parse(body, Result.class);

                if (result == null) {
                    status = 1; //0成功 1 是解析json失败 其他是具体的错误码
                    errMsg = StringUtils.substring(body, 0, 5000);  //不是json 格式
                } else if (!result.isSuccess()) {
                    status = result.getErrcode(); //0成功 1 是解析json失败 其他是具体的错误码
                    errMsg = result.getErrmsg();
                }
            } else {
                int responseStatusCode = ctx.getResponseStatusCode();
                if (responseStatusCode != 200) {
                    status = responseStatusCode;// 0成功 1 是解析json失败 其他是具体的错误码
                    errMsg = ctx.getResponseBody();
                }
            }
            InterfaceCallRecordDTO dto = new InterfaceCallRecordDTO();
            dto.setAppId((String)ctx.get(FilterConstants.SERVICE_ID_KEY));
            dto.setCallerAppId(callerAppId);
            dto.setUserId((Long)ctx.get(AbstractZuulFilter.OPERATOR_USER_ID_KEY));
            dto.setUserName((String)ctx.get(AbstractZuulFilter.OPERATOR_USER_NAME_KEY));
            dto.setAccount((String)ctx.get(AbstractZuulFilter.OPERATOR_USER_ACCOUNT_KEY));
            dto.setUri(request.getRequestURI());
            dto.setUrl(request.getRequestURL().toString());
            dto.setZuulUri(ctx.get(FilterConstants.REQUEST_URI_KEY) != null ? (String) ctx.get(FilterConstants.REQUEST_URI_KEY) : null);
            dto.setIp(ip);
            dto.setCookies(cookiesJson);
            dto.setHeaders(headers);
            dto.setQueryString(queryString);
            dto.setRequestQueryParams(requestQueryParams);
            dto.setContentLength(String.valueOf(contentLength));
            dto.setContentType(contentType);
            dto.setMethod(method);
            dto.setResponseBody(body);
            dto.setCreateTime(new Date());
            dto.setStatus(status);
            dto.setErrMsg(errMsg);
            dto.setName(apiName);
            
            securityQueueSender.send(dto);
            //log.info("安全保障平台消息队列发送，InterfaceCallRecordDTO[{}]",dto);
        } catch (Exception e) {
            log.info("body={}", body);
            log.error("调用日志记录异常", e);
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

        return null;
    }


}
