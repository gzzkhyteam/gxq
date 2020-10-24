package com.hengyunsoft.platform.security.impl.assessment;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SecurityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.RequestAppNameDTO;
import com.hengyunsoft.platform.security.api.assessment.dto.*;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessment;
import com.hengyunsoft.platform.security.entity.assess.po.SafetyAssessmentReport;
import com.hengyunsoft.platform.security.repository.assess.example.SafetyAssessmentExample;
import com.hengyunsoft.platform.security.repository.assess.example.SafetyAssessmentReportExample;
import com.hengyunsoft.platform.security.repository.assess.service.SafetyAssessmentApiService;
import com.hengyunsoft.platform.security.repository.assess.service.SafetyAssessmentReportApiService;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.impl.application
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：系统安全评估管理API
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Api(value = "API - SafetyAssessmentApiImpl.java", description = "系统安全评估管理API")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class SafetyAssessmentApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private SafetyAssessmentApiService safetyAssessmentApiService;
    @Autowired
    private SafetyAssessmentReportApiService safetyAssessmentReportApiService;
    @Autowired
    private ApplicationApi applicationApi;

    /**
     * 描述：查询系统安全评估数据列表
     * 参数：OpenApiReq<ShareRequestAssessmentFindDTO>
     * 返回值：PageInfo<ShareResponseAssessmentFindDTO>
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/assessment/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询系统安全评估数据列表", notes = "查询系统安全评估数据列表")
    @ApiResponses({
            @ApiResponse(code = 95001, message = "分页参数不能为空"),
    })
    public Result<PageInfo<ShareResponseAssessmentFindDTO>> findAssessment(@RequestBody OpenApiReq<ShareRequestAssessmentFindDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq);

        String applicationName = null;
        if(openApiReq.getData() != null){
            applicationName = openApiReq.getData().getApplicationName();
        }

        OpenApiReq<RequestAppNameDTO> open = new OpenApiReq<RequestAppNameDTO>();
        open.setPageNo(openApiReq.getPageNo());
        open.setPageSize(openApiReq.getPageSize());
        RequestAppNameDTO dto = new RequestAppNameDTO();
        dto.setName(applicationName);
        dto.setType(1);
        open.setData(dto);
        //数据获取
        PageInfo<ApplicationResDTO> pageInfoResult = applicationApi.pageAppVisibleForSelfName(open).getData();
        log.info("pageInfoResult={}", pageInfoResult);
        List<ShareResponseAssessmentFindDTO> resultList = new ArrayList<ShareResponseAssessmentFindDTO>();
        if(pageInfoResult != null) {
            if (pageInfoResult.getList() != null){
                for (ApplicationResDTO appDto : pageInfoResult.getList()) {
                    ShareResponseAssessmentFindDTO curDto = new ShareResponseAssessmentFindDTO();
                    curDto.setId(appDto.getId());
                    curDto.setApplicationName(appDto.getName());
                    curDto.setCompany(appDto.getOrgName());
                    curDto.setContractor(appDto.getProvider());
                    SafetyAssessmentReport assessmentReport = safetyAssessmentApiService.getReportAssessmentId(appDto.getId());
                    if(assessmentReport != null){
                        curDto.setLevel(assessmentReport.getLevel());
                        curDto.setAssessmentTime(assessmentReport.getAssessmentTime());
                        curDto.setAssessmentFileName(assessmentReport.getAssessmentFileName());
                        curDto.setRectificationFileName(assessmentReport.getRectificationFileName());
                    }
                    resultList.add(curDto);
                }
            }
        }
        PageInfo<ShareResponseAssessmentFindDTO> result = new PageInfo<ShareResponseAssessmentFindDTO>();
        result.setList(resultList);
        result.setPageSize(pageInfoResult.getPageSize());
        result.setSize(pageInfoResult.getSize());
        result.setTotal(pageInfoResult.getTotal());
        result.setEndRow(pageInfoResult.getEndRow());
        result.setNextPage(pageInfoResult.getNextPage());
        result.setStartRow(pageInfoResult.getStartRow());
        result.setPageNum(pageInfoResult.getPageNum());
        result.setPages(pageInfoResult.getPages());
        result.setPrePage(pageInfoResult.getPrePage());
        result.setNavigateFirstPage(pageInfoResult.getNavigateFirstPage());
        result.setNavigateLastPage(pageInfoResult.getNavigateLastPage());
        result.setNavigatepageNums(pageInfoResult.getNavigatepageNums());
        result.setNavigatePages(pageInfoResult.getNavigatePages());
        return Result.success(result);
    }

    /**
     * 描述：保存测评报告数据
     * 参数：ShareRequestAssessmentReportSaveDTO
     * 返回值：ShareResponseAssessmentReportSaveDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/assessmentreport/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存测评报告数据", notes = "保存测评报告数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<ShareResponseAssessmentReportSaveDTO> saveAssessmentReport(@RequestBody ShareRequestAssessmentReportSaveDTO dto){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();

        //判断当天是否存在测评报告
        SafetyAssessmentReportExample example = new SafetyAssessmentReportExample();
        example.createCriteria().andAssessmentIdEqualTo(dto.getAssessmentId()).andAssessmentTimeEqualTo(dto.getAssessmentTime());
        Integer count = safetyAssessmentReportApiService.count(example);
        if(count > 0){
            return Result.success(null,"当天不允许重复发起测评报告！");
        }

        SafetyAssessmentReport assessmentReport = new SafetyAssessmentReport();
        assessmentReport.setAssessmentId(dto.getAssessmentId());
        assessmentReport.setLevel(dto.getLevel());
        assessmentReport.setAssessmentTime(dto.getAssessmentTime());
        assessmentReport.setAssessmentFileId(dto.getAssessmentFileId());
        assessmentReport.setAssessmentFileName(dto.getAssessmentFileName());
        assessmentReport.setAssessmentFileUrl(dto.getAssessmentFileUrl());
        assessmentReport.setRectificationFileId(dto.getRectificationFileId());
        assessmentReport.setRectificationFileName(dto.getRectificationFileName());
        assessmentReport.setRectificationFileUrl(dto.getRectificationFileUrl());
        assessmentReport.setRemarks(dto.getRemarks());
        assessmentReport.setCreateTime(Calendar.getInstance().getTime());
        assessmentReport.setCreateUser(adminId);
        SafetyAssessmentReport result = safetyAssessmentReportApiService.save(assessmentReport);
        return Result.success(dozerUtils.map(result,ShareResponseAssessmentReportSaveDTO.class));
    }

    /**
     * 描述：根据ID查询测评信息数据
     * 参数：ShareRequestAssessmentReportSaveDTO
     * 返回值：ShareResponseAssessmentReportSaveDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/assessment/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询测评信息数据", notes = "根据ID查询测评信息数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<List<ShareResponseAssessmentReportSaveDTO>> getAssessmentById(Long id){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, id);

        SafetyAssessmentReportExample example = new SafetyAssessmentReportExample();
        example.createCriteria().andAssessmentIdEqualTo(id);
        example.setOrderByClause("assessment_time desc");
        List<SafetyAssessmentReport> list = safetyAssessmentReportApiService.find(example);

        List<ShareResponseAssessmentReportSaveDTO> resultList = dozerUtils.mapList(list,ShareResponseAssessmentReportSaveDTO.class);
        return Result.success(resultList);
    }

    /**
     * 描述：查询系统名称下拉框数据
     * 参数：
     * 返回值：ShareResponseAssessmentNameDownDTO
     * 修改人：wt
     * 修改时间：2018/7/4
     * 修改内容：
     */
    @RequestMapping(value = "/assessment/namedown", method = RequestMethod.GET)
    @ApiOperation(value = "查询系统名称下拉框数据", notes = "查询系统名称下拉框数据")
    @ApiResponses({
    })
    public Result<List<ShareResponseAssessmentNameDownDTO>> getApplicationNameDown(){
        SafetyAssessmentExample example = new SafetyAssessmentExample();
        example.createCriteria().andApplicationNameIsNotNull();
        List<SafetyAssessment> list = safetyAssessmentApiService.find(example);
        return Result.success(dozerUtils.mapList(list,ShareResponseAssessmentNameDownDTO.class));
    }

    /**
     * 描述：根据ID删除测评报告
     * 参数：id
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/6
     * 修改内容：
     */
    @RequestMapping(value = "/assreport/delete", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID删除测评报告", notes = "根据ID删除测评报告")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<Integer> deleteAssessmentById(Long id){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, id);
        Integer result = safetyAssessmentReportApiService.deleteById(id);
        return Result.success(result);
    }
}
