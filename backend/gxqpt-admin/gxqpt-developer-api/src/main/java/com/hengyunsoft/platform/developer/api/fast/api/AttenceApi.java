package com.hengyunsoft.platform.developer.api.fast.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.PageRequest;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.hystrix.FastMenuApiHystrix;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 签到/退信息表业务操作接口
 *
 * @author wt
 * @createTime 2018年5月8日
 *
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        fallback = FastMenuApiHystrix.class)
public interface AttenceApi {

    /**
     * 描述：考勤设置模块
     * 参数：
     * 返回值：AttenceRuleDTO
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/find", method = RequestMethod.GET)
    Result<AttenceRuleDTO> queryAttenceRule(@RequestParam String appId);

    /**
     * 描述：保存考勤设置模块
     * 参数：AttenceRuleDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/saveOrUpdate", method = RequestMethod.POST)
    Result<Boolean> ruleSave(@RequestBody AttenceRuleDTO dto);

    /**
     * 描述：考勤列表查询
     * 参数：AttenceQueryDTO
     * 返回值：List<AttenceQueryDTO>
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/findBy", method = RequestMethod.POST)
    Result<PageInfo<AttenceStatisticDTO>> statisticFind(@RequestBody OpenApiReq<RequestAttenceStatisticDTO> openApiReq);

    /**
     * 描述：我的考勤loadBusy
     * 参数：AttenceQueryDTO
     * 返回值：List<AttenceQueryDTO>
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/loadBusy", method = RequestMethod.POST)
    Result<Map<String,Object>> loadBusy(@RequestParam String startTime,@RequestParam String endTime);

    /**
     * 描述：我的考勤loadDetail
     * 参数：AttenceQueryDTO
     * 返回值：List<AttenceQueryDTO>
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/loadDetail", method = RequestMethod.POST)
    Result<Map<String,Object>> loadDetail(@RequestParam String startTime,@RequestParam String endTime);

    /**
     * 描述：我的考勤loadBusy
     * 参数：AttenceQueryDTO
     * 返回值：List<AttenceQueryDTO>
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/loadTotalView", method = RequestMethod.POST)
    Result<Map<String,Object>> loadTotalView(@RequestParam String startTime,@RequestParam String endTime);

    /**
     * 描述：签到or签退
     * 参数：AttenceDTO
     * 返回值：Attence
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/attencemng/save", method = RequestMethod.POST)
    Result<AttenceDTO> signInOrOut(@RequestBody AttenceDTO dto);
}
