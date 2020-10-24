package com.hengyunsoft.platform.ops.impl.fault;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.ops.entity.fault.po.LogManagement;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.faultdto.*;
import com.hengyunsoft.platform.ops.impl.utils.YwPtRoleUnits;
import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import com.hengyunsoft.platform.ops.repository.fault.service.LogManagementService;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("Log")
@Api(value = "API - LogManagementImpl", description = "日志管理")
public class LogManagementImpl implements Serializable {
    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private LogManagementService logManagementService;
    @Autowired
    YwPtRoleUnits ywPtRoleUnits;
    @Autowired
    private OperationFileService operationFileService;
    @Autowired
    GxqptEmpApi gxqptEmpApi;

    /**
     * 分页查询日志管理信息
     *
     * @param openApiReq
     */
    @RequestMapping(value = "/pageProviderInformation", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询日志管理信息", notes = "分页查询日志管理信息")
    public Result<PageInfo<LogManagementPageInfoDTO>> pageProviderInformation(@RequestBody OpenApiReq<LogManagementPageQueryDTO> openApiReq) {
        Boolean ywPtAdmin;//是否是运维平台管理员
        Boolean ywUnitAdmin;//是否是运维单位管理员
        Long adminId = BaseContextHandler.getAdminId();
        ywPtAdmin = ywPtRoleUnits.getYwUnitOrPtRole(adminId, YwPtRoleUnits.APP_ADMIN_ROLE_CODE);
        ywUnitAdmin = ywPtRoleUnits.getYwUnitOrPtRole(adminId, YwPtRoleUnits.YW_UNIT_ADMIN_ROLE_CODE);
        Map map = new HashMap<>();
        if (openApiReq.getData() != null) {
            map.put("logType", openApiReq.getData().getLogType());
            map.put("faultClassification", openApiReq.getData().getFaultClassification());
        } else {
            map.put("logType", "");
            map.put("faultClassification", "");
        }
        if (!ywPtAdmin && !ywUnitAdmin) {
            map.put("dealUser", adminId);
        } else {
            map.put("dealUser", "");
        }
        //查询
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogManagementPageDTO> list = logManagementService.findPage(map);
        PageInfo<LogManagementPageInfoDTO> pageDTO = new PageInfo<>(dozerUtils.mapPage(list, LogManagementPageInfoDTO.class));
        if (pageDTO != null && pageDTO.getList() != null && pageDTO.getList().size() > 0) {
            List<Long> ids = new ArrayList<>();
            for (LogManagementPageInfoDTO managementDTO : pageDTO.getList()) {
                Long personId = managementDTO.getDealUser();
                ids.add(personId);
            }
            Result<List<GxqptEmpRetDTO>> empUser = gxqptEmpApi.findByIdsGxqptUserName(ids);
            for (LogManagementPageInfoDTO managementDTO : pageDTO.getList()) {
                OperationFileExample fileExample = new OperationFileExample();
                fileExample.createCriteria().andBussIdEqualTo(managementDTO.getId());
                List<OperationFileDTO> files = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
                if (!files.isEmpty()) {
                    managementDTO.setFiles(files);
                }
                for (GxqptEmpRetDTO empRetDTO : empUser.getData()) {
                    if (empRetDTO.getGxqptEmpId().equals(managementDTO.getDealUser())) {
                        managementDTO.setDealUserName(empRetDTO.getName());
                    }
                }
            }
        }
        return Result.success(pageDTO);
    }

    /**
     * 根据id查询日志管理信息
     *
     * @param id
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询日志管理信息", notes = "根据id查询日志管理信息")
    public Result<LogManagementDTO> get(@RequestParam Long id) {

        if (id == null && "".equals(id)) {
            return Result.fail("查询日志管理id不能为空！");
        }
        //查询
        LogManagementDTO logManagement = dozerUtils.map(logManagementService.getById(id), LogManagementDTO.class);
        OperationFileExample fileExample = new OperationFileExample();
        fileExample.createCriteria().andBussIdEqualTo(id);
        List<OperationFileDTO> fileList = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
        logManagement.setFiles(fileList);
        return Result.success(logManagement);
    }


    /**
     * 新增日志管理
     *
     * @param saveDTO
     */
    @ApiOperation(value = "新增日志管理", notes = "新增日志管理")
    @ApiResponses({
            @ApiResponse(code = 105076, message = "日志类别不能为空"),
            @ApiResponse(code = 105077, message = "日志记录不能为空"),
            @ApiResponse(code = 105078, message = "故障级别不能为空"),
            @ApiResponse(code = 105079, message = "故障分类不能为空"),
            @ApiResponse(code = 105081, message = "日志管理故障处理时间分类不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody LogManagementSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(OperationExceptionCode.LOG_TYPE_NULL, saveDTO.getLogType());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_RECORD_NULL, saveDTO.getLogRecord());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_FAULT_LEVEL_TYPE_NULL, saveDTO.getFaultLevel());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_FAULT_CLASSIFICATION_NULL, saveDTO.getFaultClassification());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_DEAL_TIME_NULL, saveDTO.getDealTime());
        Long userId = BaseContextHandler.getAdminId();
        LogManagement logManagement = dozerUtils.map(saveDTO, LogManagement.class);
        logManagement.setDealUser(userId);
        logManagement.setCreateUser(userId);
        logManagement.setUpdateUser(userId);
        logManagementService.saveSelective(logManagement);
        List<OperationFileDTO> fileList = saveDTO.getFiles();
        if (fileList != null && fileList.size() > 0) {
            List<OperationFile> files = new ArrayList<>();
            for (OperationFileDTO dto : fileList) {
                OperationFile file = dozerUtils.map(dto, OperationFile.class);
                file.setBussId(logManagement.getId());
                file.setUserId(userId);
                file.setBussType("Log_save");
                files.add(file);
            }
            operationFileService.save(files);
        }

        return Result.success(true);
    }

    /**
     * 更新日志管理信息
     *
     * @param updateDTO
     */
    @ApiOperation(value = "修改日志管理信息", notes = "更新日志管理信息")
    @ApiResponses({
            @ApiResponse(code = 105076, message = "日志类别不能为空"),
            @ApiResponse(code = 105077, message = "日志记录不能为空"),
            @ApiResponse(code = 105078, message = "故障级别不能为空"),
            @ApiResponse(code = 105079, message = "故障分类不能为空"),
            @ApiResponse(code = 105081, message = "日志管理故障处理时间分类不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody LogManagementUpdateDTO updateDTO) {
        //验证
        BizAssert.assertNotNull(OperationExceptionCode.LOG_TYPE_NULL, updateDTO.getLogType());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_RECORD_NULL, updateDTO.getLogRecord());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_FAULT_LEVEL_TYPE_NULL, updateDTO.getFaultLevel());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_FAULT_CLASSIFICATION_NULL, updateDTO.getFaultClassification());
        BizAssert.assertNotNull(OperationExceptionCode.LOG_DEAL_TIME_NULL, updateDTO.getDealTime());
        Long userId = BaseContextHandler.getAdminId();
        LogManagement logManagement = dozerUtils.map(updateDTO, LogManagement.class);
        logManagement.setCreateUser(userId);
        logManagement.setUpdateUser(userId);
        logManagementService.updateByIdSelective(logManagement);
        OperationFileExample fileExample = new OperationFileExample();
        fileExample.createCriteria().andBussIdEqualTo(logManagement.getId());
        List<OperationFileDTO> deletefileList = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
        if (!deletefileList.isEmpty()) {
            for (OperationFileDTO fileDTO : deletefileList) {
                operationFileService.deleteById(fileDTO.getId());
            }
        }
        List<OperationFileDTO> fileList = updateDTO.getFiles();
        if (fileList != null && fileList.size() > 0) {
            List<OperationFile> files = new ArrayList<>();
            for (OperationFileDTO dto : fileList) {
                OperationFile file = dozerUtils.map(dto, OperationFile.class);
                file.setBussId(logManagement.getId());
                file.setBussType("Log_update");
                file.setUserId(userId);
                files.add(file);
            }
            operationFileService.save(files);
        }
        return Result.success(true);
    }

    /**
     * 根据id 删除日志管理信息
     *
     * @param id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "根据id 删除日志管理信息", notes = "根据id 删除日志管理信息")
    @ApiResponses({
            @ApiResponse(code = 37100, message = "日志管理ID不能为空")
    })
    public Result<Boolean> delete(@RequestParam Long id) {
        //1，验证
        BizAssert.assertNotNull(OperationExceptionCode.LOG_ID__NULL, id);
        logManagementService.deleteById(id);
        return Result.success(true);
    }

}
