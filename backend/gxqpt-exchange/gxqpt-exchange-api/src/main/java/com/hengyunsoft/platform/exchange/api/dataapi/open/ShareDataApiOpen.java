package com.hengyunsoft.platform.exchange.api.dataapi.open;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiCallDto;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiOpenDto;
import com.hengyunsoft.platform.exchange.api.dataapi.open.hystrix.ShareDataApiOpenHystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色管理Api
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.feign.exchange-server:gxqpt-exchange-server}"
//        , path = "api/exchange"
        ,fallback = ShareDataApiOpenHystrix.class
)
public interface ShareDataApiOpen {
//    /**
//     * 描述：根据密钥获取API数据
//     * 参数：secretKey
//     * 返回值：Result<List<Object>>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/8
//     * 修改内容：
//     */
//    @RequestMapping(value = {"/p/api/sharedataapiopen/{apiCode}/{secretKey}","/sharedataapiopen/{apiCode}"}, method = RequestMethod.GET)
//    Result<Object> findData(HttpServletRequest request,@PathVariable(value = "apiCode") String apiCode, @PathVariable(value = "secretKey") String secretKey);

    /**
     * 描述：获取外部调用所有API
     * 返回值： PageInfo<ApiOpenDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/7/4
     * 修改内容：
     */
    @RequestMapping(value = "/p/api/getAllUserApi", method = RequestMethod.POST)
    Result<PageInfo<ApiOpenDto>> getAllUserApi(@RequestBody OpenApiReq openApiReq);
    /**
     * 描述：根据用户Id查询可调用的API的申请Id
     * 返回值： PageInfo<ApiOpenDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/7/23
     * 修改内容：
     */
    @RequestMapping(value = "/p/api/getApiByUserId", method = RequestMethod.POST)
    Result<PageInfo<Long>> getApiByUserId(@RequestBody OpenApiReq<ApiCallDto> openApiReq);
}
