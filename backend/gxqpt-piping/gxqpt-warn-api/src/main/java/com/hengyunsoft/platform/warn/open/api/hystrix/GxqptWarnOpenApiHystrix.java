package com.hengyunsoft.platform.warn.open.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.warn.open.api.GxqptWarnOpenApi;
import com.hengyunsoft.platform.warn.open.dto.UpdateGxqptWarnOpenDTO;
import org.springframework.stereotype.Component;

/**
 * 描述:熔断实现默认响应超时
 * @author zjr
 * @date 2018/06/26
 * @return
 */
@Component
public class GxqptWarnOpenApiHystrix implements GxqptWarnOpenApi{

    @Override
    public Result<Boolean> updateByIdAndUserId(UpdateGxqptWarnOpenDTO updateGxqptWarnOpenDTO){
        return Result.timeout();
    }
}
