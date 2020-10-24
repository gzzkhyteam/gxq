package com.hengyunsoft.platform.logs.warns;

import com.hengyunsoft.platform.logs.dto.LogCommonDTO;
import com.hengyunsoft.platform.logs.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class LogMonitorUtil {
    /**
     * 执行各个告警接口
     * @param logCommonDTO
     */

    public void put(LogCommonDTO logCommonDTO, Map<String,LogRuleBaseMonitor> warnRuleMap,RedisUtils redisUtil){

        //循环
        for(Map.Entry<String,LogRuleBaseMonitor> entry : warnRuleMap.entrySet()){
            LogRuleBaseMonitor ruleMonitorKey = entry.getValue();
            ruleMonitorKey.put(logCommonDTO,redisUtil);
        }
    }

}
