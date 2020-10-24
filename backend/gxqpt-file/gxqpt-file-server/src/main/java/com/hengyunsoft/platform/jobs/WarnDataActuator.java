package com.hengyunsoft.platform.jobs;

import com.hengyunsoft.platform.logs.dto.LogCommonDTO;
import com.hengyunsoft.platform.logs.dto.LogIdDTO;
import com.hengyunsoft.platform.logs.entity.logs.po.*;
import com.hengyunsoft.platform.logs.repository.logs.dao.*;
import com.hengyunsoft.platform.logs.repository.logs.example.LogWarnRuleExample;
import com.hengyunsoft.platform.logs.repository.logs.service.LogWarnCheckService;
import com.hengyunsoft.platform.logs.utils.RedisUtils;
import com.hengyunsoft.platform.logs.utils.SerializeUtil;
import com.hengyunsoft.platform.logs.warns.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.hengyunsoft.platform.logs.utils.RedisConfig;
//import com.hengyunsoft.platform.logs.utils.RedisObjectSerializer;


@Component
@Slf4j
public class WarnDataActuator {
    @Autowired
    private LogStructAppMapper logStructAppMapper;
    @Autowired
    private LogStructTomcatMapper logStructTomcatMapper;
    @Autowired
    private LogStructNginxMapper logStructNginxMapper;
    @Autowired
    private LogStructApacheMapper logStructApacheMapper;
    @Autowired
    private LogWarnRuleMapper logWarnRuleMapper;
    @Autowired
    private LogMonitorUtil logMonitorUtil;
    @Autowired
    private RedisUtils redisUtil;
    @Autowired
    LogRuleKeyMonitor ruleKeyMonitor;
    @Autowired
    LogRuleResponseMonitor ruleResponseMonitor;
    @Autowired
    LogRuleQuantityIpMonitor ruleQuantityIpMonitor;
    @Autowired
    LogRuleQuantityMonitor ruleQuantityMonitor;
    @Value("${log.warning.total}")
    private Long logWarningTotal;
    @Autowired
    private LogWarnCheckService logWarnCheckService;
   // @Autowired
    //private RedisObjectSerializer redisObjectSerializer;
    //@Autowired
    //private  RedisTemplate redisTemplate;

    /**
     * 3分钟执行一次告警设置
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    //@Scheduled(cron = "0 0/3 * * * ?")
    public void warnDataRun() {

        log.info("-------告警启动-----");

        Map<String, LogRuleBaseMonitor> warnRuleMap = getWarnRules();
        if (warnRuleMap == null || warnRuleMap.size() == 0) {
            return;
        }

        List<LogStructApp> listApp = logStructAppMapper.queryAppWarn(logWarningTotal);
        List<LogWarnCheck> logWarnCheckList = new ArrayList<LogWarnCheck>();
        for (int i = 0; i < listApp.size(); i++) {
            LogCommonDTO logCommon = new LogCommonDTO();
            logCommon.setId(listApp.get(i).getId());
            logCommon.setLogTime(listApp.get(i).getLogTime());
            logCommon.setLogType("APP");
            logCommon.setAppId(listApp.get(i).getAppId());
            logCommon.setContent(listApp.get(i).getContent());
            logCommon.setLevel(listApp.get(i).getLevel());
            logMonitorUtil.put(logCommon, warnRuleMap,redisUtil);
            LogWarnCheck logWarnCheck = new LogWarnCheck();
            logWarnCheck.setLogStructId(listApp.get(i).getId());
            logWarnCheck.setLogType("APP");
            logWarnCheckList.add(logWarnCheck);
        }
        if(logWarnCheckList.size()>0){
            logWarnCheckService.save(logWarnCheckList);
        }


        List<LogStructTomcat> listTomcat = logStructTomcatMapper.queryTomcatWarn(logWarningTotal);
        logWarnCheckList = new ArrayList<LogWarnCheck>();
        for (int i = 0; i < listTomcat.size(); i++) {
            LogCommonDTO logCommon = new LogCommonDTO();
            logCommon.setId(listTomcat.get(i).getId());
            logCommon.setAppId(listTomcat.get(i).getAppId());
            logCommon.setLogTime(listTomcat.get(i).getLogTime());
            logCommon.setLogType("TOMCAT");
            logCommon.setTimeConsum(listTomcat.get(i).getTimeConsum());
            logCommon.setIp(listTomcat.get(i).getRemoteIp());
            logMonitorUtil.put(logCommon, warnRuleMap,redisUtil);
            LogWarnCheck logWarnCheck = new LogWarnCheck();
            logWarnCheck.setLogStructId(listTomcat.get(i).getId());
            logWarnCheck.setLogType("TOMCAT");
            logWarnCheckList.add(logWarnCheck);
        }
        if(logWarnCheckList.size()>0){
            logWarnCheckService.save(logWarnCheckList);
        }


        List<LogStructNginx> listNginx = logStructNginxMapper.queryNginxWarn(logWarningTotal);
        logWarnCheckList = new ArrayList<LogWarnCheck>();
        for (int i = 0; i < listNginx.size(); i++) {
            LogCommonDTO logCommon = new LogCommonDTO();
            logCommon.setId(listNginx.get(i).getId());
            logCommon.setAppId(listNginx.get(i).getAppId());
            logCommon.setLogTime(listNginx.get(i).getLocalTime());
            logCommon.setLogType("NGINX");
            logCommon.setTimeConsum(listNginx.get(i).getTimeConsum());
            logCommon.setIp(listNginx.get(i).getRemoteAddr());
            logMonitorUtil.put(logCommon, warnRuleMap,redisUtil);
            LogWarnCheck logWarnCheck = new LogWarnCheck();
            logWarnCheck.setLogStructId(listNginx.get(i).getId());
            logWarnCheck.setLogType("NGINX");
            logWarnCheckList.add(logWarnCheck);
        }
        if(logWarnCheckList.size()>0){
            logWarnCheckService.save(logWarnCheckList);
        }


        List<LogStructApache> listApache = logStructApacheMapper.queryApacheWarn(logWarningTotal);
        logWarnCheckList = new ArrayList<LogWarnCheck>();
        for (int i = 0; i < listApache.size(); i++) {
            LogCommonDTO logCommon = new LogCommonDTO();
            logCommon.setId(listApache.get(i).getId());
            logCommon.setAppId(listApache.get(i).getAppId());
            logCommon.setLogTime(listApache.get(i).getLogTime());
            logCommon.setLogType("APACHE");
            logCommon.setTimeConsum(listApache.get(i).getTimeConsum());
            logCommon.setIp(listApache.get(i).getRemoteIp());
            logMonitorUtil.put(logCommon, warnRuleMap,redisUtil);
            LogWarnCheck logWarnCheck = new LogWarnCheck();
            logWarnCheck.setLogStructId(listApache.get(i).getId());
            logWarnCheck.setLogType("APACHE");
            logWarnCheckList.add(logWarnCheck);
        }
        if(logWarnCheckList.size()>0){
            logWarnCheckService.save(logWarnCheckList);
        }
    }

   /*@PostConstruct
    public void init() {
        log.info("-------告警启动-----");

        warnDataRun();
    }*/

