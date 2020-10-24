package com.hengyunsoft.platform.developer.api.fast.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.hystrix.FastApplicationApiHystrix;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import com.hengyunsoft.platform.developer.api.fast.dto.RequestApplicationSaveDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 快速应用服务管理
 *
 * @author wt
 * @createTime 2018年5月3日
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        fallback = FastApplicationApiHystrix.class)
public interface FastApplicationApi {

    /**
     * 描述：快速应用分页Api
     * 参数：[FastApplicationPageDTO：快速应用分页]
     * 返回值：<PageInfo<FastApplicationPageRetDTO>>
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/page", method = RequestMethod.POST)
    Result<PageInfo<FastApplicationPageRetDTO>> page(@RequestBody OpenApiReq<FastApplicationPageDTO> openApiReq);

    /**
     * 描述：快速应用启用Api
     * 参数：FastApplicationStartUseDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/startUse", method = RequestMethod.POST)
    Result<Boolean> startUse(@RequestBody FastApplicationStartUseDTO dto);

    /**
     * 描述：快速应用更新Api
     * 参数：FastApplicationUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody FastApplicationUpdateDTO dto);

    /**
     * 描述：根据id查询快速应用详情Api
     * 参数：id
     * 返回值：ResponseApplicationDetailDTO
     * 修改人：wt
     * 修改时间：2018/5/4
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/detail", method = RequestMethod.GET)
    Result<ResponseApplicationDetailDTO> getById(@RequestParam(value = "id") Long id);
    @RequestMapping(value = "/fastapplication/detailByAppId", method = RequestMethod.GET)
    Result<ResponseApplicationDetailDTO> detailByAppId(@RequestParam(value = "appId") String appId);

    /**
     * 描述：新增应用服务
     * 参数：RequestApplicationSaveDTO
     * 返回值：Result<Boolean>
     * 修改人：wt
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/save", method = RequestMethod.POST)
    Result<Boolean> save(@RequestBody RequestApplicationSaveDTO dto);

    /**
     * 描述：查询所有应用、服务、模块、平台信息
     * 参数：
     * 返回值：ResponseApplicationDetailDTO
     * 修改人：wt
     * 修改时间：2018/5/4
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/findAllApp", method = RequestMethod.GET)
    Result<ResponseApplicationDetailDTO> findAllApplicaton();

    /**
     * 描述：根据appid查询关联的服务、模块信息
     * 参数：id
     * 返回值：ResponseApplicationDetailDTO
     * 修改人：wt
     * 修改时间：2018/5/4
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplication/findAppRelation", method = RequestMethod.GET)
    Result<ResponseApplicationDetailDTO> findApplicationRelation(@RequestParam("appId") String appId);
}

