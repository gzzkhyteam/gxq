package com.hengyunsoft.platform.logs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.LogsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.AppShowDto;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.logs.dto.LogFileDTO;
import com.hengyunsoft.platform.logs.dto.LogFileQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogFileQueryStructByIdDTO;
import com.hengyunsoft.platform.logs.dto.LogFileSaveDTO;
import com.hengyunsoft.platform.logs.dto.LogStructApacheDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppDTO;
import com.hengyunsoft.platform.logs.dto.LogStructNginxDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTomcatDTO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogFileDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFile;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface;
import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileInterfaceService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogPatternSetService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(value = "日志采集", description = "日志文件管理")
public class LogFileApiImpl /*implements LogFileApi*/{
    @Autowired
    private LogFileService logFileService;
    @Autowired
    private LogFileInterfaceService logFileInterfaceService;
    @Autowired
    private LogPatternSetService logPatternSetService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private DozerUtils dozerUtils;
    /**
     * 分页查询日志系统上传的日志文档查询
     * 查询默认值data_channel=‘UPLOAD’
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "导入日志文档分页查询", notes = "导入日志文档分页查询")
    @RequestMapping(value = "/file/pageQueryUpload", method = RequestMethod.POST)
    public Result<PageInfo<LogFileDTO>> pageQueryUpload(@RequestBody OpenApiReq<LogFileQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }


        LogFileQueryDTO data = openApiReq.getData();

        LogFileExample example = new LogFileExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }


            String logTypes=data.getLogType();
            List<String> logTypesList = new ArrayList();
            if(null!=logTypes && !"".equals(logTypes)){
                String[] logTypeArray = logTypes.split(",");
                for(int m=0; m<logTypeArray.length; m++) {
                    String logType = logTypeArray[m];
                    if(logType != null && !logType.equals("")) {
                        logTypesList.add(logType);
                    }
                }
            }
            int mark=0;//判断有没有已失效的状态
            int mark1=0;//判断有没有未解析的状态
            String isParseds=data.getIsParsed();
            List<String> isParsedList = new ArrayList();
            if(null!=isParseds && !"".equals(isParseds)){
                String[] isParsedArray = isParseds.split(",");
                for(int m=0; m<isParsedArray.length; m++) {
                    String isParsed = isParsedArray[m];
                    if(isParsed != null && !isParsed.equals("")) {
                        if(isParsed.equals("INVALID")){//已失效
                            mark=1;
                        }else if(isParsed.equals("PARSING")){//解析中
                            isParsedList.add("0");
                        }else if(isParsed.equals("PARSED")){//已解析
                            isParsedList.add("1");
                        }else if(isParsed.equals("PARSEDFAILED")){//解析失败
                            isParsedList.add("2");
                        }else if(isParsed.equals("NOTPARSED")){//未解析
                            mark1=1;
                        }
                    }
                }
            }

           // LogFileExample.Criteria criteria= example.createCriteria();
                 //   .andFDataChannelEqualTo("UPLOAD")
                 //   .andFAllEqualTo();
            int flag=0;//判断有没有进入（无特殊条件情况的条件拼接 特殊条件指：IS_PARSED的解析状态是否存在 已失效和未解析）
            if(mark==1 && isParsedList.size()>0 || mark1==1 && isParsedList.size()>0 || (mark==0 && mark1==0)){
                example.createCriteria()
                        .andFDataChannelEqualTo("UPLOAD")
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                        .andFLogTypeIn(logTypesList.size()==0? Arrays.asList(""):logTypesList)
                        .andFIsParsedIn(isParsedList.size()==0? Arrays.asList(""):isParsedList);
                flag=1;
            }
            int flag1=0;//判断有没有进入已失效的条件拼接
            if(mark==1){
                LogFileExample.Criteria criteria1= example.createCriteria()
                        .andFDataChannelEqualTo("UPLOAD")
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                        .andFLogTypeIn(logTypesList.size()==0? Arrays.asList(""):logTypesList)
                        .andFIsDeleteStructEqualTo("1");//已失效
                flag1=1;
                if(flag==1){
                    example.or(criteria1);
                }
            }
            if(mark1==1){
                LogFileExample.Criteria criteria2= example.createCriteria()
                        .andFDataChannelEqualTo("UPLOAD")
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                        .andFLogTypeIn(logTypesList.size()==0? Arrays.asList(""):logTypesList)
                        .andFIsParsedIsNull(); //未解析
                if(flag==1 || flag1==1){
                    example.or(criteria2);
                }
            }
        }else{
            example.createCriteria()
                    .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                    .andFDataChannelEqualTo("UPLOAD");
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogFileDO> lists = logFileService.pageQueryUpload(example);
        List<LogFileDTO> pageList = dozerUtils.mapPage(lists, LogFileDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiOperation(value = "预览应用系统日志", notes = "预览应用系统日志")
    @RequestMapping(value = "/file/pageQueryAppList", method = RequestMethod.POST)
    public Result<PageInfo<LogStructAppDTO>> pageQueryAppList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
        LogFileQueryStructByIdDTO data = openApiReq.getData();
        LogStructAppExample example = new LogStructAppExample();
        if (data != null) {
            example.createCriteria()
                    .andDocumentIdEqualTo(data.getDocumentId())
            ;
            //拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
                    ) {
                example.setOrderByClause(" create_time " + data.getSord());
            }
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApp> lists = logFileService.pageQueryAppList(example);
        List<LogStructAppDTO> pageList = dozerUtils.mapPage(lists, LogStructAppDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiOperation(value = "预览Apache日志", notes = "预览Apache日志")
    @RequestMapping(value = "/file/pageQueryApacheList", method = RequestMethod.POST)
    public Result<PageInfo<LogStructApacheDTO>> pageQueryApacheList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
        LogFileQueryStructByIdDTO data = openApiReq.getData();
        LogStructApacheExample example = new LogStructApacheExample();
        if (data != null) {
            example.createCriteria()
                    .andDocumentIdEqualTo(data.getDocumentId())
            ;
            //拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
                    ) {
                example.setOrderByClause(" create_time " + data.getSord());
            }
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApache> lists = logFileService.pageQueryApacheList(example);
        List<LogStructApacheDTO> pageList = dozerUtils.mapPage(lists, LogStructApacheDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiOperation(value = "预览Nginx日志", notes = "预览Nginx日志")
    @RequestMapping(value = "/file/pageQueryNginxList", method = RequestMethod.POST)
    public Result<PageInfo<LogStructNginxDTO>> pageQueryNginxList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
        LogFileQueryStructByIdDTO data = openApiReq.getData();
        LogStructNginxExample example = new LogStructNginxExample();
        if (data != null) {
            example.createCriteria()
                    .andDocumentIdEqualTo(data.getDocumentId())
            ;
            //拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
                    ) {
                example.setOrderByClause(" create_time " + data.getSord());
            }
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructNginx> lists = logFileService.pageQueryNginxList(example);
        List<LogStructNginxDTO> pageList = dozerUtils.mapPage(lists, LogStructNginxDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiOperation(value = "预览Tomcat日志", notes = "预览Tomcat日志")
    @RequestMapping(value = "/file/pageQueryTomcatList", method = RequestMethod.POST)
    public Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcatList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
        LogFileQueryStructByIdDTO data = openApiReq.getData();
        LogStructTomcatExample example = new LogStructTomcatExample();
        if (data != null) {
            example.createCriteria()
                    .andDocumentIdEqualTo(data.getDocumentId())
            ;
            //拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
                    ) {
                example.setOrderByClause(" create_time " + data.getSord());
            }
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructTomcat> lists = logFileService.pageQueryTomcatList(example);
        List<LogStructTomcatDTO> pageList = dozerUtils.mapPage(lists, LogStructTomcatDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    /**
     * 保存上传的日志文件到表log_file 和log_file_interface
     * @param logFilesSaveDTO
     * @return
     */

