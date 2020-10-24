package com.hengyunsoft.platform.standard.jobs;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.open.FileOpenJobsApi;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFile;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFileLog;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileLogService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileService;
import com.hengyunsoft.security.auth.cache.TokenCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zx
 * @createTime 2018-4-10
 */
@Component
@Slf4j
public class DownloadLogParseActuator {
    /*
     * 定时从f_file_download_water取数据插入standard_file_log表中
     */
    @Autowired
    private FileOpenJobsApi fileOpenJobsApi;

    @Autowired
    private StandardFileLogService standardFileLogService;

    @Autowired
    private StandardFileService standardFileService;

    //根据业务，配置标准系统的appId和AppSecret
    @Value("${gxqpt.standard-web.app-id:25kj6354}")
    private String appId;

    @Value("${gxqpt.standard-web.app-secret:standar25kj6354}")
    private String appSecret;

    //定时任务
    @Scheduled(cron = "0 0/5 * * * ?")
    public void doParse() {
        StandardFileExample example = new StandardFileExample();
        Optional<String> tokenOption = TokenCache.of(appId, appSecret).get();
        //获取业务系统的数据，标准文档表中的所有文件id
        List<Long> fileIds = new ArrayList<Long>();
        example.createCriteria().andDocumentIdIsNotNull();
        List<StandardFile> documentIds = standardFileService.find(example);
        //将返回数据的文件id放入list<Long>
        for (StandardFile standardFile : documentIds) {
            String docId = standardFile.getDocumentId();
            Long documentId = Long.parseLong(docId);
            fileIds.add(documentId);
        }
        //将list<Long>转换为Long[]
        Long[] fileId = new Long[fileIds.size()];
        fileIds.toArray(fileId);
        Calendar cal = Calendar.getInstance();
        Date nowDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTime = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE, -5);
        String startTime = sdf.format(cal.getTime());
        ArrayList<StandardFileLog> standardFileLogList = new ArrayList<StandardFileLog>();
        log.info("fileId={}", JSONObject.toJSONString(fileId));
        if (tokenOption.isPresent()) {
            String token = tokenOption.get();
            log.info("token={}", tokenOption.get());
            log.info("-------标准管理系统：开始从文件服务器读取下载日志-----" + startTime + "--" + endTime);
            Result<List<FileDownWaterDTO>> result = fileOpenJobsApi.findDownWater(token, fileId, startTime, endTime);
            if (result.isSuccess()) {
                if (result.getData() != null){
                    log.info("list.size()={}", result.getData().size());
                    List<FileDownWaterDTO> list = result.getData();
                    for (int i = 0; i < list.size(); i++) {
                        log.info("list.get(i)={}", JSONObject.toJSONString(list.get(i)));
                        StandardFileLog standardFileLog = new StandardFileLog();
                        standardFileLog.setDocumentId(list.get(i).getFileId());
                        String operatorTime = list.get(i).getCreateTime();
                        try {
                            standardFileLog.setOperatorTime(sdf.parse(operatorTime));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        standardFileLog.setOperatorType("down");
                        standardFileLog.setCreateTime(nowDate);
                        standardFileLogList.add(standardFileLog);
                        if (standardFileLogList.size() > 1000) {
                            standardFileLogService.save(standardFileLogList);
                            standardFileLogList.clear();
                        }
                    }
                    standardFileLogService.save(standardFileLogList);
                }else{
                    log.info(startTime+"----"+endTime+":时间段内没有文件下载记录");
                }
            }else{
                log.info("-------标准管理系统：从文件服务器读取下载日志失败-----" + startTime + "--" + endTime);
            }
        }
    }
//    @PostConstruct
//    public void init() {
//        log.info("-------标准管理系统：开始从文件服务器读取下载日志-----");
//        try {
//            Thread.sleep(2 * 60 * 1000);
//            doParse();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}

