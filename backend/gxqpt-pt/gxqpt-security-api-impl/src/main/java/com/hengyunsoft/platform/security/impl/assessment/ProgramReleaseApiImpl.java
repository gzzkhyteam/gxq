package com.hengyunsoft.platform.security.impl.assessment;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SecurityExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.security.api.assessment.dto.*;
import com.hengyunsoft.platform.security.entity.assess.po.ProgramRelease;
import com.hengyunsoft.platform.security.repository.assess.example.ProgramReleaseExample;
import com.hengyunsoft.platform.security.repository.assess.service.ProgramReleaseApiService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.impl.application
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：程序发布管理API
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Api(value = "API - ProgramReleaseApiImpl.java", description = "程序发布管理API  ")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class ProgramReleaseApiImpl{
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ProgramReleaseApiService programReleaseApiService;

    /**
     * 描述：查询程序发布数据列表
     * 参数：OpenApiReq<ShareRequestProgramFindDTO>
     * 返回值：PageInfo<ShareResponseProgramFindDTO>
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/program/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询程序发布数据列表", notes = "查询程序发布数据列表")
    @ApiResponses({
            @ApiResponse(code = 95001, message = "分页参数不能为空"),
    })
    public Result<PageInfo<ShareResponseProgramFindDTO>> findProgram(@RequestBody OpenApiReq<ShareRequestProgramFindDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq);
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq.getData().getName());
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq.getData().getAuditStatus());
        BizAssert.assertNotEmpty(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq.getData().getStartDate());
        BizAssert.assertNotEmpty(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq.getData().getEndDate());

        Long adminId = BaseContextHandler.getAdminId();
        String name = null;
        Integer auditStatus = null;
        Date startDate = new Date();
        Date endDate = new Date();
        if(openApiReq.getData() != null){
            name = openApiReq.getData().getName();
            auditStatus = openApiReq.getData().getAuditStatus();
            String paramStart = openApiReq.getData().getStartDate().trim()+" 00:00:00";
            String paramEnd = openApiReq.getData().getEndDate().trim()+" 23:59:59";
            startDate = DateUtils.getDate(paramStart);
            endDate = DateUtils.getDate(paramEnd);
        }
        if(auditStatus != null){
            auditStatus = auditStatus == -1 ? null : auditStatus;
        }
        name = "-1".equals(name) ? null : name;

        ProgramReleaseExample example = new ProgramReleaseExample();
        example.createCriteria().andNameEqualTo(name).andAuditStatusEqualTo(auditStatus)
                .andUpgradeTimeBetween(startDate,endDate);
        example.setOrderByClause("create_time desc");
        //数据获取
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ProgramRelease> list = programReleaseApiService.find(example);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ShareResponseProgramFindDTO.class)));
    }

    /**
     * 描述：保存程序发布数据
     * 参数：ShareRequestProgramSaveDTO
     * 返回值：ShareResponseProgramSaveDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/program/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存程序发布数据", notes = "保存程序发布数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<ShareResponseProgramSaveDTO> saveProgram(@RequestBody ShareRequestProgramSaveDTO dto){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();

        ProgramRelease programRelease = new ProgramRelease();
        programRelease.setAppId(appId);
        programRelease.setName(dto.getName());
        programRelease.setVersionId(dto.getVersionId());
        programRelease.setVersionName(dto.getVersionName());
        programRelease.setServerIp(dto.getServerIp());
        programRelease.setUpgradeFileId(dto.getUpgradeFileId());
        programRelease.setUpgradeFileName(dto.getUpgradeFileName());
        programRelease.setUpgradeFileUrl(dto.getUpgradeFileUrl());
        programRelease.setUpgradeConent(dto.getUpgradeConent());
        programRelease.setAuditStatus(0);
        programRelease.setUpgradeTime(Calendar.getInstance().getTime());
        programRelease.setCreateTime(Calendar.getInstance().getTime());
        programRelease.setCreateUser(String.valueOf(adminId));
        ProgramRelease result = programReleaseApiService.saveSelective(programRelease);
        return Result.success(dozerUtils.map(result,ShareResponseProgramSaveDTO.class));
    }

    /**
     * 描述：更新程序发布数据
     * 参数：ShareRequestProgramUpdateDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/24
     * 修改内容：
     */
    @RequestMapping(value = "/program/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新程序发布数据", notes = "更新程序发布数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<Integer> updateProgram(@RequestBody ShareRequestProgramUpdateDTO dto){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();

        ProgramRelease programRelease = new ProgramRelease();
        programRelease.setId(dto.getId());
        programRelease.setAppId(appId);
        programRelease.setName(dto.getName());
        programRelease.setVersionId(dto.getVersionId());
        programRelease.setVersionName(dto.getVersionName());
        programRelease.setServerIp(dto.getServerIp());
        programRelease.setUpgradeFileId(dto.getUpgradeFileId());
        programRelease.setUpgradeFileName(dto.getUpgradeFileName());
        programRelease.setUpgradeFileUrl(dto.getUpgradeFileUrl());
        programRelease.setUpgradeConent(dto.getUpgradeConent());
        programRelease.setAuditStatus(0);
        programRelease.setUpgradeTime(Calendar.getInstance().getTime());
        programRelease.setUpdateTime(Calendar.getInstance().getTime());
        programRelease.setUpdateUser(String.valueOf(adminId));
        Integer result = programReleaseApiService.updateByIdSelective(programRelease);
        return Result.success(result);
    }

    /**
     * 描述：程序发布审批
     * 参数：ShareRequestProgramAuditDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/program/audit", method = RequestMethod.POST)
    @ApiOperation(value = "程序发布审批", notes = "程序发布审批")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<Integer> saveProgram(@RequestBody ShareRequestProgramAuditDTO dto){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        //基本数据的获取
        String currName = BaseContextHandler.getName();

        ProgramRelease programRelease = new ProgramRelease();
        programRelease.setId(dto.getId());
        programRelease.setRemarks(dto.getRemarks());
        programRelease.setAuditTime(Calendar.getInstance().getTime());
        programRelease.setAuditStatus(1);
        programRelease.setAuditUser(currName);
        Integer result = programReleaseApiService.updateByIdSelective(programRelease);
        return Result.success(result);
    }

    /**
     * 描述：查看程序发布根据ID查询
     * 参数：id
     * 返回值：ShareResponseProgramGetByIdDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/program/get", method = RequestMethod.GET)
    @ApiOperation(value = "查看程序发布", notes = "查看程序发布")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<ShareResponseProgramGetByIdDTO> getProgramById(Long id){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, id);

        ProgramRelease result = programReleaseApiService.getById(id);
        return Result.success(dozerUtils.map(result,ShareResponseProgramGetByIdDTO.class));
    }

    /**
     * 描述：删除程序发布
     * 参数：id
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/15
     * 修改内容：
     */
    @RequestMapping(value = "/program/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除程序发布", notes = "删除程序发布")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<Integer> deleteProgramById(Long id){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, id);

        Integer result = programReleaseApiService.deleteById(id);
        return Result.success(result);
    }
}
