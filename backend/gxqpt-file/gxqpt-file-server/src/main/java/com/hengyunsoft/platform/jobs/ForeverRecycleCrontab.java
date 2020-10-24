package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.entity.file.po.RecycleSetting;
import com.hengyunsoft.platform.file.entity.file.po.Share;
import com.hengyunsoft.platform.file.repository.file.example.RecycleSettingExample;
import com.hengyunsoft.platform.file.repository.file.example.ShareExample;
import com.hengyunsoft.platform.file.repository.file.service.FileRecycleService;
import com.hengyunsoft.platform.file.repository.file.service.RecycleSettingService;
import com.hengyunsoft.platform.file.repository.file.service.ShareFileService;
import com.hengyunsoft.platform.file.repository.file.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时永久清空云盘系统10天后记录的定时任务
 *
 * @author sxy
 * @createTime 2018-6-14
 */
@Controller
@Slf4j
public class ForeverRecycleCrontab {

    private static LocalDate lastDate = null;

    @Autowired
    FileRecycleService fileRecycleService;
    @Autowired
    private ShareService shareService;
    @Autowired
    private ShareFileService shareFileService;
    @Autowired
    private RecycleSettingService recycleSettingService;

    /**
     * 定时永久清空云盘系统10天后记录的定时任务
     *
     * @throws Exception
     */
    //@Scheduled(cron = "0/5 * * * * ?")//每30秒执行一次
    @Scheduled(cron = "0 0 0 * * ?")//每天晚上凌晨执行
    //@Scheduled(cron = "0 0/30 * * * ?")//每30分钟执行一次
    public void handle() {
        try {
            //查询一级删除数据，根据foldId递归删除子节点
//			List<FileRecycleDTO> list = fileRecycleApi.getForeverRecycle();
            List<FileRecycle> list = fileRecycleService.getForeverRecycle();
            if (list != null && list.size() > 0) {
                for (FileRecycle dto : list) {
                    if (dto != null) {
                        //永久回收处理
                        log.info("永久回收处理开始,id,[{}]", dto.getId());
                        fileRecycleService.updateForeverRecycle(dto.getId());
                    }
                }
            }
        } catch (Exception e) {
            log.info("永久回收处理异常,", e);
        }
    }

    /**
     * 定时清除回收站以及分享过期的文件；之前没做的功能
     */
    //@Scheduled(cron = "0/5 * * * * ?")//每30秒执行一次
//    @Scheduled(cron = "0 */1 * * * ?")//每分钟执行一次
    @Scheduled(cron = "0 0 0 * * ?")//每天晚上凌晨执行
    //@Scheduled(cron = "0 0/30 * * * ?")//每30分钟执行一次
    public void dealRecycleAandSharePass() {
        if (lastDate == null) {
            lastDate = LocalDate.now();
            return;
        }
        if (lastDate != null) {
            RecycleSettingExample recycleSettingExample = new RecycleSettingExample();
            List<RecycleSetting> recycleSettings = recycleSettingService.find(recycleSettingExample);
            if (recycleSettings != null && recycleSettings.size() > 0) {
                //该定时设置只有管理员拥有只能存在一条数据-问汤云汉获得的需求
                RecycleSetting setting = recycleSettings.get(0);
                String timePeriod = setting.getTimePeriod();
                if (StringUtils.isEmpty(timePeriod)) {
                    return;
                }
                Long period;
                try {
                    period = Long.parseLong(timePeriod);
                } catch (Exception e) {
                    log.info("定时清除回收站，分享文件错误异常,", e);
                    return;
                }
                LocalDate tmp = lastDate.plusDays(period);
                if (tmp.compareTo(ChronoLocalDate.from(LocalDateTime.now())) <= 0) {
                    try {
                        //1.清除分享过期的数据
                        ShareExample shareExample = new ShareExample();
                        List<Share> list = shareService.find(shareExample);
                        List<Long> shareIds = new ArrayList<>();
                        List<Long> deleteIds = new ArrayList<>();
                        if (list != null && list.size() > 0) {
                            list.forEach(share -> {
                                boolean timeTag = share.getValid() == null ? true : (share.getValid().getTime() > (System.currentTimeMillis()) ? true : false);
                                if (!timeTag) {
                                    deleteIds.add(share.getId());
                                    shareIds.add(share.getId());
                                }
                            });
                            shareService.deleteByIds(deleteIds);
                            shareFileService.deleteByShareIds(shareIds);
                        }
                    } catch (Exception e) {
                        log.info("定时清除分享过期的数据异常,", e);
                    }
                    try {
                        //2.清空回收站数据
                        fileRecycleService.deleteAll();
                    } catch (Exception e) {
                        log.info("定时清除回收站异常,", e);
                    }
                    lastDate = LocalDate.now();
                }
            }
        }
    }
}
