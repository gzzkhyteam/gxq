package com.hengyunsoft.platform.logs.open;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.LogsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.open.FileOpenApi;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.logs.dto.LogDelDTO;
import com.hengyunsoft.platform.logs.dto.LogFileDTO;
import com.hengyunsoft.platform.logs.dto.LogFileOpenQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogFileSaveDTO;
import com.hengyunsoft.platform.logs.dto.LogStructApacheDTO;
import com.hengyunsoft.platform.logs.dto.LogStructApacheOpenQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppOpenDTO;
import com.hengyunsoft.platform.logs.dto.LogStructAppOpenQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructNginxDTO;
import com.hengyunsoft.platform.logs.dto.LogStructNginxOpenQueryDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTomcatDTO;
import com.hengyunsoft.platform.logs.dto.LogStructTomcatOpenQueryDTO;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogFileDO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFile;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface;
import com.hengyunsoft.platform.logs.entity.logs.po.LogOpenDelete;
import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApache;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructApp;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructNginx;
import com.hengyunsoft.platform.logs.entity.logs.po.LogStructTomcat;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileInterfaceExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructApacheExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructAppExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructNginxExample;
import com.hengyunsoft.platform.logs.repository.logs.example.LogStructTomcatExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileInterfaceService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogOpenDeleteService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogPatternSetService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructApacheService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructAppService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructNginxService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogStructTomcatService;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.UploadFileUtil;
import com.hengyunsoft.utils.UploadResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/p/log")
@Api(value = "日志管理", description = "日志写入，日志文件上传、查询，日志文件结构化、查询，日志文件解析")
public class LogOpenApiImpl /*implements LogOpenApi*/ {
    @Autowired
    private LogStructAppService logStructAppService;
    @Autowired
    private LogStructApacheService logStructApacheService;
    @Autowired
    private LogStructNginxService logStructNginxService;
    @Autowired
    private LogStructTomcatService logStructTomcatService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private LogFileService logFileService;
    @Autowired
    private LogFileInterfaceService logFileInterfaceService;
    @Autowired
    private LogOpenDeleteService logOpenDeleteService;
    @Autowired
    private FileOpenApi fileOpenApi;
    @Autowired
    private LogPatternSetService logPatternSetService;
    @Autowired
    private FileService fileService;

    @Value("${ftp.logAppId}")
    private String logAppId;//日志系统的appid
    @Value("${ftp.logAppSecret}")
    private String logAppSecret;//日志系统的密码
    @Value("${ftp.serverUrl}")
    private String serverUrl;//上传地址

    @ApiOperation(value = "实时写入应用系统日志", notes = "实时写入应用系统日志")
    @ApiResponses({
            @ApiResponse(code = 65006, message = "保存实体不能为空"),
            @ApiResponse(code = 66501, message = "内容超长"),
            @ApiResponse(code = 66502, message = "日志级别可选值：INFO|DEBUG|WARN|ERROR|FATAL")
    })
    @RequestMapping(value = "/write", method = RequestMethod.POST)

