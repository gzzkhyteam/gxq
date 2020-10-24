package com.hengyunsoft.platform.piping.open.hystrix;


import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.WarnMessageDTO;
import com.hengyunsoft.platform.piping.open.WarnMessageSendOpenApi;
import org.springframework.stereotype.Component;

@Component
public class WarnMessageOpenApiHystrix implements WarnMessageSendOpenApi {
    /**
     * 发送预警信息到rabbitMq
     * @param warnMessageDto
     * @return
     */
    @Override
    public Result<String> send(WarnMessageDTO warnMessageDto){return Result.timeout();}

    @Override
    public Result<String> saveInsideSend(WarnMessageDTO warnMessageDto) {return Result.timeout();
    }
}