    @ApiOperation(value = "保存日志文件", notes = "保存日志文件")
    @ApiResponses({
            @ApiResponse(code = 65001, message = "上传日志文件不允许为空"),
            @ApiResponse(code = 65002, message = "文件名称不允许为空"),
            @ApiResponse(code = 65003, message = "文件类型不允许为空"),
            @ApiResponse(code = 65004, message = "文档ID不允许为空"),
            @ApiResponse(code = 65005, message = "采集渠道不允许为空")
    })
    @RequestMapping(value = "/file/save", method = RequestMethod.POST)
    public Result<LogFileDTO> save(@RequestBody LogFileSaveDTO logFilesSaveDTO) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.FILE_NULL, logFilesSaveDTO);
        BizAssert.assertNotNull(LogsExceptionCode.FILE_NAME_EMPTY, logFilesSaveDTO.getFileName());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_TYPE_EMPTY, logFilesSaveDTO.getLogType());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_DOCUMENT_EMPTY, logFilesSaveDTO.getDocumentId());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_DATA_CHANNEL, logFilesSaveDTO.getDataChannel());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        //String appId = BaseContextHandler.getAppId();

        //3,转换po，并保存
        LogFile logFile = dozerUtils.map(logFilesSaveDTO, LogFile.class);
        //logFile.setAppId(appId);
        logFile.setCreateTime(Calendar.getInstance().getTime());
        logFile.setCreateUser(adminId);
        logFile.setCreateUserName(userName);
        logFile.setUpdateUser(adminId);
        logFile.setUpdateTime(Calendar.getInstance().getTime());
        logFile.setUpdateUserName(userName);
        logFile.setCreateUserName(logFilesSaveDTO.getCreateUserName());
        logFile.setUpdateUserName(logFilesSaveDTO.getUpdateUserName());
        logFile = logFileService.save(logFile);

        //LogFileInterface logFileInterface = dozerUtils.map(logFilesSaveDTO, LogFileInterface.class);
        LogFileInterface logFileInterface = new LogFileInterface();

        //logFileInterface.setAppId(appId);
        logFileInterface.setLogFileId(logFile.getId());
        logFileInterface.setLogType(logFilesSaveDTO.getLogType());

        //取日志格式
        LogPatternSetExample example = new LogPatternSetExample();
        example.createCriteria().andAppIdEqualTo(logFilesSaveDTO.getAppId())
                .andLogTypeEqualTo(logFilesSaveDTO.getLogType());
        List<LogPatternSet> logPatternSetList = logPatternSetService.find(example);
        String logPattern="";
        String logExportType="";
        if(logPatternSetList.size()>0){
            logPattern = logPatternSetList.get(0).getLogPattern();
            logExportType = logPatternSetList.get(0).getLogExportType();
        }
        logFileInterface.setAppId(logFilesSaveDTO.getAppId());
        logFileInterface.setLogExportType(logExportType);
        logFileInterface.setLogPattern(logPattern);                //要修改,调用接口
        logFileInterface.setDocumentId(logFilesSaveDTO.getDocumentId());
        logFileInterface.setIsParsed("0");
        logFileInterface.setIsPull("0");
        logFileInterface.setIsDeleteStruct("0");
        logFileInterface.setCreateTime(Calendar.getInstance().getTime());
        logFileInterface.setCreateUser(adminId);
        logFileInterface.setUpdateUser(adminId);
        logFileInterface.setUpdateTime(Calendar.getInstance().getTime());
        logFileInterface = logFileInterfaceService.saveInterface(logFileInterface);

        //4,返回
        return Result.success(dozerUtils.map(logFile, LogFileDTO.class));
    }
    @ApiOperation(value = "日志文档分页查询", notes = "日志文档分页查询")
    @RequestMapping(value = "/file/pageQuery", method = RequestMethod.POST)
    public Result<PageInfo<LogFileDTO>> pageQuery(@RequestBody OpenApiReq<LogFileQueryDTO> openApiReq) {
        //取当前登录用户拥用的应用系统
        Result<List<AppShowDto>> resultListApp = applicationApi.findAppIdList((long) 1);
        List<AppShowDto> listApp = resultListApp.getData();
        List<String> appIdListAll = new ArrayList();
        if(listApp.size()>0){
            for(int i=0;i<listApp.size();i++){
                AppShowDto appShowDto = listApp.get(i);
                appIdListAll.add(appShowDto.getAppId());
            }
        }

        LogFileQueryDTO data = openApiReq.getData();
        LogFileExample example = new LogFileExample();
        if (data != null) {
            String appIds=data.getAppId();
            List<String> appIdList = new ArrayList();
            if(null!=appIds && !"".equals(appIds)){
                String[] appIdArray = appIds.split(",");
                for(int m=0; m<appIdArray.length; m++) {
                    String appId = appIdArray[m];
                    if(null!=appId && !appId.equals("")) {
                        appIdList.add(appId);
                    }
                }
            }


            String logTypes=data.getLogType();
            List<String> logTypesList = new ArrayList();
            if(null!=logTypes && !"".equals(logTypes)){
                String[] logTypeArray = logTypes.split(",");
                for(int m=0; m<logTypeArray.length; m++) {
                    String logType = logTypeArray[m];
                    if(logType != null && !logType.equals("")) {
                        logTypesList.add(logType);
                    }
                }
            }
            int mark=0;//判断有没有已失效的状态
            int mark1=0;//判断有没有未解析的状态
            String isParseds=data.getIsParsed();
            List<String> isParsedList = new ArrayList();
            if(null!=isParseds && !"".equals(isParseds)){
                String[] isParsedArray = isParseds.split(",");
                for(int m=0; m<isParsedArray.length; m++) {
                    String isParsed = isParsedArray[m];
                    if(isParsed != null && !isParsed.equals("")) {
                        if(isParsed.equals("INVALID")){//已失效
                            mark=1;
                        }else if(isParsed.equals("PARSING")){//解析中
                            isParsedList.add("0");
                        }else if(isParsed.equals("PARSED")){//已解析
                            isParsedList.add("1");
                        }else if(isParsed.equals("PARSEDFAILED")){//解析失败
                            isParsedList.add("2");
                        }else if(isParsed.equals("NOTPARSED")){//未解析
                            mark1=1;
                        }
                    }
                }
            }

            // LogFileExample.Criteria criteria= example.createCriteria();
            //   .andFDataChannelEqualTo("UPLOAD")
            //   .andFAllEqualTo();
            int flag=0;//判断有没有进入（无特殊条件情况的条件拼接 特殊条件指：IS_PARSED的解析状态是否存在 已失效和未解析）
            if(mark==1 && isParsedList.size()>0 || mark1==1 && isParsedList.size()>0 || (mark==0 && mark1==0)){
                example.createCriteria()
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                        .andFLogTypeIn(logTypesList.size()==0? Arrays.asList(""):logTypesList)
                        .andFIsParsedIn(isParsedList.size()==0? Arrays.asList(""):isParsedList);
                flag=1;
            }
            int flag1=0;//判断有没有进入已失效的条件拼接
            if(mark==1){
                LogFileExample.Criteria criteria1= example.createCriteria()
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                        .andFLogTypeIn(logTypesList.size()==0? Arrays.asList(""):logTypesList)
                        .andFIsDeleteStructEqualTo("1");//已失效
                flag1=1;
                if(flag==1){
                    example.or(criteria1);
                }
            }
            if(mark1==1){
                LogFileExample.Criteria criteria2= example.createCriteria()
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFAppIdIn(appIdList.size()==0? Arrays.asList(""):appIdList)
                        .andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll)
                        .andFLogTypeIn(logTypesList.size()==0? Arrays.asList(""):logTypesList)
                        .andFIsParsedIsNull(); //未解析
                if(flag==1 || flag1==1){
                    example.or(criteria2);
                }
            }
        }else{
            LogFileExample.Criteria criteria= example.createCriteria().andFAppIdIn(appIdListAll.size()==0?Arrays.asList(""):appIdListAll);
        }
        example.setOrderByClause(" create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogFileDO> lists = logFileService.pageQueryUpload(example);
        List<LogFileDTO> pageList = dozerUtils.mapPage(lists, LogFileDTO.class);
        return Result.success(new PageInfo(pageList));
    }
    @ApiOperation(value = "日志文件解析", notes = "日志文件解析")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "文件id不能为空"),
            @ApiResponse(code = 65006, message = "实体对象未获取到值")
    })
    @RequestMapping(value = "/file/parse", method = RequestMethod.GET)
    public Result<LogFileDTO> saveFileInterface(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();

        LogFile logFile = logFileService.getById(id);
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logFile);

        LogFileInterface logFileInterface = new LogFileInterface();

        logFileInterface.setAppId(logFile.getAppId());
        logFileInterface.setLogFileId(logFile.getId());
        logFileInterface.setLogType(logFile.getLogType());

        //取日志格式
        LogPatternSetExample example = new LogPatternSetExample();
        example.createCriteria().andAppIdEqualTo(logFile.getAppId())
                .andLogTypeEqualTo(logFile.getLogType());
        List<LogPatternSet> logPatternSetList = logPatternSetService.find(example);
        String logPattern="";
        String logExportType="";
        if(logPatternSetList.size()>0){
            logPattern = logPatternSetList.get(0).getLogPattern();
            logExportType = logPatternSetList.get(0).getLogExportType();
        }
        logFileInterface.setLogExportType(logExportType);
        logFileInterface.setLogPattern(logPattern);
        logFileInterface.setDocumentId(logFile.getDocumentId());
        logFileInterface.setIsParsed("0");
        logFileInterface.setIsPull("0");
        logFileInterface.setIsDeleteStruct("0");
        logFileInterface.setCreateTime(Calendar.getInstance().getTime());
        logFileInterface.setCreateUser(adminId);
        logFileInterface.setUpdateUser(adminId);
        logFileInterface.setUpdateTime(Calendar.getInstance().getTime());
        logFileInterface = logFileInterfaceService.saveInterface(logFileInterface);

        return Result.success(dozerUtils.map(logFileInterface, LogFileDTO.class));
    }
    @ApiOperation(value = "日志文件重新解析", notes = "日志文件重新解析")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "文件id不能为空")
    })
    @RequestMapping(value = "/file/reParse", method = RequestMethod.GET)
    public Result<Boolean> updateFileInterface(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        LogFileInterface logFileInterface=logFileInterfaceService.queryLogFileInterfaceByLogFileId(id);
        //取日志格式(重新获取日志文件格式)
        LogFile logFile = logFileService.getById(id);
        LogPatternSetExample example = new LogPatternSetExample();
        example.createCriteria().andAppIdEqualTo(logFile.getAppId())
                .andLogTypeEqualTo(logFile.getLogType());
        List<LogPatternSet> logPatternSetList = logPatternSetService.find(example);
        String logPattern="";
        String logExportType="";
        if(logPatternSetList.size()>0){
            logPattern = logPatternSetList.get(0).getLogPattern();
            logExportType = logPatternSetList.get(0).getLogExportType();
        }
        logFileInterface.setIsDeleteStruct("0");
        logFileInterface.setIsParsed("0");
        logFileInterface.setUpdateTime(Calendar.getInstance().getTime());
        logFileInterface.setLogExportType(logExportType);
        logFileInterface.setLogPattern(logPattern);
        logFileInterface.setUpdateUser(BaseContextHandler.getAdminId());

        int i = logFileInterfaceService.updateByIdSelective(logFileInterface);

        if(i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        }else {
            return Result.success(true);
        }
    }


    
    @ApiOperation(value = "根据id 删除文件", notes = "根据id 删除文件")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "文件id不能为空")
    })
    @RequestMapping(value = "/file/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1、验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, id);
        LogFile logFile= logFileService.getById(id);
        String logType="";
        String documentId="";
        if(null!=logFile && null!=logFile.getLogType() && !logFile.getLogType().equals("")){
            logType=logFile.getLogType();
            documentId=logFile.getDocumentId();
        }

        //执行删除操作（删除记录）
        int i = logFileService.deleteById(id);
        //物理删除日志文件
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        Long[] documentIdLong = new Long[1];
        documentIdLong[0]= Long.valueOf(documentId);
        fileService.removeList(appId,null,documentIdLong);

        if(i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        }else {
            int j=logFileService.deleteLogFileInterfaceById(id);
            if(j == 0) {
                return Result.fail("未找到要删除的数据，log_file_id：" + id);
            }else {
                List<String> list = new ArrayList();
                list.add(documentId);
                if(logType.equals("APP")){
                    logFileService.deleteAppByDocumentId(list);
                }else if(logType.equals("APACHE")){
                    logFileService.deleteApacheByDocumentId(list);
                }else if(logType.equals("TOMCAT")){
                    logFileService.deleteTomcatByDocumentId(list);
                }else if(logType.equals("NGINX")){
                    logFileService.deleteNginxByDocumentId(list);
                }

                return Result.success(true);
            }
        }
    }

    
    @ApiOperation(value = "根据ids 批量删除文件", notes = "根据ids 批量删除文件")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "文件id不能为空"),
    })
    @RequestMapping(value = "/file/deleteBatch", method = RequestMethod.GET)
    public Result<Boolean> deleteBatch(@RequestParam(value = "ids") String ids) {
        //1，验证
        BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, ids);

        String[] idArray = ids.split(",");
        List<Long> list = new ArrayList<Long>();
        for(int m=0; m<idArray.length; m++) {
            String id = idArray[m];
            if(id != null && !id.equals("")) {
                list.add(Long.valueOf(id));
            }
        }
        List<LogFile> listLogFile = logFileService.queryLogFileByIds(list);

        int i = logFileService.deleteByIds(list);
        if(i == 0) {
            return Result.fail("未找到要删除的数据，ids：" + ids);
        }else {
            int j=logFileService.deleteLogFileInterfaceByIds(list);
            if(j == 0) {
                return Result.fail("未找到要删除的数据，ids：" + ids);
            }else {
                List<String> listApp = new ArrayList();
                List<String> listApache = new ArrayList();
                List<String> listTomcat = new ArrayList();
                List<String> listNginx = new ArrayList();
                Long[] doucmentIdLong = new Long[listLogFile.size()];
                for(int k=0;k<listLogFile.size();k++){
                    LogFile logFile = listLogFile.get(k);
                    String logType=logFile.getLogType();
                    String documentId=logFile.getDocumentId();
                    doucmentIdLong[k]= Long.valueOf(documentId);
                    if(logType.equals("APP")){
                        listApp.add(documentId);
                    }else if(logType.equals("APACHE")){
                        listApache.add(documentId);
                    }else if(logType.equals("TOMCAT")){
                        listTomcat.add(documentId);
                    }else if(logType.equals("NGINX")){
                        listNginx.add(documentId);
                    }
                }
                if(listLogFile.size()>0){
                    //物理删除日志文件
                    String appId = BaseContextHandler.getAppId();
                    Long adminId = BaseContextHandler.getAdminId();
                    fileService.removeList(appId,null,doucmentIdLong);
                }
                if(listApp.size()>0){
                    logFileService.deleteAppByDocumentId(listApp);
                }
                if(listApache.size()>0){
                    logFileService.deleteApacheByDocumentId(listApache);
                }
                if(listTomcat.size()>0){
                    logFileService.deleteTomcatByDocumentId(listTomcat);
                }
                if(listNginx.size()>0){
                    logFileService.deleteNginxByDocumentId(listNginx);
                }
                return Result.success(true);
            }
        }
    }
}
