package com.hengyunsoft.platform.piping.open;


import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.WarnMessageDTO;
import com.hengyunsoft.platform.piping.open.hystrix.WarnMessageOpenApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${gxqpt.feign.piping-server:gxqpt-piping-server}",
        fallback = WarnMessageOpenApiHystrix.class)
public interface WarnMessageSendOpenApi {
    /**
     * 发送预警信息到消息队列（rabbitMq）
     * @param warnMessageDto
     * @return
     */
    @RequestMapping(value = "/p/warnmsg/send", method = RequestMethod.POST)
    Result<String> send(@RequestBody WarnMessageDTO warnMessageDto);

    /**
     * 内部发送预警信息到消息队列（rabbitMq）
     * @param warnMessageDto
     * @return
     */
    @RequestMapping(value = "/p/warnmsg/saveInsideSend", method = RequestMethod.POST)
    Result<String> saveInsideSend(@RequestBody WarnMessageDTO warnMessageDto);
}
