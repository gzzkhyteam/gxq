package com.hengyunsoft.platform.admin.api.authority.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.api.hystrix.FastEntryApiHystrix;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryRankDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntrySaveDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryUpdateDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：快捷入口管理Api
 * 修改人：sunxiaoya
 * 修改时间：2018/3/28
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-gate-server}",
        path = "/api/admin", fallback = FastEntryApiHystrix.class)
public interface FastEntryApi {

    /**
     * 描述：新增快捷入口Api
     * 参数：[FastEntryDto：快捷入口新增实体]
     * 返回值：FastEntryDto
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @RequestMapping(value = "/fastEntry/save", method = RequestMethod.POST)
    Result<FastEntrySaveDTO> save(@RequestBody FastEntrySaveDTO fastEntryDto);

    /**
     * 描述：快捷入口
     * 参数：FastEntryUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @RequestMapping(value = "/fastEntry/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody FastEntryUpdateDTO fastEntryUpdateDTO);

    /**
     * 描述：删除快捷入口Api
     * 参数：快捷入口id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @RequestMapping(value = "/fastEntry/delete", method = RequestMethod.POST)
    Result<Boolean> delete(@RequestParam("id") Long id);


    /**
     * 描述：根据userId查询快捷入口Api
     * 参数：userId
     * 返回值：FastEntryDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @RequestMapping(value = "/fastEntry/detail", method = RequestMethod.GET)
    Result<FastEntryDTO> getById(@RequestParam("userId") Long userId);


    /**
     * 描述：查询快捷入口Api
     * 参数：
     * 返回值：FastEntryDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @RequestMapping(value = "/fastEntry/getList", method = RequestMethod.GET)
    Result<List<FastEntryDTO>>findList();

    /**
     * 获取快捷入口排行榜
     * @param resultNum
     * @return
     */
    @RequestMapping(value = "/getFastEntryRank", method = RequestMethod.GET)
    Result<List<FastEntryRankDTO>> getFastEntryRank(@RequestParam("resultNum") Long resultNum);
}
