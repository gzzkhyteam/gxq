package com.hengyunsoft.platform.developer.api.service.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.AssignModuleApplyApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述:模块申请接口
 * @author chb
 * @date 2018/4/3 11:05 
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = AssignModuleApplyApiHystrix.class)
public interface AssignModuleApplyApi {
    /**
     * 描述:新增模块申请
     * @param serviceModuleDocDTO
     * @return
     */
    @RequestMapping(value = "/assignModuleAppl/save", method = RequestMethod.POST)
    Result<AssignModuleApplyUpdateDTO> save(@RequestBody AssignModuleApplySaveDTO assignModuleApplySaveDTO);

    /**
     * 根据id获取模块申请信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/assignModuleApply/getById", method = RequestMethod.GET)
    Result<AssignModuleApplyRetDTO> getById(@RequestParam(value="id")String id);

    /**
     * 根据id删除模块申请信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/assignModuleApply/deleteById", method = RequestMethod.GET)
    Result<String> deleteById(@RequestParam(value="id")String id);

    /**
     * 根据id修改模块申请信息
     * @param assignModuleApplyUpdateDTO
     * @return
     */
    @RequestMapping(value = "/assignModuleApply/updateById", method = RequestMethod.POST)
    Result<AssignModuleApplyUpdateDTO> updateById(@RequestBody AssignModuleApplyUpdateDTO assignModuleApplyUpdateDTO);


    /*
     * 获取模块个人申请分页数据
     * @param req
     * @return
     */
    /*@RequestMapping(value = "/assignModuleApply/pageMyApply", method = RequestMethod.POST)
    Result<PageInfo<AssignModuleApplyRetDTO>> pageMyApply(@RequestBody OpenApiReq<AssignModuleApplyQueryDTO> req);*/
  /*
     * 获取模块个人审批分页数据
     * @param req
     * @return
     */
   /* @RequestMapping(value = "/assignModuleApply/pageMyAudit", method = RequestMethod.POST)
    Result<PageInfo<AssignModuleApplyRetDTO>> pageMyAudit(@RequestBody OpenApiReq<AssignModuleApplyQueryDTO> req);*/

    /*
     * 提交审批
     * @param id
     * @param moduleId
     * @param appId
     * @return
     */
    /*@RequestMapping(value = "/assignModuleApply/submit", method = RequestMethod.GET)
    Result<String> updateSubmitStatus(@RequestParam(value="id")Long id,
                                       @RequestParam(value="moduleId")Long moduleId,
                                       @RequestParam(value="appId")String appId);*/


    /*
     * 审批
     * @param applyApprDTO
     * @return
     */
    /*@RequestMapping(value = "/assignModuleApply/approve", method = RequestMethod.POST)
    Result<String> updateApproveStatus(@RequestBody AssignModuleApplyApprDTO applyApprDTO);*/

    /**
     * 查询审批历史
     * @param Long
     * @return
     */
    @RequestMapping(value = "/assignModuleApply/apprHistory", method = RequestMethod.GET)
    Result<AssignModuleApplyRetDTO> getApprHistory(@RequestParam(value="apprId")Long apprId);
}