    private Map<String, LogRuleBaseMonitor> getWarnRules() {

        LogWarnRuleExample exampleRule = new LogWarnRuleExample();
        exampleRule.createCriteria().andIsEnableEqualTo("1");
                /*.andIdGreaterThanOrEqualTo((long) 100)
                .andIdLessThanOrEqualTo((long) 200);*/
        List<LogWarnRule> listWarnRule = logWarnRuleMapper.selectByExample(exampleRule);
        Map<String, LogRuleBaseMonitor> warnRuleMap = new HashMap<String, LogRuleBaseMonitor>();

        //查询缓存中是否存在。

        for (int i = 0; i < listWarnRule.size(); i++) {
            LogWarnRule rule = listWarnRule.get(i);
            if(null!=rule.getWarnType()){
                if ("KEY".equals(rule.getWarnType())) {
                    LogRuleKeyMonitor ruleKeyMonitor = new LogRuleKeyMonitor();
                    ruleKeyMonitor.setRule(rule);
                    warnRuleMap.put(rule.getId() + "", ruleKeyMonitor);//存入Map
                }else if ("RESPONSE".equals(rule.getWarnType())) {
                    LogRuleResponseMonitor ruleResponseMonitor = new LogRuleResponseMonitor();
                    ruleResponseMonitor.setRule(rule);
                    warnRuleMap.put(rule.getId() + "", ruleResponseMonitor);//存入Map
                }else if ("QUANTITY".equals(rule.getWarnType()) && (null == rule.getQuantityLogLevel() || rule.getQuantityLogLevel().equals(""))) {
                    LogRuleQuantityIpMonitor ruleQuantityIpMonitor = new LogRuleQuantityIpMonitor();
                    ruleQuantityIpMonitor.setRule(rule);

                    if(redisUtil.exists(rule.getId()+"")) {
                   /* List<LogIdDTO> listd= new ArrayList<>();
                    LogIdDTO ll = new LogIdDTO();
                    ll.setIp("123");
                    ll.setId((long) 12);
                    listd.add(ll);
                    redisUtil.set(rule.getId()+"", SerializeUtil.serialize(listd));//存入缓存*/
                        byte[] value = (byte[]) redisUtil.get(rule.getId() + "");
                        List<LogIdDTO> list = (List<LogIdDTO>) SerializeUtil.unserialize(value);
                        ruleQuantityIpMonitor.setList(list);
                    }else{
                        ruleQuantityIpMonitor.setList(new ArrayList<LogIdDTO>());
                    }
                    warnRuleMap.put(rule.getId() + "", ruleQuantityIpMonitor);//存入Map
                }else {
                    LogRuleQuantityMonitor ruleQuantityMonitor = new LogRuleQuantityMonitor();
                    ruleQuantityMonitor.setRule(rule);
                    if(redisUtil.exists(rule.getId()+"")) {
                        byte[] value = (byte[]) redisUtil.get(rule.getId()+"");
                        List<LogIdDTO> list = (List<LogIdDTO>) SerializeUtil.unserialize(value);
                        ruleQuantityMonitor.setList(list);
                    }else{
                        ruleQuantityMonitor.setList(new ArrayList<LogIdDTO>());
                    }
                    warnRuleMap.put(rule.getId() + "", ruleQuantityMonitor);//存入Map
                }
            }
        }
        return warnRuleMap;
    }
}