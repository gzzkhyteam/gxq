package com.hengyunsoft.platform.jobs;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.util.FtpUtil;
import com.hengyunsoft.platform.logs.dto.LogFileSaveDTO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFile;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface;
import com.hengyunsoft.platform.logs.entity.logs.po.LogPatternSet;
import com.hengyunsoft.platform.logs.repository.logs.example.LogPatternSetExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileInterfaceService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogFileService;
import com.hengyunsoft.platform.logs.repository.logs.service.LogPatternSetService;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.utils.UploadFileUtil;
import com.hengyunsoft.utils.UploadResult;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogFormFtpActuator {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private LogPatternSetService logPatternSetService;
    @Autowired
    private LogFileService logFileService;
    @Autowired
    private LogFileInterfaceService logFileInterfaceService;

    @Value("${ftp.host}")
    private String host;    //ftp服务器ip
    @Value("${ftp.port}")
    private int port;        //ftp服务器端口
    @Value("${ftp.username}")
    private String username;//用户名
    @Value("${ftp.password}")
    private String password;//密码
    @Value("${ftp.basePath}")
    private String basePath;//ftp根路径
    @Value("${ftp.logAppId}")
    private String logAppId;//日志系统的appid
    @Value("${ftp.logAppSecret}")
    private String logAppSecret;//日志系统的密码
    @Value("${ftp.serverUrl}")
    private String serverUrl;//上传地址


    //每晚5点执行
//    @Scheduled(cron = "0 0 5 * * ?")
    @Scheduled(cron = "0 0/10 * * * ?")
    public void getFileFtp() {
        log.info("--ftp--");
        FtpUtil ftpUtil = new FtpUtil();
        try {
            //注意区分 测试环境、58正式环境、开发环境 ！！！！！！！！！！！
            //测试环境读取:test2.yml、58正式环境读取:prod.yml、开发环境读取:dev.yml
            //连接ftp
            FTPClient ftp = ftpUtil.getConnectionFTP(host, port, username, password);
            log.info("host={}， port={}, username={}, password={}", host, port, username, password);

            if (basePath == null || basePath.equals("")) {
                basePath = "/";
            }
            if (!basePath.endsWith("/")) {
                basePath = basePath + "/";
            }
            log.info("---basePath={}", basePath);
            String logBasePath = basePath + "logfile/";

            if (!ftp.changeWorkingDirectory(logBasePath)) {
                log.info("changeWorkingDirectory");
                ftp.makeDirectory(logBasePath);
                ftp.changeWorkingDirectory(logBasePath);
            }
            FTPFile[] sysFiles = ftp.listFiles(logBasePath);
            if (sysFiles != null) {
                log.info("sysFiles.length={}", sysFiles.length);
            }
            for (FTPFile sysFile : sysFiles) {
                log.info("sysFile.isDirectory()={} ,sysFile.getName()={}", sysFile.isDirectory(), sysFile.getName());
                if (sysFile.isDirectory()) {
                    //需要遍历的目录，必须以"/"开始和结束
                    String sysPath = logBasePath + sysFile.getName() + "/";
                    log.info("ftp取文件：" + "输入第一级路径,应用系统名称文件夹：" + sysPath);
                    FTPFile[] logTypeFiles = ftp.listFiles(sysPath);//取出第三级文件夹，日志类型
                    for (FTPFile logTypeFile : logTypeFiles) {
                        if (logTypeFile.isDirectory()) {
                            String logTypePath = sysPath + logTypeFile.getName() + "/";
                            log.info("ftp取文件：" + "输入第二级路径,应用系统日志类型文件夹：" + logTypePath);
                            FTPFile[] files = ftp.listFiles(logTypePath);//取文件
                            log.info("files.size={}", files.length);
                            for (FTPFile file : files) {
                                String appId = sysFile.getName();
                                String logType = logTypeFile.getName();
                                //Long userId = Long.valueOf((file.getName()).substring(0, (file.getName()).indexOf("_")));
                                //String fileNamef =(file.getName()).substring((file.getName()).indexOf("_")+1);
                                ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.getSize());
                                log.info("ftp取文件：" + "输入第三级路径,文件：" + logTypePath + file.getName());
                                InputStream in = ftp.retrieveFileStream(logTypePath + file.getName());
                                int buf_size = 1024;
                                byte[] buffer = new byte[buf_size];
                                int len = 0;
                                while (-1 != (len = in.read(buffer, 0, buf_size))) {
                                    bos.write(buffer, 0, len);
                                }
                                boolean flag = uploadAndSave(appId, logType, file.getName(), bos.toByteArray());//文件上传并保存到文件和接口表
                                log.info("flag={}", flag);
                                if (flag) {
                                    ftpUtil.deleteFile(ftp, logTypePath, file.getName());//删除FTP上取走的文件

                                }
                                in.close();
                                ftp.completePendingCommand();
                            }
                        }
                    }
                }
            }
            log.info("for-end");
            ftpUtil.closeFTP(ftp);
        } catch (Exception e) {
            log.error("读取ftp报错", e);
            e.printStackTrace();
        }
    }

    //上传文件并保存文件信息到日志文件表和日志文件接口表
    public boolean uploadAndSave(String appId, String logType, String fileName, byte[] contents) {
        log.info("ftp取文件：" + "进入上传并保存到接口文件方法...........");
        String bigLogType = logType.toUpperCase();
        //获取token
        String token = TokenCache.of(logAppId, logAppSecret).get().get();
        log.info("token={}", token);
        //先用内网ip试试， 外网ip有问题
        //String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzNWtqNjM1NiIsImFwcE5hbWUiOiLml6Xlv5fnrqHnkIbns7vnu58iLCJleHAiOjE1MjU0MzMwNTh9.aE5n2IrepQC0vrt_f_XkASLIK5jTpVBkXzC1lbftVbynNQAjcpQ-eQJ_DerVNz3U2p6nBRS8NaUdZBiHuv8owIPqpv4aqGjytPdkFRjbOwZlbC1A2bkD2fN4oIdyljY449nrLI0EevIjlKOkC1Ueo-nTiQx8xAaJoHEM2qlZXhk";
        com.hengyunsoft.utils.Result fileUpload = UploadFileUtil.uploadFile(serverUrl + "/p/file/simple", token, -1L, fileName, contents);
        log.info("ftp取文件：" + "调用上传接口");
        UploadResult uploadListDTO = fileUpload.getData();
        log.info("ftp取文件：" + "取接口中data返回的值" + uploadListDTO.toString());
        if (null != uploadListDTO) {
            log.info("ftp取文件：" + "有数据，进入到保存到地表方法");
            LogFileSaveDTO logFileSaveDTO = new LogFileSaveDTO();
            logFileSaveDTO.setAppId(appId);
            logFileSaveDTO.setLogType(bigLogType);
            logFileSaveDTO.setDocumentId(uploadListDTO.getList().get(0).getId() + "");
            logFileSaveDTO.setFileName(fileName.substring(0, fileName.lastIndexOf(".")));
            logFileSaveDTO.setDocumentPath(uploadListDTO.getList().get(0).getUrl());
            logFileSaveDTO.setDataChannel("FTP");

            //3,转换po，并保存
            LogFile logFile = dozerUtils.map(logFileSaveDTO, LogFile.class);
            logFile.setCreateTime(Calendar.getInstance().getTime());
            //logFile.setCreateUser(adminId);
            logFile.setCreateUserName("");
            logFile = logFileService.save(logFile);

            LogFileInterface logFileInterface = new LogFileInterface();
            logFileInterface.setAppId(appId);
            logFileInterface.setLogFileId(logFile.getId());
            logFileInterface.setLogType(bigLogType);
            //取日志格式
            LogPatternSetExample example = new LogPatternSetExample();
            example.createCriteria().andAppIdEqualTo(appId)
                    .andLogTypeEqualTo(bigLogType);
            List<LogPatternSet> logPatternSetList = logPatternSetService.find(example);
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
            //logFileInterface.setCreateUser(adminId);
            // logFileInterface.setUpdateUser(adminId);
            logFileInterface.setUpdateTime(Calendar.getInstance().getTime());
            logFileInterface = logFileInterfaceService.saveInterface(logFileInterface);
            log.info("ftp取文件：" + "保存完毕");
        }
        return true;
    }

    /*@PostConstruct
    public void init() {
        //初始化启动这的时候token是获取不到的
        log.info("-------ftp-----");

        getFileFtp();
    }*/

}