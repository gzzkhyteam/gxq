package com.hengyunsoft.platform.admin.open.core.api;


import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.org.*;
import com.hengyunsoft.platform.admin.open.core.api.hystrix.GxqptOrgOpenHystrix;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 单位管理-open
 *
 * @author wangzhen
 * @createTime 2018-03-26
 */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//        path = "/api/admin", fallback = GxqptOrgOpenHystrix.class)

@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = GxqptOrgOpenHystrix.class)
public interface GxqptOrgOpenApi {
    /**
     * 通过应用id+体系编码获得其可见所有单位
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/org/pageByAppAndSys", method = RequestMethod.POST)
    Result<PageInfo<GxqptOrgResDTO>> pageByAppAndSys(@RequestBody OpenApiReq<String> openApiReq);

    /**
     * 通过用户id+体系编码获得所有单位
     *
     * @param systemCode
     * @return
     */
    @RequestMapping(value = "/p/org/findByAdmAndSys", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> findByAdmAndSys(@RequestParam(value = "userId") Long userId, @RequestParam(value = "systemCode") String systemCode);

//    /**
//     * 通过用户id+体系编码获得所有单位及其子单位
//     *
//     * @param systemCode
//     * @return
//     */
//    @RequestMapping(value = "/p/org/findByAdmSysCodeTree", method = RequestMethod.GET)
//    public Result<List<GxqptOrgResDTO>> pageByAdmAndSystemCodeTree(@RequestParam(value = "systemCode") String systemCode);

    /**
     * 通过体系编码获得所有单位
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/org/pageBySys", method = RequestMethod.POST)
    Result<PageInfo<GxqptOrgResDTO>> pageBySys(@RequestBody OpenApiReq<String> openApiReq);

    /**
     * 获取聚合体系单位
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/org/pagePoly", method = RequestMethod.POST)
    Result<PageInfo<GxqptOrgPolyResDTO>> pagePoly(@RequestBody OpenApiReq openApiReq);

    /**
     * 通过当前请求应用来获取聚合体系单位
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/org/pagePolyByApp", method = RequestMethod.POST)
    Result<PageInfo<GxqptOrgPolyResDTO>> pagePolyByApp(@RequestBody OpenApiReq openApiReq);

    @RequestMapping(value = "/p/org/pagePolyByUser", method = RequestMethod.GET)
    Result<List<GxqptOrgPolyResDTO>> pagePolyByUser(@RequestParam(value = "userId") Long userId);

    @RequestMapping(value = "/p/org/allOrg", method = RequestMethod.GET)
    Result<List<GxqptOrgPolyResDTO>> allOrg();

    /**
     * 根据userId查询相关信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/org/getOrgInfoByUserId", method = RequestMethod.GET)
    Result<List<OrgAndEmpInfoDTO>> getOrgInfoByUserId(@RequestParam(value = "userId") Long userId);

    /**
     * 2018-6-26 移动端需要新增
     * 根据userId查询其所在单位，部门，岗位职务信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/org/getOrgSimpleInfo", method = RequestMethod.GET)
    Result<List<OrgInfosDTO>> getOrgSimpleInfo(@RequestParam(value = "userId") Long userId);
    /**
     * 2018-5-30
     * 根据userId
     * 查询主单位中、部门、职务、岗位以及体系编码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/org/getOrgDeptDutyByUserId", method = RequestMethod.GET)
    Result<OrgDeptDutyInfoDTO> getOrgDeptDutyByUserId(@RequestParam(value = "userId") Long userId);


    /**
     * 2018-6-26 移动端需要新增
     * 根据userID,OrgID查询单位、部门、职务、岗位以及体系编码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/org/getOrgDeptDutyinfo", method = RequestMethod.GET)
    Result<List<OrgDeptDutyInfoDTO>> getOrgDeptDutyinfo(@RequestParam(value = "userId") Long userId
            ,@RequestParam(value = "orgId") String orgId);
}
