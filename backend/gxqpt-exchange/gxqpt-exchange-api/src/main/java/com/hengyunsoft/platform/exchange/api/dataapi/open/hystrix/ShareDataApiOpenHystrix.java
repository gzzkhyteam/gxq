package com.hengyunsoft.platform.exchange.api.dataapi.open.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiCallDto;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiOpenDto;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyListDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.open.ShareDataApiOpen;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：熔断机制的实现， 默认返回超时响应
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：新增熔断机制
 */
@Component
public class ShareDataApiOpenHystrix implements ShareDataApiOpen{
//    @Override
//    public Result<Object> findData(HttpServletRequest request,String apiCode, String secretKey) {
//        return Result.timeout();
//    }

    @Override
    public Result<PageInfo<ApiOpenDto>> getAllUserApi(OpenApiReq openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<Long>> getApiByUserId(OpenApiReq<ApiCallDto> openApiReq) {
        return Result.timeout();
    }
}
