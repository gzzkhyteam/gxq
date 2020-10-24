package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.file.entity.file.domain.SynFileDataDO;
import com.hengyunsoft.platform.file.entity.file.po.FileUserNum;
import com.hengyunsoft.platform.file.entity.file.po.FileUserSize;
import com.hengyunsoft.platform.file.repository.file.example.FileUserNumExample;
import com.hengyunsoft.platform.file.repository.file.example.FileUserSizeExample;
import com.hengyunsoft.platform.file.repository.file.service.FileUserNumService;
import com.hengyunsoft.platform.file.repository.file.service.FileUserSizeService;
import com.hengyunsoft.platform.file.repository.file.service.ShareFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 定时同步文件表数据
 * @author wt
 * @createTime 2018-8-17
 *
 */
@RestController
@Slf4j
public class FileDevelopDataSynTask {

    @Autowired
    private ShareFileService shareFileService;
    @Autowired
    private FileUserNumService fileUserNumService;
    @Autowired
    private FileUserSizeService fileUserSizeService;
    /**
     * 定时同步file文件表数据
     * @throws Exception
     */
    //每天 12：30  凌晨1:30 全量同步
//    @Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "0 30 1,12 * * ?")
    public void send() {
        log.info("定时获取文件表数据");
        try {
            log.info("开始执行定时任务");
            runNum();
            runSize();
            log.info("结束执行定时任务");
        } catch (Exception e) {
            log.error("定时获取文件表数据失败!",e);
        }
    }
    private void runNum(){
        Date startDate = null;
        Date endDate = null;
        FileUserNumExample countNumExample = new FileUserNumExample();
        countNumExample.createCriteria().andIdIsNotNull();
        /**
         * @Modify: mdengb
         * 清空之前表的数据
         * */
        List<FileUserNum> fileUserNums = fileUserNumService.find(countNumExample);
        if(!fileUserNums.isEmpty()) {
            List<Long> ids = fileUserNums.stream().map(FileUserNum::getId).collect(Collectors.toList());
            fileUserNumService.deleteByIds(ids);
        }
       /* Integer countNum = fileUserNumService.count(countNumExample);
        if(countNum > 0){
            startDate = DateUtils.getBeginDayOfYesterday();
            endDate = DateUtils.getEndDayOfYesterDay();
        }*/
        List<SynFileDataDO> synFileDataDOList = shareFileService.findSynFileData(startDate,endDate);
        for (SynFileDataDO synFileDataDO : synFileDataDOList){
            FileUserNum fileUserNum = new FileUserNum();
            fileUserNum.setAppId(synFileDataDO.getAppId());
            fileUserNum.setCreateTime(new Date());
            fileUserNum.setCreateUser(synFileDataDO.getCreateUser());
            fileUserNum.setDataType(synFileDataDO.getDataType());
            fileUserNum.setType(synFileDataDO.getType());
            fileUserNum.setFyearMonth(synFileDataDO.getYMonth());
            fileUserNum.setNum(synFileDataDO.getNum());
            fileUserNumService.saveSelective(fileUserNum);
        }
    }
    private void runSize(){
        Date startDate = null;
        Date endDate = null;
        FileUserSizeExample countSizeExample = new FileUserSizeExample();
        countSizeExample.createCriteria().andIdIsNotNull();
        /**
         * @Modify: mdengb
         * 清空之前表的数据
         * */
        List<FileUserSize> fileUserNums = fileUserSizeService.find(countSizeExample);
        if(!fileUserNums.isEmpty()) {
            List<Long> ids = fileUserNums.stream().map(FileUserSize::getId).collect(Collectors.toList());
            fileUserSizeService.deleteByIds(ids);
        }
//        Integer countSize = fileUserSizeService.count(countSizeExample);
//        if(countSize > 0){
//            startDate = DateUtils.getBeginDayOfYesterday();
//            endDate = DateUtils.getEndDayOfYesterDay();
//        }
        List<SynFileDataDO> synFileDataDOList = shareFileService.findSynFileData(startDate,endDate);
        for (SynFileDataDO synFileDataDO : synFileDataDOList){
            FileUserSize fileUserSize = new FileUserSize();
            fileUserSize.setAppId(synFileDataDO.getAppId());
            fileUserSize.setCreateTime(new Date());
            fileUserSize.setCreateUser(synFileDataDO.getCreateUser());
            fileUserSize.setDataType(synFileDataDO.getDataType());
            fileUserSize.setType(synFileDataDO.getType());
            fileUserSize.setFyearMonth(synFileDataDO.getYMonth());
            fileUserSize.setSize(synFileDataDO.getSize());
            fileUserSizeService.saveSelective(fileUserSize);
        }
    }
}
