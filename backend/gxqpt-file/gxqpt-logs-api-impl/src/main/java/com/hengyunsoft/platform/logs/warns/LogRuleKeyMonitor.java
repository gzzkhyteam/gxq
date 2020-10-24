package com.hengyunsoft.platform.logs.warns;

import com.hengyunsoft.platform.logs.dto.LogCommonDTO;
import com.hengyunsoft.platform.logs.entity.logs.po.LogWarnRule;
import com.hengyunsoft.platform.logs.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Slf4j
public class LogRuleKeyMonitor extends LogRuleBaseMonitor implements Serializable {


    private LogWarnRule rule;
    public LogWarnRule getRule(){
        return rule;
    }
    public void setRule(LogWarnRule rule){
        this.rule=rule;
    }

    /**
     * 入口
     * @param logCommonDTO
     */
    @Override
    public void put(LogCommonDTO logCommonDTO,RedisUtils redisUtil){
        //判断该条日志是不是符合这条规则
        if(!filter(logCommonDTO)){
           return ;
        }
        if(trigWarn(logCommonDTO)){//判断是不是满足设置告警规则
            sendWarn(logCommonDTO,rule);//触发告警
        }

    }

    /**
     * 过滤该日志是不是符合这条规则
     * @param logCommonDTO
     * @return
     */
    @Override
    public boolean filter(LogCommonDTO logCommonDTO) {
        //应用系统不一致的
        if(!rule.getAppId().equals(logCommonDTO.getAppId())){
            return false;
        }
        //关键词告警类，只合适APP（应用系统的）
        if(!"APP".equals(logCommonDTO.getLogType())){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkInvalidate(LogCommonDTO logCommonDTO) {
          return true;
    }

    /**
     * 判断是不是满足设置告警规则
     * @param logCommonDTO
     * @return
     */
    @Override
    public boolean trigWarn(LogCommonDTO logCommonDTO) {
        if(null == logCommonDTO.getContent()){
            return false;
        }
        String rules = rule.getKeyContent().toLowerCase();
        String [] ruleKey=rules.split(",");
        for(int i=0;i<ruleKey.length;i++){
            if(logCommonDTO.getContent().toLowerCase().contains(ruleKey[i])){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "LogRuleResponseMonitor{" +
                "rule='" + rule.toString() + '\'' +
                '}';
    }
}
