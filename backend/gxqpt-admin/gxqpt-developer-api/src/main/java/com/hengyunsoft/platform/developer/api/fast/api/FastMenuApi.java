package com.hengyunsoft.platform.developer.api.fast.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.fast.api.hystrix.FastMenuApiHystrix;
import com.hengyunsoft.platform.developer.api.fast.dto.FastBizConfigDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.FastMenuReqDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.FastMenuUpdateDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 快速菜单服务管理
 *
 * @author wt
 * @createTime 2018年5月3日
 *
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        fallback = FastMenuApiHystrix.class)
public interface FastMenuApi {

    /**
     * 描述：根据id查询快速应用业务场景配置Api
     * 参数：parentId
     * 返回值：FastMenuDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/fastmenu/getBizConfig", method = RequestMethod.GET)
    Result<List<FastBizConfigDTO>> getBizConfig(@RequestParam("parentId") Long parentId);

    /**
     * 描述：根据id查询快速应用菜单Api
     * 参数：id
     * 返回值：FastMenuDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    Result<String> getMenu(@RequestBody FastMenuReqDTO dto);

    /**
     * 描述：快速应用菜单更新Api
     * 参数：FastMenuUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody FastMenuUpdateDTO dto);

}
