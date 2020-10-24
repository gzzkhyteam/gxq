package com.hengyunsoft.platform.standard.jobs;

import com.hengyunsoft.platform.modular.config.NexusConfig;
import com.hengyunsoft.platform.modular.repository.service.ModularLogService;
import com.hengyunsoft.platform.modular.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.zip.GZIPInputStream;

@Component
@Slf4j
public class NexusLogParseActuator {

    /*
     * 每天解析一次日志
     */
    @Autowired
    private ModularLogService modularLogService;
    @Autowired
    private NexusConfig nexusConfig;


    @Scheduled(cron = "0 0 0/1 * * ?")
    public void doParse() {
        log.info("nexus日志解析：解析开始-----------------");
        String nexusLogDirStr = nexusConfig.getLogDir();
        if (StringUtils.isEmpty(nexusLogDirStr)) {
            log.error("参数nexus.logDir未配置，请检查！");
            return;
        }

        boolean isDir = FileUtil.isDir(nexusLogDirStr);
        if (!isDir) {
            log.error("参数nexus.logDir：" + nexusLogDirStr + "不是文件夹，请检查！");
            return;
        }

        if (!nexusLogDirStr.endsWith("/")) {
            nexusLogDirStr = nexusLogDirStr + "/";
        }

        //查找要解析的日志文件
        File nexusLogDir = new File(nexusLogDirStr);
        File[] listFiles = nexusLogDir.listFiles(new NexusLogFileter());
        if (listFiles == null || listFiles.length == 0) {
            log.info("nexus日志解析：未找到要解析的日志文件");
            return;
        }

        String nexusLogBakDir = nexusLogDirStr + "backup/";
        //解析日志文件
        for (int i = 0; i < listFiles.length; i++) {
            File file = listFiles[i];
            boolean b = FileUtil.moveFile(file, nexusLogBakDir);
            if (b) {
                String unzipFile = unGzipFile(nexusLogBakDir + file.getName());//解压
                log.debug("nexus日志解析：" + file.getName() + "解压完成,开始解析:" + unzipFile);
                modularLogService.parseLogFile(unzipFile);//解析
                boolean isDel = FileUtil.delFile(unzipFile);//删除
                log.debug("nexus日志解析：删除解压后的文件" + unzipFile + ":" + isDel);
                log.debug("nexus日志解析：" + file.getName() + "解析完成");
            } else {
                log.error(file.getName() + "移动到备份目录失败，请检查！");
            }
        }
        log.info("nexus日志解析：解析完成");
    }

    static class NexusLogFileter implements FilenameFilter {
        @Override
        public boolean accept(File file, String filename) {
            if (filename != null && filename.toLowerCase().startsWith("request") && filename.toLowerCase().endsWith("log.gz")) {
                return true;
            } else {
                return false;
            }
        }

    }

    @PostConstruct
    public void init() {
        log.info("-------启动nexus日志解析job-----");
        doParse();
    }

    private String unGzipFile(String zipFileName) {
        String outputFile = "";
        try {
            //建立gzip压缩文件输入流
            FileInputStream fis = new FileInputStream(zipFileName);
            //建立gzip解压工作流
            GZIPInputStream gZipFis = new GZIPInputStream(fis);
            //建立解压文件输出流
            outputFile = zipFileName.substring(0, zipFileName.lastIndexOf('.'));
            FileOutputStream fos = new FileOutputStream(outputFile);

            int num;
            byte[] buf = new byte[1024];

            while ((num = gZipFis.read(buf, 0, buf.length)) != -1) {
                fos.write(buf, 0, num);
            }

            gZipFis.close();
            fos.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outputFile;
    }
}