    public Result<LogStructAppOpenDTO> write(@RequestBody LogStructAppOpenDTO logStructAppOpenDTO) {
        //验证
        BizAssert.assertNotNull(LogsExceptionCode.ENTITY_NULL, logStructAppOpenDTO);
        //对传入的内容做长度判断
        if (null != logStructAppOpenDTO.getClassName() && logStructAppOpenDTO.getClassName().length() > 50) {
            return Result.fail(66501, "类名className的值超出限制，最长50字符");
        }
        if (null != logStructAppOpenDTO.getContent() && logStructAppOpenDTO.getContent().length() > 2000) {
            return Result.fail(66501, "日志内容content的值超出限制，最长2000字符");
        }
        String levels = logStructAppOpenDTO.getLevel();
        if (null != levels && (!"INFO".equals(levels.toUpperCase()) && !"DEBUG".equals(levels.toUpperCase()) && !"WARN".equals(levels.toUpperCase()) && !"ERROR".equals(levels.toUpperCase()) && !"FATAL".equals(levels.toUpperCase()))) {
            return Result.fail(66502, "日志级别可选值为：INFO|DEBUG|WARN|ERROR|FATAL");
        }
        if (null != logStructAppOpenDTO.getLine() && logStructAppOpenDTO.getLine().length() > 11) {
            return Result.fail(66501, "代码行数line的值超出限制，最长11字符");
        }
        if (null != logStructAppOpenDTO.getLogBusinessType() && logStructAppOpenDTO.getLogBusinessType().length() > 50) {
            return Result.fail(66501, "日志业务类型logBusinessType的值超出限制，最长50字符");
        }
        if (null != logStructAppOpenDTO.getLogName() && logStructAppOpenDTO.getLogName().length() > 50) {
            return Result.fail(66501, "日志名称logName的值超出限制，最长50字符");
        }
        if (null != logStructAppOpenDTO.getMethod() && logStructAppOpenDTO.getMethod().length() > 50) {
            return Result.fail(66501, "方法名method的值超出限制，最长50字符");
        }
        if (null != logStructAppOpenDTO.getSourceFileName() && logStructAppOpenDTO.getSourceFileName().length() > 50) {
            return Result.fail(66501, " 源文件名sourceFileName的值超出限制，最长50字符");
        }
        if (null != logStructAppOpenDTO.getSystemLiveTime() && logStructAppOpenDTO.getSystemLiveTime().length() > 11) {
            return Result.fail(66501, " 应用存活时间systemLiveTime的值超出限制，最长11字符");
        }
        if (null != logStructAppOpenDTO.getThread() && logStructAppOpenDTO.getThread().length() > 50) {
            return Result.fail(66501, " 线程名thread的值超出限制，最长50字符");
        }
        String appId = BaseContextHandler.getAppId();
        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并保存
        LogStructApp logStructApp = dozerUtils.map(logStructAppOpenDTO, LogStructApp.class);
        logStructApp.setAppId(appId);
        if (null != levels) {
            logStructApp.setLevel(levels.toUpperCase());
        }
        logStructApp.setDocumentId("WRITE");//实时写入
        logStructApp.setDataChannel("WRITE");//实时写入采集渠道
        logStructApp.setCreateTime(Calendar.getInstance().getTime());
        logStructApp.setCreateUser(adminId);
        logStructApp.setCreateUserName(userName);
        logStructApp = logStructAppService.save(logStructApp);

        return Result.success(dozerUtils.map(logStructApp, LogStructAppOpenDTO.class));
    }

    @ApiOperation(value = "日志文件上传", notes = "")
    @ApiImplicitParams({

            @ApiImplicitParam(name = "logType", value = "日志类型 可选值：APACHE|NGINX|TOMCAT|APP", dataType = "string", paramType = "query", example = "APACHE,NGINX,TOMCAT,APP"),
    })
    @ApiResponses({
            @ApiResponse(code = 65003, message = "日志类型不允许为空"),
            @ApiResponse(code = 66503, message = "日类型可选值：APACHE|NGINX|TOMCAT|APP")
    })
    @RequestMapping(value = "/upload", method = RequestMethod.POST)

