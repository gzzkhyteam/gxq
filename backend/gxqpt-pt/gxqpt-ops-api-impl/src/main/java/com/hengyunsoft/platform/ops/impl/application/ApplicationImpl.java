package com.hengyunsoft.platform.ops.impl.application;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.ops.applicationdto.ApplicationDTO;
import com.hengyunsoft.platform.ops.applicationdto.ApplicationPageReqDTO;
import com.hengyunsoft.platform.ops.applicationdto.ApplicationSaveDTO;
import com.hengyunsoft.platform.ops.entity.application.po.ApplicationUpdate;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import com.hengyunsoft.platform.ops.repository.application.service.ApplicationUpdateService;
import com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample;
import com.hengyunsoft.platform.ops.repository.file.service.OperationFileService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("application")
@Api(value = "API - ApplicationImpl", description = "应用升级版本管理")
public class ApplicationImpl {
    @Autowired
    private ApplicationUpdateService applicationService;
    @Autowired
    private OperationFileService operationFileService;

    @Autowired
    private DozerUtils dozerUtils;


    @ApiOperation(value = "查询应用升级版本分页信息", notes = "查询应用升级版本分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ApplicationDTO>> page(@RequestBody OpenApiReq<ApplicationPageReqDTO> openApiReq) {

        Date startTime = openApiReq.getData().getStartTime();
        Date endTime = openApiReq.getData().getEndTime();
        String versionNumber = openApiReq.getData().getVersionNumber();
        String appId = openApiReq.getData().getAppId();

        Map map = new HashMap<>();
        map.put("appId", appId);
        map.put("versionNumber", versionNumber);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(applicationService.getPageList(map), ApplicationDTO.class)));
    }

    @ApiOperation(value = "保存应用升级版本信息", notes = "保存应用升级版本信息")
    @ApiResponses({
            @ApiResponse(code = 105010, message = "系统名称不能为空"),
            @ApiResponse(code = 105011, message = "版本号不能为空"),
            @ApiResponse(code = 105012, message = "版本名称不能为空"),
            @ApiResponse(code = 105013, message = "发布服务器地址不能为空"),
            @ApiResponse(code = 105014, message = "启用状态不能为空"),
            @ApiResponse(code = 105015, message = "升级内容不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<ApplicationSaveDTO> save(@RequestBody ApplicationSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(OperationExceptionCode.SYSTEM_NAME_NULL, saveDTO.getSystemName());
        BizAssert.assertNotNull(OperationExceptionCode.VERSION_NUMBER_NULL, saveDTO.getVersionNumber());
        BizAssert.assertNotNull(OperationExceptionCode.VERSION_NAME_NULL, saveDTO.getVersionName());
        BizAssert.assertNotNull(OperationExceptionCode.PUBLISHING_SERVER_NULL, saveDTO.getPublishingServer());
        BizAssert.assertNotNull(OperationExceptionCode.PUBLISHING_STATUS_NULL, saveDTO.getStatus());
        BizAssert.assertNotNull(OperationExceptionCode.UPGRADE_CONTENT_NULL, saveDTO.getUpgradeContent());

        //转换，保存应用升级表数据
        Long userId = BaseContextHandler.getAdminId();
        ApplicationUpdate application = dozerUtils.map(saveDTO, ApplicationUpdate.class);
        applicationService.saveSelective(application);

        //保存应用升级附件信息
        List<OperationFileDTO> files = saveDTO.getFiles();
        if (files != null && files.size() > 0) {
            List<OperationFile> operationFiles = new ArrayList<>();
            if (files != null && files.size() > 0) {
                for (OperationFileDTO dto : files) {
                    OperationFile file = dozerUtils.map(dto, OperationFile.class);
                    file.setBussId(application.getId());
                    file.setBussType("application_update");
                    file.setUserId(userId);
                    operationFiles.add(file);
                }
            }
            operationFileService.save(operationFiles);
        }
        return Result.success(dozerUtils.map(application, ApplicationSaveDTO.class));
    }

    @ApiOperation(value = "修改应用升级版本信息", notes = "修改应用升级版本信息")
    @ApiResponses({
            @ApiResponse(code = 105010, message = "系统名称不能为空"),
            @ApiResponse(code = 105011, message = "版本号不能为空"),
            @ApiResponse(code = 105012, message = "版本名称不能为空"),
            @ApiResponse(code = 105013, message = "发布服务器地址不能为空"),
            @ApiResponse(code = 105014, message = "启用状态不能为空"),
            @ApiResponse(code = 105015, message = "升级内容不能为空")
    })
    @RequestMapping(value = "/updateApplication", method = RequestMethod.POST)
    public Result<ApplicationSaveDTO> updateApplication(@RequestBody ApplicationSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(OperationExceptionCode.SYSTEM_NAME_NULL, saveDTO.getSystemName());
        BizAssert.assertNotNull(OperationExceptionCode.VERSION_NUMBER_NULL, saveDTO.getVersionNumber());
        BizAssert.assertNotNull(OperationExceptionCode.VERSION_NAME_NULL, saveDTO.getVersionName());
        BizAssert.assertNotNull(OperationExceptionCode.PUBLISHING_SERVER_NULL, saveDTO.getPublishingServer());
        BizAssert.assertNotNull(OperationExceptionCode.PUBLISHING_STATUS_NULL, saveDTO.getStatus());
        BizAssert.assertNotNull(OperationExceptionCode.UPGRADE_CONTENT_NULL, saveDTO.getUpgradeContent());

        //转换，保存应用升级表数据
        Long userId = BaseContextHandler.getAdminId();
        ApplicationUpdate application = dozerUtils.map(saveDTO, ApplicationUpdate.class);
        application.setUpdateUser(userId);
        applicationService.updateByIdSelective(application);

        OperationFileExample fileExample = new OperationFileExample();
        fileExample.createCriteria().andBussIdEqualTo(application.getId());
        List<OperationFileDTO> deletefiles = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
        List<Long> fileIds = new ArrayList<>();
        if (deletefiles != null && deletefiles.size() > 0) {
            for (OperationFileDTO dto : deletefiles) {
                fileIds.add(dto.getId());
            }
            operationFileService.deleteByIds(fileIds);
        }
        //保存应用升级附件信息
        List<OperationFileDTO> files = saveDTO.getFiles();
        if (files != null && files.size() > 0) {
            List<OperationFile> operationFiles = new ArrayList<>();
            if (files != null && files.size() > 0) {
                for (OperationFileDTO dto : files) {
                    OperationFile file = dozerUtils.map(dto, OperationFile.class);
                    file.setBussId(application.getId());
                    file.setUserId(userId);
                    operationFiles.add(file);
                    file.setBussType("application_update");
                }
            }
            operationFileService.save(operationFiles);
        }
        return Result.success(dozerUtils.map(application, ApplicationSaveDTO.class));
    }

    @ApiOperation(value = "根据应用升级id查询系统信息", notes = "根据应用升级id查询系统信息")
    @RequestMapping(value = "/getApplition", method = RequestMethod.GET)
    public Result<ApplicationDTO> getApplition(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("应用升级id不能为空！");
        }
        // ApplicationUpdateExample example=new ApplicationUpdateExample();
        OperationFileExample fileExample = new OperationFileExample();
        fileExample.createCriteria().andBussIdEqualTo(id);
        List<OperationFileDTO> files = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
        ApplicationDTO dto = dozerUtils.map(applicationService.getById(id), ApplicationDTO.class);
        if (files != null && files.size() > 0) {
            dto.setFileList(files);
        }
        return Result.success(dto);
    }

    @ApiOperation(value = "应用升级禁用启用", notes = "应用升级禁用启用")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestParam(value = "id") Long id, @RequestParam(value = "status") Integer status) {
        //验证
        if (id == null || id.equals("")) {
            return Result.fail("应用id不能为空！");
        }
        if (status == null || status.equals("")) {
            return Result.fail("状态不能为空！");
        }
        //更新应用升级表数据
        Long userId = BaseContextHandler.getAdminId();
        ApplicationUpdate application = applicationService.getById(id);
        application.setStatus(status);//'状态:1启用，2禁用',
        applicationService.updateByIdSelective(application);
        return Result.success(true);
    }
}
