package com.hengyunsoft.platform.admin.open.core;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.OrgSystemModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.org.*;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptOrgExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptOrgService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwOrgExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwOrgService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 单位管理-open
 *
 * @author wangzhen
 * @createTime 2018-03-26
 */
@Api(value = "API - GxqptOrgApiImpl", description = "单位管理对外接口")
@RestController
@RequestMapping("/p/org")
@Slf4j
@OrgSystemModule
public class GxqptOrgOpenApiImpl implements GxqptOrgOpenApi {
    @Autowired
    private GxqptOrgService orgService;
    @Autowired
    private SdzzwwOrgService sdzzwwOrgService;
    @Autowired
    private GxqptSystemService systemService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private UserService userService;

    /**
     * 获得其可见所有单位
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @ApiOperation(value = "分页获得其可见所有单位", notes = "通过应用id+体系编码分页获得其可见所有单位")
    @RequestMapping(value = "/pageByAppAndSys", method = RequestMethod.POST)
    public Result<PageInfo<GxqptOrgResDTO>> pageByAppAndSys(@RequestBody OpenApiReq<String> openApiReq) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, openApiReq.getData());
        if (!systemService.isExistSystem(openApiReq.getData())) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        if (openApiReq.getData().equals(CommonConstants.SYS_SDZZWW_CODE)) {
            SdzzwwOrgExample example = new SdzzwwOrgExample();
            example.createCriteria().andIsdeleteEqualTo(String.valueOf(DeleteStatus.UN_DELETE.getStatus()));
            return Result.success(new PageInfo<>(dozerUtils.mapPage(sdzzwwOrgService.find(example), GxqptOrgResDTO.class)));
        }

        //3.获取token信息
        String appId = BaseContextHandler.getAppId();

        //4.查询结果并返回
        List list = orgService.pageByAppAndSys(appId, openApiReq.getData());
        if (list.size() > 0) {
            return Result.success(new PageInfo<>(dozerUtils.mapPage(list, GxqptOrgResDTO.class)));
        }
        return Result.success(new PageInfo<>());
    }

    /**
     * 通过用户id+体系编码获得所有单位
     *
     * @param systemCode
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "获得某体系用户所有单位", notes = "通过用户id+体系编码获得所有未删除单位")
    @RequestMapping(value = "/findByAdmAndSys", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findByAdmAndSys(@RequestParam(value = "userId") Long userId, @RequestParam(value = "systemCode") String systemCode) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        if (!systemService.isExistSystem(systemCode)) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }
        //2.查询结果并返回
        List list = orgService.findByAdmAndSys(userId, systemCode);
        return Result.success(dozerUtils.mapPage(list, GxqptOrgResDTO.class));
    }

//    /**
//     * 通过用户id+体系编码获得所有单位及其子单位
//     *
//     * @param systemCode
//     * @return
//     */
//    @Override
//    public Result<List<GxqptOrgResDTO> findByAdmAndSystemCodeTree(String systemCode) {
//        return null;
//    }