    public Result<Boolean> upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "logType") String logType) {
        if (null == logType || "".equals(logType)) {
            return Result.fail(65003, "日志类型(logType)不能为空！");
        }
        String bigLogType = logType.toUpperCase();
        if (!"APACHE".equals(bigLogType) && !"NGINX".equals(bigLogType) && !"TOMCAT".equals(bigLogType) && !"APP".equals(bigLogType)) {
            return Result.fail(66503, "日类型可选值：APACHE|NGINX|TOMCAT|APP");
        }
        String appId = BaseContextHandler.getAppId();
        String fileNameFix = file.getOriginalFilename();
        String fileName = fileNameFix.substring(0, fileNameFix.lastIndexOf("."));//filea.getName()).substring(0,(filea.getName()).lastIndexOf(".")+1);
        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        log.info("appId={}, fileName={}, fileNameFix={}, adminId={}, userName={}", appId, fileName, fileNameFix, adminId, userName);
        //日志类型走枚举，不走数据字典
        try {
            //获取文件字节流
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.getSize());
            InputStream in = file.getInputStream();
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            //获取token
            String token = TokenCache.of(logAppId, logAppSecret).get().get();
            log.info("token={} ", token);

            log.info("urlaaaa={}", serverUrl + "/api/file/p/file/simple");

            com.hengyunsoft.utils.Result fileUpload = UploadFileUtil.uploadFile(serverUrl + "/p/file/simple", token, null, fileNameFix, bos.toByteArray());
            log.info("fileUpload={} ", fileUpload);
            if (fileUpload.getErrcode() != 0) {
                return Result.fail(fileUpload.getErrcode(), fileUpload.getErrmsg());
            }
            UploadResult uploadListDTO = fileUpload.getData();
            log.info("uploadListDTO={} ", uploadListDTO);
            //Result<UploadListDTO> fileUpload = fileOpenApi.upload(file);
            //UploadListDTO uploadListDTO = fileUpload.getData();

            if (null != uploadListDTO) {
                LogFileSaveDTO logFileSaveDTO = new LogFileSaveDTO();
                logFileSaveDTO.setAppId(appId);
                //String bigLogType = logType.toUpperCase();
                logFileSaveDTO.setLogType(bigLogType);
                logFileSaveDTO.setDocumentId(uploadListDTO.getList().get(0).getId() + "");
                logFileSaveDTO.setFileName(fileName);
                logFileSaveDTO.setDocumentPath(uploadListDTO.getList().get(0).getUrl());
                logFileSaveDTO.setDataChannel("IMPORT");

                //3,转换po，并保存
                LogFile logFile = dozerUtils.map(logFileSaveDTO, LogFile.class);
                log.info("logFile={} ", JSONObject.toJSONString(logFile));
                //logFile.setAppId(appId);
                logFile.setCreateTime(Calendar.getInstance().getTime());
                logFile.setCreateUser(adminId);
                logFile.setCreateUserName(userName);
                logFile = logFileService.save(logFile);
                log.info("logFile={} ", JSONObject.toJSONString(logFile));

                //LogFileInterface logFileInterface = dozerUtils.map(logFilesSaveDTO, LogFileInterface.class);
                LogFileInterface logFileInterface = new LogFileInterface();
                logFileInterface.setAppId(appId);
                logFileInterface.setLogFileId(logFile.getId());
                logFileInterface.setLogType(bigLogType);
                //取日志格式
                LogPatternSetExample example = new LogPatternSetExample();
                example.createCriteria().andAppIdEqualTo(appId)
                        .andLogTypeEqualTo(bigLogType);
                List<LogPatternSet> logPatternSetList = logPatternSetService.find(example);
                log.info("logPatternSetList={} ", JSONObject.toJSONString(logPatternSetList));
                String logPattern = "";
                String logExportType = "";
                if (logPatternSetList.size() > 0) {
                    logPattern = logPatternSetList.get(0).getLogPattern();
                    logExportType = logPatternSetList.get(0).getLogExportType();
                }
                logFileInterface.setAppId(appId);
                logFileInterface.setLogExportType(logExportType);
                logFileInterface.setLogPattern(logPattern);                //要修改,调用接口
                logFileInterface.setDocumentId(logFileSaveDTO.getDocumentId());
                logFileInterface.setIsParsed("0");
                logFileInterface.setIsPull("0");
                logFileInterface.setIsDeleteStruct("0");
                logFileInterface.setCreateTime(Calendar.getInstance().getTime());
                logFileInterface.setCreateUser(adminId);
                logFileInterface.setUpdateUser(adminId);
                logFileInterface.setUpdateTime(Calendar.getInstance().getTime());
                logFileInterface = logFileInterfaceService.saveInterface(logFileInterface);
                log.info("logFileInterface={} ", JSONObject.toJSONString(logFileInterface));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传报错", e);
            return Result.fail(e);
        }
        return Result.success(true, "上传成功");
    }

    @ApiOperation(value = "日志文件查询", notes = "")
    @RequestMapping(value = "/pageQuery", method = RequestMethod.POST)

    public Result<PageInfo<LogFileDTO>> pageQuery(@RequestBody OpenApiReq<LogFileOpenQueryDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        LogFileOpenQueryDTO data = openApiReq.getData();
        LogFileExample example = new LogFileExample();
        if (null != data) {
            example.createCriteria()
                    .andFileNameLike(LogFileExample.fullLike(openApiReq.getData().getFileName()))
                    .andFCreateTimeGt(data.getCreateTimeStart())
                    .andFCreateTimeLt(data.getCreateTimeEnd())
                    .andFAppIdEqualTo(appId);
        } else {
            LogFileExample.Criteria criteria = example.createCriteria();
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogFileDO> lists = logFileService.pageQueryUpload(example);
        List<LogFileDTO> pageList = dozerUtils.mapPage(lists, LogFileDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiOperation(value = "应用系统日志查询", notes = "")
    @RequestMapping(value = "/pageQueryApp", method = RequestMethod.POST)

    public Result<PageInfo<LogStructAppDTO>> pageQueryApp(@RequestBody OpenApiReq<LogStructAppOpenQueryDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        LogStructAppOpenQueryDTO data = openApiReq.getData();
        LogStructAppExample example = new LogStructAppExample();
        if (data != null) {
            String levels = data.getLevel();
            List<String> levelList = new ArrayList();
            if (null != levels && !"".equals(levels)) {
                String[] levelArray = levels.split(",");
                for (int m = 0; m < levelArray.length; m++) {
                    String level = levelArray[m];
                    if (level != null && !level.equals("")) {
                        levelList.add(level);
                    }
                }
            }
            example.createCriteria().andLogTimeGreaterThanOrEqualTo(openApiReq.getData().getLogTimeStart())
                    .andLogTimeLessThanOrEqualTo(openApiReq.getData().getLogTimeEnd())
                    .andClassNameLike(LogStructAppExample.fullLike(openApiReq.getData().getClassName()))
                    .andContentLike(LogStructAppExample.fullLike(openApiReq.getData().getContent()))
                    .andFLevelIn(levelList.size() == 0 ? Arrays.asList("") : levelList)
                    .andAppIdEqualTo(appId);
        } else {
            example.createCriteria();
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApp> lists = logStructAppService.pageQueryApp(example);
        List<LogStructAppDTO> pageList = dozerUtils.mapPage(lists, LogStructAppDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiOperation(value = "Apache日志查询", notes = "")
    @RequestMapping(value = "/pageQueryApache", method = RequestMethod.POST)

    public Result<PageInfo<LogStructApacheDTO>> pageQueryApache(@RequestBody OpenApiReq<LogStructApacheOpenQueryDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        LogStructApacheOpenQueryDTO data = openApiReq.getData();
        LogStructApacheExample example = new LogStructApacheExample();
        if (data != null) {
            String status = data.getStatus();
            List<String> statusList = new ArrayList();
            if (null != status && !"".equals(status)) {
                String[] statusArray = status.split(",");
                for (int m = 0; m < statusArray.length; m++) {
                    String sts = statusArray[m];
                    if (sts != null && !sts.equals("")) {
                        statusList.add(sts);
                    }
                }
            }
            example.createCriteria()
                    .andLogTimeGreaterThanOrEqualTo(openApiReq.getData().getLogTimeStart())
                    .andLogTimeLessThanOrEqualTo(openApiReq.getData().getLogTimeEnd())
                    .andRequestUrlLike(LogStructApacheExample.fullLike(openApiReq.getData().getRequestUrl()))
                    .andFTimeConsumGreaterThanOrEqualTo(openApiReq.getData().getTimeConsumStart())
                    .andFTimeConsumLessThanOrEqualTo(openApiReq.getData().getTimeConsumEnd())
                    .andRemoteIpEqualTo(openApiReq.getData().getRemoteIp())
                    .andAppIdEqualTo(appId)
                    .andFStatusIn(statusList.size() == 0 ? Arrays.asList("") : statusList);
        } else {
            example.createCriteria();
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructApache> lists = logStructApacheService.pageQueryApache(example);
        List<LogStructApacheDTO> pageList = dozerUtils.mapPage(lists, LogStructApacheDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiOperation(value = "Nginx日志查询", notes = "")
    @RequestMapping(value = "/pageQueryNginx", method = RequestMethod.POST)

    public Result<PageInfo<LogStructNginxDTO>> pageQueryNginx(@RequestBody OpenApiReq<LogStructNginxOpenQueryDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        LogStructNginxOpenQueryDTO data = openApiReq.getData();
        LogStructNginxExample example = new LogStructNginxExample();
        if (data != null) {
            String status = data.getStatus();
            List<String> statusList = new ArrayList();
            if (null != status && !"".equals(status)) {
                String[] statusArray = status.split(",");
                for (int m = 0; m < statusArray.length; m++) {
                    String sts = statusArray[m];
                    if (sts != null && !sts.equals("")) {
                        statusList.add(sts);
                    }
                }
            }
            example.createCriteria()
                    .andLocalTimeGreaterThanOrEqualTo(openApiReq.getData().getLocalTimeStart())
                    .andLocalTimeLessThanOrEqualTo(openApiReq.getData().getLocalTimeEnd())
                    .andRequestUrlLike(LogStructNginxExample.fullLike(openApiReq.getData().getRequestUrl()))
                    .andFTimeConsumGreaterThanOrEqualTo(openApiReq.getData().getTimeConsumStart())
                    .andFTimeConsumLessThanOrEqualTo(openApiReq.getData().getTimeConsumEnd())
                    .andRemoteAddrEqualTo(openApiReq.getData().getRemoteAddr())
                    .andAppIdEqualTo(appId)
                    .andFStatusIn(statusList.size() == 0 ? Arrays.asList("") : statusList);
        } else {
            example.createCriteria();
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructNginx> lists = logStructNginxService.pageQueryNginx(example);
        List<LogStructNginxDTO> pageList = dozerUtils.mapPage(lists, LogStructNginxDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiOperation(value = "Tomcat日志查询", notes = "")
    @RequestMapping(value = "/pageQueryTomcat", method = RequestMethod.POST)

    public Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcat(@RequestBody OpenApiReq<LogStructTomcatOpenQueryDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        LogStructTomcatOpenQueryDTO data = openApiReq.getData();
        LogStructTomcatExample example = new LogStructTomcatExample();
        if (data != null) {

            String status = data.getStatus();
            List<String> statusList = new ArrayList();
            if (null != status && !"".equals(status)) {
                String[] statusArray = status.split(",");
                for (int m = 0; m < statusArray.length; m++) {
                    String sts = statusArray[m];
                    if (sts != null && !sts.equals("")) {
                        statusList.add(sts);
                    }
                }
            }
            example.createCriteria()
                    .andLogTimeGreaterThanOrEqualTo(openApiReq.getData().getLogTimeStart())
                    .andLogTimeLessThanOrEqualTo(openApiReq.getData().getLogTimeEnd())
                    .andRequestUrlLike(LogStructTomcatExample.fullLike(openApiReq.getData().getRequestUrl()))
                    .andFTimeConsumGreaterThanOrEqualTo(openApiReq.getData().getTimeConsumStart())
                    .andFTimeConsumLessThanOrEqualTo(openApiReq.getData().getTimeConsumEnd())
                    .andRemoteIpEqualTo(openApiReq.getData().getRemoteIp())
                    .andAppIdEqualTo(appId)
                    .andFStatusIn(statusList.size() == 0 ? Arrays.asList("") : statusList);
        } else {
            example.createCriteria();
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<LogStructTomcat> lists = logStructTomcatService.pageQueryTomcat(example);
        List<LogStructTomcatDTO> pageList = dozerUtils.mapPage(lists, LogStructTomcatDTO.class);
        return Result.success(new PageInfo(pageList));
    }

    @ApiOperation(value = "删除全部日志", notes = "")
    @ApiResponses({
            @ApiResponse(code = 66001, message = "开始时间不能为空"),
            @ApiResponse(code = 66002, message = "结束时间不能为空"),
            @ApiResponse(code = 66504, message = "未找到删除时间段的数据"),
            @ApiResponse(code = 66505, message = "删除数据失败"),
    })
    @RequestMapping(value = "/delAllLog", method = RequestMethod.POST)

    public Result<Boolean> delAllLog(@RequestBody LogDelDTO logDelDTO) {
        BizAssert.assertNotNull(LogsExceptionCode.LOG_STARTTIME_EMPTY, logDelDTO.getLogTimeStart());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_ENDTIME_EMPTY, logDelDTO.getLogTimeEnd());

        /*String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        //按时间：
        //删除自己应用系统的日志
        //记录删除的日志
        LogFileInterfaceExample logFileInterfaceExample = new LogFileInterfaceExample();
        logFileInterfaceExample.createCriteria().andAppIdEqualTo(appId)
                .andLogStartTimeGreaterThanOrEqualTo(logDelDTO.getLogTimeStart())
                .andLogStartTimeLessThanOrEqualTo(logDelDTO.getLogTimeEnd());
        List<LogFileInterface> logFileInterface = logFileInterfaceService.queryLogFileInterfaceByTime(logFileInterfaceExample);
        if(logFileInterface.size()==0){
            return Result.fail(66504,"未找到删除时间段的数据");
        }
        List<String> documentIdList = new ArrayList<String>();
        Long[] documentIdLong = new Long[logFileInterface.size()];
        List<Long> ids = new ArrayList<>();
        for(int i=0;i<logFileInterface.size();i++){
            ids.add(logFileInterface.get(i).getId());
            documentIdList.add(logFileInterface.get(i).getDocumentId());
            documentIdLong[i]= Long.valueOf(logFileInterface.get(i).getDocumentId());
        }
        int i=logFileInterfaceService.deleteByIds(ids);//删除log_file_interface
        if(i>0){
            LogOpenDelete logOpenDelete = new LogOpenDelete();
            logOpenDelete.setAppId(appId);
            logOpenDelete.setIp("");
            logOpenDelete.setCallServeTime(Calendar.getInstance().getTime());
            logOpenDelete.setDeleteCondition("按时间段删除log_file_interface：从"+logDelDTO.getLogTimeStart()+"至"+logDelDTO.getLogTimeEnd());
            logOpenDelete.setDeleteCount((long) i);
            logOpenDelete.setCreateTime(Calendar.getInstance().getTime());
            logOpenDelete.setCreateUser(BaseContextHandler.getAdminId());
            logOpenDelete.setCreateUserName(BaseContextHandler.getName());
            logOpenDeleteService.save(logOpenDelete);//保存删除的文件接口数据
        }


        if(documentIdList.size()>0){
            //物理删除日志文件
            fileService.removeList(logAppId,null,documentIdLong);
            //删除log_file
            LogFileExample logFileExample = new LogFileExample();
            logFileExample.createCriteria().andDocumentIdIn(documentIdList);
            logFileService.deleteByDocumentIds(logFileExample,"按时间段删除log_file：从"+logDelDTO.getLogTimeStart()+"至"+logDelDTO.getLogTimeEnd());
            //删除App
            LogStructAppExample logStructAppExample = new LogStructAppExample();
            logStructAppExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructAppService.deleteByDocumentIds(logStructAppExample,"按时间段删除log_struct_app：从"+logDelDTO.getLogTimeStart()+"至"+logDelDTO.getLogTimeEnd());
            //删除Tomcat
            LogStructTomcatExample logStructTomcatExample = new LogStructTomcatExample();
            logStructTomcatExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructTomcatService.deleteByDocumentIds(logStructTomcatExample,"按时间段删除log_struct_tomcat：从"+logDelDTO.getLogTimeStart()+"至"+logDelDTO.getLogTimeEnd());
            //删除Apache
            LogStructApacheExample logStructApacheExample = new LogStructApacheExample();
            logStructApacheExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructApacheService.deleteByDocumentIds(logStructApacheExample,"按时间段删除log_struct_apache：从"+logDelDTO.getLogTimeStart()+"至"+logDelDTO.getLogTimeEnd());
            //删除Nginx
            LogStructNginxExample logStructNginxExample = new LogStructNginxExample();
            logStructNginxExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructNginxService.deleteByDocumentIds(logStructNginxExample,"按时间段删除log_struct_nginx：从"+logDelDTO.getLogTimeStart()+"至"+logDelDTO.getLogTimeEnd());
        }*/

        /*if (i == 0) {
            return Result.fail(66505,"删除数据失败" );
        } else {
            return Result.success(true);
        }*/
        Result<Boolean> resultapp = delAppLog(logDelDTO);
        Result<Boolean> resultapache = delApacheLog(logDelDTO);
        Result<Boolean> resultnginx = delNginxLog(logDelDTO);
        Result<Boolean> resulttomcat = delTomcatLog(logDelDTO);
        if (resultapp.getErrcode() == 66504 && resultapache.getErrcode() == 66504 && resultnginx.getErrcode() == 66504 && resulttomcat.getErrcode() == 66504) {
            return Result.fail(66504, "未找到删除时间段的数据");
        }
        return Result.success(true);
    }

    @ApiOperation(value = "删除应用系统日志", notes = "")
    @ApiResponses({
            @ApiResponse(code = 66001, message = "开始时间不能为空"),
            @ApiResponse(code = 66002, message = "结束时间不能为空"),
            @ApiResponse(code = 66504, message = "未找到删除时间段的数据"),
            @ApiResponse(code = 66505, message = "删除数据失败"),
    })
    @RequestMapping(value = "/delAppLog", method = RequestMethod.POST)

    public Result<Boolean> delAppLog(@RequestBody LogDelDTO logDelDTO) {
        String appId = BaseContextHandler.getAppId();
        BizAssert.assertNotNull(LogsExceptionCode.LOG_STARTTIME_EMPTY, logDelDTO.getLogTimeStart());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_ENDTIME_EMPTY, logDelDTO.getLogTimeEnd());
        //按时间：
        //删除日志
        //删除结构化日志
        //删除App
        LogStructAppExample logStructAppExample = new LogStructAppExample();
        logStructAppExample.createCriteria().andAppIdEqualTo(appId)
                .andLogTimeGreaterThanOrEqualTo(logDelDTO.getLogTimeStart())
                .andLogTimeLessThanOrEqualTo(logDelDTO.getLogTimeEnd());

        List<LogStructApp> logStrucApp = logStructAppService.find(logStructAppExample);
        if (logStrucApp.size() == 0) {
            return Result.fail(66504, "未找到删除时间段的数据");
        }
        int i = logStructAppService.deleteByDocumentIds(logStructAppExample, "按时间段删除log_struct_app：从" + logDelDTO.getLogTimeStart() + "至" + logDelDTO.getLogTimeEnd());
        if (i == 0) {
            return Result.fail(66505, "删除数据失败");
        } else {
            return Result.success(true);
        }
    }

    @ApiOperation(value = "删除Apache日志", notes = "")
    @ApiResponses({
            @ApiResponse(code = 66001, message = "开始时间不能为空"),
            @ApiResponse(code = 66002, message = "结束时间不能为空"),
            @ApiResponse(code = 66504, message = "未找到删除时间段的数据"),
            @ApiResponse(code = 66505, message = "删除数据失败"),
    })
    @RequestMapping(value = "/delApacheLog", method = RequestMethod.POST)

    public Result<Boolean> delApacheLog(@RequestBody LogDelDTO logDelDTO) {
        String appId = BaseContextHandler.getAppId();
        BizAssert.assertNotNull(LogsExceptionCode.LOG_STARTTIME_EMPTY, logDelDTO.getLogTimeStart());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_ENDTIME_EMPTY, logDelDTO.getLogTimeEnd());
        //按时间：
        //删除日志
        //删除结构化日志
        //删除Apache
        LogStructApacheExample logStructApacheExample = new LogStructApacheExample();
        logStructApacheExample.createCriteria().andAppIdEqualTo(appId)
                .andLogTimeGreaterThanOrEqualTo(logDelDTO.getLogTimeStart())
                .andLogTimeLessThanOrEqualTo(logDelDTO.getLogTimeEnd());
        List<LogStructApache> logStrucApacheList = logStructApacheService.find(logStructApacheExample);
        if (logStrucApacheList.size() == 0) {
            return Result.fail(66504, "未找到删除时间段的数据");
        }
        int i = logStructApacheService.deleteByDocumentIds(logStructApacheExample, "按时间段删除log_struct_apache：从" + logDelDTO.getLogTimeStart() + "至" + logDelDTO.getLogTimeEnd());
        if (i == 0) {
            return Result.fail(66505, "删除数据失败");
        } else {
            return Result.success(true);
        }
    }

    @ApiOperation(value = "删除Nginx日志", notes = "  ")
    @ApiResponses({
            @ApiResponse(code = 66001, message = "开始时间不能为空"),
            @ApiResponse(code = 66002, message = "结束时间不能为空"),
            @ApiResponse(code = 66504, message = "未找到删除时间段的数据"),
            @ApiResponse(code = 66505, message = "删除数据失败"),
    })
    @RequestMapping(value = "/delNginxLog", method = RequestMethod.POST)

    public Result<Boolean> delNginxLog(@RequestBody LogDelDTO logDelDTO) {
        String appId = BaseContextHandler.getAppId();
        BizAssert.assertNotNull(LogsExceptionCode.LOG_STARTTIME_EMPTY, logDelDTO.getLogTimeStart());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_ENDTIME_EMPTY, logDelDTO.getLogTimeEnd());
        //按时间：
        //删除日志
        //删除结构化日志
        //删除Nginx
        LogStructNginxExample logStructNginxExample = new LogStructNginxExample();
        logStructNginxExample.createCriteria().andAppIdEqualTo(appId)
                .andLocalTimeGreaterThanOrEqualTo(logDelDTO.getLogTimeStart())
                .andLocalTimeLessThanOrEqualTo(logDelDTO.getLogTimeEnd());
        List<LogStructNginx> logStrucNginxList = logStructNginxService.find(logStructNginxExample);
        if (logStrucNginxList.size() == 0) {
            return Result.fail(66504, "未找到删除时间段的数据");
        }
        int i = logStructNginxService.deleteByDocumentIds(logStructNginxExample, "按时间段删除log_struct_nginx：从" + logDelDTO.getLogTimeStart() + "至" + logDelDTO.getLogTimeEnd());
        if (i == 0) {
            return Result.fail(66505, "删除数据失败");
        } else {
            return Result.success(true);
        }
    }

    @ApiOperation(value = "删除Tomcat日志", notes = "  ")
    @ApiResponses({
            @ApiResponse(code = 66001, message = "开始时间不能为空"),
            @ApiResponse(code = 66002, message = "结束时间不能为空"),
            @ApiResponse(code = 66504, message = "未找到删除时间段的数据"),
            @ApiResponse(code = 66505, message = "删除数据失败"),
    })
    @RequestMapping(value = "/delTomcatLog", method = RequestMethod.POST)

    public Result<Boolean> delTomcatLog(@RequestBody LogDelDTO logDelDTO) {
        //1，验证
        String appId = BaseContextHandler.getAppId();
        BizAssert.assertNotNull(LogsExceptionCode.LOG_STARTTIME_EMPTY, logDelDTO.getLogTimeStart());
        BizAssert.assertNotNull(LogsExceptionCode.LOG_ENDTIME_EMPTY, logDelDTO.getLogTimeEnd());
        //按时间：
        //删除日志
        //删除结构化日志
        //删除Tomcat
        LogStructTomcatExample logStructTomcatExample = new LogStructTomcatExample();

        logStructTomcatExample.createCriteria().andAppIdEqualTo(appId)
                .andLogTimeGreaterThanOrEqualTo(logDelDTO.getLogTimeStart())
                .andLogTimeLessThanOrEqualTo(logDelDTO.getLogTimeEnd());
        List<LogStructTomcat> logStructTomcatList = logStructTomcatService.find(logStructTomcatExample);
        if (logStructTomcatList.size() == 0) {
            return Result.fail(66504, "未找到删除时间段的数据");
        }
        int i = logStructTomcatService.deleteByDocumentIds(logStructTomcatExample, "按时间段删除log_struct_tomcat：从" + logDelDTO.getLogTimeStart() + "至" + logDelDTO.getLogTimeEnd());
        if (i == 0) {
            return Result.fail(66505, "删除数据失败");
        } else {
            return Result.success(true);
        }
    }

    //文件id是documentId
    @ApiOperation(value = "按文件id删除，多个id用“,”隔开", notes = "")
    @ApiResponses({
            @ApiResponse(code = 65000, message = "文件ids不能为空"),
            @ApiResponse(code = 66505, message = "删除数据失败"),
            @ApiResponse(code = 66506, message = "未找到要删除的数据ids"),

    })
    @RequestMapping(value = "/delLogFileByIds", method = RequestMethod.POST)

    public Result<Boolean> delLogFileByIds(@RequestParam(value = "ids") String ids) {
        //1，验证
        if (null == ids || ids.trim().length() == 0) {
            BizAssert.assertNotNull(LogsExceptionCode.ID_NULL, null);
        }
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        LogFileInterfaceExample logFileInterfaceExample = new LogFileInterfaceExample();

        String[] idArray = ids.split(",");

        List<String> documentIdList = new ArrayList<String>();
        Long[] documentIdLong = new Long[idArray.length];
        for (int m = 0; m < idArray.length; m++) {
            String id = idArray[m];
            if (id != null && !id.equals("")) {
                documentIdList.add(id);
                documentIdLong[m] = Long.valueOf(id);
            }
        }
        //List<LogFile> listLogFile = logFileService.queryLogFileByIds(list);
        logFileInterfaceExample.createCriteria().andAppIdEqualTo(appId)
                .andDocumentIdIn(documentIdList);
        List<LogFileInterface> logFileInterface = logFileInterfaceService.queryLogFileInterfaceByTime(logFileInterfaceExample);
        List<Long> list = new ArrayList<Long>();
        List<Long> interfaceIds = new ArrayList<>();
        for (int i = 0; i < logFileInterface.size(); i++) {
            interfaceIds.add(logFileInterface.get(i).getId());
            list.add(logFileInterface.get(i).getLogFileId());
        }

        int i = logFileInterfaceService.deleteByIds(interfaceIds);//删除log_file_interface

        LogOpenDelete logOpenDelete = new LogOpenDelete();
        logOpenDelete.setAppId(appId);
        logOpenDelete.setIp("");
        logOpenDelete.setCallServeTime(Calendar.getInstance().getTime());
        logOpenDelete.setDeleteCondition("按文件id(documentId)删除log_file_interface数据，条件：" + ids);
        logOpenDelete.setDeleteCount((long) i);
        logOpenDelete.setCreateTime(Calendar.getInstance().getTime());
        logOpenDelete.setCreateUser(BaseContextHandler.getAdminId());
        logOpenDelete.setCreateUserName(BaseContextHandler.getName());
        logOpenDeleteService.save(logOpenDelete);//保存删除的文件接口数据

        if (documentIdList.size() > 0) {
            if (logFileInterface.size() > 0) {
                //当输入多个ids时，有存在的，有不存在的，过滤出存在id,放入documentIdLongExit数组中。
                Long[] documentIdLongExit = new Long[logFileInterface.size()];
                for (int kj = 0; kj < logFileInterface.size(); kj++) {
                    documentIdLongExit[kj] = Long.valueOf(logFileInterface.get(kj).getDocumentId());
                }
                //物理删除日志文件
                fileService.removeList(logAppId, null, documentIdLongExit);
                //删除log_file
                logFileService.deleteByIds(list);
                logOpenDelete.setDeleteCondition("按文件id(documentId)删除log_file数据，条件：" + ids);
                logOpenDelete.setDeleteCount((long) i);
                logOpenDeleteService.save(logOpenDelete);//保存删除的文件接口数据
            }
            //删除App
            LogStructAppExample logStructAppExample = new LogStructAppExample();
            logStructAppExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructAppService.deleteByDocumentIds(logStructAppExample, "按文件id(documentId)删除log_struct_app数据，条件：" + ids);
            //删除Tomcat
            LogStructTomcatExample logStructTomcatExample = new LogStructTomcatExample();
            logStructTomcatExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructTomcatService.deleteByDocumentIds(logStructTomcatExample, "按文件id(documentId)删除log_struct_tomcat数据，条件：" + ids);
            //删除Apache
            LogStructApacheExample logStructApacheExample = new LogStructApacheExample();
            logStructApacheExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructApacheService.deleteByDocumentIds(logStructApacheExample, "按文件id(documentId)删除log_struct_apache数据，条件：" + ids);
            //删除Nginx
            LogStructNginxExample logStructNginxExample = new LogStructNginxExample();
            logStructNginxExample.createCriteria().andDocumentIdIn(documentIdList);
            logStructNginxService.deleteByDocumentIds(logStructNginxExample, "按文件id(documentId)删除log_struct_nginx数据，条件：" + ids);
        }
        if (logFileInterface.size() == 0) {
            return Result.fail(66506, "未找到要删除的数据，ids：" + ids);
        }
        if (i == 0) {
            return Result.fail(66505, "删除数据失败");
        } else {
            return Result.success(true);
        }
    }
}
