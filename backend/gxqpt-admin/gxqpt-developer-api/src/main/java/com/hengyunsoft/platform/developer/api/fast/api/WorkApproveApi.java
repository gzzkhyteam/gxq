package com.hengyunsoft.platform.developer.api.fast.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.hystrix.FastMenuApiHystrix;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 考勤审批
 *
 * @author wt
 * @createTime 2018年5月8日
 *
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        fallback = FastMenuApiHystrix.class)
public interface WorkApproveApi {

    /**
     * 描述：考勤列表查询
     * 参数：AttenceQueryDTO
     * 返回值：List<AttenceQueryDTO>
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/findBy", method = RequestMethod.POST)
    Result<PageInfo<ResponseWorkApproveDTO>> statisticFind(@RequestBody OpenApiReq<RequestWorkApproveDTO> openApiReq);

    /**
     * 描述：出差审批保存
     * 参数：WorkApproveBusinessDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/businesssave", method = RequestMethod.POST)
    Result<Boolean> workApproveBusinessSave(@RequestBody RequestWorkApproveBusinessDTO dto);

    /**
     * 描述：出差审批更新
     * 参数：WorkApproveBusinessDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/businessupdate", method = RequestMethod.POST)
    Result<Integer> workApproveBusinessUpdate(@RequestBody RequestWorkApproveBusinessDTO dto);

    /**
     * 描述：出差审批查询
     * 参数：approveId
     * 返回值：WorkApproveBusinessDTO
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/businessview", method = RequestMethod.POST)
    Result<WorkApproveBusinessDTO> workApproveBusinessById(@RequestParam Long approveId);

    /**
     * 描述：加班审批保存
     * 参数：WorkApproveExtraDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/extrasave", method = RequestMethod.POST)
    Result<Boolean> workApproveExtraSave(@RequestBody RequestWorkApproveExtraDTO dto);

    /**
     * 描述：加班审批更新
     * 参数：WorkApproveExtraDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/extraupdate", method = RequestMethod.POST)
    Result<Integer> workApproveExtraUpdate(@RequestBody RequestWorkApproveExtraDTO dto);

    /**
     * 描述：加班审批查询
     * 参数：approveId
     * 返回值：WorkApproveExtraDTO
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/extraview", method = RequestMethod.POST)
    Result<WorkApproveExtraDTO> workApproveExtraById(@RequestParam Long approveId);

    /**
     * 描述：请假审批保存
     * 参数：WorkApproveLeaveDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/leavesave", method = RequestMethod.POST)
    Result<Boolean> workApproveLeaveSave(@RequestBody RequestWorkApproveLeaveDTO dto);

    /**
     * 描述：请假审批更新
     * 参数：WorkApproveLeaveDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/leaveupdate", method = RequestMethod.POST)
    Result<Integer> workApproveLeaveUpdate(@RequestBody RequestWorkApproveLeaveDTO dto);

    /**
     * 描述：请假审批查询
     * 参数：approveId
     * 返回值：WorkApproveLeaveDTO
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/leaveview", method = RequestMethod.POST)
    Result<WorkApproveLeaveDTO> workApproveLeaveById(@RequestParam Long approveId);

    /**
     * 描述：普通审批保存
     * 参数：WorkApproveSupplyDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/supplysave", method = RequestMethod.POST)
    Result<Boolean> workApproveSupplySave(@RequestBody RequestWorkApproveSupplyDTO dto);

    /**
     * 描述：普通审批更新
     * 参数：WorkApproveSupplyDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/supplyupdate", method = RequestMethod.POST)
    Result<Integer> workApproveSupplyUpdate(@RequestBody RequestWorkApproveSupplyDTO dto);

    /**
     * 描述：普通审批查询
     * 参数：approveId
     * 返回值：WorkApproveSupplyDTO
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/supplyview", method = RequestMethod.POST)
    Result<WorkApproveSupplyDTO> workApproveSupplyById(@RequestParam Long approveId);

    /**
     * 描述：保存审批记录
     * 参数：WorkApproveRecordDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "attence/workapprove/recordSave", method = RequestMethod.POST)
    Result<Boolean> workApproveRecordSave(@RequestBody RequestWorkApproveRecordDTO dto);
}
