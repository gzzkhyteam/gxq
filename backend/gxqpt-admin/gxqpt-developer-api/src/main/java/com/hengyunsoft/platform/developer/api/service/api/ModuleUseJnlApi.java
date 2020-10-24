package com.hengyunsoft.platform.developer.api.service.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.ModuleUseJnlApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * com.hengyunsoft.platform.developer.api.service.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：开发者调用日志记录Api
 * 修改人：sunxiaoya
 * 修改时间：2018/4/17
 * 修改内容：
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        fallback = ModuleUseJnlApiHystrix.class)
public interface ModuleUseJnlApi {

    /**
     * 描述：开发者调用日志记录Api
     * 参数：[ModuleUseJnlSaveDTO：开发者调用日志记录]
     * 返回值：ModuleUseJnlSaveDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @RequestMapping(value = "/moduleUse/save", method = RequestMethod.POST)
    Result<Boolean> save(@RequestBody ModuleUseJnlSaveDTO dto);

    /**
     * 描述：开发者调用日志记录Api
     * 参数：[ModuleUseJnlDTO：开发者调用日志记录]
     * 返回值：ModuleUseJnlMsgDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/19
     * 修改内容：
     */
    @RequestMapping(value = "/moduleUse/getJnl", method = RequestMethod.POST)
    Result<List<ModuleUseJnlMsgDTO>> getJnl(@RequestBody ModuleUseJnlDTO dto);

    /**
     * 获取模块调用总量
     * @return
     */
    @RequestMapping(value = "/moduleUse/getSumTotalNum",method =RequestMethod.GET )
    Result<ModuleUseTotalDTO> getSumTotalNum();

    /**
     * 统计全天模块调用数
     * @return
     */
    @RequestMapping(value ="/moduleUser/findDayData",method =RequestMethod.GET )
    Result<List<ModuleUseDayDataDTO>> findDayData();

    /**
     * 获取接口调用排行榜
     * @return
     */
    @RequestMapping(value = "/moduleUser/getModuleUseRank", method = RequestMethod.GET)
    Result<List<ModuleUseRankDTO>> getModuleUseRank();

}