    /**
     * 获得某体系所有单位
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @ApiOperation(value = "获得某体系所有单位", notes = "通过体系编码获得所有未删除单位")
    @RequestMapping(value = "/pageBySys", method = RequestMethod.POST)
    public Result<PageInfo<GxqptOrgResDTO>> pageBySys(@RequestBody OpenApiReq<String> openApiReq) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, openApiReq.getData());
        if (!systemService.isExistSystem(openApiReq.getData())) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }
        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询结果并返回
        List list = orgService.pageBySys(openApiReq.getData());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, GxqptOrgResDTO.class)));
    }

    /**
     * 获取聚合体系单位
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "获取聚合体系单位", notes = "通过体系聚合查询获得所有未删除单位")
    @RequestMapping(value = "/pagePoly", method = RequestMethod.POST)
    public Result<PageInfo<GxqptOrgPolyResDTO>> pagePoly(@RequestBody OpenApiReq openApiReq) {
        //1.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询结果并返回
        List list = orgService.pagePoly();
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, GxqptOrgPolyResDTO.class)));
    }

    /**
     * 通过应用id来获取聚合体系单位
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "获取某应用聚合体系单位", notes = "通过应用id来获取聚合体系单位")
    @RequestMapping(value = "/pagePolyByApp", method = RequestMethod.POST)
    public Result<PageInfo<GxqptOrgPolyResDTO>> pagePolyByApp(@RequestBody OpenApiReq openApiReq) {
        //1.获取应用id
        String appId = BaseContextHandler.getAppId();

        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询结果并返回
        List list = orgService.pagePolyByApp(appId);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, GxqptOrgPolyResDTO.class)));
    }

    /**
     * 通过adminId来获取聚合体系单位
     *
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "获取某个用户聚合体系单位", notes = "通过userId来获取聚合体系未删除且启用的单位")
    @RequestMapping(value = "/pagePolyByUser", method = RequestMethod.GET)
    public Result<List<GxqptOrgPolyResDTO>> pagePolyByUser(@RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);

        //2.查出该用户及其所有体系
        User user = userService.getById(userId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, user);

        //3.查询
        List list = orgService.findOrgByUser(user.getOwnSystem(), userId);
        return Result.success(dozerUtils.mapList(list, GxqptOrgByUserDTO.class));
    }

    @Override
    @ApiResponses({
    })
    @ApiOperation(value = "获取所有的单位", notes = "获取所有的单位")
    @RequestMapping(value = "/allOrg", method = RequestMethod.GET)
    public Result<List<GxqptOrgPolyResDTO>> allOrg() {
        //3.查询
        List<GxqptOrg> list = orgService.find(null);
        return Result.success(dozerUtils.mapList(list, GxqptOrgPolyResDTO.class));
    }

    /**
     * 根据userId查询单位相关信息
     * 修改人：chb
     * 修改时间：2018-4-23
     * 修改内容：根据定窑最新需求修改
     *
     * @param userId
     * @return
     * @auth chb
     */
    @Override
    @RequestMapping(value = "/getOrgInfoByUserId", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "查询其对应的单位信息", notes = "通过userId查询其对应的单位信息")
    public Result<List<OrgAndEmpInfoDTO>> getOrgInfoByUserId(@RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        //2.查询
        User user = userService.getById(userId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, user);

        String systemCode = user.getOwnSystem();
        List<OrgAndEmpInfoDTO> relist = dozerUtils.mapList(orgService.getOrgInfoByUserId(userId, systemCode), OrgAndEmpInfoDTO.class);
        return Result.success(relist);
    }


    /**
     * 2018-6-26 移动端需要新增
     * 根据userId查询其所在单位，部门，岗位职务信息
     *
     * @param userId
     * @return
     */
    @Override
    @RequestMapping(value = "/getOrgSimpleInfo", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "查询其所在单位，部门，岗位职务信息", notes = "根据userId查询其所在单位，部门，岗位职务信息")
    public Result<List<OrgInfosDTO>> getOrgSimpleInfo(@RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        //2.查询
        User user = userService.getById(userId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, user);

        String systemCode = user.getOwnSystem();
        List<OrgInfosDTO> relist = dozerUtils.mapList(orgService.getOrgSimpleInfo(userId, systemCode), OrgInfosDTO.class);
        return Result.success(relist);
    }

    /**
     * 2018-5-30
     * 根据userId,查询主单位中、部门、职务、岗位以及体系编码
     *
     * @param userId
     * @return
     */
    @Override
    @RequestMapping(value = "/getOrgDeptDutyByUserId", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "查询主单位中、部门、职务、岗位以及体系编码", notes = "根据userId,查询主单位中、部门、职务、岗位以及体系编码")
    public Result<OrgDeptDutyInfoDTO> getOrgDeptDutyByUserId(@RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        //2.查询
        User user = userService.getById(userId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, user);

        String systemCode = user.getOwnSystem();
        OrgDeptDutyInfoDTO result = dozerUtils.map(orgService.getOrgDeptDutyByUserId(userId, systemCode), OrgDeptDutyInfoDTO.class);
        return Result.success(result);
    }

    /**
     * 2018-5-30
     * 根据userId,orgId查询用户所在所有部门、职务、岗位以及体系编码
     *
     * @param userId
     * @return
     */
    @Override
    @RequestMapping(value = "/getOrgDeptDutyinfo", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空"),
            @ApiResponse(code = 56008, message = "单位id不能为空")
    })
    @ApiOperation(value = "查询用户所在所有部门、职务、岗位以及体系编码", notes = "根据userId,orgId查询用户所在所有部门、职务、岗位以及体系编码")
    public Result<List<OrgDeptDutyInfoDTO>> getOrgDeptDutyinfo(@RequestParam(value = "userId") Long userId
            , @RequestParam(value = "orgId") String orgId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);
        User user = userService.getById(userId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, user);

        String systemCode = user.getOwnSystem();
        List<OrgDeptDutyInfoDTO> result = dozerUtils.mapList(orgService.getOrgDeptDutyinfo(userId, systemCode, orgId), OrgDeptDutyInfoDTO.class);
        return Result.success(result);
    }
}
