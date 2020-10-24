package com.hengyunsoft.platform.piping.open;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.open.hystrix.SmsSendApiHystrix;

@FeignClient(name = "${gxqpt.feign.piping-server:gxqpt-piping-server}",
        fallback = SmsSendApiHystrix.class)
public interface SmsSendApi {
    /**
     * 发送信息到rabbitMq
     *
     * @param msgSendDTO
     * @return
     */
    @RequestMapping(value = "/p/sms/send", method = RequestMethod.POST)
    Result<String> send(@RequestBody SmsSendDTO smsSendDTO);
}
