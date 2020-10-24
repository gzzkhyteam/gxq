package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.mybatis.annotation.IgnoreTx;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;
import com.hengyunsoft.platform.developer.repository.service.service.ModuleUseJnlService;
import com.hengyunsoft.platform.developer.utils.PlatformUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 定时记录功能调用情况
 * @author sxy
 *
 */
@Controller
@Slf4j
@IgnoreTx
public class ModuleUseJnlCrontab {

	//成功占比
	private static final String SUCCESS = "95";

	//失败占比
	private static final String FAIL = "5";

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    ServiceModuleService serviceModuleService;
    @Autowired
    ModuleUseJnlService moduleUseJnlService;
    private Random random = new Random();

	/**
	 * 定时记录功能调用情况30秒轮询一次
	 * @throws Exception
	 */
	//@Scheduled(cron = "0/30 * * * * ?")//每30秒执行一次
    //@Scheduled(cron = "0/5 * * * * ?")//每5秒执行一次
	@Scheduled(cron = "0 0/10 * * * ?")//每2分钟执行一次
	public void jnl(){

	    //1.按比例分配结果
		String result = getCode(SUCCESS,FAIL);
		log.info("定时记录功能调用，按比例分配结果，result,[{}]",new Object[]{result});

        //2.组装数据
        ServiceModuleExample example = new ServiceModuleExample();
        example.createCriteria();
        example.setOrderByClause("id asc");

        //3.查询并返回
        List<ServiceModule> smList = serviceModuleService.find(example);//查询所有模块
        List<Application> appList = applicationService.findAppByCondition();//查询非 支撑服务(zcfw)，支撑服务模块(zcfwmk) 之外应用
        if(smList.size()==0||appList.size()==0){
            return;
        }
        String appId = getAppId(appList);
        Long moduleId = getModuleId(smList);

        //4、保存
        if(StringUtils.isNotEmpty(appId)&&moduleId!=null){
            ModuleUseInfo moduleUseInfo = new ModuleUseInfo();
            moduleUseInfo.setAppId(appId);
            moduleUseInfo.setTotalNum(getRandom());
            moduleUseInfo.setModuleId(String.valueOf(moduleId));
            moduleUseInfo.setErrorNum((result.equals("success"))?0:1);
            log.info("定时记录功能调用日志开始，appId,[{}]，moduleId,[{}]",new Object[]{appId,moduleId});
            moduleUseJnlService.saveLog(moduleUseInfo);
            log.info("定时记录功能调用日志成功，appId,[{}]，moduleId,[{}]",new Object[]{appId,moduleId});
        }
	}

	/**
	 * 通过按比例分配算法分配出成功或者失败
	 * @return
	 */
	private static String getCode(String s, String f) {
        PlatformUtil success = new PlatformUtil();
		success.setWeight(new BigDecimal(s).movePointLeft(2));
        PlatformUtil fail = new PlatformUtil();
		fail.setWeight(new BigDecimal(f).movePointLeft(2));
		ArrayList<Object> platforms = new ArrayList<Object>();
		platforms.add(success);
		platforms.add(fail);
		Object p = platforms.get(0);
		return (((PlatformUtil) p).isHit(Math.random()))?"success":"fail";
	}

    /**
     * 获取随机模块ID
     * @param smList
     * @return
     */
    private Long getModuleId(List<ServiceModule> smList){
        int index = (int)(Math.random()*smList.size());
        return smList.get(index).getId();
    }

    /**
     * 获取随机appId
     * @param appList
     * @return
     */
    private String getAppId(List<Application> appList){
        int index=(int)(Math.random()*appList.size());
        return appList.get(index).getAppId();
    }

    /**
     * 获取随机数 20 - 50
     * @param
     * @return
     */
    private int getRandom(){
        int index = random.nextInt(50);
        return index;
    }
}
