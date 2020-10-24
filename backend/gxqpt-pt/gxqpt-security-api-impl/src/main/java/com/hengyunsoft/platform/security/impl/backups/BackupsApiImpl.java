package com.hengyunsoft.platform.security.impl.backups;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SecurityExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationResDTO;
import com.hengyunsoft.platform.security.api.backups.dto.*;
import com.hengyunsoft.platform.security.entity.backups.po.Backups;
import com.hengyunsoft.platform.security.entity.backups.po.BackupsLog;
import com.hengyunsoft.platform.security.repository.backups.example.BackupsExample;
import com.hengyunsoft.platform.security.repository.backups.example.BackupsLogExample;
import com.hengyunsoft.platform.security.repository.backups.service.BackupsApiService;
import com.hengyunsoft.platform.security.repository.backups.service.BackupsLogApiService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.impl.application
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：备份管理API
 * 修改人：wt
 * 修改时间：2018/6/29
 * 修改内容：
 */
@Api(value = "API - BackupsApiImpl.java", description = "备份管理API  ")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class BackupsApiImpl /*implements BackupsApi*/ {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private BackupsApiService backupsApiService;
    @Autowired
    private BackupsLogApiService backupsLogApiService;
    @Autowired
    private ApplicationApi applicationApi;

    /**
     * 描述：查询备份数据列表
     * 参数：OpenApiReq<ShareRequestProgramFindDTO>
     * 返回值：PageInfo<ShareResponseProgramFindDTO>
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    
    @RequestMapping(value = "/backups/findList", method = RequestMethod.POST)
    @ApiOperation(value = "查询备份数据列表", notes = "查询备份数据列表")
    @ApiResponses({
            @ApiResponse(code = 95001, message = "分页参数不能为空"),
    })
    public Result<PageInfo<ShareResponseBackupsFindListDTO>> findBackups(@RequestBody OpenApiReq<ShareRequestBackupsFindListDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PAGE_OPENAPIREQ, openApiReq);

        Integer dbType = null;
        String applicationName = null;
        if(openApiReq.getData() != null){
            dbType = openApiReq.getData().getDbType();
            applicationName = openApiReq.getData().getApplicationName();
        }
        List<ApplicationResDTO> applicationList = applicationApi.findAppVisibleForSelf(1).getData();
        List<String> paramsName = new ArrayList<String>();
        for (ApplicationResDTO dto : applicationList){
            paramsName.add(dto.getName());
        }

        BackupsExample example = new BackupsExample();
        dbType = dbType < 1 ? null : dbType;
        if("-1".equals(applicationName)){
            example.createCriteria().andDbTypeEqualTo(dbType).andApplicationNameIn(paramsName);
        }else{
            example.createCriteria().andDbTypeEqualTo(dbType).andApplicationNameEqualTo(applicationName);
        }

        //数据获取
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<Backups> list = backupsApiService.find(example);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ShareResponseBackupsFindListDTO.class)));

    }

    /**
     * 描述：保存备份数据
     * 参数：ShareRequestBackupsSaveDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    
    @RequestMapping(value = "/backups/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存备份数据", notes = "保存备份数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<ShareResponseBackupsSaveDTO> saveBackups(@RequestBody ShareRequestBackupsSaveDTO dto) {
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();

        Backups backups = new Backups();
        backups.setAppId(dto.getAppId());
        backups.setApplicationName(dto.getApplicationName());
        backups.setName(dto.getName());
        backups.setPath(dto.getPath());
        backups.setFileExt(dto.getFileExt());
        backups.setServerIp(dto.getServerIp());
        backups.setServerAccount(dto.getServerAccount());
        backups.setServerPasswd(dto.getServerPasswd());
        backups.setDbType(dto.getDbType());
        backups.setBackupFrequency(dto.getBackupFrequency());
        backups.setCheckMark(dto.getCheckMark());
        backups.setStartTime(dto.getStartTime());
        backups.setRemarks(dto.getRemarks());
        backups.setCreateTime(Calendar.getInstance().getTime());
        backups.setCreateUser(adminId);
        Backups result = backupsApiService.saveSelective(backups);
        return Result.success(dozerUtils.map(result,ShareResponseBackupsSaveDTO.class));
    }

    /**
     * 描述：更新备份数据
     * 参数：ShareRequestBackupsUpdateDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    
    @RequestMapping(value = "/backups/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新备份数据", notes = "更新备份数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<Integer> updateBackups(@RequestBody ShareRequestBackupsUpdateDTO dto) {
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();

        Backups backups = new Backups();
        backups.setId(dto.getId());
        backups.setApplicationName(dto.getApplicationName());
        backups.setName(dto.getName());
        backups.setPath(dto.getPath());
        backups.setFileExt(dto.getFileExt());
        backups.setServerIp(dto.getServerIp());
        backups.setServerAccount(dto.getServerAccount());
        backups.setServerPasswd(dto.getServerPasswd());
        backups.setDbType(dto.getDbType());
        backups.setBackupFrequency(dto.getBackupFrequency());
        backups.setCheckMark(dto.getCheckMark());
        backups.setStartTime(dto.getStartTime());
        backups.setRemarks(dto.getRemarks());
        backups.setUpdateTime(Calendar.getInstance().getTime());
        backups.setUpdateUser(adminId);
        Integer result = backupsApiService.updateByIdSelective(backups);
        return Result.success(result);
    }

    /**
     * 描述：查询备份监控表
     * 参数：
     * 返回值：ShareResponseBackupsLogDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/backupslog/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询备份监控表", notes = "查询备份监控表")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<ShareResponseBackupsLogTimeDTO> queryBackupsLog(@RequestBody ShareRequestBackupsLogDTO dto) {
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);
        BizAssert.assertNotEmpty(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto.getYearMonth());

        ShareResponseBackupsLogTimeDTO result = new ShareResponseBackupsLogTimeDTO();
        BackupsExample backupsExample = new BackupsExample();
        backupsExample.createCriteria().andNameEqualTo(dto.getName()).andApplicationNameEqualTo(dto.getApplicationName());
        Backups backups = backupsApiService.getUnique(backupsExample);
        if(backups == null || backups.getCheckMark() == false){
            return Result.success(null,"没有查询到备份设置数据");
        }
        Date paramStartDate = null;
        Date paramEndDate = null;
        String startTime = dto.getYearMonth() + "-01 00:00:00";
        String endTime = dto.getYearMonth() + "-31 23:59:59";
        Date nowDate = backups.getStartTime();
        Date startDate = DateUtils.getDate(startTime);
        Date endDate = DateUtils.getDate(endTime);
        Integer subDay1 = DateUtils.subDays(nowDate,startDate);
        Integer subDay2 = DateUtils.subDays(nowDate,endDate);

        if(subDay1 < 0){
            paramStartDate = startDate;
            paramEndDate = endDate;
        }else{
            if(subDay2 < 0){
                paramStartDate = nowDate;
                paramEndDate = endDate;
            }else{
                paramStartDate = startDate;
                paramEndDate = endDate;
            }
        }

        BackupsLogExample backupsLogExample = new BackupsLogExample();
        backupsLogExample.createCriteria().andAppIdEqualTo(backups.getAppId())
                .andCreateTimeBetween(paramStartDate,paramEndDate);
        backupsLogExample.setOrderByClause("create_time ASC");
        List<BackupsLog> list = backupsLogApiService.find(backupsLogExample);
        result.setStartTime(nowDate);
        result.setLogList(dozerUtils.mapList(list,ShareResponseBackupsLogDTO.class));
        return Result.success(result);
    }

    /**
     * 描述：查询所有系统名称
     * 参数：
     * 返回值：ShareResponseBackupsDownNameDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/backups/getallname", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有系统名称", notes = "查询所有系统名称")
    @ApiResponses({
    })
    public Result<List<ShareResponseBackupsDownNameDTO>> getBackupsNameDown(){

        BackupsExample example = new BackupsExample();
        example.createCriteria().andNameIsNotNull();
        List<Backups> result = backupsApiService.find(example);
        return Result.success(dozerUtils.mapList(result,ShareResponseBackupsDownNameDTO.class));
    }

    /**
     * 描述：根据ID查询备份数据
     * 参数：ID
     * 返回值：ShareResponseBackupsGetByIdDTO
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/backups/getbyid", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询备份数据", notes = "根据ID查询备份数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<ShareResponseBackupsGetByIdDTO> getById(Long id){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, id);

        Backups backups = backupsApiService.getById(id);
        return Result.success(dozerUtils.map(backups,ShareResponseBackupsGetByIdDTO.class));
    }

    /**
     * 描述：根据备份系统名称查询备份名称
     * 参数：systemName
     * 返回值：List<String>
     * 修改人：wt
     * 修改时间：2018/8/20
     * 修改内容：
     */
    @RequestMapping(value = "/backups/getbySystemName", method = RequestMethod.GET)
    @ApiOperation(value = "根据备份系统名称查询备份名称", notes = "根据备份系统名称查询备份名称")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<List<String>> getBySystemName(@RequestParam(value = "systemName") String systemName){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, systemName);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();

        List<String> result = new ArrayList<String>();
        BackupsExample example = new BackupsExample();
        example.createCriteria().andApplicationNameEqualTo(systemName);
        List<Backups> backups = backupsApiService.find(example);
        for (Backups curr:backups){
            result.add(curr.getName());
        }
        return Result.success(result);
    }

    /**
     * 描述：保存备份日志数据
     * 参数：ShareRequestBackupsLogSaveDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/4
     * 修改内容：
     */
    @RequestMapping(value = "/backupslog/save", method = RequestMethod.GET)
    @ApiOperation(value = "保存备份日志数据", notes = "保存备份日志数据")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    @IgnoreToken
    public Result<ShareResponseBackupsLogSaveDTO> saveBackLog(ShareRequestBackupsLogSaveDTO dto){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, dto);

        BackupsLog backupsLog = new BackupsLog();
        backupsLog.setAppId(dto.getAppId());
        backupsLog.setCreateTime(dto.getCreateTime());
        BackupsLog result = backupsLogApiService.saveSelective(backupsLog);
        return Result.success(dozerUtils.map(result,ShareResponseBackupsLogSaveDTO.class));
    }

    /**
     * 描述：校验备份名称是否重复
     * 参数：name
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/6/29
     * 修改内容：
     */
    @RequestMapping(value = "/backups/valionlyname", method = RequestMethod.GET)
    @ApiOperation(value = "校验备份名称是否重复", notes = "校验备份名称是否重复")
    @ApiResponses({
            @ApiResponse(code = 95003, message = "参数不能为空"),
    })
    public Result<Integer> queryValidateNameOnly(String name){
        //数据验证
        BizAssert.assertNotNull(SecurityExceptionCode.PARAM_OBJECT_IS_NULL, name);
        BackupsExample example = new BackupsExample();
        example.createCriteria().andNameEqualTo(name);
        Backups backups = backupsApiService.getUnique(example);
        Integer result = 0;
        if(backups != null){
            result = 1;
        }
        return Result.success(result);
    }
}
