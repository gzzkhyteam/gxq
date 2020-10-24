package com.hengyunsoft.platform.sms.open;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.sms.open.hystrix.SmsTemplateOpenApiHystrix;
/**
 * 短信模板管理接口
 * @author Administrator
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/sms",
fallback = SmsTemplateOpenApiHystrix.class)
public interface SmsTemplateOpenApi {
    /**
     * 获取某个渠道下的模板列表
     * @return
     */
    @RequestMapping(value = "/p/smstemplate/channellist", method = RequestMethod.GET)
    Result<List<Map<String,Object>>> getSmsTemplateChannelList(@RequestParam(value = "channelid") String channelid);
}
